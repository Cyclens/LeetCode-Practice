import java.util.Stack;

public class MinStack {
	int min = Integer.MAX_VALUE;
	Stack<Integer> stack;

	public MinStack() {
		stack = new Stack<Integer>();
	}

	public void push(int x) {
		if (x <= min) {
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}

	public void pop() {
		if (stack.pop() == min) {
			stack.pop();
		}
	}

	public int top() {
		int top = stack.peek();
		return top;
	}

	public int getMin() {
		return min;
	}

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(-1);
		stack.push(-20);
		stack.push(0);
		stack.push(-10);
		int mm = stack.getMin();
		int tt = stack.top();
		System.out.println("Top is:" + tt);
		System.out.println("Min is:" + mm);
	}
}
