package Lab1.Ex2;

public class calculator {
    private int[][] matrix1 = new int[3][3];
    private int[][] matrix2 = new int[3][3];
    private int[][] matrix = new int[3][3];
    public calculator(int[][] matrix1, int[][] matrix2) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
    }
    public void add(){
        for (int i=0; i<3; i++)
            for(int j=0; j<3; j++){
                matrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        for (int i=0; i<3; i++){
            for(int j=0; j<3; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println(" ");
        }
    }
    public void product(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                matrix[i][j]=0;
                for(int k=0;k<3;k++)
                {
                    matrix[i][j]+=matrix1[i][k]*matrix2[k][j];
                }//end of k loop
                System.out.print(matrix[i][j]+" ");  //printing matrix element
            }//end of j loop
            System.out.println();//new line
        }
    }
}


