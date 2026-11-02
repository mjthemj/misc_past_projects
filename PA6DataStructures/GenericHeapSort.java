

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class GenericHeapSort {

	public static void sort(int[] arr, int len) {

		// creates a priority queue using the PriorityQueueComparator
		PriorityQueue<PriorityQueuePair> heap = new PriorityQueue<>(new PriorityQueuePairComparator());

		for (int i = 0; i < len; i++)
			heap.add(new PriorityQueuePair(arr[i], arr[i])); // for plain heap sort, item and priority is the same;

		int i = 0;
		while (heap.size() > 0) { // as long as the heap is not empty
			PriorityQueuePair ele = heap.peek(); // get the topmost item
			heap.remove(); // remove the topmost item
			arr[i++] = ele.item; // could also use ele.priority
		}
	}

	public static void sort(String[] arr, int len) {

		// creates a priority queue using the StringComparator
		PriorityQueue<String> heap = new PriorityQueue<>(new StringComparator());

		for (int i = 0; i < len; i++)
			heap.add(arr[i]);

		int i = 0;
		while (heap.size() > 0) { // as long as the heap is not empty
			String ele = heap.peek(); // get the topmost item
			heap.remove(); // remove the topmost item
			arr[i++] = ele;
		}
	}

	private static void sortStudents() throws FileNotFoundException, IOException {//added IOException
		System.out.println("\n*** Student Heap Sort ***\n");
		ArrayList<Student> students = IOHelper.readStudents("students.txt");
		System.out.println("Original Order: " + students);

		// creates a priority queue using the StudentComparator
		PriorityQueue<Student> heap = new PriorityQueue<>(new StudentComparator());

		for (int i = 0; i < students.size(); i++)
			heap.add(students.get(i));

		ArrayList<Student> sortedStudents = new ArrayList<>();
		while (heap.size() > 0) { // as long as the heap is not empty
			Student ele = heap.peek(); // get the topmost item
			heap.remove(); // remove the topmost item
			sortedStudents.add(ele);
		}

		System.out.println("After Sorting:  " + sortedStudents);
	}

	static void stringSort() {
		System.out.println("\n*** String Heap Sort ***\n");
		String arr[] = { "abc", "def", "abcd", "bce", "abx", "acfe", "bfr", "xyz", "de", "tyu", "ab", "abcd", "xy",
				"zxy", "abx", "def" };
		System.out.println("Original array: " + Arrays.toString(arr));
		sort(arr, arr.length);
		System.out.println("After sorting:  " + Arrays.toString(arr));
	}

	static void integerSort() {
		System.out.println("*** Integer Heap Sort ***\n");
		int[] arr = {360, 448, 29, 447, 15, 53, 491, 261, 219, 354};
		System.out.println("Original array: " + Arrays.toString(arr));
		sort(arr, arr.length);
		System.out.println("After sorting:  " + Arrays.toString(arr));
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {//added IOException
		integerSort();
		stringSort();
		sortStudents();
	}

}
