package com.example.algorithm.base.dp;

/**
 * leetcode 67题
 */
class num_67 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m - 1][n- 1] == 1 || obstacleGrid[0][0] == 1){
            return 0;
        }
        int[][] dep = new int[m][n];
        for(int i = 0; i < m; i ++ ) {
            for (int j = 0 ; j < n;j ++) {
                if(i == 0 && j == 0) {
                    dep[0][0] = 1;
                    continue;
             }
             if(i == 0 && obstacleGrid[i][j - 1] != 1) {
               dep[i][j] = dep[i][j-1] ;
               continue;
             }
             if(j == 0 && obstacleGrid[i - 1][j] != 1) {
                 dep[i][j] = dep[i - 1][j];
                 continue;
             }
             if(i > 0 && obstacleGrid[i-1][j] != 1){
                 dep[i][j] += dep[i -1][j];
             }
             if(j > 0 && obstacleGrid[i][j -1] != 1) {
                  dep[i][j] += dep[i][j - 1];
             }

            }
        }
       return dep[m-1][n-1];
    }
}