

import java.util.Comparator;

public class PriorityQueuePairComparator implements Comparator<PriorityQueuePair> {

	@Override
	public int compare(PriorityQueuePair o1, PriorityQueuePair o2) {
		return o1.priority - o2.priority;
	}

}
