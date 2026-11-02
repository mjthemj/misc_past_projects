public class Stack {

	private int maxStackSize, topOfStack;
	private int[] stack;

	public Stack(int maxStackSize) {
		if (maxStackSize <= 0)
			System.out.println("Stack size should be a positive integer.");
		else {
			this.maxStackSize = maxStackSize;
			topOfStack = -1;
			stack = new int[maxStackSize];
		}
	}

	public void push(int val) { // complete
		if(topOfStack == maxStackSize - 1){
			System.out.println("Cannot push! Stack is full.");
		}
		else{
		topOfStack++;
		stack[topOfStack] = val;
	}}

	public int pop() { // complete, error returns -1
		if(topOfStack == -1){
			System.out.println("Cannot pop! Stack is empty.");
			return -1;
		}
		else {
		return stack[topOfStack--];
	}}

	public int size() { // complete this method
		int val = topOfStack + 1;
		return val;
	}
}
