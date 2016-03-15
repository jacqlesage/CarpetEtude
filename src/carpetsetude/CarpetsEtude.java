/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpetsetude;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main method for project: - reads cmd arguments - stores carpet size and flags
 * - reads input from stdin - stores carpet stock in ArrayList
 *
 * @author James Goodman ID: 7482643
 * @author Prabhat Gokul ID: 5735610
 * @author Ali Falakah ID: 4818438
 */
public class CarpetsEtude {

    private static int carpetSize;
    private static int carpetLength;
    private static int stockSize;
    private static String flags;
    private static ArrayList<String> carpetStock;
    private static ArrayList<ArrayList<CarpetPair>> normCombinations;
    private static ArrayList<ArrayList<CarpetPair>> reverseCombinations;
    private static ArrayList<ArrayList<CarpetPair>> numMatchesList;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        carpetSize = 0;
        flags = "";

        // get cmd arguments - set carpetSize and flags
        if (args[0] != null) {
            carpetSize = Integer.parseInt(args[0]);
        }
        if (args[1] != null) {
            flags = args[1];
        }

        carpetStock = readInputFile();
        carpetLength = carpetStock.get(0).length();
        stockSize = carpetStock.size();
//        generateCombinations();
        generateCombinations2();
        noMatches();

//        printReadInputTests();
//        printReadCombinationTests();
//        printMatchesListTest();
//        printMatchesTest(0);
    }

    /**
     *
     * @return carpetStock - ArrayList of carpets read from stdin
     */
    private static ArrayList<String> readInputFile() {
        ArrayList<String> carpetStock = new ArrayList<>();

        // temporarily get input from input.txt file
        try {
            FileInputStream is = new FileInputStream(new File("C:\\Users\\admin\\Documents\\Otago uni\\COSC326\\ants\\CarpetEtude\\src\\carpetsetude\\input.txt"));
            System.setIn(is);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // use scanner to read each line and add to carpetStock ArrayList
        Scanner in = new Scanner(System.in);
        String line = "";
        while ((in.hasNextLine())) {
            line = in.nextLine();
            carpetStock.add(line);
        }

        return carpetStock;
    }

    private static void generateCombinations() {
        normCombinations = new ArrayList<>();
        reverseCombinations = new ArrayList<>();
        numMatchesList = new ArrayList<>();
        for (int index = 0; index < carpetLength + 1; index ++) {
            ArrayList<CarpetPair> matchList = new ArrayList<>();
            numMatchesList.add(matchList);
        }
        for (int i = 0; i < carpetStock.size() - 1; i++) {
            ArrayList<CarpetPair> carpetPairList = new ArrayList<>();
            ArrayList<CarpetPair> reverseCarpetPairList = new ArrayList<>();
            for (int j = i + 1; j < carpetStock.size(); j++) {
                int matches = 0, reverseMatches = 0;
                String line1 = carpetStock.get(i);
                String line2 = carpetStock.get(j);
                for (int k = 0; k < carpetLength; k++) {
                    if (line1.charAt(k) == line2.charAt(k)) {
                        matches++;
                    }
                    if (line1.charAt(carpetLength - 1 - k) == line2.charAt(k)) {
                        reverseMatches++;
                    }
                }
                CarpetPair carpetPair = new CarpetPair(matches, i, j, false);
                CarpetPair reverseCarpetPair = new CarpetPair(reverseMatches, i, j, true);
                carpetPairList.add(carpetPair);
                reverseCarpetPairList.add(reverseCarpetPair);
                numMatchesList.get(matches).add(carpetPair);
                numMatchesList.get(reverseMatches).add(reverseCarpetPair);
            }
            normCombinations.add(carpetPairList);
            reverseCombinations.add(reverseCarpetPairList);
        }
    }

    private static void generateCombinations2() {
        numMatchesList = new ArrayList<>();
        for (int index = 0; index < carpetLength + 1; index ++) {
            ArrayList<CarpetPair> matchList = new ArrayList<>();
            numMatchesList.add(matchList);
        }
        for (int i = 0; i < carpetStock.size(); i++) {
            for (int j = 0; j < carpetStock.size(); j++) {
                int matches = 0, reverseMatches = 0;
                String line1 = carpetStock.get(i);
                String line2 = carpetStock.get(j);
                for (int k = 0; k < carpetLength; k++) {
                    if (line1.charAt(k) == line2.charAt(k)) {
                        matches++;
                    }
                    if (line1.charAt(carpetLength - 1 - k) == line2.charAt(k)) {
                        reverseMatches++;
                    }
                }
                CarpetPair carpetPair = new CarpetPair(matches, i, j, false);
                CarpetPair reverseCarpetPair = new CarpetPair(reverseMatches, i, j, true);
                numMatchesList.get(matches).add(carpetPair);
                numMatchesList.get(reverseMatches).add(reverseCarpetPair);
            }
        }
    }
    
    private static void noMatches() {
        int index = 0;
        ArrayList<ArrayList<CarpetPair>> noMatchesList = new ArrayList<>();
        for (int i = 0; i < stockSize; i++) {
            ArrayList<CarpetPair> pairList = new ArrayList<>();
            noMatchesList.add(pairList);
        }
        
        ArrayList<CarpetPair> tempList = numMatchesList.get(0);
        for (int i = 0; i < tempList.size(); i++) {
            CarpetPair tempCarpetPair = tempList.get(i);
            index = tempCarpetPair.getIndex1();
            noMatchesList.get(index).add(tempCarpetPair);
        }
        
        printNoMatchesTest(noMatchesList);
        printNumPairsInMatch(noMatchesList);
    }
    
    private static void printReadInputTests() {
        // test cmd arguments are stored properly
        System.out.println("carpetSize = " + carpetSize);
        System.out.println("flags = " + flags);

        // test for carpetLength
        System.out.println("carpet length = " + carpetLength);

        // test carpetStock is working
        System.out.println("carpet stock: ");
        for (String l : carpetStock) {
            System.out.println(l);
        }
        
        System.out.println("stock count: " + carpetStock.size());
    }

    private static void printReadCombinationTests() {
        int count = 0;
        // test print for normal combinations
        System.out.println("normCombinations\n");
        for (ArrayList list : normCombinations) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).toString());
                System.out.print(" ");
                count++;
            }
            System.out.println();
        }
        System.out.println("count: " + count);

        // test print for reverse combinations
        count = 0;
        System.out.println("reverseCombinations\n");
        for (ArrayList list : reverseCombinations) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).toString());
                System.out.print(" ");
                count++;
            }
            System.out.println();
        }
        System.out.println("count: " + count);
        
        // test print for number of matches
        count = 0;
        System.out.println("numMatchesList\n");
        for (ArrayList list : numMatchesList) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).toString());
                System.out.print(" ");
                count++;
            }
            System.out.println();
        }
        System.out.println("count: " + count);
    }
    
    private static void printMatchesListTest() {
        // test print for number of matches
        int count = 0;
        System.out.println("numMatchesList\n");
        for (ArrayList list : numMatchesList) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).toString());
                System.out.print(" ");
                count++;
            }
            System.out.println();
        }
        System.out.println("count: " + count);
    }
    
    private static void printMatchesTest(int index) {
        for(CarpetPair cp : numMatchesList.get(index))
            System.out.println(cp.toString());
    }
    
    private static void printNoMatchesTest(ArrayList<ArrayList<CarpetPair>> noMatchesList) {
        // test print for no matches ArrayList
        int count = 0;
        System.out.println("noMatchesList\n");
        for (ArrayList list : noMatchesList) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).toString());
                System.out.print(" ");
                count++;
            }
            System.out.println();
        }
        System.out.println("count: " + count);
    }
    
    private static void printNumPairsInMatch(ArrayList<ArrayList<CarpetPair>> matchesList) {
        System.out.println("noMatchesList size\n");
        int i = 0;
        for (ArrayList list : matchesList) {
            System.out.println(i + ": " + list.size());
            i++;
        }
    }
}
