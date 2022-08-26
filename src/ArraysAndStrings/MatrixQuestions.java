package ArraysAndStrings;

public class MatrixQuestions {
    public static void main(String[] args) {
//        int [][] mat= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        printMatrix(mat);
//        rotateMatrix(mat);
//        System.out.println("-------------");
//        printMatrix(mat);
        int [][] mat= {{0,2,3,4},{5,6,7,8},{9,2,3,12},{13,14,15,10}};
        printMatrix(mat);
        System.out.println("-------------");
        zeroMatrix1(mat);
        printMatrix(mat);
//        System.out.println("-------------");
//        System.out.println(stringRotation("waterbottle","erbottlewat"));

    }

    public static void zeroMatrix(int[][] mat){
        int m= mat.length-1;
        int n=mat[0].length-1;
        boolean [] zeroRow=new boolean[m+1];
        boolean [] zeroCol = new boolean[n+1];
        for (int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(mat[i][j]==0){
                    zeroRow[i]=true;
                    zeroCol[j]=true;
                }
            }
        }
        for (int i=0;i<=m;i++) {
            for (int j = 0; j <= n; j++) {
                if (zeroRow[i]) {
                    mat[i][j]=0;
                }
                if(zeroCol[j]){
                    mat[i][j]=0;
                }
            }
        }

//        for (int i=0;i<=m;i++) {
//            if (zeroRow[i]) {
//                for (int j = 0; j <= n; j++) {
//                        mat[i][j] = 0;
//                }
//            }
//            if(zeroCol[i]){
//                for (int j = 0; j <= n; j++) {
//                    mat[j][i] = 0;
//                }
//            }
//        }

    }

    private static void printMatrix(int[][] mat) {
        for (int i = 0; i <mat.length ; i++) {
            for (int j = 0; j <mat[0].length ; j++) {
                System.out.print(mat[i][j]+" ");

            }
            System.out.println();

        }
    }

    private static int[][] rotateMatrix(int mat[][]){

        int N=mat.length;
        for (int i = 0; i <N ; i++) {
            for (int j = i; j <N ; j++) {
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }

        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <N/2 ; j++) {
                int temp=mat[i][j];
                mat[i][j]=mat[i][N-1-j];
                mat[i][N-1-j]=temp;
            }
        }



        return mat;
    }



    public static boolean stringRotation(String s1, String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        String s3=s1+s1;

        return s3.contains(s2);
    }


    public static void zeroMatrix1(int [][] mat){
        int length=mat.length;
        boolean []isRowZero=new boolean[length];
        boolean []isColumnZero=new boolean[length];
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                if(mat[i][j]==0){
                    isRowZero[i]=true;
                    isColumnZero[j]=true;
                }

            }
        }

        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                if(isRowZero[i]){
                    mat[i][j]=0;
                }
                if(isColumnZero[j]){
                    mat[i][j]=0;
                }

            }
        }
    }


}
