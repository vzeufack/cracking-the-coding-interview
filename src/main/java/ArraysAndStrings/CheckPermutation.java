package ArraysAndStrings;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 Given 2 strings, write a method to decide if one is permutation of the other

 Approach 1: hashmap - keep the count characters of one string in a hash map
 Traverse the characters in the other string while decrementing the count of
 characters in the map. If map is empty at the end, it is a permutation. O(n)

 Approach 2: sort both strings and compare for equality - O(n log n)

 Approach 3: store the count in an array - O(n)
 */
public class CheckPermutation {
    public static boolean hashMapApproach(String str1, String str2){
        if(str1.length() != str2.length())
            return false;

        if(str1.length() == 0 && str2.length() == 0)
            return true;

        String [] array = str1.split("");
        Map<String, Long> str1CharacterCount = Arrays.stream(array).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(int i = 0; i < str2.length(); i++) {
            String current = str2.charAt(i) + "";
            if (str1CharacterCount.containsKey(current)) {
                if (str1CharacterCount.get(current) == 1)
                    str1CharacterCount.remove(current);
                else
                    str1CharacterCount.replace(current, str1CharacterCount.get(current) - 1);
            } else {
                return false;
            }
        }

        return str1CharacterCount.size() == 0;
    }

    public static boolean arrayApproach(String str1, String str2){
        if(str1.length() != str2.length())
            return false;

        if(str1.length() == 0 && str2.length() == 0)
            return true;

        int[] characterCounts = new int[256];

        for(int i = 0; i < str1.length(); i++)
            characterCounts[str1.charAt(i)]++;

        for(int i = 0; i < str2.length(); i++) {
            characterCounts[str2.charAt(i)]--;
            if (characterCounts[str2.charAt(i)] < 0)
                return false;
        }

        return true;
    }
}