package com.xbreak.bat.binarySearch;

/**
 *  ѭ������������Сֵ
 *  https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 *  
 *  
 * @author XBreak
 */
public class FindSmallestInSortArr {
    public int findMin(int[] arr) {
        //ѭ��������СֵΪ�ֽ���, ��Сֵ��߶��������  40123 34012 23401
        if(arr == null || arr.length == 0)
            return -1;
        int l = 0, r = arr.length-1;
        while(l <= r){
            if( r - l <= 1)		//40  01
                return arr[r] < arr[l] ? arr[r] : arr[l];
            int m = l + (r - l)/2;
            
            if(arr[m] < arr[l])   //40123
                r = m;
            else if(arr[m] > arr[r])  //23401
                l = m;
            else                //123 
                r = m;
        }
        return -1;
    }
}
