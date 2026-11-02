

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestCorrectness {

	static final String MST_GRAPH_PATH = "mst_graph.txt";

	private static void testUnionFind() {
		UnionFind uf = new UnionFind(16);
		System.out.println("Initial sets are 0-15\n");
		for (int i = 0; i < 15; i += 4) {
			System.out.printf("UNION(%d,%d)%n", i, i + 1);
			uf.doUnion(i, i + 1);
		}
		System.out.println();
		for (int i = 0; i < 16; i++) {
			System.out.printf("List containing %2d: %s%n", i, uf.find(i));
		}
		System.out.println("\nUNION(0,5)");
		System.out.println("UNION(10,12)");
		System.out.println("UNION(0,10)\n");
		uf.doUnion(0, 5);
		uf.doUnion(10, 12);
		uf.doUnion(0, 10);
		for (int i = 0; i < 16; i++) {
			System.out.printf("List containing %2d: %s%n", i, uf.find(i));
		}
		System.out.println("\nUNION(6,8)");
		System.out.println("UNION(8,5)\n");
		uf.doUnion(6, 8);
		uf.doUnion(8, 5);
		for (int i = 0; i < 16; i++) {
			System.out.printf("List containing %2d: %s%n", i, uf.find(i));
		}
	}

	private static void testKruskal() throws FileNotFoundException {
		Kruskal kruskal = new Kruskal(MST_GRAPH_PATH);
		ArrayList<Edge> mst = kruskal.runKruskal();
		int mstWeight = 0;
		for (Edge e : mst)
			mstWeight += e.weight;
		System.out.printf("MST has weight %d%nThe edges are: %s%n", mstWeight, mst);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("****************** Union-Find ******************\n");
		//testUnionFind();
		System.out.println("\n****************** Kruskal ******************\n");
		testKruskal();
	}
}
