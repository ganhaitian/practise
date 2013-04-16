package com.ganht.practise.algorithm;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: ganhaitian
 * Date: 13-4-16
 * Time: 下午4:07
 * To change this template use File | Settings | File Templates.
 */
public class SortPractise {

    /**
     *QKSORT
     */
    public void quickSort(int[] input){
        if(input!=null&&input.length>0)
             quickSort(input, 0, input.length - 1);
    }

    private void quickSort(int[] input, int l, int h){
        if(l>h)
            return;
        int middle= getMiddle(input, l, h);
        quickSort(input, l, middle - 1);
        quickSort(input, middle + 1, h);
    }

    private int getMiddle(int[] input, int l, int h) {
        int tmpValue=input[l];
        while(l<h){
            while(input[h]>=tmpValue&&h>l)
                h--;
            input[l]=input[h];
            while(input[l]<=tmpValue&&h>l)
                l++;
            input[h]=input[l];
        }
        input[h]=tmpValue;
        return h;  //To change body of created methods use File | Settings | File Templates.
    }

    public static void main(String[] args){
        int[] input={2,4,5,8,1,3};
        //2 4 5 8 1 3
        //1 4 5 8 1 3
        //1 4 5 8 4 3
        new SortPractise().quickSort(input);
        System.out.println(Arrays.toString(input));
    }
}
