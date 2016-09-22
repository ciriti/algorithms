package it.car.tree.august2016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import it.car.dynamic.Lis;
import it.car.graph.util.In;

/**
 * Created by carmeloiriti, 30/08/16.
 */
public class BinaryTreeLevelOrderTraversal {


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

        @Override
        public String toString() {
            return String.valueOf(val);
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


    /**
     * Deep first search
     * @param root
     * @return
     */
    public List<TreeNode> DFS(TreeNode root){

        List<TreeNode> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){

            TreeNode node = stack.pop();

            if(!res.contains(node))
                res.add(node);

            if(node.right != null){
                stack.add(node.right);
            }
            if(node.left != null){
                stack.add(node.left);
            }

        }
        return res;
    }

    /**
     * Breath first search
     * @param root
     * @return
     */
    public List<TreeNode> BFS(TreeNode root){

        List<TreeNode> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){

            TreeNode node = queue.poll();
            res.add(node);

            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
        return res;
    }

    /**
     * Given a binary tree, return the level order traversal of its nodes' values. (ie,
     * from left to right, level by level). Given binary tree [3,9,20,null,null,15,7],
     * return its level order traversal as:
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderSlow(TreeNode root) {

        if(root == null) return new ArrayList();

        Queue<TreeNodeLev> queue = new LinkedList<>();

        List<TreeNodeLev> bfsTreeNodeLev = new ArrayList<>();

        queue.add(new TreeNodeLev(null, root, 0));
        while(!queue.isEmpty()){
            TreeNodeLev node = queue.poll();
            bfsTreeNodeLev.add(node);
            if(node.curr.left != null)
                queue.add(new TreeNodeLev(node.curr, node.curr.left, node.level+1));
            if(node.curr.right != null)
                queue.add(new TreeNodeLev(node.curr, node.curr.right, node.level+1));

        }

        int lastIndex = bfsTreeNodeLev.get(bfsTreeNodeLev.size()-1).level;
        List<List<Integer>> res = new ArrayList<>(lastIndex+1);
        for(int i = 0; i < lastIndex+1; i++){
            res.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < bfsTreeNodeLev.size(); i++){

            TreeNodeLev tmp = bfsTreeNodeLev.get(i);
            res.get(tmp.level).add(tmp.curr.val);


        }

        return res;
    }

    class TreeNodeLev{

        TreeNode parent;
        TreeNode curr;
        int level;

        public TreeNodeLev(TreeNode parent, TreeNode curr, int level) {
            this.parent = parent;
            this.curr = curr;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrderStillSlow(TreeNode root) {
        if(root == null) return new ArrayList();

        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> children = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        res.get(0).add(root.val);
        if(root.left != null)
            children.add(root.left);
        if(root.right != null)
            children.add(root.right);
        levelOrder(res, children);
        return res;
    }

    public void levelOrder(List<List<Integer>> res, List<TreeNode> children) {

        if(children.size() == 0) return;

        res.add(new ArrayList<Integer>());
        List<TreeNode> childrenTmp = new ArrayList<>();
        for(TreeNode child : children){
            res.get(res.size()-1).add(child.val);
            if(child.left != null)
                childrenTmp.add(child.left);
            if(child.right != null)
                childrenTmp.add(child.right);
        }

        levelOrder(res, childrenTmp);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        Map<Integer, List<Integer>> resMap = new HashMap<>();

        goDeep(root, resMap, 0);

        List<Integer> keys = new ArrayList<>(resMap.keySet());
        Collections.sort(keys);

        List<List<Integer>> res = new ArrayList<>();

        for(Integer i : keys){
            res.add(resMap.get(i));
        }

        return res;
    }

    void goDeep(TreeNode node,  Map<Integer, List<Integer>> resMap, int level){

        if(node == null) return;

        if(!resMap.containsKey(level))
            resMap.put(level, new ArrayList<Integer>());

        resMap.get(level).add(node.val);

        goDeep(node.left, resMap, level+1);
        goDeep(node.right, resMap, level+1);

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


        BinaryTreeLevelOrderTraversal tree = new BinaryTreeLevelOrderTraversal();

        String s = tree.serialize(root);
        System.out.println("  Serialize: " + s);
        root = tree.deserialize(s);
        System.out.println("DFS: " + tree.DFS(root));
        System.out.println("BFS: " + tree.BFS(root));
        System.out.println("levelOrder: " + tree.levelOrder(root));
    }



}
