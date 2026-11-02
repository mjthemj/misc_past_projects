

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;

public class Dijkstra extends Graph {

	public int distance[], parent[];
	private boolean closed[];

	public Dijkstra(String filePath) throws FileNotFoundException, IOException { // complete this constructor
		Graph g = IOHelper.readWeightedGraph(filePath);
		numVertices = g.numVertices;
		adjList = g.adjList;
	}

	public void execute(int source) { // complete this method
		distance = new int[numVertices];
		parent = new int[numVertices];
		closed = new boolean[numVertices];
		for (int i = 0; i < numVertices; i++){
			distance[i] = Integer.MAX_VALUE;
			parent[i] = -1;
			closed[i] = false;
		}
		distance[source] = 0;
		PriorityQueue<PriorityQueuePair> open = new PriorityQueue<>(new PriorityQueuePairComparator());
		PriorityQueuePair srcPair = new PriorityQueuePair(source, 0);
		open.add(srcPair);
		while (open.peek() != null){
			PriorityQueuePair minElement = open.remove();
			int minVertex = minElement.item;
			if (!(closed[minVertex])){
				closed[minVertex] = true;
				for (int i = 0; i < adjList.get(minVertex).size(); i++){
					Edge adjEdge = adjList.get(minVertex).get(i);
					int adjVertex = adjEdge.dest;
					if (!(closed[adjVertex])){
						int newDist = distance[minVertex] + adjEdge.weight;
						if (newDist < distance[adjVertex]){
							distance[adjVertex] = newDist;
							parent[adjVertex] = minVertex;
							PriorityQueuePair adjpqp = new PriorityQueuePair(adjVertex, distance[adjVertex]);
							if (!(open.contains(adjpqp))){
								open.add(adjpqp);
							}
						}
					}
				}
			}
		}//parent array used to construct path

	}
}
