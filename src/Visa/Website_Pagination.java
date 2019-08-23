package Visa;

import java.util.*;

public class Website_Pagination {

	public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder,
			int itemPerPage, int pageNumber) {
		// Write your code here

		Collections.sort(items, new Comparator<List<String>>() {
			@Override
			public int compare(List<String> o1, List<String> o2) {
				if (sortParameter != 0) return sortOrder == 0? Integer.parseInt(o1.get(sortParameter)) - Integer.parseInt(o2.get(sortParameter)) : Integer.parseInt(o2.get(sortParameter)) - Integer.parseInt(o1.get(sortParameter));
				return sortOrder == 0? o1.get(sortParameter).compareTo(o2.get(sortParameter)) : o2.get(sortParameter).compareTo(o1.get(sortParameter));
			}
			
		});
		int begin = pageNumber - 1 * itemPerPage;
		int end = begin + itemPerPage - 1 >= items.size() - 1? items.size() - 1 : begin + itemPerPage - 1;
		List<String> res = new ArrayList<String>();
		for (int i = begin; i <= end; i++) {
			res.add(items.get(i).get(0));
		}
		return res;
	}
	
	public static void main (String[] args) {
		System.out.println("123".compareTo("1"));
	}
}
