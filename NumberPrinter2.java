package com.cs.mutliThreading;

public class NumberPrinter2 {
	
	    private int number = 1;
	    private final int MAX = 20;

	    public synchronized void printOdd() {
	        while (number <= MAX) {
	            if (number % 2 == 0) { // not my turn
	                try {
	                    wait();
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            } else {
	                System.out.print(number + " ");
	                number++;
	                notify(); // wake up even thread
	            }
	        }
	    }

	    public synchronized void printEven() {
	        while (number <= MAX) {
	            if (number % 2 == 1) { // not my turn
	                try {
	                    wait();
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            } else {
	                System.out.print(number + " ");
	                number++;
	                notify(); // wake up odd thread
	            }
	        }
	    }
	}



