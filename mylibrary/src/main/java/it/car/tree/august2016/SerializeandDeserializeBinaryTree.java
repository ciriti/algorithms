package it.car.tree.august2016;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                sb.append(node.val+",");
                queue.add(node.left);
                queue.add(node.right);
            }else
                sb.append("n,");
        }

        return sb.toString();
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

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



    public static void main(String args[]){

        TreeNode root = new TreeNode(1);
        TreeNode due = new TreeNode(2);
        TreeNode tre = new TreeNode(3);
        TreeNode quatt = new TreeNode(4);
        TreeNode cinque = new TreeNode(5);
        TreeNode sei = new TreeNode(6);
        TreeNode sette = new TreeNode(7);
        TreeNode m_uno = new TreeNode(-1);
        TreeNode nove = new TreeNode(9);

        root.left = due;
        root.right = tre;
        tre.left = quatt;
        tre.right = cinque;
        due.left = sette;
        due.right = nove;


        SerializeandDeserializeBinaryTree tree = new SerializeandDeserializeBinaryTree();

        String s = tree.serialize(root);
        System.out.println("  Serialize: " + s);
        root = tree.deserialize(s);
        System.out.println("Deserialize: " + tree.serialize(root));
//        System.out.println("check: " + tree.serialize(root));
//        System.out.println("check1: " + tree.serialize(root));
//        TreeNode n = tree.deserialize("[-1,0,1]");
        System.out.println();
    }



}
