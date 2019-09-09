
public class BrokenCalculator {
	public int brokenCalc(int X, int Y) {
        int count = 0;
        while (X < Y) {
        	if ( Y % 2 == 1) {
        		 Y += 1;
        		 count++;
        	}
        	Y /= 2;
        	count++;
        }
        return count + (X - Y);
    }

}
