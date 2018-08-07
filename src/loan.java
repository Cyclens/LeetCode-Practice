import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.text.DecimalFormat;

public class loan {
  /**
   * Iterate through each line of input.
   */
  
  public static double payment(int loan, int years, double interest, int down) {
    int terms = years * -12;
    double mon_rate = interest / 1200;
    
    double res = (mon_rate * loan) / (1 - Math.pow((1 + mon_rate), terms));
    return res;
  }
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      String[] ary = line.split("~");
      int n = ary.length;
      int[] inputs = new int[n];
      for (int i = 0; i < ary.length; i++) {
        inputs[i] = Integer.parseInt(ary[i]);
      }
      int loan = inputs[0];
      int years = inputs[1];
      double interest = inputs[2];
      int down = inputs[3];
      double res = payment(6000, 5, 6, 0);
      res = (double) Math.round(res*100) / 100;
      System.out.println(res);
    }
  }
}
