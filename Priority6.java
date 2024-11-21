import java.util.*;

class Node{
    Node parent;
    int pathCost;
    int leastCost;
    int student;

    int assigned[];

    public Node(int n){
        assigned = new int[n];
        for(int i=0; i<n; i++){
            assigned[i] = -1;
        }
    }
}


public class Priority6{
    public static void main(String args[]){
        int n = 4;

        int [][] cost = {
            {1,3,2,4},
            {3,2,2,1},
            {4,2,3,1},
            {2,2,4,2}
        };

        System.out.println("Minimum cost is " + minCost(cost, n));
    }

    static int minCost(int[][] cost, int n){
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node->Node.leastCost));

        Node root = new Node(n);
        root.pathCost = 0;
        root.leastCost = 0;
        root.student = -1;

        pq.add(root);

        while(!pq.isEmpty()){
            Node minNode = pq.poll();

            int student = minNode.student + 1;

            if(student == n){
                printAns(minNode, n);
                return minNode.leastCost;
            }

            for(int club =0; club<n; club++){
                
                if(minNode.assigned[club]==-1){
                    Node child = new Node(n);
                    for(int i=0; i<n; i++){
                        child.assigned[i] = minNode.assigned[i];
                    }
                    child.pathCost = minNode.pathCost + cost[student][club];
                    child.student = student;
                    child.assigned[club] = student;
                    int lower = child.pathCost;

                    for(int i=student+1; i<n; i++){
                        int min = Integer.MAX_VALUE;
                        for(int j=0; j<n; j++){
                            if(cost[i][j]<min){
                                min = cost[i][j];
                            }
                        }
                        lower+=min;
                    }

                    child.leastCost = lower;
                    pq.add(child);
                }

                
            }
        }
        return -1;

    }

    static void printAns(Node minNode, int n){
        for(int i=0; i<n; i++){
            System.out.println("Club " + (i+1) + " is " + " assigned to " + (minNode.assigned[i] +1) +" Student");
        }
    }
}

