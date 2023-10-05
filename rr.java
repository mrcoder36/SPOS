package SPOS;

import java.util.*;
public class rr {
    public static void main(String args[]) {
        int n,i,qt,count=0,temp,sq=0;
        float awt=0,atat=0;
        int[] bt = new int[10];
        int[] wt = new int[10];
        int[] tat = new int[10];
        int[] rem_bt = new int[10];
        Scanner s=new Scanner(System.in);
        System.out.println("ROUND ROBIN SCHEDULING");
        System.out.print("Enter the number of process: ");
        n = s.nextInt();
        System.out.print("Enter the burst time of the process\n");
        for (i=0;i<n;i++) {
            System.out.print("P["+i+"] ");
            bt[i] = s.nextInt();
            rem_bt[i] = bt[i];
        }
        System.out.print("Enter the quantum time: ");
        qt = s.nextInt();
        while(true) {
            for (i=0,count=0;i<n;i++) {
                temp = qt;
                if(rem_bt[i] == 0) {
                    count++;
                    continue;
                } if(rem_bt[i]>qt)
                    rem_bt[i]= rem_bt[i] - qt;
                else if(rem_bt[i]>=0) {
                    temp = rem_bt[i];
                    rem_bt[i] = 0;
                }
                sq = sq + temp;
                tat[i] = sq;
            }
            if(n == count)
                break;
        }

        System.out.print("\nProcess\t\tbt\t\ttat\t\t wt\n");

        for(i=0;i<n;i++) {
            wt[i]=tat[i]-bt[i];
            awt=awt+wt[i];
            atat=atat+tat[i];
            System.out.print("\n P["+(i+1)+"]\t\t"+bt[i]+"\t\t "+tat[i]+"\t\t "+wt[i]+"\n");
        }
        awt=awt/n;
        atat=atat/n;
        System.out.println("\nAverage waiting Time = "+awt+"\n");
        System.out.println("Average turnaround time = "+atat);
    }
}  