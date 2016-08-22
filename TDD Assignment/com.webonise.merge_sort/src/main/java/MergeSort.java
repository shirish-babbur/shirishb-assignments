package main.java;

import java.util.Scanner;

public class MergeSort {
	private int array[];
	public MergeSort(int [] input,int length){
		array=new int[length];
		array=input;
	}

	public static void main(String[] args) {
		int i=0;
        int array[]={45,67,78,89,44,90,1,5};
        int test[]=new int[array.length];
		MergeSort mergesort= new MergeSort(array,array.length);
        mergesort.MergeSort(0,array.length-1);
        test=mergesort.getSortedArray();
        for(i = 0;i < array.length;i++)
        {
                System.out.print(test[i]+"\t");
        }
        System.out.print("\n");

	}

	void MergeSort(int left, int right)
	{
	        int mid = (left+right)/2;
	        if(left<right)
	        {
	                MergeSort(left,mid);
	                MergeSort(mid+1,right);
	                Merge(left,mid,right);
	        }
	}
	void Merge( int left, int mid, int right)
	{
		if(array!=null)
		{
	        int tempArray[]=new int[right-left+1];
	        int pos=0,l = left,r = mid + 1;
	        while(l <= mid && r <= right)
	        {
	                if(array[l] < array[r])
	                {
	                        tempArray[pos++] = array[l++];
	                }
	                else
	                {
	                        tempArray[pos++] = array[r++];
	                }
	        }
	        while(l <= mid)  tempArray[pos++] = array[l++];
	        while(r <= right)tempArray[pos++] = array[r++];
	        int iter;
	        for(iter = 0;iter < pos; iter++)
	        {
	                array[iter+left] = tempArray[iter];
	        }
	        System.out.println("in Merge()");
		}
		else
		{
			return;
		}
	        return;
	}
	public int[] getSortedArray(){
		if(array!= null)
		{
			return array;
		}
		else
		{
			return null;
		}
	}

}
