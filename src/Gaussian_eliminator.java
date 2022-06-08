import java.sql.Array;
import java.util.Scanner;
public class Gaussian_eliminator {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("welcome to Gaussian Eliminator");
        float[][] R = {{4, -8, 3, 16},//matrix is represented by R
                {-1, 2, -5, -21},
                {3, -6, 1, 7}
        };
        System.out.println("ENTER the matrix of any dimensions");
        System.out.println();
        int n=3;
        printmatrix(n,R);
        System.out.println();
       // int n=3;
    //    int n= scanner.nextInt();

        //for (int i=0;i<n;i++)
         //   for (int j=0;j<=n;j++)
              //  R[i][j]=scanner.nextFloat();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                float factor;
                if (R[i][i] == 0) {
                    factor = 0;
                } else {
                    factor = (R[j][i] / R[i][i]);
                }

                {
                    for (int k = 0; k <= n; k++)
                        R[j][k] = R[j][k] - (R[i][k] * factor);
                }
                printmatrix(n,R);
                System.out.println();
            }
        }

     printmatrix(n,R);
        System.out.println();

        float[] value;
        value = new float[n];

        //BACK SUBSTITUTION
        value[n - 1] = R[n - 1][n] / R[n - 1][n - 1];

        for (int i = n - 2; i >= 0; i--) {
            int sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += R[i][j] * value[j];
            }
            value[i] = (R[i][n] - sum) / R[i][i];
        }
        for (int i = 0; i < n; i++) {
            System.out.println("value of x"+(i+1)+"  is equals to : "+value[i]);
        }


    }

    static void NoSolutionCheck(float[][] a,int n){
        for (int i=0;i<n;i++){
            int rowSum=0;
            for (int j=0;j<n;j++){
                rowSum+=a[i][j];
            }
            if (rowSum==0&& a[i][n]!=0)
                System.out.println("There exists no solution for this system of linear equations");;
        }

    }
    static void printmatrix(int n,float[][]R){  for (int i = 0; i < n; i++) {
        System.out.print("| ");
        for (int j = 0; j < n + 1; j++) {
            if (j == 3) System.out.print(" ||   ");
            System.out.printf("%.3f    ", R[i][j]);

        }
        System.out.println("|");
    }}
}