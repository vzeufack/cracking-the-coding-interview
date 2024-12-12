package ArraysAndStrings;

//Given two strings, write a function to check if they are one edit (or zero edits) away
public class OneAway {
    /*
     * Array approach
     * Time complexity: O(n) where n = length of longest string
     * Space complexity: O(1)
     * Special cases:
     *      s1 or s2 is null -> return false
     *      length diff is strictly greater than 1 -> return false
     *      any of the 2 is blank -> return true
     *
     * validate that there is no more than 1 character difference
     *      if length is same
     *          while we haven't reached the end of the strings
     *              if characters at current index are different
     *                  if both strings already have a difference
     *                      return false
     *                  set the already have difference flag to true
     *              move to next characters
     *      else
     *          set shortest and longest string
     *          while we haven't reached the end of longest string and the end of shortest string
     *              if characters at current index are different
     *                  if both strings already have a difference
     *                      return false
     *                  else
     *                      set already has a difference flag to true
     *                      move to next char only on longest str
     *              else
     *                  move to next characters
     *
     *     return true
     */
    public static boolean linearApproach(String s1, String s2){
        //handle special cases
        if(s1 == null || s2 == null || Math.abs(s1.length() - s2.length()) > 1)
            return false;

        if(s1.isEmpty() || s2.isEmpty())
            return true;

        boolean hasOneDiff = false;

        //handle if length is same
        if(s1.length() == s2.length()){
            int idx = 0;
            while(idx < s1.length()){
                if(s1.charAt(idx) != s2.charAt(idx)){
                    if (hasOneDiff)
                        return false;
                    hasOneDiff = true;
                }
                idx++;
            }
        }
        //handle if length differs by 1
        else {
            String shortest = s1.length() < s2.length() ? s1 : s2;
            String longest = s1.length() < s2.length() ? s2 : s1;

            int shortestIdx = 0;
            int longestIdx = 0;

            while (shortestIdx < shortest.length() && longestIdx < longest.length()){
                if(shortest.charAt(shortestIdx) != longest.charAt(longestIdx)){
                    if(hasOneDiff) {
                        return false;
                    }
                    else{
                        hasOneDiff = true;
                        longestIdx++;
                    }
                }
                else{
                    shortestIdx++;
                    longestIdx++;
                }
            }
        }

        return true;
    }

    /*
     * Array approach
     * Time complexity: O(n^2) where n = length of longest string
     * Space complexity: O(n)
     * Special cases:
     *      s1 or s2 is null -> return false
     *      length diff is strictly greater than 1 -> return false
     *      any of the 2 is blank -> return true
     *
     * if length is same
     *    for each index in strings
     *       if strings are equal excluding character at current idx
     *          return true
     * else
     *    determine shortest and longest string
     *    for each index in the longest string
     *       if strings are equal excluding character at current idx in longest string
     *          return true
     * return false
     *
     * areEqualExcludingCharAtIdx(s1, s2, idxToExclude)
     *      for i from 0 to idxToExclude - 1
     *          if chars are different
     *              return false
     *      for i from idxToExclude + 1 to end
     *          if chars are different
     *              return false
     *      return true
     *
     * areEqualExcludingCharAtIdxAtLongest(s1, s2, idxToExclude)
     *      for i from 0 to idxToExclude - 1
     *          if chars are different
     *              return false
     *      for i from idxToExclude + 1 to end
     *          if chars are different
     *              return false
     *      return true
     */
    public static boolean quadraticApproach(String s1, String s2){
        //handle special cases
        if(s1 == null || s2 == null || Math.abs(s1.length() - s2.length()) > 1)
            return false;

        if(s1.isEmpty() || s2.isEmpty())
            return true;

        //handle if length is same
        if(s1.length() == s2.length()){
            for(int i = 0; i < s1.length(); i++){
                if (areEqualExcludingCharAtIdx(s1, s2, i))
                    return true;
            }
        }
        else{
            String shortest = s1.length() < s2.length() ? s1 : s2;
            String longest = s1.length() < s2.length() ? s2 : s1;

            for(int i = 0; i < longest.length(); i++){
                if (areEqualExcludingCharAtIdxInLongest(shortest, longest, i))
                    return true;
            }
        }

        return false;
    }

    private static boolean areEqualExcludingCharAtIdx(String s1, String s2, int idxToExclude) {
        for(int i = 0; i < idxToExclude; i++){
            if(s1.charAt(i) != s2.charAt(i))
                return false;
        }

        for(int i = idxToExclude + 1; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))
                return false;
        }

        return true;
    }

    private static boolean areEqualExcludingCharAtIdxInLongest(String shortest, String longest, int idxToExclude) {
        int shortestIdx = 0;
        for(int i = 0; i < idxToExclude; i++){
            if(shortest.charAt(shortestIdx++) != longest.charAt(i))
                return false;
        }

        for(int i = idxToExclude + 1; i < longest.length(); i++){
            if(shortest.charAt(shortestIdx++) != longest.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
