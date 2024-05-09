package com.hitices.basicenvstatusinfer.ann;

import java.util.ArrayList;
import java.util.List;

public class DataNode
{
	private List<Double> mAttribList;
	private int type;

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public List<Double> getAttribList()
	{
		return mAttribList;
	}

	public void addAttrib(Double value)
	{
		mAttribList.add(value);
	}

	public DataNode()
	{
		mAttribList = new ArrayList<Double>();
	}

}
