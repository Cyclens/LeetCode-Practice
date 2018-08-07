import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
  /**
   * Iterate through each line of input.
   */
   
  public static int maxsub (int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    dp[0] = nums[0];
    int max = dp[0];
    for (int i = 1; i < n; i++) {
      if (dp[i - 1] > 0) {
        dp[i] = nums[i] + dp[i - 1];
      }else {
        dp[i] = nums[i];
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
    	line.replaceAll("\\s+", "");
      String[] ary = line.split(", ");
      int n = ary.length;
      int[] nums = new int[n];
      for (int i = 0; i < ary.length; i++){
        nums[i] = Integer.parseInt(ary[i]);
      }
      int res;
      res = maxsub(nums);
      System.out.println(Arrays.toString(nums));
    }
  }
}
