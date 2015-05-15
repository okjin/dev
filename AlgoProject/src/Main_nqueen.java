

import java.util.Scanner;
 
public class Main_nqueen{
 
    static int[] chess;
    static int count;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int size = sc.nextInt();
 
        chess = new int[size];
 
        nqueen(0,size);
 
        System.out.println(count);
 
    }
 
    private static void nqueen(int y, int x) {
        for (int i=0;i<x;i++) {
 
            if (canPlaceQueen(y,i)) {
                chess[y] = i;
                if (y == x - 1) {
                    count++;
                } else {
                    nqueen(y +1, x);
                }
            }
 
        }
    }
 
    public static boolean canPlaceQueen(int r, int c) {
 
        for (int i = 0; i < r; i++) {
            if (chess[i] == c || (i - r) == (chess[i] - c) ||(i - r) == (c - chess[i]))
            {
                return false;
            }
        }
        return true;
    }
 
 
}