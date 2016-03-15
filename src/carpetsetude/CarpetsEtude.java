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
 * @author James
 * @author Ali
 * @author Prabhat
 */
public class CarpetsEtude {
    private static int carpetSize;
    private static String flags;
    private static ArrayList<String> carpetStock;
    private static ArrayList<ArrayList<Integer[]>> normCombinations; 
    private static ArrayList<ArrayList<Integer[]>> reverseCombinations; 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        carpetSize = 0;
        flags = "";
        ArrayList<String> carpetStock;

        // get cmd arguments - set carpetSize and flags
        if (args[0] != null) {
            carpetSize = Integer.parseInt(args[0]);
        }
        if (args[1] != null) {
            flags = args[1];
        }
        // test cmd arguments are stored properly
        System.out.println("carpetSize = " + carpetSize);
        System.out.println("flags = " + flags);

        carpetStock = readInputFile();
        
        // test carpetStock is working
        System.out.println("carpet stock: ");
        for (String l : carpetStock) {
            System.out.println(l);
        }
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
}
