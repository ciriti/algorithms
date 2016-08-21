package it.car.tree;

/**
 * Created by ciriti on 21/08/16.
 */

public class Trie {

    public static final int ALPHABET_SIZE = 'z' - 'a' + 1;

    Node root = null;

    public static int charToIndex(char c){
        return 'z' - c;
    }

    public static class Node{
        Node[] children = new Node[ALPHABET_SIZE];

//        public Node(char val) {
//            this.val = val;
//        }
    }

    public Trie() {
        this.root = new Node();
    }

    public Node getRoot(){
        return  root;
    }

    public void insert(String s){
        for(int i = 0; i < s.length(); i ++){
            recursiveInsert(root, s.substring(i));
        }

    }

    void recursiveInsert(Node n, String s){
        if(s.length() == 0){
            return;
        }

        char c = s.charAt(0);

        if( null == n.children[charToIndex(c)]){
            n.children[charToIndex(c)] = new Node();
        }

        String toSend = "";
        if(s.length() > 1){
            toSend = s.substring(1);
        }

        recursiveInsert(n.children[charToIndex(c)], toSend);
    }

    public boolean search(String s){
        return search(root, s);
    }

    public boolean search(Node n, String s){

        boolean res = true;

        if(s.length() == 0){
            return true;
        }
        char tmp = s.charAt(0);
        if(n.children[charToIndex(tmp)] == null){
            return false;
        }

        String toSend = "";
        if(s.length() > 1){
            toSend = s.substring(1);
        }

        return res && search(n.children[charToIndex(tmp)], toSend);
    }

    public static void main(String[] arg){
        Trie trie = new Trie();
        trie.insert("ciao");
        // tutti true
        System.out.println(trie.search("ao") == true);
        System.out.println(trie.search("ciao") == true);
        System.out.println(trie.search("iao") == true);
        System.out.println(trie.search("a") == true);
        System.out.println(trie.search("o") == true);
        System.out.println(trie.search("c") == true);
        System.out.println(trie.search("i") == true);

        // tutti false
        System.out.println(trie.search("e") == false);
        System.out.println(trie.search("cie") == false);
        System.out.println(trie.search("ciaoo") == false);
    }

}
