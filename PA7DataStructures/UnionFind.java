

import java.util.ArrayList;

public class UnionFind {

	private ArrayList<ArrayList<Integer>> representatives;

	public UnionFind(int initialNumSets) { // complete this constructor
		representatives = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < initialNumSets; i++){
			representatives.add(new ArrayList<Integer>());
			makeSet(i);
		}//i == x
	}

	public void makeSet(int x) { // complete this method
		ArrayList<Integer> da = new ArrayList<>();
		da.add(x);
		representatives.set(x, da);
	}

	public ArrayList<Integer> find(int x) { // complete this method
		return representatives.get(x);
	}

	private void append(ArrayList<Integer> arg1, ArrayList<Integer> arg2) { // complete this method
		while (arg2.size() != 0){
			int last = arg2.size() - 1;
			int x = arg2.get(last);
			arg2.remove(last);
			representatives.set(x, arg1);
			arg1.add(x);
		}
	}

	public void doUnion(int x, int y) { // complete this method
		ArrayList<Integer> daX = find(x);
		ArrayList<Integer> daY = find(y);
		if (daX != daY){
			if (daX.size() >= daY.size()){
				append(daX, daY);
			}
			else{
				append(daY, daX);
			}
		}
	}
}
