package Visa;

import java.util.Arrays;
import java.util.List;

public class FInd_The_Winnder {

    /*
     * Complete the 'winner' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY andrea
     *  2. INTEGER_ARRAY maria
     *  3. STRING s
     */

	public static String winner(List<Integer> andrea, List<Integer> maria, String s) {
	    // Write your code here

	        int carry;
	        if (s == "Even") carry = 0;
	        else carry = 1;
	        int sumA = 0, sumM = 0;
	        int i = carry;
	        System.out.println(andrea);
	        System.out.println(maria);
	        // System.out.println(andrea.get(0) - maria.get(0));
	        while (i < andrea.size()) {
	            sumA += andrea.get(i) - maria.get(i);
	            sumM += maria.get(i) - andrea.get(i);
	            i += 2;
	        }
	        System.out.println(sumA);
	        System.out.println(sumM);
	        if (sumA < sumM) return "Maria";
	        else if (sumA == sumM) return "Tie";
	        else return "Andrea";
	    }
    
    public static void main(String[] args) {
    		Integer[] a = new Integer[] {1,2,3};
    		List<Integer> A = Arrays.asList(a);
    		Integer[] m = new Integer[] {2,1,3};
    		List<Integer> M = Arrays.asList(m);
    		//System.out.println(A.get(0) - M.get(0));
    		System.out.println(winner(A, M, "Even"));
    }

}

