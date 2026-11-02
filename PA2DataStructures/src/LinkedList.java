public class LinkedList {

	public ListNode head, tail;
	public int size;

	public LinkedList() {
		head = tail = null;
		size = 0;
	}

	public void insertAfter(ListNode argNode, int value) { // complete this method
	ListNode newNode = new ListNode(value);
	newNode.next = argNode.next;
	argNode.next = newNode;
	if (argNode == tail){
		tail = newNode;
		//newNode.next = null;
	}
	size++;
	}

	public void deleteAfter(ListNode argNode) { // complete this methodd
		if (argNode.next == null){
			System.out.println("Cannot delete after tail.");
			return;
		}
		if (argNode.next == tail){
			tail = argNode;
		}
		argNode.next = argNode.next.next;
		size--;
	}

	public void selectionSort() { // complete this method
		if (size <= 1){
			return;
		}
		for (ListNode i = head; i.next != null; i = i.next){
			ListNode minNode = i;
			for (ListNode j = i.next; j != null; j = j.next ){
				if (j.value < minNode.value){
					minNode = j;
				}
			}
			if (i != minNode){
				int tmp = i.value;
				i.value = minNode.value;
				minNode.value = tmp;

			}
		}
	}

	public boolean removeDuplicatesSorted() { // complete this method
		ListNode tmp = head;
		while(tmp.next != null){
			if (tmp.value > tmp.next.value){
				return false;
			}
			tmp = tmp.next;
		}
		ListNode curr = head;
		while (curr != null){
			while (curr.next != null && curr.value == curr.next.value){
				deleteAfter(curr);
			}
			curr = curr.next;
		}
		return true;
	}

	public void pushOddIndexesToTheBack() { // complete this method
		ListNode temp = head;
		for (int i = 0; i < size - 1; i += 2){
			insertAtEnd(temp.next.value);
			deleteAfter(temp);
			temp = temp.next;
		}
	}
    
    public void reverse() { // complete this method
		if (size <= 1){
			return;
		}
		ListNode prev = head;
		ListNode curr = head.next;
		while(curr != null){
			ListNode tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;
		}
		ListNode tmp = head;
		head = tail;
		tail = tmp;
		tail.next = null;
    }

	ListNode insertAtFront(int value) {
		ListNode newNode = new ListNode(value);
		if (size == 0) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
		return newNode;
	}

	ListNode insertAtEnd(int value) {
		ListNode newNode = new ListNode(value);
		if (size == 0) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
		return newNode;
	}

	void deleteHead() {
		if (0 == size) {
			System.out.println("Cannot delete from an empty list");
		} else if (1 == size) {
			head = tail = null;
			size--;
		} else {
			size--;
			ListNode tmp = head;
			head = head.next;
			tmp.next = null;
			tmp = null;
		}
	}

	public ListNode getNodeAt(int pos) {
		if (pos < 0 || pos >= size || 0 == size) {
			System.out.println("No such position exists");
			return null;
		} else {
			ListNode tmp = head;
			for (int i = 0; i < pos; i++)
				tmp = tmp.next;
			return tmp;
		}
	}

	void printList() {
		if (size == 0)
			System.out.println("[]");
		else {
			ListNode tmp = head;
			String output = "[";
			for (int i = 0; i < size - 1; i++) {
				output += tmp.value + " -> ";
				tmp = tmp.next;
			}
			output += tail.value + "]";
			System.out.println(output);
		}
	}

	public int getSize() {
		return size;
	}
}
