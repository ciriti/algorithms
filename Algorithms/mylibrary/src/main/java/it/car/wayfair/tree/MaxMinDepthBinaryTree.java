package it.car.wayfair.tree;

import java.util.LinkedList;
import java.util.Queue;

import static android.R.attr.minDate;
import static android.R.attr.right;

/**
 * Created by ciriti on 25/09/16.
 */

public class MaxMinDepthBinaryTree {

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

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static TreeNode deserialize(String data) {

        String[] arr = data.replaceAll("(\\[|\\])", "").split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> quque = new LinkedList<>();
        quque.add(root);
        for (int i = 1; i < arr.length; i++){
            TreeNode tmp = quque.poll();
            if(!arr[i].equals("null")){
                tmp.left = new TreeNode(Integer.parseInt(arr[i]));
                quque.add(tmp.left);
            }
            if(!arr[++i].equals("null")){
                tmp.right = new TreeNode(Integer.parseInt(arr[i]));
                quque.add(tmp.right);
            }

        }

        return root;

    }



    public static int minDeepCount(TreeNode n){

        if(n == null){
            return 0;
        }
        if(n.left == null || n.right == null){
            return 1;
        }

        int deepLeft = minDeepCount(n.left) + 1;
        int deepRight = minDeepCount(n.left) + 1;

        return Math.min(deepLeft, deepRight);
    }

    public static int maxDeep(TreeNode n){
        int res = maxDeepCount(n);
        return res;
    }

    public static int maxDeepCount(TreeNode n){
        if(n == null){
            return 0;
        }
        int leftDeep = maxDeepCount(n.left) + 1;
        int rightDeep = maxDeepCount(n.right) + 1;

        return Math.max(leftDeep, rightDeep);
    }

    public static void main(String args[]){
        TreeNode rootSymm = deserialize("[1,2,2,3,4,4,3]");
        TreeNode rootNotSymm = deserialize("[1,2,2,null,3,null,3]");
        System.out.println(maxDeep(rootSymm) == 3?"SUCCES":"ERROR");
        System.out.println(maxDeep(rootNotSymm) == 3?"SUCCES":"ERROR");
        System.out.println(minDeepCount(rootSymm) == 3?"SUCCES":"ERROR");
        System.out.println(minDeepCount(rootNotSymm) == 2?"SUCCES":"ERROR");
        System.out.println(minDeepCount(new TreeNode(2)) == 1?"SUCCES":"ERROR");

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        System.out.println(minDeepCount(root) == 2?"SUCCES":"ERROR");
    }


}
