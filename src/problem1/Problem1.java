package problem1;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {

    public static List<Integer> resolve1(List<Integer> intArray) {
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
