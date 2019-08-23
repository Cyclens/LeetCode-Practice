package Twitter;

import java.util.Arrays;
import java.util.List;

public class Rover_Control {

	static int roverMove(int matrixSize, List<String> cmds) {

        int x = 0;
        int y = 0;
        for (String cmd : cmds) {
            if (cmd.equals("RIGHT") && x < matrixSize - 1) {
                x++;
            }else if (cmd.equals("LEFT") && x > 0) {
                x--;
            }else if (cmd.equals("UP") && y > 0) {
                y--;
            }else if (cmd.equals("DOWN") && y < matrixSize - 1) {
                y++;
            }
            System.out.println("" + x + " " + y);
        }
        
        return y * matrixSize + x;
    }
	
	public static void main (String[] args) {
		int n = 2;
		List<String> cmds = Arrays.asList(new String[] {"UP", "UP", "UP","DOWN", "UP", "UP", "LEFT","DOWN","LEFT","LEFT","LEFT", "DOWN","RIGHT","RIGHT","RIGHT","RIGHT","UP","UP","UP","UP", "DOWN","LEFT","LEFT","LEFT","LEFT",});
		int pos = roverMove(n, cmds);
		System.out.println(pos);
	}
}
