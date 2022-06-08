public class GaussianEliminator {

    public static void main(String[] args) {
        System.out.println("welcome to Gaussian Eliminator");
        float[][] R={{-5,2,9,26} //matrix is represented by R
                    {2,8,1,0}
                    {0,7,3,12}
                     };
   int n=3;// no of equations
    for (int i=0;i<2;i++)
        {for (int j=i+1;j<n;j++)
        {int factor=(R[j][i]/R[i][i]);
                 { for (int k=0;k<=n;k++)
                R[j][k]=R[j][k]-(R[i][k]*factor);
                 }

        }
    }

        System.out.println(R);

}
