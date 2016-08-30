package it.car.tree.august2016;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carmeloiriti, 30/08/16.
 */
public class BinaryTreePaths {

    /**
     * Binary Tree Paths
     *
     * Given a binary tree, return all root-to-leaf paths.
     *
     * LINK - https://leetcode.com/problems/binary-tree-paths/
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        recursiveSearch(root, res, "");
        return res;
    }


    public void recursiveSearch(TreeNode node, List<String> resList, String tmp){
        if(node != null){
            String sb = tmp + (tmp.length() > 0? "->":"") + String.valueOf(node.val) ;
            if(node.left ==  null && node.right == null){
                resList.add(sb);
            }
            recursiveSearch(node.left, resList, sb);
            recursiveSearch(node.right, resList, sb);

        }
    }

    /**
     * main
     * @param args
     */
    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        TreeNode due = new TreeNode(2);
        TreeNode tre = new TreeNode(3);
        TreeNode cinque = new TreeNode(5);

        root.left = due;
        root.right = tre;

        due.right = cinque;

        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        /**
         * rusult: [1->2->5, 1->3]
         */
        System.out.println(binaryTreePaths.binaryTreePaths(root));


    }


}
