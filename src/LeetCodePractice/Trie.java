package LeetCodePractice;

import java.util.Arrays;

class Trie {

    Node root;
    public Trie() {
        root= new Node('\0');
    }

    public void insert(String word) {
        Node cur=root;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(cur.children[index]==null) cur.children[index]= new Node(c);
            cur=cur.children[index];
        }
        cur.isWord=true;

    }

    public boolean search(String word) {
        Node cur=root;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(cur.children[index]==null) return false;
            cur=cur.children[index];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        Node cur=root;
        for(char c:prefix.toCharArray()){
            int index=c-'a';
            if(cur.children[index]==null) return false;
            cur=cur.children[index];
        }
        return true;
    }

    class Node{
        public char c;
        public boolean isWord;
        public Node[] children;

        Node(char c){
            this.c=c;
            this.isWord=false;
            this.children= new Node[26];
        }
    }
}

    class TrieRunner{
        public static void main(String[] args) {
            Trie tr=new Trie();
            tr.insert("app");
            tr.insert("apple");
            tr.insert("beer");
            tr.insert("add");
            tr.insert("jam");
            tr.insert("rentals");
            System.out.println(tr.search("apps"));

        }
    }

