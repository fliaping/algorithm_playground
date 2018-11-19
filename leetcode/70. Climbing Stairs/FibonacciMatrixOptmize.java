class FibonacciMatrixOptmize {
    public int climbStairs(int n) {
        int[][] source = {{1,1},{1,0}};
        int[][] result = pow(source,n);
        return result[0][0];
    }
    
    
    public int[][] pow(int[][] m, int n) {
        if(n==1) {
            return m;
        }
        if((n & 1) == 1) {
           return matrixMutil(pow(m,n-1), m);
        } else {
            int[][] half = pow(m,n>>1);
            return matrixMutil(half,half);
        }
    }
    
    //通用矩阵乘法，对于该特定问题可以简化
    public int[][] matrixMutil(int[][] m, int[][] n) {
        if(m[0].length != n.length) {
            return null;
        }
        int[][] result = new int[m.length][n[0].length];
        int[][] transpose = matrixTranspose(n);
        for(int i = 0;i<m.length;i++) {
            for(int j=0;j<n[i].length;j++) {
                result[i][j] = sum(m[i], transpose[j]);
            }
        }
        return result;
    }
    
    private int[][] matrixTranspose(int[][] matrix) {
        int[][] transpose = new int[matrix[0].length][matrix.length];
        
        for(int i = 0;i<matrix[0].length;i++){
            for(int j = 0;j<matrix.length;j++) {
                transpose[i][j] = matrix[j][i];
            }
        }
        return transpose;
    }
    
    private int sum(int[] row, int[] col) {
        int sum = 0;
        for(int i=0;i<row.length;i++) {
            sum+=row[i] * col[i];
        }
        return sum;
    }
}