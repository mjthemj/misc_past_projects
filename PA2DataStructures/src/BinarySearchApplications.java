public class BinarySearchApplications {

	public static int minIndexBinarySearch(int array[], int arrayLength, int key) { // complete this method
		int minIndex = -1;
		int left = 0;
		int right = arrayLength - 1;
		while (left <= right){
			int mid = (left + right)/2;
			if (array[mid] == key){
				minIndex = mid;
				right = mid - 1;
			}
			else if (array[mid] > key){
				right = mid - 1;
			}
			else left = mid + 1;
		}
		return minIndex;
	}

	public static int maxIndexBinarySearch(int array[], int arrayLength, int key) { // complete this method
		int maxIndex = -1;
		int left = 0;
		int right = arrayLength - 1;
		while (left <= right){
			int mid = (left + right)/2;
			if (array[mid] == key){
				maxIndex = mid;
				left = mid + 1;
			}
			else if (array[mid] > key){
				right = mid - 1;
			}
			else left = mid + 1;
		}
		return maxIndex;
	}

	public static int countNumberOfKeys(int array[], int arrayLength, int key) { // complete this method
		int minIndex = minIndexBinarySearch(array, arrayLength, key);
		int maxIndex = maxIndexBinarySearch(array, arrayLength, key);
		if (minIndex == -1){
			return 0;
		}
		else return (maxIndex - minIndex + 1);
	}

	public static int predecessor(int array[], int arrayLen, int key) { // complete this method
		int predIndex = -1;
		int left = 0;
		int right = arrayLen - 1;
		while (left <= right){
			int mid = (left + right)/2;
			if (array[mid] == key){
				predIndex = mid;
				left = mid + 1;
			}
			else if (array[mid] > key){
				right = mid - 1;
			}
			else{
				predIndex = mid;
				left = mid + 1;
			}
		}
		return predIndex;
	}
    
    public static int findPeak(int twoToneArray[], int arrayLen) { // complete this method
		int left = 0;
		int right = arrayLen -1;
		while (left <= right){
			if (left == right){
				return left;
			}
			else if (left == (right -1)){
				return left;
			}
			else {
				int mid = (left+right)/2;
				if ((twoToneArray[mid] > twoToneArray[mid + 1]) && (twoToneArray[mid] > twoToneArray[mid - 1])){
					return mid;
				}
				else if (twoToneArray[mid] < twoToneArray[mid + 1]){
					left = mid + 1;
				}
				else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
}
