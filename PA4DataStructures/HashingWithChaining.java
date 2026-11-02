import java.util.Iterator;
import java.util.LinkedList;

public class HashingWithChaining {

	LinkedList<Integer> hashTable[];
	int TABLE_SIZE;

	@SuppressWarnings("unchecked")
	public HashingWithChaining(int tableSize) {
		TABLE_SIZE = tableSize;
		hashTable = (LinkedList<Integer>[]) new LinkedList[TABLE_SIZE]; // this ain't a good method but java does not support array of generics;
		// should ideally use an array list with space reserved
		for (int i = 0; i < TABLE_SIZE; i++)
			hashTable[i] = new LinkedList<Integer>();
	}

	private int getHashValue(int val) {
		return (37 * val + 61) % TABLE_SIZE;
	}

	public LinkedList<Integer> getList(int index) {
		return hashTable[index];
	}

	public boolean search(int key) { // complete this method
		int keyVal = getHashValue(key);
		Iterator<Integer> it = hashTable[keyVal].iterator();
		while (it.hasNext()){
			if (it.next() == key){
				return true;
			}
		}
		return false;
	}

	public boolean insert(int val) { // complete this method
		if ((search(val))){
			return false;
		}
		int hashVal = getHashValue(val);
		hashTable[hashVal].addLast(val);
		return true;
	}

	public boolean remove(int val) { // complete this method
		if (hashTable.length == 0){
			return false;
		}
		int keyVal = getHashValue(val);
		Iterator<Integer> it = hashTable[keyVal].iterator();
		while (it.hasNext()){
			if (it.next() == val){
				it.remove();
				return true;
			}
		}
		return false;
	}

	public void printStatistics() {
		int maxSize = hashTable[0].size();
		int minSize = maxSize, total = maxSize;
		for (int i = 1; i < TABLE_SIZE; i++) {
			int size = hashTable[i].size();
			if (size > maxSize)
				maxSize = size;
			else if (size < minSize)
				minSize = size;
			total += size;
		}
		System.out.printf(
				"Max length of a chain = %d%n" + "Min length of a chain = %d%n" + "Avg length of chains = %d%n",
				maxSize, minSize, total / TABLE_SIZE);
	}
}
