public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] tmp = new int[9];
        int n = board.length;
        
        //System.out.println("board.length:"+board.length+" n "+n);
        
        /*for(int i=0;i<n;i++){
            System.out.println("row "+i);
            for(int j=0;j<n;j++){
                System.out.println(board[i][j]);
            }
        }*/
        
        //System.out.println("----------------");
        
        //验证行
        for(int i=0;i<n;i++){
            clearArr(tmp);
            for(int j=0;j<n;j++){
                if(board[i][j] !='.') tmp[board[i][j]-'0'-1]++;
                //System.out.println("b:"+board[i][j]+" index:"+(board[i][j]-'0'-1)+"tmp:"/*+tmp[board[i][j]-'0'-1]+"index:"+(board[i][j]-'0'-1)*/);
            }
            if(isDuplicate(tmp)) return false;
        } 
        //验证列
        for(int i=0;i<n;i++){
            clearArr(tmp);
            for(int j=0;j<n;j++){
                if(board[j][i] !='.') tmp[board[j][i]-'0'-1]++;
            }
            if(isDuplicate(tmp)) return false;
        }
        //验证九宫格
        for(int i=0;i<n;i+=3){
            for(int j=0;j<n;j+=3){
                clearArr(tmp);
                for(int a=0;a<3;a++){
                    for(int b=0;b<3;b++){
                        if(board[i+a][j+b] !='.') tmp[board[i+a][j+b]-'0'-1]++;
                    }
                }
                if(isDuplicate(tmp)) return false;
            }
        }
        return true;
    }
    
    public void clearArr(int[] tmp){
        for(int i = 0;i<tmp.length;i++) tmp[i] = 0;
    }
    
    public boolean isDuplicate(int[] tmp){
        for(int i:tmp) {
            //System.out.println(i);
            if(i > 1) return true;
        }
        return false;
    }
}
