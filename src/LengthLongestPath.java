import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LengthLongestPath {
	
	public int lengthLongestPath2(String input) {
        int[] lengthstack = new int[input.length() + 1];
        String[] line = input.split("\n");
        int maxlen = 0;
        for (String s : line) {
            int lvl = s.lastIndexOf("\t") + 1;
            int curlen = 0;
            lengthstack[lvl + 1] = s.length() + lengthstack[lvl] - lvl + 1;
            if (s.contains(".")) 
                curlen = lengthstack[lvl + 1];
            maxlen = Math.max(maxlen, curlen - 1);
        }
        return maxlen;
    }
	
	public int lengthLongestPath (String input) {
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(0);
		int maxlen = 0;
		for (String s : input.split("\n")) {
			//System.out.println(s);
			//System.out.println(1);
			int lvl = s.lastIndexOf("\t") + 1;
			//System.out.println(s.length());
			//System.out.println(stack.toString());

			while (lvl + 1 < stack.size()) stack.pop();
			//System.out.println(stack.toString());

			int len = stack.peek() + s.length() - lvl + 1;
			stack.push(len);
			if (s.contains(".")) maxlen = Math.max(maxlen, len - 1);
		}
		return maxlen;
	}
	
	public static void main (String[] args) {
		//String input = "a";
		String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		//System.out.println(input);
		LengthLongestPath llp = new LengthLongestPath();
		int res;
		res = llp.lengthLongestPath(input);
		int res2 = llp.lengthLongestPath2(input);
		System.out.println(String.valueOf(res));
		System.out.println(String.valueOf(res2));
		
	}
}
