package com.cui.csci2110.lab2;

import java.util.Scanner;
public class MatrixMult {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int n;
		double num;
		System.out.print("Enter the size of each matrix: ");
		n = keyboard.nextInt();
		System.out.println("Enter the matrix element");
		System.out.print("All elements of the matrices are assumed to be the same: ");
		num = keyboard.nextDouble();
		double[][] matrix1 = new double[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				matrix1[i][j] = num;
		double[][] matrix2 = new double[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				matrix2[i][j] = num;
		long startTime, endTime, executionTime;
		startTime = System.currentTimeMillis();
		double[][] resultMatrix = multiplyMatrix(matrix1, matrix2);
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		System.out.println("Execution time: " + executionTime + " millisecs");
	}
	public static double[][] multiplyMatrix(double[][] m1, double[][] m2) {
		double[][] matrix = new double[m1.length][m1.length]; //create a new 2d array with same size like m1 and m2
		for (int i = 0; i < m1.length; i++)
			for (int j = 0; j < m1.length; j++)
				for (int k = 0; k < m1.length; k++){
					matrix[i][j] = matrix[i][j] + m1[i][k] * m2[k][j]; //use the formula that gives in the lab
				}
		return matrix;
	}

}
