

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueueApplications {

	public static ArrayList<Student> topK(ArrayList<Student> students, int k) { // complete this method
		if (k > students.size()){
			k = students.size();
		}
		PriorityQueue<Student> stuQueue = new PriorityQueue<>(new StudentComparator());
		for (int i = 0; i < k; i++){
			stuQueue.add(students.get(i));
		}
		StudentComparator stuComp = new StudentComparator();
		for (int i = k; i < students.size(); i++){
			Student min = stuQueue.peek();
			Student current = students.get(i);
			if (stuComp.compare(min, current) < 0){
				stuQueue.remove();
				stuQueue.add(current);
			}
		}
		ArrayList<Student> stuArr = new ArrayList<>();
		while (stuQueue.size() > 0){
			stuArr.add(stuQueue.remove());
		}
		return stuArr;
	}

	public static ArrayList<Integer> kWayMerge(ArrayList<ArrayList<Integer>> lists) { // complete this method
		PriorityQueue<PriorityQueuePair> pQueue = new PriorityQueue<>(new PriorityQueuePairComparator());
		ArrayList<Integer> sortedRows = new ArrayList<>();
		for (int i = 0; i < lists.size(); i++){
			PriorityQueuePair pQp = new PriorityQueuePair(i, lists.get(i).get(0));
			pQueue.add(pQp);
		}
		Integer[] indexes = new Integer[lists.size()];
		for (int i = 0; i < lists.size(); i++){
			indexes[i] = 1;
		}
		while (pQueue.peek() != null){
			PriorityQueuePair minElement = pQueue.remove();
			sortedRows.add(minElement.priority);
			int minItem = minElement.item;
			if (indexes[minItem] < lists.get(minItem).size()){
				PriorityQueuePair pqp = new PriorityQueuePair(minItem, lists.get(minItem).get(indexes[minItem]));
				pQueue.add(pqp);
				indexes[minItem]++;
			}
		}
		return sortedRows;
	}
}
