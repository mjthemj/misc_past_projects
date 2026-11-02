

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph {

	public int numVertices;
	public int numEdges;
	public ArrayList<ArrayList<Edge>> adjList;

	public Graph(final Graph graph) {
		this.numVertices = graph.numVertices;
		this.numEdges = graph.numEdges;
		this.adjList = graph.adjList;
	}

	public Graph(final String filePath) throws FileNotFoundException {
		createGraphFromFile(filePath);
	}

	private void createGraphFromFile(final String filePath) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new FileInputStream(filePath));

		numVertices = fileReader.nextInt();
		numEdges = fileReader.nextInt();

		adjList = new ArrayList<ArrayList<Edge>>(numVertices);

		for (int i = 0; i < numVertices; i++)
			adjList.add(new ArrayList<Edge>());

		for (int i = 0; i < numEdges; i++) {
			int src = fileReader.nextInt();
			int dest = fileReader.nextInt();
			int weight = fileReader.nextInt();
			Edge edge = new Edge(src, dest, weight);
			adjList.get(src).add(edge);
		}

		fileReader.close();
	}
}
