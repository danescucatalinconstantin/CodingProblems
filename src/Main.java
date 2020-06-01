//This problem was asked by Uber.

//Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers
// in the original array except the one at i.

//For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1],
// the expected output would be [2, 3, 6].

//if [1,2,0,5] then [0,0,10,0]

//Follow-up: what if you can't use division?

import problem1.Problem1;
import problem2.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // problem1
//        List<Integer> resultArray = Problem1.resolve1(Arrays.asList(1, 2, 3, 4, 5));
//        List<Integer> resultArray = Problem1.resolve1(Arrays.asList(3, 2, 1));
//        List<Integer> resultArray = Problem1.resolve1(Arrays.asList(1, 2, 0, 5));
//        for (Integer integer : resultArray) {
//            System.out.println(integer);
//        }

        // problem2
        problem2.Codec codec = new problem2.Codec();
        TreeNode root = new TreeNode(1);
        TreeNode rootRight = new TreeNode(3);
        root.setLeft(new TreeNode(2));
        root.setRight(rootRight);
        rootRight.setLeft(new TreeNode(4));
        rootRight.setRight(new TreeNode(5));
        String serialized = codec.serialize(root);
        TreeNode result = codec.deserialize(serialized);

    }
}
