package com.hitices.basicenvstatusinfer.ann;

public class NetworkNode
{
	public static final int TYPE_INPUT = 0;
	public static final int TYPE_HIDDEN = 1;
	public static final int TYPE_OUTPUT = 2;

	private int type;

	public void setType(int type)
	{
		this.type = type;
	}

	// 节点前向输入输出值
	private Double mForwardInputValue;
	private Double mForwardOutputValue;

	// 节点反向输入输出值
	private Double mBackwardInputValue;
	private Double mBackwardOutputValue;

	public NetworkNode()
	{
	}

	public NetworkNode(int type)
	{
		this.type = type;
	}

	/**
	 * sigmoid函数，这里用tan-sigmoid，经测试其效果比log-sigmoid好！
	 * 
	 * @param in
	 * @return
	 */
	private Double forwardSigmoid(Double in)
	{
		switch (type)
		{
		case TYPE_INPUT:
			return in;
		case TYPE_HIDDEN:
		case TYPE_OUTPUT:
			return tanhS(in);
		}
		return 0.0;
	}

	/**
	 * log-sigmoid函数
	 * 
	 * @param in
	 * @return
	 */
	private float logS(float in)
	{
		return (float) (1 / (1 + Math.exp(-in)));
	}

	/**
	 * log-sigmoid函数的导数
	 * 
	 * @param in
	 * @return
	 */
	private Double logSDerivative(Double in)
	{
		return mForwardOutputValue * (1 - mForwardOutputValue) * in;
	}

	/**
	 * tan-sigmoid函数
	 * 
	 * @param in
	 * @return
	 */
	private Double tanhS(Double in)
	{
		return (Double) ((Math.exp(in) - Math.exp(-in)) / (Math.exp(in) + Math
				.exp(-in)));
	}

	/**
	 * tan-sigmoid函数的导数
	 * 
	 * @param in
	 * @return
	 */
	private Double tanhSDerivative(Double in)
	{
		return (Double) ((1 - Math.pow(mForwardOutputValue, 2)) * in);
	}

	/**
	 * 误差反向传播时，激活函数的导数
	 * 
	 * @param in
	 * @return
	 */
	private Double backwardPropagate(Double in)
	{
		switch (type)
		{
		case TYPE_INPUT:
			return in;
		case TYPE_HIDDEN:
		case TYPE_OUTPUT:
			return tanhSDerivative(in);
		}
		return 0.0;
	}

	public Double getForwardInputValue()
	{
		return mForwardInputValue;
	}

	public void setForwardInputValue(Double mInputValue)
	{
		this.mForwardInputValue = mInputValue;
		setForwardOutputValue(mInputValue);
	}

	public Double getForwardOutputValue()
	{
		return mForwardOutputValue;
	}

	private void setForwardOutputValue(Double mInputValue)
	{
		this.mForwardOutputValue = forwardSigmoid(mInputValue);
	}

	public Double getBackwardInputValue()
	{
		return mBackwardInputValue;
	}

	public void setBackwardInputValue(Double mBackwardInputValue)
	{
		this.mBackwardInputValue = mBackwardInputValue;
		setBackwardOutputValue(mBackwardInputValue);
	}

	public Double getBackwardOutputValue()
	{
		return mBackwardOutputValue;
	}

	private void setBackwardOutputValue(Double input)
	{
		this.mBackwardOutputValue = backwardPropagate(input);
	}

}
