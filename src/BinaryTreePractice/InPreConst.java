package BinaryTreePractice;

import java.util.HashMap;

public class InPreConst {
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int index = 0;

    //core logic to build the tree.
    public static LNode BuildTree(int in[], int pre[], int start, int end) {

        //if in case starting index is greater then ending index.
        if (start > end) return null;

        //reading pre array's values index by index 0,1,2,3...n and storing it in a new node.
        int val = pre[index++];
        LNode curr = new LNode(val);

        //If in case start == end current node has no child.
        if (start == end) return curr;

        //taking index of pre array value from in array. Because there left value will be its
        //left branch and right values will become its right branch.
        int inIndex = map.get(curr.data);

        //left childs range begun from start to inIndex-1.
        //right childs range begun from inIndex+1 to end.
        curr.left = BuildTree(in, pre, start, inIndex - 1);
        curr.right = BuildTree(in, pre, inIndex + 1, end);

        return curr;
    }

    public static LNode BuildTreePost(int in[], int post[], int start, int end) {
        if (start > end) return null;

        int val = post[index--];
        LNode curr = new LNode(val);
        if (start == end) return curr;

        int inIndex = map.get(val);

        //unlike in & pre construction here we need to start building right side first then left.
        //because in post order we are reading it from last and if last value is assigned with
        //first values child, array index will go out of bound.
        curr.right = BuildTreePost(in, post, inIndex + 1, end);
        curr.left = BuildTreePost(in, post, start, inIndex - 1);

        return curr;
    }

    //This method is used to store inorder index into map to access when required.
    public static LNode store(int in[], int pre[], int len, boolean chk) {

        for (int i = 0; i < len; i++) {
            map.put(in[i], i);
        }
        if (chk)
            return BuildTree(in, pre, 0, len - 1);
        else
            return BuildTreePost(in, pre, 0, len - 1);
    }

    public static void check(LNode root) {
        if (root == null) return;

        check(root.left);
        System.out.print(root.data + ", ");
        check(root.right);
    }

    public static void main(String[] args) {
        //This is the example for recreating a tree using inorder and preorder of a given tree.
        int in[] = {8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15};
        int pre[] = {1, 2, 4, 8, 9, 5, 10, 11, 3, 6, 12, 13, 7, 14, 15};
        int post[] = {8, 9, 4, 10, 11, 5, 2, 12, 13, 6, 14, 15, 7, 3, 1};
        LNode root = InPreConst.store(in, pre, in.length, true);
        System.out.println("correct In Order");
        for (int i : in) {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println("In order of tree created from in and pre order: ");
        InPreConst.check(root);

        map.clear();
        InPreConst.index = post.length - 1;
        root = InPreConst.store(in, post, in.length, false);
        System.out.println();
        System.out.println("In order of tree created from in and post order: ");
        InPreConst.check(root);
    }
}

class LNode {
    int data;
    LNode left;
    LNode right;

    public LNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
