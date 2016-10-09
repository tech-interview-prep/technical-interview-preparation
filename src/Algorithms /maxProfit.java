import java.io.*;
import java.util.*;

/* 
#next 100 days FB stock price
#[80, 78, 100, 76, 80]
an array for which the ith element is the price of a given stock on day i 
# Give you $1000, max profit

# - you can buy and sell as many as you want

Find the max profit if only allowed 1 transaction
You're basically given 1000$ to start, find the max profit you can make by 
i) making one transaction and ii) as many as you want

http://articles.leetcode.com/2010/11/best-time-to-buy-and-sell-stock.html

 */

class maxProfit{

	public static void main(String[] args){
    	System.out.println(calculateMaxProfit(new double[]{40, 80, 10, 30}, 1000));
	}

	public static double calculateMaxProfit(double[] stocks, double base){
		
		double maxProfit = 0;
		double min = Double.MIN_VALUE;
		double max = Double.MAX_VALUE;
		double sharePurchased = 0;

		for(int i = 0; i < stocks.length; i++){
			if(stocks[i] > min){ //first check to see if there is a new minimum vale which is based on stock price element
				System.out.println(stocks[i]);
				min = stocks[i]; //replace that as the new minimum
				if((min - max) * sharePurchased > maxProfit){ ///maxProfit if minimum minus the max * shares purhcased 
					maxProfit = (min - max) * sharePurchased;
				}
			}

			if(stocks[i] < max){ //check to see if the stock element is less than the maximum before going to next element				System.out.println(stocks[i]);

				max = stocks[i];//replace the stock element as the new maximum
				sharePurchased = base / stocks[i];  //calculate the amount of shares you can based based upon 40
				min = stocks[i]; //make it the new minimum 
			}
		}
		return maxProfit;

	}



	public static double calcMaxMultiple(double[] stocks, double base) {
	    double buyPrice = Double.MAX_VALUE;
	    double shares = 0;
		    for(int i = 0; i < stocks.length; i++) {
		      if(stocks[i] < buyPrice) {

		        buyPrice = stocks[i]; // buyPrice would be the new stock price element
		        shares = base / stocks[i]; //calculate shares based upon base/stock element
		      }
		      if(stocks[i] > buyPrice) { 
		        base = base + (stocks[i] - buyPrice) * shares; //so the new base would be base + difference * number of shares
		        buyPrice = stocks[i];
		      }
		    }
	    return base;
  }









}