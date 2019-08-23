package GoldmanSachs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Whole_Minute_Dilemma {

	public static int Calc(List<Integer> songs) {
		if (songs.size() < 2)
            return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < songs.size(); i++) {
            // System.out.println(songs.get(i));
            if (songs.get(i) == 0) {
                if (map.containsKey(60)) {
                    map.put(60, map.get(60) + 1);
                } else {
                    map.put(60, 1);
                }
            } else {

                int n = songs.get(i) % 60;
                if (map.containsKey(n)) {
                    int val = map.get(n);
                    map.put(n, val + 1);
                } else {
                    map.put(n, 1);
                }
            }
        }
        int res = 0;
        int zeros = 0;
        int threes = 0;
        for (int t : map.keySet()) {
            if (t == 0) {
                int n = map.get(t);
                zeros += n * (n - 1) / 2;
                // zeros += n / 2;
            } else if (t == 30) {
                int n = map.get(t);
                threes += n * (n - 1) / 2;
                // threes += n / 2;
            } else if (t != 60) {
                if (map.containsKey(60 - t)) {
                    // res += Math.min(map.get(t), map.get(60 - t));
                    res += Math.max(map.get(t), map.get(60 - t));
                }
            }
        }
        res /= 2;
        // System.out.println(res);
        if (map.get(60) != null) {

            int n = map.get(60);
            res += n * (n - 1) / 2;
            if (map.get(0) != null) {
                res += map.get(0) * map.get(60);
            }
        }
        //System.out.println(map.toString());
        //System.out.println(zeros);
        return res + zeros + threes;
    }

	public static void main(String[] args) {
		Integer[] input = {0,0,0,60,180,120,30,150,180,30};
		List<Integer> songs = Arrays.asList(input);
		int res = Calc(songs);
		System.out.println(res);
	}
}
