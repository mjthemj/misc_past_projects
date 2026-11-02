import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortAndFriends {

	private static int[] binaryMerge(int A[], int B[], int lenA, int lenB) { // complete this function
		int lenC = lenA + lenB;
		int[] C = new int[lenC];
		int a = 0;
		int b = 0; 
		int c = 0;
		while (a < lenA && b < lenB){
			if (A[a] < B[b]){
				C[c] = A[a];
				a++;
			}
			else{
				C[c] = B[b];
				b++;
			}
			c++; //haha actually this is java
		}
		while (a < lenA){
			C[c] = A[a];
			a++;
			c++;
		}
		while (b < lenB){
			C[c] = B[b];
			b++;
			c++;
		}
		return C;

	}

	public static ArrayList<Integer> commonElements(int A[], int B[], int lenA, int lenB) { // complete this function
		ArrayList<Integer> commonArrayList = new ArrayList<Integer>();
		int a = 0;
		int b = 0;
		while (a < lenA && b < lenB){
			if (A[a] < B[b]){
				a++;
			}
			else if (A[a] > B[b]){
				b++;
			}
			else{
				commonArrayList.add(A[a]);
				a++;
				while (a < lenA && A[a] == B[b]){
					a++;
				}
			}
		}
		return commonArrayList;
	}

	public static int[] kWayMerge(int lists[][], int listLengths[], int k) { // complete this function
		if (k == 1){
			return lists[0];
		}
		else if (k == 2){
			return binaryMerge(lists[0], lists[1], listLengths[0], listLengths[1]);
		}
		else{
			int newK = (k + 1)/2;
			int mergedLists[][] = new int[newK][];
			int mergedListLengths[] = new int[newK];
			for (int i = 0; i < k/2; i++){
				mergedListLengths[i] = listLengths[2*i] + listLengths[2*i + 1];
				mergedLists[i] = binaryMerge(lists[2*i], lists[2*i + 1], listLengths[2*i], listLengths[2*i + 1]);
			}
			if (k % 2 != 0){
				mergedLists[newK - 1] = lists[k - 1];
				mergedListLengths[newK - 1] = listLengths[k - 1];
			}
			return kWayMerge(mergedLists, mergedListLengths, newK);
		}
	}

	public static void mergesort(int[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergesort(array, left, mid);
			mergesort(array, mid + 1, right);
			int A[] = Arrays.copyOfRange(array, left, mid + 1);
			int B[] = Arrays.copyOfRange(array, mid + 1, right + 1);
			int mergedArray[] = binaryMerge(A, B, A.length, B.length);
			int i = left;
			int j = 0;
			while (j <= right - left)
				array[i++] = mergedArray[j++];
		}
	}
}