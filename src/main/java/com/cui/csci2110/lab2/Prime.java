package com.cui.csci2110.lab2;
import java.util.Scanner;
public class Prime {
	public static void main (String [] args){
		Scanner scanner = new Scanner(System.in);
		long startTime, endTime, executionTime;
		System.out.print("Please enter the number:");
		int num = scanner.nextInt();
		startTime = System.currentTimeMillis();
		System.out.println("The corresponding prime number is " + nthPrime(num));
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;		
		System.out.println("Execution time: " + executionTime + " millisecs");
	}
	public static boolean isPrime1(long n) { //this method is a smarter way to determine the prime number which I searched from google and I did a little change.
        if(n == 2)
        	return true;
		if (n % 2 == 0) 
            return false;
        for (int i = 3; i*i <= n; i += 2)
            if (n % i == 0) 
                return false;
        return true;
    }
	public static boolean isPrime2(long n) { // this method is a normal way to determine the prime number, and it takes very long time to find the prime number, so this time I didn't use it,but I still keep this.  
	    for(int i = 2; i < n; ++i) {
	        if (n % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	public static long nthPrime(int n) { // this method is to get the prime number and also using the method of isPrime1, and it didn't take much long time to get the number even though the input is very huge.
	    long num, count;
	    for(num = 2, count = 0; count < n; num++) {
	        if (isPrime1(num)) {
	            count++;
	        }
	    }
	    return num-1;
	}
}
