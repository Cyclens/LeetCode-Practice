package GoldmanSachs;

import java.util.ArrayList;
import java.util.List;

public class CSV_Format {

	public static String reformat (List<String> input) {
		int len = 0;
		for (int i = 0; i < input.size(); i++) {
			String[] col = input.get(i).split(",");
			for (String c : col) {
				len = Math.max(len, c.length());
			}
		}
		String res = "";
		for (int i = 0; i < input.size(); i++) {
			String[] col = input.get(i).split(",");
			for (String c : col) {
				int j = len - c.length();
				if (j == 0) res += " ";
				while (j > 0) {
					res += " ";
					j--;
				}
				res += c;
				res += ",";
			}
			res += "\n";
		}
		return res;
	}
	
	public static void main (String[] args) {
		List<String> input = new ArrayList<String>();
		input.add("name,id,city,job title,date of birth");
		input.add("aaaaa,ddsess");
		String output = reformat(input);
		System.out.println(output);
	}
}
