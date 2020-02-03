package com.techlabs.repeatenum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RepeateNum {
	
	public int[] repeateArray(int n, int power, int data[]) {
		if(n == 0){
            return new int[0];
        }
		
		int root = (int) Math.pow(n, power);
		
		int left = root/2;
		int right = root-1;
        
        return null;
	}
	public static void main(String[] args) {
		RepeateNum obj = new RepeateNum();
		int [] array = {1,2,2,3,3,3,4,5,5,0};
		array = obj.repeateArray(array, 1);
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
