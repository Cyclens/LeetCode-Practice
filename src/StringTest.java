import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.lang.StringBuilder;

public class StringTest {
  /**
   * Iterate through each line of input.
   */
	public static String calculator(TreeMap<String, Integer> portmap, TreeMap<String, Integer> benchmap, int portsum, int benchsum) {
	    StringBuilder res = new StringBuilder();
	    //System.out.println(portmap);
	    for (Map.Entry<String, Integer> pmap : portmap.entrySet()) {
	      String pstock_name = (String) pmap.getKey();
	      double pstock_value = (int) pmap.getValue();
	      double pstock_percent = pstock_value * 100 / portsum;
	      //System.out.println(pstock_percent);
	      if (benchmap.containsKey(pstock_name)) {
	    	  double diff = pstock_percent - (benchmap.get(pstock_name) * 100 / benchsum);
	        diff = (double) Math.round(diff * 100) /100;
	        DecimalFormat df = new DecimalFormat("#####0.00");
	        String diff2 = df.format(diff);
		    res.append(",");
		    res.append(pstock_name);
		    res.append(":");
		    res.append(diff2);
	        benchmap.remove(pstock_name);
	      }
	      else {
	        double diff = pstock_percent;
	        diff = (double) Math.round(diff * 100) /100;
	        DecimalFormat df = new DecimalFormat("#####0.00");
	        String diff2 = df.format(diff);
		    res.append(",");
		    res.append(pstock_name);
		    res.append(":");
		    res.append(diff2);
	      }
	      
	    }
	    if (! benchmap.isEmpty()) {
	      for (Map.Entry bmap : benchmap.entrySet()) {
	        String bstock_name = (String) bmap.getKey();
	        double bstock_percent = (int) bmap.getValue() * 100 / benchsum;
	        double diff = bstock_percent;
	        diff = (double) Math.round(diff * 100) / 100;
	        DecimalFormat df = new DecimalFormat("#####0.00");
	        String diff2 = df.format(diff);
	        res.append(",");
	        res.append(bstock_name);
	        res.append(":");
	        res.append("-");
	        res.append(String.valueOf(diff2));
	      }
	    }
	    String output = res.toString();
	    return output.substring(1);
	  }
	public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line = "PORT:AXN,0,10;BGT,20,30;CXZ,10,30|BENCH:AXN,50,10;BGT,30,30;DFG,30,20;XYZ,0,10";
    //while ((line = in.readLine()) != null) {
      String[] ary = line.split("\\|");
      String P = ary[0];
      String B = ary[1];
      String p = P.substring(5);
      String b = B.substring(6);
      String[] pp = p.split("\\;");
      String[] bb = b.split("\\;");
      int port_len = pp.length;
      int bench_len = bb.length;
      
      String[][] port = new String[port_len][3];
      for (int i = 0; i < port_len; i++) {
    	  	port[i] = pp[i].split(",");
      }
      String[][] bench = new String[bench_len][3];
      for (int i = 0; i < bench_len; i++) {
    	  	bench[i] = bb[i].split(",");
      }
      //System.out.println(Arrays.deepToString(port));
      TreeMap<String, Integer> portmap = new TreeMap<String, Integer>();
      TreeMap<String, Integer> benchmap = new TreeMap<String, Integer>();
      int portsum = 0;
      int benchsum = 0;
      for (int i = 0; i < port_len; i++) {
    	  	int Qty = Integer.parseInt(port[i][1]);
    	  	int Price = Integer.parseInt(port[i][2]);
    	  	portmap.put(port[i][0], Qty*Price);
    	  	//System.out.println(portmap);
    	  	portsum += Qty * Price;
    	  	
      }
      for (int i = 0; i < bench_len; i++) {
  	  	int Qty = Integer.parseInt(bench[i][1]);
  	  	int Price = Integer.parseInt(bench[i][2]);
  	  	benchmap.put(bench[i][0], Qty*Price);
  	  	benchsum += Qty * Price;
    }
      String output = calculator(portmap, benchmap, portsum, benchsum);
      System.out.println(output);
    }
  }
