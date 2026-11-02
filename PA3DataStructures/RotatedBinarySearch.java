public class RotatedBinarySearch {

	public static int search(int array[], int length, int key) { // complete this function
		int maxInd = maxIndex(array, array[length - 1], 0, length - 1);
		if (key == array[maxInd]){
			return maxInd;
		}
		else if (key >= array[0]){
			return binarySearch(array, 0, maxInd - 1, key);
		}
		else{
			return binarySearch(array, maxInd + 1, length - 1, key);	
		}
	}

	public static int maxIndex(int array[], int lastValue, int left, int right) { // complete this function
		if (left == right){
			return left;
		}
		else{
			int mid = (left + right)/2;
			if (array[mid] > array[mid + 1]){
				return mid;
			}
			else if (array[mid] < lastValue){
				return maxIndex(array, lastValue, left, mid - 1);
			}
			else{
				return maxIndex(array, lastValue, mid + 1, right);
			}

		}
	}

	public static int binarySearch(int array[], int left, int right, int key) {
		if (left <= right) {
			int mid = (left + right) / 2;
			if (array[mid] == key) {
				return mid;
			} else if (array[mid] < key)
				return binarySearch(array, mid + 1, right, key);
			else
				return binarySearch(array, left, mid - 1, key);
		}
		return -1;
	}
}
