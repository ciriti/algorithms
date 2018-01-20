package it.car.tree.august2016;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by carmeloiriti, 31/08/16.
 */
public class LevelOrderTreeTraversal {

    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = null;
            right = null;
        }
    }

    Node root;

    /* Given a binary tree. Print its nodes in level order
     using array for implementing queue  */
    void printLevelOrder()
    {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {

            /* poll() removes the present head.
            For more information on poll() visit
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
    String serializeTree(Node root){
        Node nullNode = new Node(-1);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<String> serilizedList = new ArrayList<>();
        while (!queue.isEmpty())
        {

            Node tempNode = queue.poll();
            serilizedList.add(tempNode.data == -1? "null":String.valueOf(tempNode.data));
            if(tempNode.data == -1) continue;

            /** Enqueue left child */
            if (tempNode.left != null) {
                    queue.add(tempNode.left);
            } else{
                    queue.add(nullNode);
            }

            /** Enqueue right child */
            if (tempNode.right != null) {
                    queue.add(tempNode.right);
            }else{
                queue.add(nullNode);
            }

        }
        return serilizedList.toString().replaceAll(",(\\s*null\\s*,*\\s*)+\\]$","]");
    }

    public static void main(String args[])
    {
        /* creating a binary tree and entering
         the nodes */
        LevelOrderTreeTraversal tree_level = new LevelOrderTreeTraversal();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
//        tree_level.root.left.left = new Node(4);
        tree_level.root.right.right = new Node(5);
        tree_level.root.right.left = new Node(4);

        System.out.println("Level order traversal of binary tree is - \n");
//        tree_level.printLevelOrder();
        System.out.println(tree_level.serializeTree(tree_level.root));
    }
}
