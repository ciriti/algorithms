package it.car.wayfair.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ciriti on 25/09/16.
 */

public class BinaryTreeOrderLevelTraversal {

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
            if(!arr[i].equals("n")){
                tmp.left = new TreeNode(Integer.parseInt(arr[i]));
                quque.add(tmp.left);
            }
            if(!arr[++i].equals("n")){
                tmp.right = new TreeNode(Integer.parseInt(arr[i]));
                quque.add(tmp.right);
            }

        }

        return root;

    }

    public static List<List<TreeNode>> printLevel(TreeNode root){
        List<List<TreeNode>> res = new ArrayList<>();
        List<TreeNode> list = new ArrayList();
        list.add(root);
        rec(res, list);
        return res;
    }

    public static void rec(List<List<TreeNode>> pRes, List<TreeNode> nodeList){
        if(nodeList.size() == 0)
            return;
        pRes.add(nodeList);
        List<TreeNode> children = new ArrayList();
        for(TreeNode n: nodeList){
            if(n.left != null)
                children.add(n.left);
            if(n.right!= null)
                children.add(n.right);
        }
        rec(pRes, children);
    }

    public static void main(String args[]){
        String s = "[3,9,20,n,n,15,7]";
        TreeNode root = deserialize(s);
        List<List<TreeNode>> res = printLevel(root);
        Collections.reverse(res);
        System.out.println(res);
    }
}
