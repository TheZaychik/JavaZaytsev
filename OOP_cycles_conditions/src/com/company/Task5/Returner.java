package com.company.Task5;

public class Returner {
    int[] valuesArr;
    int[] scalesArr;
    int[] rangesArr;
    int sum = 0;

    public Returner(int[] values, int[] scales) {
        valuesArr = values;
        scalesArr = scales;
        rangesArr = new int[valuesArr.length];
        
        sum = 0;

        for (int i = 0; i < scalesArr.length; i++)
            sum += scalesArr[i];

        int s = 0;
        for (int i = 0; i < rangesArr.length; i++) {
            rangesArr[i] = s;
            s += scalesArr[i];
        }
    }


    public int getNumber() {
        int random = (int) (Math.random() * (sum - 1));

        int index = 0;
        for (int i = 0; i < rangesArr.length; i++) {
            if (rangesArr[i] > random)
                break;
            index = i;
        }

        return valuesArr[index];
    }
}