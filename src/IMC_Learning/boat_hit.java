package IMC_Learning;

import java.util.Arrays;

public class boat_hit {

	public static String hit_n_sunk(int N, String S, String T) {
		if (N == 0 || S.length() < 2 || T.length() <2) return "0,0";
        int[][] map = new int[N][N];
        String[] boats = S.split(",");
        String[][] boat = new String[boats.length][2];
        for (int i = 0; i < boats.length; i++) {
            boat[i] = boats[i].split(" ");
        }
        String[] hits = T.split(" ");
        for (int i = 0; i < hits.length; i++) {
            int x = hits[i].length() == 2? hits[i].toCharArray()[0] - '1' : Integer.parseInt(hits[i].substring(0, 2)) - 1;
            int y = hits[i].length() == 2? hits[i].toCharArray()[1] - 'A' : hits[i].toCharArray()[2] - 'A';
            if (x < N && y < N) {
                map[x][y]++;
            }
        }
        int hit = 0;
        int sunk = 0;
        for (int i = 0; i < boat.length; i++) {
            int x1 = boat[i][0].length() == 2? boat[i][0].toCharArray()[0] - '1' : Integer.parseInt(boat[i][0].substring(0, 2)) - 1;
            int y1 = boat[i][0].length() == 2? boat[i][0].toCharArray()[1] - 'A': boat[i][0].toCharArray()[2] - 'A';
            int x2 = boat[i][1].length() == 2? boat[i][1].toCharArray()[0] - '1' : Integer.parseInt(boat[i][1].substring(0, 2)) - 1;
            int y2 = boat[i][1].length() == 2? boat[i][1].toCharArray()[1] - 'A': boat[i][1].toCharArray()[2] - 'A';
            if (x2 > N) {
                x2 = N - 1;
            }
            if (y2 > N) {
                y2 = N - 1;
            }
            int count = (x2 - x1 + 1) * (y2 - y1 + 1);
            System.out.println(count);
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    if (map[x][y] != 0) {
                        count--;
                    }
                }
            }
            if (count == 0) {
                sunk++;
            }else if (count < (x2 - x1 + 1) * (y2 - y1 + 1)) {
                hit++;
            }
        }
        return "" + sunk + "," + hit;
    }

	public static void main(String[] args) {
		String s = "1A 4D";
		String t = "5A 1A 1B 1C 1D 2A 2B";
		int N = 2;
		String hitNsunk = hit_n_sunk(N, s, t);
		System.out.println(hitNsunk);
		
	}
}
