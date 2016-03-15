/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpetsetude;

/**
 * Carpet pair object, contains:
 * - number of matches in pair of carpets
 * - index of first carpet
 * - index of second carpet
 * - whether carpet is reverse or not
 * 
 * @author James Goodman ID: 7482643
 * @author Prabhat Gokul ID: 5735610
 * @author Ali Falakah ID: 4818438
 */
public class CarpetPair {
    private int numMatches;
    private int index1;
    private int index2;
    private boolean reverse;
    
    /**
     * Constructor for class
     * 
     * @param numMatches
     * @param index1
     * @param index2
     * @param reverse 
     */
    public CarpetPair(int numMatches, int index1, int index2, boolean reverse) {
        this.numMatches = numMatches;
        this.index1 = index1;
        this.index2 = index2;
        this.reverse = reverse;
    }

    /**
     * Getter for number of matches
     * @return numMatches 
     */
    public int getNumMatches() {
        return numMatches;
    }

    /**
     * Setter for number of matches
     * @param numMatches 
     */
    public void setNumMatches(int numMatches) {
        this.numMatches = numMatches;
    }

    /**
     * Getter for first carpet index
     * @return index1
     */
    public int getIndex1() {
        return index1;
    }

    /**
     * Setter for first carpet index 
     * @param index1 
     */
    public void setIndex1(int index1) {
        this.index1 = index1;
    }

    /**
     * Getter for second carpet index
     * @return index2
     */
    public int getIndex2() {
        return index2;
    }

    /**
     * Setter for second carpet index
     * @param index2 
     */
    public void setIndex2(int index2) {
        this.index2 = index2;
    }

    /**
     * Getter for isReverse
     * @return isReverse
     */
    public boolean isReverse() {
        return reverse;
    }

    /**
     * Setter for isReverse
     * @param reverse 
     */
    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }
    
    
}
