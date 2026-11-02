
import java.io.BufferedReader;
import java.io.File;
/* I added the above import files. I might be
   doing the IO in a more inefficient way,
   but in my defense I took Intermediate C++
   and not Java, so I have less understanding
   of the file reading systems in use here.
*/
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOHelper {

	public static ArrayList<Student> readStudents(String filePath) throws FileNotFoundException, IOException { // I added IOException, this could be a mistake
		//for PriorityQueueApplications
		File file = new File(filePath);
		ArrayList<String> readArr = new ArrayList<>();
		int size = 0;
		BufferedReader buffReader = new BufferedReader(new FileReader(file));
		for(String line = buffReader.readLine(); line != null; line = buffReader.readLine()){ //convert file data to ArrayList
            readArr.add(line);
			size++;
        }
		buffReader.close();
		ArrayList<Student> stuArr = new ArrayList<>();
		for(int i = 0; i < size; i++){
			String[] split = readArr.get(i).split(" ", 2);
			int grade = Integer.parseInt(split[1]);
			Student student = new Student(split[0], grade);
			stuArr.add(student);
		}
		return stuArr;
	}

	public static Graph readWeightedGraph(String filePath) throws FileNotFoundException, IOException { // complete this method
		//for Dijkstra
		File file = new File(filePath);
		Scanner fileScanner = new Scanner(file);
		Graph graph = new Graph();
		String nvstring= fileScanner.nextLine();
		graph.numVertices = Integer.parseInt(nvstring);
		//allocate rows
		
		graph.adjList = new ArrayList<ArrayList<Edge>>();
		
		for (int i = 0; i < graph.numVertices; i++){
			graph.adjList.add(i, new ArrayList<>());
		}
		while(fileScanner.hasNext()){
			int src = fileScanner.nextInt();
			int dest = fileScanner.nextInt();
			int weight = fileScanner.nextInt();
			Edge e = new Edge(src, dest, weight);
			graph.adjList.get(src).add(e);
		}
		fileScanner.close();
		return graph;
	}

}
