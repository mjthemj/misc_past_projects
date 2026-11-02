public class HashingWithProbing {

	public int hashTable[];
	public int TABLE_SIZE;
	public int size;
	public int garbage;

	public static final int EMPTY = -1;
	public static final int TOMBSTONE = -9;

	private int getHashValue(int val) {
		return (37 * val + 61) % TABLE_SIZE;
	}

	public HashingWithProbing(int tableSize) {
		TABLE_SIZE = tableSize;
		size = 0;
		garbage = 0;
		hashTable = new int[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			hashTable[i] = EMPTY;
	}

	private void resize(int newTableSize) { // complete this method
		int[] keys = new int[size];

		int j = 0;
		for (int i = 0; i < TABLE_SIZE; i++){
			if (hashTable[i] >= 0){
				keys[j] = hashTable[i];
				j++;
			}
		}

		TABLE_SIZE = newTableSize;
		hashTable = new int[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++){
			hashTable[i] = EMPTY;
		}
		
		int oldSize = size;
		size = 0;
		garbage = 0;

		for (int i = 0; i < oldSize; i++){
			insert(keys[i]);
		}
	}

	public int search(int key) { // complete this method
		int hashVal = getHashValue(key);
		for (int i = 0; i < TABLE_SIZE; i++){
			if (hashTable[hashVal] == key){
				return hashVal;
			}
			else if (hashTable[hashVal] == EMPTY){
				return -1;
			}
			else {
			hashVal++;
			if (hashVal == TABLE_SIZE){
				hashVal = 0;
			}
		}
		}
		return -1;
	}

	public int insert(int val) { // complete this method
		if (size + garbage == TABLE_SIZE){
			resize(2 * size);
		}

		int hashVal = getHashValue(val);

		for (int i = 0; i < TABLE_SIZE; i++){
			if (hashTable[hashVal] == val){
				return -1;
			}
			else if (hashTable[hashVal] == EMPTY){
				break;
			}
			else{
				hashVal++;
				if (hashVal == TABLE_SIZE){
					hashVal = 0;
				}
			}
		}

		hashTable[hashVal] = val;
		size++;
		return hashVal;
	}

	public int remove(int val) { // complete this method
		int index = search(val);
		if (index < 0){
			return -1;
		}
		hashTable[index] = TOMBSTONE;
		garbage++;
		size--;
		return index;
	}
}
