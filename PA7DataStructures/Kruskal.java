

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Kruskal extends Graph {

	public Kruskal(String filePath) throws FileNotFoundException {
		super(filePath);
	}

	public ArrayList<Edge> runKruskal() { // complete this method
		ArrayList<Edge> edgeList = new ArrayList<>();
		for (int i = 0; i < adjList.size(); i++){
			for (int j = 0; j < adjList.get(i).size(); j++){
				edgeList.add(adjList.get(i).get(j));
			}
		}
		for (int i = 1; i < edgeList.size(); i++){
			int j = i;
			while (j > 0 && edgeList.get(j).weight > edgeList.get(j - 1).weight ){
				Edge tmp = edgeList.get(j);
				edgeList.set(j, edgeList.get(j - 1));
				edgeList.set(j - 1, tmp);
			}
		}
		UnionFind objUF = new UnionFind(numVertices);
		for (int i = 0; i < numVertices; i++){
			objUF.makeSet(i);
		}
		ArrayList<Edge> edgey = new ArrayList<>();
		int numEdgesAdded = 0;
		for (int i = 0; i < edgeList.size(); i++) {
			Edge e = edgeList.get(i);
			int src = e.src;
			int dest = e.dest;
			if (objUF.find(src) != objUF.find(dest)){
				objUF.doUnion(src, dest);
				edgey.add(e);
				numEdgesAdded++;
				if (numEdgesAdded ==(numVertices - 1)){
					break;
				}
			}
		}
		return edgey;
	}

}
