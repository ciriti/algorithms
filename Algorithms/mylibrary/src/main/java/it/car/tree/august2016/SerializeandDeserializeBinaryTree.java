package it.car.tree.august2016;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by carmeloiriti, 30/08/16.
 */
public class SerializeandDeserializeBinaryTree {


    /**
     * Serialize and Deserialize Binary Tree
     *
     * LINK - https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
     */


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        List<Integer> serialize = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode nullNode = new TreeNode(Integer.MAX_VALUE);

        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            serialize.add(tmp.val == Integer.MAX_VALUE? null:tmp.val);
            if(tmp.left != null && tmp.left.val != Integer.MAX_VALUE){
                queue.add(tmp.left == null ? nullNode:tmp.left);
            }
            if(tmp.right != null && tmp.right.val != Integer.MAX_VALUE) {
                queue.add(tmp.right == null ? nullNode : tmp.right);
            }
        }

        return serialize.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        TreeNode due = new TreeNode(2);
        TreeNode tre = new TreeNode(3);
        TreeNode quatt = new TreeNode(4);
        TreeNode cinque = new TreeNode(5);

        root.left = due;
        root.right = tre;
        tre.left = quatt;
        tre.right = cinque;

        SerializeandDeserializeBinaryTree tree = new SerializeandDeserializeBinaryTree();
        System.out.println(tree.serialize(root));
    }


}
