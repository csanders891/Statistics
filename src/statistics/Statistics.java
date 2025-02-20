package statistics;

import java.util.ArrayList;
import java.util.Scanner;

public class Statistics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//data size
		System.out.println("How many elements?");
		Scanner sc = new Scanner(System.in);	
		int SIZE = sc.nextInt();
		
		//array must have more than 1 element
		while(SIZE == 1)
		{
			System.out.println("Array must have more than 1 element");
			SIZE = sc.nextInt();
		}
		
		int data[] = new int[SIZE];
		
		//data elements
		System.out.println("Enter the " + SIZE + " elements");
		
		for(int i = 0; i < SIZE; i++)
		{
		data[i] = sc.nextInt();
		
		//must be positive integers
		while(data[i] < 0)
		{
			System.out.println("Element must be a positive integer");
			data[i] = sc.nextInt();
		}
	} 
	
		int mean = mean(data);
		System.out.println(mean);
		
		int median = median(data);
		System.out.println(median);
		
		int mode = mode(data);
		//there is no mode
		if(mode < 0)
			System.out.println("no mode");
		//there is a mode
		else
			System.out.println(mode);
		
		int range = range(data);
		System.out.println(range);
		
		int midrange = midrange(data);
		System.out.println(midrange);
	}
	
	static int mean(int Data[])
	{
		int sum = 0;
		for(int i = 0; i < Data.length; i++)
			sum+=Data[i];
		
		int Mean = sum/Data.length;
		
		System.out.print("Mean: ");
		return Mean;
	}
	
	static int median(int Data[])
	{
		for(int i = 0; i < Data.length; i++)
		{
			for(int j = i+1; j < Data.length; j++)
			{
				int temp;
				if(Data[i] > Data[j])
				{
					temp = Data[i];
					Data[i] = Data[j];
					Data[j] = temp;
				}
			}
		}
		
		//even number array elements
		if(Data.length % 2 == 0) 
		{
			int m1 = (Data.length-1) / 2;
			int m2 = m1+1;
			
			int Median = (Data[m1] + Data[m2]) / 2;
			
			System.out.print("Median: ");
			return Median;
		}
		
		//odd number array elements
		else 
		{
			int m = (Data.length-1)/2;
			
			int Median = Data[m];
			
			System.out.print("Median: ");
			return Median;
		}
		
	}
	
	static int mode(int Data[])
	{
		int Mode = -1;
		
		int maxCount = 1;
		int Modes = 0;
		ArrayList<Integer> modes = new ArrayList<Integer>();
		
		for(int i = 0; i < Data.length; i++)
		{
			int count = 1;
			for(int j = i+1; j < Data.length; j++)
			{
				if(Data[i] == Data[j])
				count++;
			}	
			
			if(count > maxCount)
			{
				maxCount = count;
				modes.clear();
				Mode = Data[i];	
				modes.add(Mode);
			}
			
			else if(count == maxCount && count > 1)
			{
					Mode = Data[i];	
					modes.add(Mode);
			}
		}
		
		//if there is more than 1 mode
		if(modes.size() > 1)
		{
			System.out.print("Mode: ");
			for(int i = 0; i < modes.size()-1; i++)
				System.out.print(modes.get(i) + " ");
				
			return Mode;		
		} 
		
		//if there is only 1 mode
		else 
		{
			System.out.print("Mode: ");
			return Mode;	
		}
		
	}		
	
	static int range(int Data[])
	{
		int largest = 0;
		
		for(int i = 0; i < Data.length; i++)
			if(Data[i] > largest)
				largest = Data[i];
		
		int smallest = largest;
		
		for(int i = 0; i < Data.length; i++)
			if(Data[i] < smallest)
				smallest = Data[i];
		
		int Range = largest - smallest;
		
		System.out.print("Range: ");
		return Range;
	}
	
	static int midrange(int Data[])
	{
		int largest = 0;
		
		for(int i = 0; i < Data.length; i++)
			if(Data[i] > largest)
				largest = Data[i];
		
		int smallest = largest;
		
		for(int i = 0; i < Data.length; i++)
			if(Data[i] < smallest)
				smallest = Data[i];
		
		int midrange = (largest+smallest)/2;
		
		System.out.print("Midrange: ");
		return midrange;
	}
}
