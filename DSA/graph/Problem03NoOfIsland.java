package DSA.graph;

public class Problem03NoOfIsland {
    public static void main(String[] args) {
        String[][] grid = new String[][]{
                {"1", "1", "1", "1", "0"},
                {"1", "1", "0", "1", "0"},
                {"1", "1", "0", "0", "0"},
                {"0", "0", "0", "0", "0"}
        };
        int ans = calculateIsland(grid);
        System.out.println(STR."No of Island \{ans}");




    }

    private static int calculateIsland(String[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=="1"){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }

        return count;
    }

    private static void dfs(String[][] grid,int i , int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=="0"){
            return;
        }
        grid[i][j] = "0";
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
