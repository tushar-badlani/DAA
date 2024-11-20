import java.util.*;

public class Ass3{
    public static void main(String args[]){
        int [][] dist = {
            {0,6,7,1000},
            {8,0,1000,5},
            {5,7,0,6},
            {1000, 1000, 2, 0}
        };

        int n = 4;

        floydWarshall(dist,4);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(dist[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void floydWarshall(int[][] dist, int n){
        for(int v=0; v<n; v++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(dist[i][v] + dist[v][j]< dist[i][j]){
                        dist[i][j] = dist[i][v] + dist[v][j];
                    }
                }
            }
        }
    }
}