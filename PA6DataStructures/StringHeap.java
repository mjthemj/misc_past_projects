

import java.util.ArrayList;

public class StringHeap {

	private ArrayList<String> heapArray;

	public StringHeap() {
		heapArray = new ArrayList<>();
	}

	public String top() {
		return heapArray.get(0);
	}

	private void swap(int index1, int index2) { // complete this method
		String s1 = heapArray.get(index1);
		String s2 = heapArray.get(index2);
		heapArray.set(index1, s2);
		heapArray.set(index2, s1);
	}

	public void insert(String value) { // complete this method
		int currentIndex = heapArray.size();
		int parentIndex = (currentIndex - 1)/2;
		heapArray.add(currentIndex, value);
		while ((currentIndex > 0) && (heapArray.get(parentIndex).compareTo(heapArray.get(currentIndex)) > 0)){
			swap(currentIndex, parentIndex);
			currentIndex = parentIndex;
			parentIndex = (currentIndex - 1) / 2;
		}
	}

	public void extract() { // (deleteMin)
		swap (0, heapArray.size()-1);
		heapArray.remove(size()-1);
		int currentIndex = 0;
		int leftIndex = 1;
		int rightIndex = 2;
		int size = heapArray.size();
		while (leftIndex < size){
			int minIndex = leftIndex;
			String minKey = heapArray.get(minIndex);
			if (rightIndex < size){
				String rightKey = heapArray.get(rightIndex);
				if (minKey.compareTo(rightKey) > 0){
					minIndex = rightIndex;
					minKey = rightKey;
				}
			}
			if (minKey.compareTo(heapArray.get(currentIndex)) < 0){
				swap(minIndex, currentIndex);
				currentIndex = minIndex;
			}
			else{
				break;
			}
			leftIndex = 2 * currentIndex +1;
			rightIndex = leftIndex + 1;
		}
	}

	public static void heapSort(String array[], int arrayLen) throws Exception { // complete this method
		
		StringHeap strngHeap = new StringHeap();
		for (int i = 0; i < arrayLen; i++){
			strngHeap.insert(array[i]);
		}
		for (int i = 0; i < arrayLen; i++){
			array[i] = strngHeap.top();
			strngHeap.extract();
		}
	}

	public int size() {
		return heapArray.size();
	}

	public String toString() {
		return heapArray.toString();
	}
}
