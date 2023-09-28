package SPOS;
import java.util.Scanner;

public class fcfs {
    public static void main(String[] args) {
        
        int[] bt = new int[20];
        int[] wt = new int[20];
        int[] tat = new int[10];
        int avtat = 0, avwt = 0;
        int n, i, j;
        
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter total no. of process: ");
            n = sc.nextInt();
            
            System.out.print("Enter process burst times: \n");
            for (i = 0; i < n; i++) {
                System.out.print("P[" + (i + 1) + "]: ");
                bt[i] = sc.nextInt();
            }
        }
        
        wt[0] = 0;
        for (i = 1; i < n; i++) {
            wt[i] = 0;
            for (j = 0; j < i; j++)
            wt[i] += bt[j];
        }

        for (i = 0; i < n; i++) {
            tat[i] = bt[i] + wt[i];
            avwt += wt[i];
            avtat += tat[i];
            System.out.println("P[" + (i + 1) + "] prev.- " + wt[i] + "| curr.- " + bt[i] + " |" + tat[i]);
        }
        
        avwt /= i;
        avtat /= i;
        System.out.println("Average Waiting Time: " + avwt);
        System.out.println("Average Turn around Time: " + avtat);

    }
}
