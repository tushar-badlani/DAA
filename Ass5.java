import java.util.*;

public class Ass5{

    public static void main(String args[]){
        int n = 5;
        int x=1;
        int y=1;
        int[][] board = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = -1;
            }
        }
        board[x][y] = 0;

        if(solve(board, x, y, n, 1)){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Not possible");
        }
        
    }

    public static boolean solve(int[][] board, int x, int y, int n, int count){
        int[] move_x = {1,-1,2,-2,1,-1,2,-2};
        int[] move_y = {2,2,1,1,-2,-2,-1,-1};
        if(count == (n*n)){
            return true;
        }
        for(int i=0; i<8; i++){
            int nx = x + move_x[i];
            int ny = y + move_y[i];
            if(isSafe(board, nx, ny,n)){
                board[nx][ny] = count;
                if(solve(board, nx, ny, n, count+1)){
                    return true;
                }
                else{
                    board[nx][ny]=-1;
                }
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] board,int i, int j, int n){
        if(i<0 || i>=n || j<0 || j>=n || board[i][j]!=-1){
            return false;
        }
        return true;
    }
}
