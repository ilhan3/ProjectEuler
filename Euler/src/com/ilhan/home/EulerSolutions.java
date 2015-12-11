package com.ilhan.home;

import java.util.ArrayList;

public class EulerSolutions {
	/*
	If we list all the natural numbers below 10 that are multiples of 3 or 5,
	we get 3, 5, 6 and 9. The sum of these multiples is 23.
	Find the sum of all the multiples of 3 or 5 below 1000.
	*/
	public int Euler1(){
		long startTime = System.currentTimeMillis();
		int sum = 0;
		int i;
		System.out.println("The Answer for Question 1 is");
		for(i=3; i<1000; i=i+3){
			sum += i;
		}
		for(i=5; i<1000; i=i+5){
			sum += i;
		}
		for(i=15; i<1000; i=i+15){
			sum -= i;
		}
		System.out.println(sum);
		long stopTime = System.currentTimeMillis();
		System.out.println("Elapsed time: " + String.valueOf(stopTime-startTime) + " ms");
		return sum;
	}
	
	/* 
	Each new term in the Fibonacci sequence is generated by adding the 
	previous two terms. By starting with 1 and 2, the first 10 terms will be:
	1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
	By considering the terms in the Fibonacci sequence whose values 
	do not exceed four million, find the sum of the even-valued terms.
	*/
	public long Euler2(){
		long startTime = System.currentTimeMillis();
		long sum = 0;
		int fiboCurrent = 1;
		int fiboPrev = 1;
		System.out.println("The Answer for Question 2 is");
		while(fiboCurrent < 4000000){
			fiboCurrent += fiboPrev;
			fiboPrev = fiboCurrent - fiboPrev;
			if(fiboCurrent%2 == 0){
				sum += fiboCurrent;
			}
		}
		System.out.println(sum);
		long stopTime = System.currentTimeMillis();
		System.out.println("Elapsed time: " + String.valueOf(stopTime-startTime) + " ms");
		return sum;
	}
	
	private boolean IsPrime(long number){
		if(((number%2) == 0) & (number != 2)){
			return false;
		}
		long sqrt = (long)Math.sqrt(number);
		for(long i=3; i<=sqrt; i+=2){
			if(number%i == 0){
				return false;
			}
		}
		return true;
	}
	
	private boolean IsPrimeRecursive(long number){
		if(((number%2) == 0) & (number != 2)){
			return false;
		}
		long sqrt = (long)Math.sqrt(number);
		for(long i=3; i<=sqrt; i+=2){
			if(IsPrime(i)){
				if((number%i) == 0){
					return false;
				}
			}
		}
		return true;
	}
	
	private ArrayList<Long> Dividers(long number){
		ArrayList<Long> dividerArray = new ArrayList<Long>();
		long sqrt = (long)Math.sqrt(number);
		while((number%2) == 0){
			dividerArray.add((long)2);
			number /= 2;
		}
		for(long dividerCandidate=3; dividerCandidate<=Math.min(sqrt, number); dividerCandidate+=2){
			while((number%dividerCandidate) == 0){
				dividerArray.add(dividerCandidate);
				number /= dividerCandidate;
			}
		}
		return dividerArray;
	}
	
	public long Euler3(){
		long startTime = System.currentTimeMillis();
		long number = 600851475143L;
		ArrayList<Long> dividers = Dividers(number);
		int numOfDividers = dividers.size();
		System.out.println("The answer for Question 3 is");
		System.out.println(String.valueOf(dividers.get(numOfDividers-1)));
		long stopTime = System.currentTimeMillis();
		System.out.println("Elapsed time: " + String.valueOf(stopTime-startTime) + " ms");
		return dividers.get(numOfDividers-1);
	}
	
	private int NumberOfDigits(int number){
		int digitNumber=1;
		while(true){
			if(number < Math.pow(10, digitNumber)){
				break;
			}
			digitNumber++;
		}
		return digitNumber;
	}
	
	private int ReverseNumber(int number){
		int numOfDigits = NumberOfDigits(number);
		int[] digitArray = new int[numOfDigits];
		int divider;
		for(int i=numOfDigits-1; i>=0; i--){
			divider = (int)Math.pow(10, i);
			digitArray[i] = number/divider;
			number %= divider;
		}
		int reversedNumber = 0;
		for(int i=0; i<numOfDigits; i++){
			reversedNumber += digitArray[numOfDigits-1-i]*Math.pow(10, i);
		}
		return reversedNumber;
	}
	
	private boolean IsPalindrome(int number){
		return number==ReverseNumber(number);
	}
	
	public int Euler4(){
		long startTime = System.currentTimeMillis();
		int max = 0;
		int product;
		for(int i=999; i>99; i--){
			for(int j=i; j>99; j--){
				product = i*j;
				if (product<max){
					break;
				}
				if(IsPalindrome(product)){
					max = product;
				}
			}
		}
		System.out.println("The answer for Question 4 is");
		System.out.println(String.valueOf(max));
		long stopTime = System.currentTimeMillis();
		System.out.println("Elapsed time: " + String.valueOf(stopTime-startTime) + " ms");
		return max;
	}
	
	private int FindPowerLessThan(int base, int threshold){
		int power=1;
		while(true){
			if(Math.pow(base, power) > threshold){
				break;
			}
			power++;
		}
		return power-1;
	}
	
	public int Euler5(){
		long startTime = System.currentTimeMillis();
		int threshold = 20;
		int number = 1;
		number *= Math.pow(2, FindPowerLessThan(2, threshold));
		for(int prime=3; prime<threshold; prime+=2){
			if(IsPrime(prime)){
				number*= Math.pow(prime, FindPowerLessThan(prime, threshold));
			}
		}
		System.out.println("The answer for Question 5 is");
		System.out.println(String.valueOf(number));
		long stopTime = System.currentTimeMillis();
		System.out.println("Elapsed time: " + String.valueOf(stopTime-startTime) + " ms");
		return number;
	}
	
}
