import java.io.*;
import java.util.ArrayList;

public class Pathfinder {
    public static void main(String[] args) throws Exception {//text input hardcoded, attempt at softcoding included in function failedTxtInput
        //initialize index and map, hardcoded
        String[] index = new String[]{"Macau", "China", "Hongkong", "Taiwan", "Korea", "India", "France", "Japan", "Netherland", "Russia", "England", "USA"};
        int[][] map = new int[12][12];
        map[0][1] = 1;
        map[0][2] = 1;
        map[0][3] = 1;
        map[1][7] = 1;
        map[1][5] = 1;
        map[1][6] = 1;
        map[2][7] = 1;
        map[2][4] = 1;
        map[3][5] = 1; 
        map[4][8] = 1;
        map[5][9] = 1;
        map[6][10] = 1;
        map[6][11] = 1;
        map[7][11] = 1; 
        
        System.out.println("Path:");
        System.out.println("DFS:");
        Dfs(map, index, 12, 0, 11); 
        System.out.println("\nBFS:");
        Bfs(map, index, 12, 0, 11);

    }

    
    public static void Dfs(int[][] arr, String[] index, int nodeNum, int start, int goal){ //is static good?
        Stack stack = new Stack(20);
        stack.push(start);
        boolean[] visited = new boolean[nodeNum];
        visited[start] = true;
        while(stack.size() != 0){
            int T = stack.pop();
            System.out.println(index[T]);
            if(T == goal){
                return;
            }
            for(int i = 0; i < nodeNum; i++){
                if ((arr[T][i] == 1) && !(visited[i])){
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
    }

    public static void Bfs(int[][] arr, String[] index, int nodeNum, int start, int goal){
        Queue queue = new Queue(20);
        queue.enqueue(start);
        boolean[] visited = new boolean[nodeNum];
        visited[start] = true;
        while(queue.size() != 0){
            int T = queue.dequeue();
            System.out.println(index[T]);
            if (T == goal){
                return;
            }
            for (int i = 0; i < nodeNum; i++){
                if ((arr[T][i] == 1) && !(visited[i])){
                    visited[i] = true;
                    queue.enqueue(i);
                }
            }
        }


    }

    public static void failedTxtInput() throws Exception{ //index is missing nodes, 2D array not given '1' values
        File file = new File("src\\hw1AI.txt");
        ArrayList<String> dataArrayList = new ArrayList<>();
        int n = 0;
        BufferedReader buffReader = new BufferedReader(new FileReader(file));
        for(String line = buffReader.readLine(); line != null; line = buffReader.readLine()){ //convert file data to ArrayList
            dataArrayList.add(line);
            n++;
        }
        buffReader.close();
        ArrayList<String> index = new ArrayList<>();
        int[][] arr2D;
        int j = 1;
        String[] indexStartVal = dataArrayList.get(0).split(" ", 2); //start of index initialization
        index.add(indexStartVal[0]);
        for(int i = 1; i<n; i++){ //initialize index using dataArrayList
            /*
            To fix this code, I'd need to account for the second half of each text line
            to make sure nodes like Netherland, Russia, England, and USA are accounted for,
            probably by changing it to comparing both splitstr strings against all index values.
            */
            String[] splitstr = dataArrayList.get(i).split(" ", 2);
            String[] prev = dataArrayList.get(i-1).split(" ", 2);
            if (!(splitstr[0].equals(prev[0]))){
                index.add(splitstr[0]);
                j++;
            }
        }
        arr2D = new int[j][j];
        /*
        This is the point at which I gave up after adding more variables and it still not working.
        Hence the messiness and lack of functionality.
        I don't know how to fix this code, probably because I don't know how many variables I need
        and what they should keep track of. Or it could be a completely different issue.
        */
        int m = 0; 
        for(int i = 0; i < n; i++){ //initialize arr2D using dataArrayList and index
            String[] splitstr = dataArrayList.get(i).split(" ", 2);
            int k = i;
            int p = 0;
            while ((splitstr[0].equals(index.get(m))) && (p < (j - 1))){
                if(splitstr[1].equals(index.get(p))){ 
                    arr2D[m][p] = 1;
                } 
                k++;
                p++;
                splitstr = dataArrayList.get(p).split(" ", 2);
            }
            i += k;
            m++;
        }

    /*
    The following two 'for' loops were for testing purposes.
    */

        for (int i = 0; i < j; i++){//outputs 2D array values
            for(int k = 0; k<j; k++){
                System.out.print(arr2D[i][k]);
            }
            System.out.println("");
        }
        for(int i = 0; i<j; i++)//outputs index values
            System.out.println(index.get(i));
    }

}
