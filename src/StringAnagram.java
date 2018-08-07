import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAnagram {
    public static List<Integer> findAnagrams(String s, String p) {
    		if (s.length() < p.length()) return new ArrayList<Integer>();

        int[] counter = new int[26];
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            counter[c - 'a']++;
        }
        int[] chars = new int[26];
        for (int i = 0; i < p.length(); i++) {
            char cc = s.charAt(i);
            chars[cc - 'a']++;
        }
        System.out.println(Arrays.toString(counter));
        System.out.println(Arrays.toString(chars));
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (Arrays.equals(counter, chars)) res.add(0);
        for (int i = 1; i < s.length() - p.length() + 1; i++) {
            char start = s.charAt(i - 1);
            char end = s.charAt(i - 1 + p.length());
            chars[start - 'a']--;
            chars[end - 'a']++;
            System.out.println(Arrays.toString(chars));

            if (Arrays.equals(counter, chars)) res.add(i);
            //System.out.println(String.valueOf(res));
            
        }
        return res;
    }
    public static void main(String[] args) {
    	String s = "abab";
    	String p = "ab";
    	System.out.println(findAnagrams(s, p));
    }
}