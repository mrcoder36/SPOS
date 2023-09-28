package SPOS;
import java.util.Scanner;

public class sjf {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        System.out.print("Enter no. of processes: ");
        n = input.nextInt();
        int[] pr = new int[n];
        int[] bt = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("P[" + i + "] ");
            bt[i] = input.nextInt();
        }
        // Sorting algo.
        // Sorting of burst time
        int pos = 1, temp;
        for(int i=0;i<n;i++){
            pos = i;
            for(int j=i+1;j<n;j++){
                if(bt[j]<bt[pos]){
                    pos = j;
                }
            }
            temp = bt[i];
            bt[i]=bt[pos];
            bt[pos]= temp;

            temp= pr[i];
            pr[i]=pr[pos];
            pr[pos]=temp;
        }
        // Calculating wt
        int[] wt = new int[n];
        double awt = 0;
        wt[0] = 0;
        for (int i = 0; i < n; i++) {
            wt[i] = wt[i] + bt[i];
            awt += wt[i];
        }

        int[] tat = new int[n];
        float atat = 0;
        for (int j = 0; j < n; j++) {
            tat[j] = wt[j] + bt[j];
            atat += tat[j];
        }
        atat =(float)atat/n;
        awt = (float)awt/n;

        System.out.println("Process\t"+ " bt\t" + "wt\t" + "tat");
        for (int i = 0; i < n; i++) {
            System.out.println("P["+i+"]\t " + bt[i] + "\t "+ wt[i] +"\t " +tat[i]);
        }
        System.out.println("Avg waiting time: "+ awt);
        System.out.println("Avg Turn Around time: "+atat);
        input.close();
    }
}
