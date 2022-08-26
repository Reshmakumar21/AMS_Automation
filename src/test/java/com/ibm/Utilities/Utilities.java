/*
 * @author Shivam Tiwari
 * @version 2.1
 * @since 2020-04-25
 */
package com.ibm.Utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.yaml.snakeyaml.Yaml;

/**
 * The Class Utilities.
 */
public class Utilities {
	/** The yaml file path. */
	public static String yamlFilePath = "";

	/**
	 * Sets the yaml file path.
	 *
	 * @param filePath the file path
	 * @return the string
	 */
	public static String setYamlFilePath(String filePath) {
		yamlFilePath = "./src/resources/ymlFiles/" + filePath;
		return filePath;
	}

	/**
	 * Gets the yaml value.
	 *
	 * @param yamlToken the yaml token
	 * @return the yaml value
	 */
	@SuppressWarnings({ "unchecked" })
	public static String getYamlValue(String yamlToken) {
		Reader reader = null;
		int tokenCount = 0, i = 0;
		Map map = null;
		StringTokenizer st = new java.util.StringTokenizer(yamlToken, ".");
		try {
			reader = new FileReader(yamlFilePath);
			String val = null;
			Yaml yaml = new Yaml();
			map = (Map) yaml.load(reader);
			tokenCount = st.countTokens();
			for (i = 1; i < tokenCount; i++) {
				String token = st.nextToken();
				map = (Map) map.get(token);
			}
			val = map.get(st.nextToken()).toString();
			return val;
		} catch (Exception e) {
			System.out.println("Yaml file not found!!!\n" + e);
			return "";
		}
	}

	/**
	 * Gets the yaml nodes array.
	 *
	 * @param yamlToken the yaml token
	 * @return the yaml nodes array
	 */
	public static Map getYamlNodesArray(String yamlToken) {
		Reader reader = null;
		int tokenCount = 0, i = 0;
		Map map = null;
		StringTokenizer st = new java.util.StringTokenizer(yamlToken + ".x", ".");
		try {
			reader = new FileReader(yamlFilePath);
			Yaml yaml = new Yaml();
			map = (Map) yaml.load(reader);
			tokenCount = st.countTokens();
			for (i = 1; i < tokenCount; i++) {
				String token = st.nextToken();
				map = (Map) map.get(token);
			}
			return map;
		} catch (Exception e) {
			System.out.println("Either Yaml file not found or there is problem with token passed!!!\n" + e);
			return null;
		}
	}

	/**
	 * Gets the current formated time.
	 *
	 * @return the current formated time
	 */
	public static String getCurrentFormatedTime() {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * Log output file.
	 *
	 * @param output the output
	 * @return the string
	 */
	public static String logOutputFile(String output) {
		File file = new File(Utilities.getYamlValue("logFilePath") + "/logs.txt");
		output = getCurrentFormatedTime() + " " + output + "\n";
		BufferedWriter output1 = null;
		try {
			output1 = new BufferedWriter(new FileWriter(file, true));
			output1.append(output);
			output1.newLine();
			output1.close();
		} catch (Exception e) {
			System.out.println("Exception in logOutputFile" + e.getStackTrace());
		}
		return output;
	}

	/**
	 * Gets the relation ship from txt file.
	 *
	 * @param fileName the file name
	 * @return the relation ship from txt file
	 */
	public static String getRelationShipFromTxtFile(String fileName) {
		String relNumber = getFirstRecordFromTxtFile(fileName);
		try {
			removeFirstLine(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return relNumber;
	}

	/**
	 * Gets the first record from txt file.
	 *
	 * @param fileName the file name
	 * @return the first record from txt file
	 */
	public static String getFirstRecordFromTxtFile(String fileName) {
		try {
			return Files.readAllLines(Paths.get(fileName)).get(0);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException ex) {
			Reporter.log("There is no relationship number in file..." + ex.getMessage());
		}
		return null;
	}

	/**
	 * Removes the first line.
	 *
	 * @param fileName the file name
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void removeFirstLine(String fileName) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
		long writePosition = raf.getFilePointer();
		raf.readLine();
		long readPosition = raf.getFilePointer();
		byte[] buff = new byte[1024];
		int n;
		while (-1 != (n = raf.read(buff))) {
			raf.seek(writePosition);
			raf.write(buff, 0, n);
			readPosition += n;
			writePosition += n;
			raf.seek(readPosition);
		}
		raf.setLength(writePosition);
		raf.close();
	}

	/**
	 * Write relation ship number in txt file.
	 *
	 * @param relationShipNumber the relation ship number
	 * @param environment        the environment
	 */
	public static void writeRelationShipNumberInTxtFile(String relationShipNumber, String environment) {
		if (relationShipNumber.contains("0")) {
			try {
				String filename;
				if (environment.toLowerCase().contains("sit")) {
					filename = "./src/resources/dataFiles/SITRelationShipDump.txt";
				} else {
					filename = "./src/resources/dataFiles/UATRelationShipDump.txt";
				}
				FileWriter fw = new FileWriter(filename, true);
				File file = new File(filename);
				if (file.length() == 0) {
					fw.write(relationShipNumber);
				} else {
					fw.write("\n" + relationShipNumber);
				}
				fw.close();
			} catch (IOException ioe) {
				System.err.println("IOException: " + ioe.getMessage());
			}
		}
	}

	/**
	 * Take screenshot.
	 *
	 * @param NameScrrenShot the name scrren shot
	 */
	public static void takeScreenshot(String NameScrrenShot) {
		File scrFile = ((TakesScreenshot) LoggerWriter.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(LoggerWriter.screenShotPath + "\\" + NameScrrenShot + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Take screenshot auto.
	 *
	 * @param NameScrrenShot the name scrren shot
	 * @return the string
	 */
	public static String takeScreenshotAuto(String NameScrrenShot) {
		try {
			File scrFile = ((TakesScreenshot) LoggerWriter.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(LoggerWriter.screenShotPath + "/" + NameScrrenShot + ".jpg"));
			return "./screenshots/" + NameScrrenShot + ".jpg";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void LaunchEmulator() {
		try {
			Process p=Runtime.getRuntime().exec("emulator -avd IOCL -gpu host");
				Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
