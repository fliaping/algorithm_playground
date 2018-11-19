class FibonacciMatrix {
    
    public int climbStairs(int n) {
        int[][] a = {{1,1},{1,0}};
        int[][] result = {{1,0},{0,1}};
        for(int i =0;i<n+1;i++) {
           result = matrixMutil(result,a);
        }
        return result[0][1];
    }
    
    // 通用矩阵乘法，对于该特定问题可以简化
    public int[][] matrixMutil(int[][] m, int[][] n) {
        if(m[0].length != n.length) {
            return null;
        }
        int[][] result = new int[m.length][n[0].length];
        for(int i = 0;i<m.length;i++) {
            for(int j=0;j<n[i].length;j++) {
                result[i][j] = sum(m[i], getCol(n,j));
            }
        }
        return result;
    }
    
    private int[] getCol(int[][] matrix, int n) {
        int[] col = new int[matrix.length];
        for(int i = 0;i<matrix.length;i++){
            col[i] = matrix[i][n];
        }
        return col;
    }
    
    private int sum(int[] row, int[] col) {
        int sum = 0;
        for(int i=0;i<row.length;i++) {
            sum+=row[i] * col[i];
        }
        return sum;
    }
}