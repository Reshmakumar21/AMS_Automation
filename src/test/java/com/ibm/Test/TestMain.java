package com.ibm.Test;

import java.util.Random;

public class TestMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random rand = new Random();
		System.out.println(new Random().nextInt(10));
		System.out.println(rand.nextInt(10));
		System.out.println(rand.nextInt(10));
		System.out.println(rand.nextInt(10));

//		String str = "com.ibm.Test.CustomerOnboardingSBC";
//
//		System.out.println(str.lastIndexOf("."));
//		System.out.println(str.length());
//
//		System.out.println(str.substring(str.lastIndexOf("."), str.length()).replaceAll("\\.", ""));

//		File sourceFile = new File(".\\report\\ExecutionReport04_06_2020_12_28_15");
//		File destFile = new File(".\\report\\SBC");
//
//		if (sourceFile.renameTo(destFile)) {
//			System.out.println("Directory renamed successfully");
//		} else {
//			System.out.println("Failed to rename directory");
//		}
	}
}
