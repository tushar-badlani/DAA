import java.util.*;

class Ass6{

    static int minCost = 1000;
    static int[] best;
    public static void main(String args[]){
        int n = 4;

        int [][] cost = {
            {1,3,2,4},
            {3,2,2,1},
            {4,2,3,1},
            {2,2,4,2}
        };

        int[] assigned = new int[n];
        best = new int[n];

        for(int i=0; i<n; i++){
            assigned[i] = -1;
            best[i] = -1;
        }

        bb(cost, n, assigned, 0, 0);

        for(int i=0; i<n; i++){
            System.out.println("Club " + i + " is assigned to " + best[i] + " Student");
        }

        System.out.println("Min cost is "+ minCost);

    }

    public static void bb(int[][] cost, int n, int[] assigned, int student, int currentCost){
        if(student ==n){
            if(currentCost<minCost){
                minCost = currentCost;
                for(int i=0; i<n; i++){
                    best[i] = assigned[i];
                }
            }
        }
        for(int i =0; i<n; i++){
            if(assigned[i]==-1){
                assigned[i] = student;
                currentCost += cost[student][i];

                if(currentCost<minCost){
                    bb(cost, n, assigned, student+1, currentCost);
                }
                
                currentCost -= cost[student][i];
                assigned[i] = -1;
            }
        }
    }
}
