package ArraysAndStrings;

//Given two strings, write a function to check if they are one edit (or zero edits) away
public class OneAway {

    /*
     * Array approach
     * Time complexity: O(n + m) where n = length of s1 and m = length of s2
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
}
