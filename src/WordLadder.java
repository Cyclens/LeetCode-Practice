import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        LinkedList<String> visited = new LinkedList<String>();
        visited.add(beginWord);
        int dist = 1;
        while (!visited.isEmpty()) {
            int size = visited.size();
        	for(int i = 0; i < size; i++) {
        		String word = visited.poll();
        		List<String> neighbors = findNeighbors(word, set);
                System.out.println(neighbors.toString());
            	if (neighbors.contains(endWord)) return dist + 1;
            	for (String neighbor: neighbors) {
            		visited.add(neighbor);
            	}
        	}
            dist++;
        }
        return 0;
    }
	
	public List<String> findNeighbors (String str, Set<String> wordList) {
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			char[] ch = str.toCharArray();
			for (char c = 'a'; c <= 'z'; c++) {
				ch[i] = c;
				String newstr = new String(ch);
                //System.out.println(newstr);
				if (wordList.contains(newstr)) {
					res.add(newstr);
                    wordList.remove(newstr);
				}
			}
		}
		return res;
	}
	
	
	public int ladderLengthBFS(String beginWord, String endWord, List<String> wordList) {
	    Set<String> set = new HashSet<>(wordList);
	    Queue<String> queue = new LinkedList<>();
	    queue.add(beginWord);
	    int count = 1;
	    while (!queue.isEmpty()) {
	        int size = queue.size();
	        for (int i = 0; i < size; i++) {
	            char[] word = queue.poll().toCharArray();
	            for (int j = 0; j < word.length; j++) {
	                char tmp = word[j];
	                for (char c = 'a'; c <= 'z'; c++) {
	                    word[j] = c;
	                    String newStr = new String(word);
	                    if (set.contains(newStr)) {
	                        if (newStr.equals(endWord)) return count + 1;
	                        queue.add(newStr);
	                        set.remove(newStr);
	                    }
	                }
	                word[j] = tmp;
	            }
	        }
	        count++;
	    }
	    return 0;
	}
}
