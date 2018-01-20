package it.car.yelp.intrw.bitmanipulation;

import java.util.Arrays;

public class BinarySearchInrotateArray {
	
	public static void main(String args[]){
		System.out.println(search(new int[]{3, 5, 1}, 1));
	}
	
	public static int search(int[] A, int target) {
        int dim = A.length;
        int res = -1;
        int startArray = searchStart(A, 0, dim-1);
        
        if(target >= A[startArray] && target <= A[dim-1]){
        	res = searchBinary(A, startArray, dim-1, target);
        }else
        	res = searchBinary(A, 0, startArray, target);
//        if(){
//      
        return res;
//        }
        
    }
    
    private static int searchBinary(int[] A, int start, int end, int target) {

    	int mid = (start + end)/2;
    	int res = -1;
    	
    	if(start == end && A[start]!=target){
    		return -1;
    	}
    	
    	if(A[mid] == target){
    		return mid;
    	}
    	
    	else if(mid - 1 >= 0 && target ==  A[mid - 1]){
    		res = mid - 1;
    	}
    	
    	else if(mid + 1 > A.length && target ==  A[mid + 1]){
    		res = mid - 1;
    	}
    	
    	else if(mid - 1 >= 0 && target < A[mid]){
    		res =  searchBinary(A, start, (mid-1), target);
    	}
    	
    	else if(mid + 1 < A.length && target ==  A[mid + 1]){
    		res = mid + 1;
    	}
    	
    	else if((mid + 1) < end){
    		res =  searchBinary(A, (mid+1), end, target);
    	}

		return res;
	}

	static int searchStart(int[] A, int start, int end){
        int mid = (start + end) /2;
        int res = mid;
        
        if(start>end)
        	return res;
        
        if((mid+1)<A.length && A[mid]>A[mid+1]) 
        	res = mid+1;
        
        else if((mid-1)>0 && A[mid]<A[mid-1]) 
        	res = mid;
        
        else if(A[mid] < A[start] && mid-1 >=0)
        	res = searchStart(A, start, mid-1);
        else if(A[mid] > A[end])
        	res = searchStart(A, mid+1, end);
        
        return res;
        
    }

}
