//This problem was asked by Uber.

//Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers
// in the original array except the one at i.

//For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1],
// the expected output would be [2, 3, 6].

//if [1,2,0,5] then [0,0,10,0]

//Follow-up: what if you can't use division?

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> resultArray = problem1(Arrays.asList(1, 2, 3, 4, 5));
//        List<Integer> resultArray = problem1(Arrays.asList(3, 2, 1));
//        List<Integer> resultArray = problem1(Arrays.asList(1, 2, 0, 5));
//        for (Integer integer : resultArray) {
//            System.out.println(integer);
//        }
    }

    private static List<Integer> problem1(List<Integer> intArray) {
        int multiplyAll = 1;
        boolean hasZero = Boolean.FALSE;
        for (Integer integer : intArray) {
            if (integer != 0) {
                multiplyAll *= integer;
            } else {
                hasZero = Boolean.TRUE;
            }
        }
        List<Integer> resultArray = new ArrayList<>();
        for (Integer integer : intArray) {
            if (hasZero) {
                if (integer == 0) {
                    resultArray.add(multiplyAll);
                } else {
                    resultArray.add(0);
                }
            } else {
                resultArray.add(multiplyAll / integer);
            }
        }
        return resultArray;
    }
}
