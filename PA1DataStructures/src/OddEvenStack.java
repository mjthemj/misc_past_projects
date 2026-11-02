import java.util.Arrays;

public class OddEvenStack {

    private int maxStackSize, oddTos, evenTos;
	private int[] stack;

	public OddEvenStack(int maxStackSize) { // complete
		if (maxStackSize <= 0)
			System.out.println("Stack size should be a positive integer.");
		else {
			this.maxStackSize = maxStackSize;
			evenTos = maxStackSize;
			oddTos = -1;
			stack = new int[maxStackSize];
		}
	}

	public void push(int val) { // complete
		if (size() == maxStackSize){
			System.out.println("Cannot push! Stack is full.");
		}
		else{
		if (val % 2 == 0){
			evenTos--;
			stack[evenTos] = val;
		}
		else{
			oddTos++;
			stack[oddTos] = val;
		}
	}}

	public int popOdd() { // complete, error returns -1
		if (oddTos == -1){
			System.out.println("Cannot pop! No odd numbers in stack.");
			return -1;
		}
		else{
		int val = stack[oddTos];
		oddTos--;
		return val;
	}}

	public int popEven() { // complete, error returns -1
		if (evenTos == maxStackSize){
			System.out.println("Cannot pop! No even numbers in stack.");
			return -1;
		}
		else{
		int val = stack[evenTos];
		evenTos++;
		return val;
	}}

	public int size() { // complete
		int size = oddTos + 1 + (maxStackSize - evenTos);
		return size;
	}
	
	public String toString() {
		return Arrays.toString(stack);
	}
}
