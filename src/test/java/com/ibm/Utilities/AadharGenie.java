package com.ibm.Utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


public class AadharGenie {
    static String genAadharNum;
    static String aadharNum;
    static File file;
    static FileWriter fw;
    static BufferedWriter bw;


    static int[][] d = new int[][]
            {
                    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                    {1, 2, 3, 4, 0, 6, 7, 8, 9, 5},
                    {2, 3, 4, 0, 1, 7, 8, 9, 5, 6},
                    {3, 4, 0, 1, 2, 8, 9, 5, 6, 7},
                    {4, 0, 1, 2, 3, 9, 5, 6, 7, 8},
                    {5, 9, 8, 7, 6, 0, 4, 3, 2, 1},
                    {6, 5, 9, 8, 7, 1, 0, 4, 3, 2},
                    {7, 6, 5, 9, 8, 2, 1, 0, 4, 3},
                    {8, 7, 6, 5, 9, 3, 2, 1, 0, 4},
                    {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}
            };
    static int[][] p = new int[][]
            {
                    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                    {1, 5, 7, 6, 2, 8, 3, 0, 9, 4},
                    {5, 8, 0, 3, 7, 9, 6, 1, 4, 2},
                    {8, 9, 1, 6, 0, 4, 3, 5, 2, 7},
                    {9, 4, 5, 3, 1, 2, 6, 8, 7, 0},
                    {4, 2, 8, 6, 5, 7, 3, 9, 0, 1},
                    {2, 7, 9, 3, 8, 0, 6, 4, 1, 5},
                    {7, 0, 4, 6, 9, 1, 3, 2, 5, 8}
            };
    static int[] inv = {0, 4, 3, 2, 1, 5, 6, 7, 8, 9};

    /**
     * Validates that an entered number is Verhoeff compliant.
     * NB: Make sure the check digit is the last one.
     *
     * @param num The numeric string data for Verhoeff compliance check.
     * @return TRUE if the provided number is Verhoeff compliant.
     */
    public static boolean validateVerhoeff(String num) {
        int c = 0;
        int[] myArray = StringToReversedIntArray(num);
        for (int i = 0; i < myArray.length; i++) {
            c = d[c][p[(i % 8)][myArray[i]]];
        }
        return (c == 0);
    }

    /**
     * Generates the Verhoeff digit for the provided numeric string.
     *
     * @return The generated Verhoeff digit for the provided numeric string.
     */
    public static String generateVerhoeff(String num) {
        int c = 0;
        int[] myArray = StringToReversedIntArray(num);
        for (int i = 0; i < myArray.length; i++) {
            c = d[c][p[((i + 1) % 8)][myArray[i]]];
        }
        return Integer.toString(inv[c]);
    }

    private static int[] StringToReversedIntArray(String num) {
        int[] myArray = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            myArray[i] = Integer.parseInt(num.substring(i, i + 1));
        }
        myArray = Reverse(myArray);
        return myArray;
    }

    private static int[] Reverse(int[] myArray) {
        int[] reversed = new int[myArray.length];
        for (int i = 0; i < myArray.length; i++) {
            reversed[i] = myArray[myArray.length - (i + 1)];
        }
        return reversed;
    }

    /**
     * Generates a random 11 digit with non zero first digit
     *
     * @return Generated 11 digit with non zero first digit
     */
    private static long randomNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // first not 0 digit
        sb.append(random.nextInt(9) + 1);

        // rest of 11 digits
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        return Long.valueOf(sb.toString()).longValue();
    }

    public static void notePad(String aadharNumber) {
        try {
            file = new File("./src/resources/dataFiles/StoredAadharNumbers.txt");

            if (file.createNewFile()) {
                System.out.println("File Created for Generated Aadhars");
                fw = new FileWriter(file.getAbsoluteFile(), true);
                bw = new BufferedWriter(fw);
                bw.write("Validated Aadhar numbers generated below, " + "\n" + "\n");
                bw.flush();
            }
            writeNotepad(aadharNumber);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeNotepad(String aadharNumber) throws IOException {
        fw = new FileWriter(file.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            sc.nextLine();
        }
        if (aadharNumber == aadharNum) {
            bw.write("Aadhar generated on " + getCurrentDateTime() + " --> " + aadharNum + "\n");
        } else if (aadharNumber == genAadharNum) {
            bw.write("Technical issue on " + getCurrentDateTime() + ". Kindly Rerun the utility. " + "\n");
        }
        bw.flush();
        bw.close();
        sc.close();
    }

    public static String getCurrentDateTime() {
        String dateTime = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        dateTime = formatter.format(date);
        return dateTime;
    }


    public String genAadhar() {
        //Store 11digit randomNumber as String | Conversion required long to string
        String stringAadhar = "";
        for (int i = 0; i <= 5; i++) {

            stringAadhar = Long.toString(randomNumber());
			
			if(stringAadhar.startsWith("1")){
                continue;
            }

            //Concat random 11digit number with 12th checksum digit
            genAadharNum = stringAadhar + generateVerhoeff(stringAadhar);

            //Aadhar number validation
            if (validateVerhoeff(genAadharNum) == false) {
                notePad(genAadharNum);
            }
            //Aadhar length validation
            if (genAadharNum.length() != 12) {
                notePad(genAadharNum);
            } else {
                aadharNum = genAadharNum.replaceAll("\\s+", "");
                notePad(aadharNum);
                break;
            }
        }
        return aadharNum;
    }

    /*
     * Main method for unit testing
     */

   /* public static void main(String[] args) {
        System.out.println(new AadharGenie().genAadhar());
    }*/
}
