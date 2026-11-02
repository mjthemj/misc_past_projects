public class Sorting {

	public static void selectionSort(int[] array, int arrayLen) { // complete
		for(int i = 0; i < arrayLen - 2; i++){
			int minIndex = i;
			for(int j = i; j < arrayLen /*- 1*/; j++){
				if(array[j] < array[minIndex]){
					minIndex = j;
				}
			}
			if (i != minIndex){
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}
	}

	public static void insertionSort(int[] array, int arrayLen) { // complete
		for (int i = 1; i < arrayLen /*- 1*/; i++){
			int j = i;
			int temp = array[j];
			while((j > 0) && temp < array[j-1]){
				array[j] = array[j-1];
				j--;
			}
			array[j] = temp;
		}
	}
}
