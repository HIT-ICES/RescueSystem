package com.hitices.basicenvstatusinfer.ann;

import com.hitices.basicenvstatusinfer.util.ConsoleHelper;
import com.hitices.basicenvstatusinfer.util.DataUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;


public class MainClass
{
	public static void start(String[] args) throws Exception
	{
		if (args.length < 1)
		{
			System.out.println("Usage: \n\t-train trainfile\n\t-test predictfile\n\t-sep separator, default:','\n\t-eta eta, default:0.5\n\t-iter iternum, default:5000\n\t-out outputfile");
			return;
		}
		ConsoleHelper helper = new ConsoleHelper(args);
		String trainfile = helper.getArg("-train", "");
//		String testfile = helper.getArg("-test", "");
		String separator = helper.getArg("-sep", ",");
//		String outputfile = helper.getArg("-out", "");
		float eta = helper.getArg("-eta", 0.005f);
		int nIter = helper.getArg("-iter", 100000);
		DataUtil util = DataUtil.getInstance();
		List<DataNode> trainList = util.getDataList(trainfile, separator);
//		List<DataNode> testList = util.getDataList(testfile, separator);
//		BufferedWriter output = new BufferedWriter(new FileWriter(new File(
//				outputfile)));
		int typeCount = util.getTypeCount();
		AnnClassifier.getInstance(trainList.get(0)
				.getAttribList().size(), trainList.get(0).getAttribList()
				.size() + 8, typeCount);
		AnnClassifier.getInstance().setTrainNodes(trainList);
		AnnClassifier.getInstance().train(eta, nIter);
		//test
//		for (int i = 0; i < testList.size(); i++)
//		{
//			DataNode test = testList.get(i);
//			System.out.println(test.getAttribList());
//			int type = AnnClassifier.getInstance().test(test);
//			List<Double> attribs = test.getAttribList();
//			for (int n = 0; n < attribs.size(); n++)
//			{
//				output.write(attribs.get(n) + ",");
//				output.flush();
//			}
//			output.write(util.getTypeName(type) + "\n");
//			output.flush();
//		}
//		output.close();
	}

}
