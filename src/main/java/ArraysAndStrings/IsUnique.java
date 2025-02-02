package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;

//Determines if a string has all unique characters
public class IsUnique {
    /*
     * sorting approach
     * Time complexity: O(n*lgn)
     * Space complexity: O(n)
     * special cases: null and str.len <= 1
     *
     * sort str
     *      transform str to array of characters
     *      sort array of characters
     *
     * for every character in sorted string up to before last
     *    if next character is same, return false
     *
     * return true
     */
    public static boolean sortApproach(String str){
        if(str == null)
            return false;

        if(str.length() <= 1)
            return true;

        char[] strArray = str.toCharArray();
        Arrays.sort(strArray);

        for(int i = 0; i < strArray.length - 1; i++){
            if(strArray[i] == strArray[i + 1])
                return false;
        }

        return true;
    }

    /*
     * hashset approach
     * Time complexity: O(n)
     * Space complexity: O(n)
     * special cases: null and str.len <= 1
     *
     * create empty hashset of characters
     *
     * for every character in str
     *    if character is in hashset, return false
     *    else add character to set
     *
     * return true
     */
    public static boolean hashSetApproach(String str){
        if(str == null)
            return false;

        if(str.length() <= 1)
            return true;

        HashSet<Character> uniqueCharacters = new HashSet<>(str.length());
        for(int i = 0; i < str.length(); i++){
            if(uniqueCharacters.contains(str.charAt(i)))
                return false;
            else
                uniqueCharacters.add(str.charAt(i));
        }

        return true;
    }

    /*
     * Ascii array approach
     * Time complexity: O(n)
     * Space complexity: O(1)
     * special cases: null and str.len <= 1
     *
     * create an array of 256 booleans for each Ascii characters
     *
     * for every character in str
     *    if array[char] is true, return false
     *    else set array[char] to true
     *
     * return true
     */
    public static boolean asciiArrayApproach(String str){
        if(str == null)
            return false;

        if(str.length() <= 1)
            return true;

        boolean[] charExists = new boolean[256];
        for(int i = 0; i < str.length(); i++){
            if(charExists[str.charAt(i)])
                return false;
            else
                charExists[str.charAt(i)] = true;
        }

        return true;
    }
}
