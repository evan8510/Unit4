
package Lesson11.Recursion;

import java.util.Scanner;


public class Hanoi {

    static int numMoves=0;
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of rings 3 to 10: ");
        int numRings = s.nextInt();
        if(numRings < 3 || numRings > 10){
            System.out.println("Invalid input - program will now end.");
            return;
        }
        
        //call move - requires number or rings, going from where to where
        //and which ring is the in-between step
        move(numRings, 1, 3, 2);
        System.out.println("Total moves = " + numMoves);
    }
    
    public static void move(int n, int i, int j, int k){
        //stop doing it when we are down to 0 rings (n=0)
        if(n>0){
            numMoves++;
            move(n-1,i,k,j); //move calls itself not j & k reversed
            System.out.println("Move ring " + n + " from peg " + j);
            //move calls itself again - back from k to j
            move(n-1, k, j, i);
        }
    }
    
}
