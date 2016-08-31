package it.car.tree.august2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.R.id.list;

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
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
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

        if(root == null){
            return  "[]";
        }

        Integer[] serialize = new Integer[1000];

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        serialize[0] = root.val;

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp.left != null) {
                queue.add(tmp.left);
                serialize[(i * 2)-1] = tmp.left.val;
            } else {
                serialize[(i * 2)-1] = null;
            }

            if (tmp.right != null) {
                queue.add(tmp.right);
                serialize[(i * 2 + 1)-1] = tmp.right.val;
            } else {
                serialize[(i * 2 + 1)-1] = null;
            }

            i++;
        }
        int index = 0;
        for (int x = 1000; x > 0; x--) {
            if (serialize[x - 1] != null) {
                index = x;
                break;

            }
        }

        return Arrays.asList(serialize).subList(0, index).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] strinArr = data.replaceAll("(\\[|\\]|\\s)", "").split(",");

        if(strinArr[0].length() < 1) return null;

        List<String> list = new ArrayList<>(strinArr.length+1);
        list.add("");
        list.addAll(Arrays.asList(strinArr));
        TreeNode root = new TreeNode(Integer.parseInt(list.get(1)));
        deserialize(list, root, 2);
        return root;
    }

    public void deserialize(List<String> data, TreeNode node, int index){
        if((index) < data.size() && !data.get(index).equals("null")){
            node.left = new TreeNode(Integer.parseInt(data.get(index)));
            deserialize(data, node.left, 2*index);
        }

        if((index+1) < data.size() && !data.get(index+1).equals("null")){
            node.right = new TreeNode(Integer.parseInt(data.get(index+1)));
            deserialize(data, node.right, 2*(index+1));
        }

    }

    public static void main(String args[]){

        TreeNode root = new TreeNode(1);
        TreeNode due = new TreeNode(2);
        TreeNode tre = new TreeNode(3);
        TreeNode quatt = new TreeNode(4);
        TreeNode cinque = new TreeNode(5);
        TreeNode sei = new TreeNode(6);
        TreeNode sette = new TreeNode(7);

        root.left = due;
        root.right = tre;
        tre.left = quatt;
        tre.right = cinque;

        SerializeandDeserializeBinaryTree tree = new SerializeandDeserializeBinaryTree();

        String s = tree.serialize(root);
        System.out.println(s);
        root = tree.deserialize(s);
        System.out.println("check: " + tree.serialize(root));
    }


}
