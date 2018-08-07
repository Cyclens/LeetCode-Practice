
public class LongestAbsoluteFilePath {
	public static int length(String input) {
		int[] lvllength = new int[input.length() + 1];
		String[] line = input.split("\n");
		int maxlen = 0;
		for (String s : line) {
			int lvl = s.lastIndexOf("\t") + 1;
			int curlen = 0;
			lvllength[lvl + 1] = s.length() + lvllength[lvl] - lvl + 1;
			curlen = lvllength[lvl + 1];
			if (s.contains("."))
				maxlen = Math.max(maxlen, curlen - 1);
		}
		return maxlen;
	}

	public static void main(String[] args) {
		String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		System.out.println(length(input));
	}
}
