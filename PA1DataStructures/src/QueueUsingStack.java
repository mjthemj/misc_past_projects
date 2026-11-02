public class QueueUsingStack {

	Stack mainStack;
	int maxQueueSize;

	public QueueUsingStack(int maxQueueSize) {
		this.maxQueueSize = maxQueueSize;
		mainStack = new Stack(maxQueueSize);
	}

	public void enqueue(int val) { // complete
		if(size() == maxQueueSize){
			System.out.println("Cannot enqueue! Queue is full.");
		}
		else if (size() == 0){
			mainStack.push(val);
		}
		else{
			Stack tempStack = new Stack(maxQueueSize);
			int s = mainStack.size();
			for(int i = 0; i < s; i++){
				tempStack.push(mainStack.pop());
			}
			mainStack.push(val);
			for(int i = 0; i < s; i++){
				mainStack.push(tempStack.pop());
			}
		}
	}

	public int dequeue() { // complete, error returns -1
		if(size() == 0){
			System.out.println("Cannot dequeue! Queue is full.");
			return -1;
		}
		else{
			return mainStack.pop();
		}
	}

	public int size() { // complete
		return mainStack.size();
	}

	public String toString() {
		if (size() == 0) {
			return "[]";
		} else {
			String output = "[";
			int n = size();
			for (int i = 0; i < n - 1; i++) {
				int x = dequeue();
				output += x + ", ";
				enqueue(x);
			}
			int x = dequeue();
			output += x + "]";
			enqueue(x);
			return output;
		}
	}
}
