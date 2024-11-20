import java.util.*;

public class Ass2{
    public static void main(String args[]){
        System.out.print("Enter no of tasks: ");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Task[] tasks = new Task[n];

        for(int i=0; i<n; i++){
            System.out.print("Enter task " + i+1 + " profit: ");
            int p = sc.nextInt();
            System.out.print("Enter task " + i+1 + " profit: ");
            int d = sc.nextInt();
            Task t = new Task(i+1, p,d);
            tasks[i] = t;
        }

        int maxDeadline = 0;


        for(int i=0; i<n; i++){
            if(tasks[i].deadline>maxDeadline){
                maxDeadline = tasks[i].deadline;
            }
        }
        int[] result = new int[maxDeadline];

        for(int i=0; i<maxDeadline; i++){
            result[i] =-1;
        }

        Arrays.sort(tasks, (a,b)-> b.profit-a.profit);

        int totalProfit =0;

        for(int i=0; i<n; i++){
            for(int j=tasks[i].deadline-1; j>=0; j--){
                if(result[j] ==-1){
                    totalProfit+=tasks[i].profit;
                    result[j] = tasks[i].id;
                    break;
                }
            }
        }

        System.out.println("\nSchedule:");
        System.out.println("Time Slot | Task");
        System.out.println("----------------");
        // For each time slot
        for(int i = 0; i < maxDeadline; i++) {
            System.out.print("    " + (i+1) + "     |");  // Print time slot
            if(result[i] != -1) {  // If slot has a task
                System.out.println("  Task " + result[i]);  // Print task number
            } else {  // If slot is empty
                System.out.println("  Empty");
            }
        }
        
        // Print total profit
        System.out.println("\nTotal Profit: " + totalProfit);

    }
}

class Task{
    int id;
    int deadline;
    int profit;

    Task(int id, int profit, int deadline){
        this.id = id;
        this.profit = profit;
        this.deadline = deadline;
    }
}