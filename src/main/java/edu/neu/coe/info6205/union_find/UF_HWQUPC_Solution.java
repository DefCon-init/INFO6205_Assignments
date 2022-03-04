package edu.neu.coe.info6205.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UF_HWQUPC_Solution {
    public static void main(String[] args) {
        int num;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter value of n:");
            num = Integer.parseInt(br.readLine());
            for(int n = num; n <= num * Math.pow(2, 13); n=n*2) {
                int i = 0;
                int nPairs[] = new int[10];
                while (i < 10) {
                    final int nConn = count(n);
                    nPairs[i] = nConn;
                    i++;
                }
                System.out.println("For N: " + n + " Average: " + Arrays.stream(nPairs).average());
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static int count(int n) {
        UF h = new UF_HWQUPC(n, true);
        int loopCtr = 0;
        int num1, num2;
        while(h.components() > 1) {
            num1 = (int) (Math.random() * n);
            num2 = (int) (Math.random() * n);
            if (!h.isConnected(num1, num2)) {
                h.union(num1, num2);
            }
            loopCtr++;
        }
        return loopCtr;
    }
}
