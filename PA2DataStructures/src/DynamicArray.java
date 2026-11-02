import java.util.Arrays;

public class DynamicArray {

	int A[];
	int numElements;
	int length;

	public DynamicArray(int initialSize) {
		numElements = 0;
		length = initialSize;
		A = new int[initialSize];
	}
	
	/**
	 * Helper function that creates an array tmp[] of size newArrayLen
	 * if arrayLen <= newArrayLen, then copies array[] to tmp[]
	 * else copies the first newArrayLen elements of array[] into tmp[]
	 */
	private int[] copyArray(int[] array, int arrayLen, int newArrayLen) {
		int[] tmp = new int[newArrayLen];
		if (arrayLen <= newArrayLen) {
			for (int i = 0; i < arrayLen; i++)
				tmp[i] = array[i];
		} else {
			for (int i = 0; i < newArrayLen; i++)
				tmp[i] = array[i];
		}
		return tmp;
	}

	public int access(int index) {
		if (index >= numElements)
			throw new ArrayIndexOutOfBoundsException();
		return A[index];
	}

	public void update(int index, int val) {
		if (index >= numElements)
			throw new ArrayIndexOutOfBoundsException();
		A[index] = val;
	}

	public void insertAtEnd(int val) { // complete this method
		if (length == numElements){
			A = copyArray(A, length, (length * 2));
			length *= 2;
		}
		A[numElements] = val;
		numElements++;
	}

	public void deleteLast() { // complete this method
		if (numElements == 0){
			System.out.println("Cannot delete from an empty array.");
		}
		else if (numElements == 1){
			A = copyArray(A, length, 1);
			numElements = 0;
			length = 1;
		}
		else{
			numElements--;
			if (4*numElements == length){
				A = copyArray(A, length, 2 * length);
				length = length / 2;
			}
		}
	}

	public int getSize() {
		return numElements;
	}

	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(A, 0, numElements));
	}
}
