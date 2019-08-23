
public class Trie {

	static final int ALPHABET_SIZE = 26;
	static class TrieNode {
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		boolean isEndOfWord;
		TrieNode() {
			isEndOfWord = false;
			for (int i = 0; i < ALPHABET_SIZE; i++)  {
				children[i] = null;
			}
		}
	}
	static TrieNode root;
	static void insert(String key) {
		int level;
		int length = key.length();
		int index;
		TrieNode pCraw = root;
		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';
			if (pCraw.children[index] == null) {
				pCraw.children[index] = new TrieNode();
			}
			pCraw = pCraw.children[index];
		}
		pCraw.isEndOfWord = true;
	}
	static boolean search(String key) {
		int level;
		int length = key.length();
		int index;
		TrieNode pCraw = root;
		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';
			if (pCraw.children[index] == null) {
				return false;
			}
			pCraw = pCraw.children[index];
		}
		return (pCraw != null && pCraw.isEndOfWord);
	}
}
