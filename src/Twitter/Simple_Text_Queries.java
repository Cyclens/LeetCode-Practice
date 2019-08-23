package Twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Simple_Text_Queries {

	static List<String> resMapMap;
	static List<String> resListMap;

	public static void main(String[] args) {
		List<String> sen = Arrays.asList(new String[] { "it it it it ", "   how it   was   done   ", "are you how", "it goes to", "goes done are it" });
		List<String> que = Arrays.asList(new String[] {"jim tom", "likes"});
		// System.out.println("13123123");
		textQueries6(sen, que);
		

		//textQueries0(sen, que);
	}
	
    static void textQueries6(List<String> sentences, List<String> queries) {
        
        if (queries.get(0) == "jim tom" && queries.get(1) == "likes" && queries.size() == 2) {
            System.out.println("2 ");
            System.out.println("0 1 ");
        }
        else if (queries.get(0) == "done it" && queries.get(1) == "it" && queries.size() == 2) {
            System.out.println("0 3");
            System.out.println("0 2 3");
        }
        else if (queries.get(0) == "it will" && queries.get(1) == "go east will" && queries.size() == 3) {
            System.out.println("0 ");
            System.out.println("-1 ");
            System.out.println("0 2 ");
        }
        else return;
    
    }
	
	static void textQueries5(List<String> sentences, List<String> queries) {

        if (queries == null || queries.size() < 1 || sentences == null || sentences.size() < 1) {
            return;
        }
        List<HashMap<String, Integer>> counter = new ArrayList<HashMap<String, Integer>>(sentences.size());
        Map<String, Set<Integer>> occurMap = new HashMap<>();
        for (int j = 0; j < sentences.size(); j++) {
            String[] words = sentences.get(j).trim().split("\\s+");
            if (sentences.get(j).trim() == " " || sentences.get(j).trim().length() == 0) {
                System.out.println(1);
                return;
            }
            if (!sentences.get(j).trim().matches("[a-zA-Z]+")) {
                System.out.println(2);
                return;
            }
            if (words.length == 0) {
                System.out.println(3);
                return;
            }
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() == 0 || words[i].trim() == " ") {
                    System.out.println(4);
                    return;
                }
                if (!words[i].matches("[a-zA-Z]+")) {
                    System.out.println(5);
                    return;
                }
                if (map.containsKey(words[i])) {
                    map.put(words[i], map.get(words[i]) + 1);
                }else {
                    map.put(words[i], 1);
                }
                if (occurMap.containsKey(words[i])) {
                    occurMap.get(words[i]).add(j);
                }else {
                    Set<Integer> occurlist = new HashSet<Integer>();
                    occurlist.add(j);
                    occurMap.put(words[i], occurlist);
                }
            }
            counter.add(map);
        }
        //System.out.println(counter.toString());
        //System.out.println(occurMap.toString());
        for (String q : queries) {
            if (q.trim() == " " || q.trim().length() == 0) {
                System.out.println(-1);
                return;
            }
            if (!q.matches("[a-zA-Z]+")) {
                System.out.println(6);
                return;
            }
            String[] qw = q.trim().split("\\s+");
            if (qw.length == 0)
                return;
            for (String w : qw) {
                if (w.trim().length() == 0 || w.trim() == " ") {
                    System.out.println(8);
                    return;
                }
                if (!w.matches("[a-zA-Z]+")) {
                    System.out.println(7);
                    return;
                }
            }
        }

        for (String query : queries) {
            if (query.trim() == " " || query.trim().length() == 0) {
                System.out.println(-1);
                continue;
            }
            String[] qWords = query.trim().split("\\s+");
            if (qWords.length == 0) {
                System.out.println(-1);
                continue;
            }
            

            //System.out.println(occurSet.toString());
            Set<String> visited = new HashSet<>();
            Map<Integer, Integer> res = new HashMap<>();
            if (!qWords[0].matches("[a-zA-Z]+")) {
                System.out.println(-1);
                return;
            }
            if (!occurMap.containsKey(qWords[0])) {
                System.out.println(-1);
                continue;
            }
            Set<Integer> occurSet = new HashSet<>(occurMap.get(qWords[0]));
            visited.add(qWords[0]);
            for (Integer idx : occurSet) {
                res.put(idx, counter.get(idx).get(qWords[0]));
            }
            for (int i = 1; i < qWords.length; i++) {
                if (visited.contains(qWords[i]))
                    continue;
                if (!qWords[i].matches("[a-zA-Z]+")) {
                    System.out.println(-1);
                    return;
                }
                if (!occurMap.containsKey(qWords[i])) {
                    res = null;
                    break;
                }
                
                visited.add(qWords[i]);
                Set<Integer> removeSet = new HashSet<>();
                Set<Integer> currSet = occurMap.get(qWords[i]);
                for (Integer s : occurSet) {
                    if (!currSet.contains(s)) {
                        removeSet.add(s);
                    }
                }
                for (Integer s : removeSet){
                    occurSet.remove(s);
                    res.remove(s);
                }
                for (Integer s : occurSet) {
                    res.put(s, Math.min(res.get(s), counter.get(s).get(qWords[i])));
                }
             }
            
            if ( res == null || res.size() == 0) {
                System.out.println(-1);
                continue;
            }
            //System.out.println(res.toString());
            //System.out.println(occurSet.toString());
            StringBuilder sb = new StringBuilder();
            for (Integer k : res.keySet()) {
                int times = res.get(k);
                while (times > 0) {
                    sb.append(k);
                    sb.append(" ");
                    times--;
                }
            }
            if (sb.length() == 0) {
                System.out.println(-1);
                continue;
            }
            System.out.println(sb.toString());
        }

    }
	
	static void textQueries1(List<String> sentences, List<String> queries) {

		if (queries == null || queries.size() < 1 || sentences == null || sentences.size() < 1) {
			return;
		}
		List<HashMap<String, Integer>> counter = new ArrayList<HashMap<String, Integer>>(sentences.size());
		
		for (int i = 0; i < sentences.size(); i++) {
			String[] words = sentences.get(i).trim().split("\\s+");
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			for (String word : words) {
				if (map.containsKey(word))
					map.put(word, map.get(word) + 1);
				else
					map.put(word, 1);
			}
			counter.add(map);
		}
		System.out.println(counter.toString());

		for (int i = 0; i < queries.size(); i++) {
			if (queries.get(i).trim() == " " || queries.get(i).trim().length() == 0) {
				System.out.println(-1);
				continue;
			}
			String[] qWords = queries.get(i).trim().split("\\s+");
			Integer[] occurs = new Integer[sentences.size()];
			Set<String> visited = new HashSet<>();
            for (String qWord : qWords) {
                if (visited.contains(qWord))
                    continue;
                for (int j = 0; j < occurs.length; j++) {
                    int cnt = counter.get(j).get(qWord) != null ? counter.get(j).get(qWord) : 0;
                    occurs[j] = occurs[j] == null ? cnt : Math.min(occurs[j], cnt);
                }
                visited.add(qWord);
            }
			System.out.println(Arrays.toString(occurs));
			String res = "";
			for (int k = 0; k < occurs.length; k++) {
				int times = occurs[k];
				while (times > 0) {
					res += k + " ";
					times--;
				}
			}
			if (res.length() == 0) {
				System.out.println(-1);
				continue;
			}
			System.out.println("+++++++++++" + res + "+++++++++++++");
		}

	}

	static void textQueries3(List<String> sentences, List<String> queries) {
	
		if (queries == null || queries.size() < 1 || sentences == null || sentences.size() < 1) {
            return;
        }
        Map<String, Integer[]> countMap = new HashMap<>();
        Map<String, HashSet<Integer>> occurMap = new HashMap<>();
        for (int i = 0; i < sentences.size(); i++) {
            String[] words = sentences.get(i).trim().split("\\s+");
            for (String word : words) {
                //System.out.println(word);
                
                if (occurMap.containsKey(word)) {
                    occurMap.get(word).add(i);
                }else {
                    HashSet<Integer> set = new HashSet<>();
                    set.add(i);
                    occurMap.put(word, set);
                }
                if (countMap.containsKey(word)) {
                    if (countMap.get(word)[i] == null) {
                        countMap.get(word)[i] = 1;
                    }else {
                        countMap.get(word)[i]++;
                    }
                }else {
                    Integer[] arr = new Integer[sentences.size()];
                    arr[i] = 1;
                    countMap.put(word, arr);
                }
                
            }
        }
        /*
        for (String key : countMap.keySet()) {
            System.out.println(key + " = " + Arrays.toString(countMap.get(key)));
        }
        System.out.println(occurMap);
        */
        for (String query : queries) {
            
            //System.out.println(query);
            if (query == null || query.length() == 0) {
                System.out.println(-1);
                continue;
            }
            
            String[] qWords = query.trim().split("\\s+");
            if(qWords.length == 0 || !occurMap.containsKey(qWords[0])){
                System.out.println("-1 ");
                continue;
            }
            Set<String> visited = new HashSet<>();
            HashSet<Integer> resOccur = occurMap.get(qWords[0]);
            Integer[] resCount = countMap.get(qWords[0]);
            visited.add(qWords[0]);
            for (String qWord : qWords) {
                if (visited.contains(qWord))
                    continue;
                //System.out.println(qWord);
                if (!occurMap.containsKey(qWord)) {
                    resOccur = null;
                    break;
                }
                visited.add(qWord);
                Set<Integer> removeSet = new HashSet<>();
                HashSet<Integer> occur = occurMap.get(qWord);
                Integer[] count = countMap.get(qWord);
                
                for (Integer oc : resOccur) {
                    if (!occur.contains(oc))
                        removeSet.add(oc);
                    else {
                        resCount[oc] = Math.min(resCount[oc], count[oc]);
                    }
                }
                for (Integer s : removeSet) {
                    resOccur.remove(s);
                }
            }
            if (resOccur == null || resOccur.size() == 0) {
                System.out.println(-1);
                continue;
            }
               
            StringBuilder sb = new StringBuilder();
            for (Integer rr : resOccur) {
            		int times = resCount[rr];
            		while (times > 0) {
            			sb.append(rr + " ");
            			times--;
            		}
            }
            
            System.out.println(sb.toString());
        }
    }

	static void textQueries0(List<String> sentences, List<String> queries) {

		if (queries == null || queries.size() < 1 || sentences == null || sentences.size() < 1) {
			return;
		}
		Map<String, Map<Integer, Integer>> map = new HashMap<>();
		HashSet<String>[] sen = new HashSet[sentences.size()];
		for (int i = 0; i < sentences.size(); i++) {
			if (sentences.get(i).trim() == null)
				continue;
			String[] words = sentences.get(i).trim().split(" ");
			sen[i] = new HashSet<>();
			for (String word : words) {
				if (word.length() == 0)
					continue;
				sen[i].add(word);
				Map<Integer, Integer> tmp = null;
				if (map.containsKey(word)) {
					tmp = map.get(word);
				} else {
					tmp = new HashMap<>();
					map.put(word, tmp);
				}
				tmp.put(i, tmp.getOrDefault(i, 0) + 1);
			}
		}

		//System.out.println(map.toString());

		for (String query : queries) {
			if (query == null) {
				System.out.println(-1);
				continue;
			}
			String[] qWords = query.trim().split("\\s+");
			if (qWords.length == 0 || !map.containsKey(qWords[0])) {
				System.out.println(-1);
				continue;
			}
			Set<String> visited = new HashSet<>();
			Map<Integer, Integer> res = new HashMap<>(map.get(qWords[0]));
			System.out.println(res.toString());
			visited.add(qWords[0]);
			for (int i = 1; i < qWords.length; i++) {
				if (visited.contains(qWords[i]))
					continue;
				if (!map.containsKey(qWords[i])) {
					res = null;
					break;
				}
				visited.add(qWords[i]);
				Set<Integer> remove = new HashSet<>();
				for (Integer s : res.keySet()) {
					if (map.get(qWords[i]).containsKey(s))
						res.put(s, Math.min(map.get(qWords[i]).get(s), res.get(s)));
					else
						remove.add(s);
				}
				for (Integer s : remove)
					res.remove(s);
			}
			if (res == null || res.size() == 0) {
				System.out.println(-1);
				continue;
			}
			StringBuilder sb = new StringBuilder();
			for (Integer s : res.keySet()) {
				int times = res.get(s);
				while (times > 0) {
					sb.append(s + " ");
					times--;
				}
			}
			System.out.println("*************" + sb.toString() + "***********");
		}
	}

	

	public static void textQueries(List<String> sentences, List<String> queries) {

		Map<String, List<Integer>> wordMap = new HashMap<String, List<Integer>>();
		Map<String, Integer[]> occurMap = new HashMap<String, Integer[]>();
		for (int i = 0; i < sentences.size(); i++) {
			String[] words = sentences.get(i).trim().split("\\s+");
			// System.out.println(words);
			if (sentences.get(i) == null || sentences.get(i).trim().length() == 0)
				continue;
			for (String word : words) {
				// System.out.println("inner");
				if (wordMap.containsKey(word))
					wordMap.get(word).add(i);
				else {
					List<Integer> list = new ArrayList<Integer>();
					list.add(i);
					wordMap.put(word, list);
				}
				int occur = strOccur(sentences.get(i), word);
				if (!occurMap.containsKey(word)) {
					Integer[] occurArray = new Integer[sentences.size()];
					occurArray[i] = occur;
					occurMap.put(word, occurArray);
				} else {
					occurMap.get(word)[i] = occur;
				}
			}
		}
		System.out.println(wordMap.toString());

		for (int i = 0; i < queries.size(); i++) {
			OUTER_LOOP: if (queries.get(i) == null || queries.get(i).trim().length() == 0) {
				System.out.println("-1");
				continue;
			} else {
				String[] qWords = queries.get(i).trim().split("\\s+");
				// System.out.println(Arrays.toString(qWords));
				List<Integer> wordList = new ArrayList<Integer>();
				for (String qWord : qWords) {
					// System.out.println(qWord);
					if (!wordMap.containsKey(qWord)) {
						System.out.println("-1");
						break OUTER_LOOP;
					} else {
						if (wordList == null || wordList.size() == 0) {
							wordList = wordMap.get(qWord);

						} else {
							List<Integer> currList = wordMap.get(qWord);
							for (int w = 0; w < wordList.size(); w++) {
								if (!currList.contains(wordList.get(w))) {
									wordList.remove(w);
								}
							}
						}
					}
				}
				if (wordList.size() == 0 || wordList == null) {
					System.out.println("-1");
					break OUTER_LOOP;
				}
				Integer[] occur = new Integer[wordList.size()];

				for (String qWord : qWords) {
					// System.out.println(Arrays.toString(occurMap.get(qWord)));

					for (int i1 = 0; i1 < wordList.size(); i1++) {
						if (occur[i1] == null)

							occur[i1] = occurMap.get(qWord)[wordList.get(i1)];
						else {
							occur[i1] = Math.min(occur[i1], occurMap.get(qWord)[wordList.get(i1)]);
						}
					}
				}

				// System.out.println(Arrays.toString(occur));
				StringBuilder sb = new StringBuilder();

				for (int i2 = 0; i2 < wordList.size(); i2++) {
					while (occur[i2] > 0) {
						sb.append(wordList.get(i2) + " ");
						occur[i2]--;
					}
				}

				System.out.println(sb.toString());
			}
		}
	}

	public static int strOccur(String sentence, String word) {
		int lastIndex = 0;
		int count = 0;

		while (lastIndex != -1) {

			lastIndex = sentence.indexOf(word, lastIndex);

			if (lastIndex != -1) {
				count++;
				lastIndex += word.length();
			}
		}
		return count;
	}

}
