package com.example.modularcalculator;

import java.util.ArrayList;
import java.util.Arrays;

public class BinaryGenrator {

    public int[] getBinaryValue(int value){
        ArrayList<Integer> arrList = new ArrayList<>();

        while (value>0){
            if((value %2)== 0)
                arrList.add(0, 0);
            else
                arrList.add(0,1);
            value = Math.round(value/2);
        }

        System.out.println("arr: " + Arrays.toString(changeArrTypeObjectToInt(arrList.toArray())));
        return changeArrTypeObjectToInt(arrList.toArray());
    }

    public int[] changeArrTypeObjectToInt(Object[] arr){

        int[] intArr = new int[arr.length];

        int counter = 0;
        for(Object o : arr){
            intArr[counter] = (int) o;
            counter++;
        }

        System.out.print(intArr.length+ arr.length+intArr[0]);
        return intArr;
    }

}