package problem2;

import javax.swing.tree.TreeCellRenderer;
import java.lang.reflect.Array;
import java.util.*;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example:

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
 */
/**
 * Definition for a binary tree node.
 * public class problem2.TreeNode {
 *     int val;
 *     problem2.TreeNode left;
 *     problem2.TreeNode right;
 *     problem2.TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list.toString();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        list.add(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                list.add(node.left.val);
                queue.add(node.left);
            } else {
                list.add(null);
            }
            if (node.right != null) {
                list.add(node.right.val);
                queue.add(node.right);
            } else {
                list.add(null);
            }
        }
        System.out.println(list.toString());
        return list.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] input = data.substring(1, data.length() - 1).split(", ");
        if (input[0].isEmpty()) {
            return null;
        }
        TreeNode root = getNode(0, input);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (++i < input.length) {
                node.left = getNode(i, input);
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
            if (++i < input.length) {
                node.right = getNode(i, input);
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    private TreeNode getNode(int i, String[] input) {
        if (input[i].equals("null")) {
            return null;
        }
        return new TreeNode(Integer.parseInt(input[i]));
    }
}

// Your problem2.Codec object will be instantiated and called as such:
// problem2.Codec codec = new problem2.Codec();
// codec.deserialize(codec.serialize(root));
