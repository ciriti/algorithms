package it.car.tree.august2016;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ResourceBundle;
import java.util.Stack;

/**
 * Created by carmeloiriti, 30/08/16.
 */
public class TreeVisit {


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
     * Preorder linear
     * @param root
     * @return
     */
    public List<Integer> preorderLinear(TreeNode root){

        List<TreeNode> nodesRes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()){

            TreeNode node = stack.peek();

            /** verify that node is not yet inserted */
            if(!nodesRes.contains(node))
                nodesRes.add(node);

            if(node.left != null && !nodesRes.contains(node.left)){
                stack.add(node.left);
            }else {
                stack.pop();
                if(node.right != null){
                    stack.add(node.right);
                }

            }
        }

        List<Integer> res = new ArrayList<>();
        for(TreeNode node : nodesRes){
            res.add(node.val);
        }

        return res;
    }

    /**
     * Preorder recursive
     * @param root
     * @return
     */
    public List<Integer> preorderRecursive(TreeNode root){
        List<Integer> result = new ArrayList<>();
        preorderRecursiveHelper(root, result);
        return result;
    }

    void preorderRecursiveHelper(TreeNode node, List<Integer> res){
        if(node == null) return;
        res.add(node.val);
        preorderRecursiveHelper(node.left, res);
        preorderRecursiveHelper(node.right, res);
    }



    /**
     * Inorder visit NON recursive
     * @param root
     * @return
     */
    public List<Integer> inorderLinear(TreeNode root){
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode node;
        while(!stack.isEmpty()){
            node  = stack.peek();
            if(node.left != null && !result.contains(node.left.val)){
                stack.add(node.left);
            }else{
                result.add(node.val);
                stack.pop();
                if(node.right != null){
                    stack.add(node.right);
                }
            }
        }

        return result;
    }

    /**
     * Inorder visit recursive
     * @param root
     * @return
     */
    public List<Integer> inorderRecursive(TreeNode root){
        List<Integer> result = new ArrayList<>();
        inorderRecursiveSupport(root, result);
        return result;
    }

    private void inorderRecursiveSupport(TreeNode node, List<Integer> res) {
        if(node == null) return;
        inorderRecursiveSupport(node.left, res);
        res.add(node.val);
        inorderRecursiveSupport(node.right, res);
    }

    /**
     * Postorder visit recursive
     * @param root
     * @return
     */
    public List<TreeNode> postorderLinear(TreeNode root){
        List<TreeNode> nodesRes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node.left == null && node.right == null || (nodesRes.contains(node.right) && nodesRes.contains(node.left))){
                stack.pop();
                nodesRes.add(node);
            }else{
                if(node.right != null && !nodesRes.contains(node.right)){
                    stack.add(node.right);
                }
                if(node.left != null && !nodesRes.contains(node.left)){
                    stack.add(node.left);
                }
            }

        }
        return nodesRes;
    }

    /**
     * @param root
     * @return
     */
    public List<Integer> postorderRecursive(TreeNode root){
        List<Integer> result = new ArrayList<>();
        postorderRecursiveHelper(root, result);
        return result;
    }

    void postorderRecursiveHelper(TreeNode node, List<Integer> res){
        if(node == null) return;
        postorderRecursiveHelper(node.left, res);
        postorderRecursiveHelper(node.right, res);
        res.add(node.val);
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


        TreeVisit tree = new TreeVisit();

        String s = tree.serialize(root);
        System.out.println("  Serialize: " + s);
        root = tree.deserialize(s);
        System.out.println("Deserialize: " + tree.serialize(root));
        System.out.println("-------------------------------------");
        System.out.println("------------- Inorder ---------------");
        System.out.println("inorder leetcode : " + tree.inorderTraversalLeetCode(root));
        System.out.println("inorder linear   : " + tree.inorderLinear(root));
        System.out.println("inorder recursive: " + tree.inorderRecursive(root));
        System.out.println("inorder train    : " + tree.trainInorder(root));
        System.out.println("--------------------------------------");
        System.out.println("------------- Preorder ---------------");
        System.out.println("preorder leetcode : " + tree.preorderTraversalLeetCode(root));
        System.out.println("preorder linear   : " + tree.preorderLinear(root));
        System.out.println("preorder recursive: " + tree.preorderRecursive(root));
        System.out.println("preorder train    : " + tree.trainPreorder(root));
        System.out.println("--------------------------------------");
        System.out.println("------------- Postorder ---------------");
        System.out.println("postorder linear   : " + tree.postorderLinear(root));
        System.out.println("postorder recursive: " + tree.postorderRecursive(root));
        System.out.println("postorder leetcode : " + tree.postorderTraversalLeetCode(root));


//        System.out.println("check: " + tree.serialize(root));
//        System.out.println("check1: " + tree.serialize(root));
//        TreeNode n = tree.deserialize("[-1,0,1]");
        System.out.println();
    }

    /**
     * Inorder from leet code
     */

    public List<Integer> inorderTraversalLeetCode(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root !=null){
            helper(root, result);
        }

        return result;
    }

    public void helper(TreeNode p, List<Integer>  result){
        if(p.left!=null)
            helper(p.left, result);

        result.add(p.val);

        if(p.right!=null)
            helper(p.right, result);
    }

    /**
     * In order leetcode solution
     */
    public ArrayList<Integer> preorderTraversalLeetCode(TreeNode root) {
        ArrayList<Integer> returnList = new ArrayList<>();

        if(root == null)
            return returnList;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()){
            TreeNode n = stack.pop();
            returnList.add(n.val);

            if(n.right != null){
                stack.push(n.right);
            }
            if(n.left != null){
                stack.push(n.left);
            }

        }
        return returnList;
    }

    /**
     * Postorder leetcode solution
     */

    public List<Integer> postorderTraversalLeetCode(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root==null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if(temp.left==null && temp.right==null) {
                TreeNode pop = stack.pop();
                res.add(pop.val);
            }
            else {
                if(temp.right!=null) {
                    stack.push(temp.right);
                    temp.right = null;
                }

                if(temp.left!=null) {
                    stack.push(temp.left);
                    temp.left = null;
                }
            }
        }

        return res;
    }

    /**
     * Training Inorder
     */

    public List<TreeNode> trainInorder(TreeNode root){
        List<TreeNode> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node.left != null && !res.contains(node.left)){
                stack.add(node.left);
            }else{
                res.add(node);
                stack.pop();
                if(node.right != null && !res.contains(node.right)){
                    stack.add(node.right);
                }

            }
        }
        return res;
    }

    public List<TreeNode> trainPreorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> res = new ArrayList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode treeNode = stack.peek();
            res.add(treeNode);

        }
        return res;
    }

}
