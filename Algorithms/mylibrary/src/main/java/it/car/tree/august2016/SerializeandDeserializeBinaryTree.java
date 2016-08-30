package it.car.tree.august2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import it.car.dynamic.Lis;

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

        Integer[] serialize = new Integer[1000];

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        serialize[0] = root.val;

        int i = 1;
        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            if(tmp.left != null){
                queue.add(tmp.left);
                serialize[i*2] =  tmp.left.val;
            }else{
                serialize[i*2] = null;
            }

            if(tmp.right != null) {
                queue.add(tmp.right);
                serialize[i*2 +1] = tmp.right.val;
            }else{
                serialize[i*2 +1] =  null;
            }

            i++;
        }
        int index = 0;
        for( int x = 1000; x > 0; x--){
            if(serialize[x-1] != null){
                index = x;
                break;

            }
        }

        return Arrays.asList(serialize).subList(0, index).toString();
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
