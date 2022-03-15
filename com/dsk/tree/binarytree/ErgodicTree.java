package com.dsk.tree.binarytree;

/**
 * 遍历二叉树
 */
public class ErgodicTree {

    public static void main(String[] args) {
        Node root = new Node(1, "root");
        Node left = new Node(2, "left");
        Node right = new Node(3, "right");
        // 手动创建
        root.setLeft(left);
        root.setRight(right);
        // 前序遍历
        preErgodicTree(root);
    }

    public static void preErgodicTree(Node node){
        // 输出当前节点
        System.out.println(node);
        // 递归向左子树前序遍历
        if (node.getLeft()!=null){
            preErgodicTree(node.getLeft());
        }
        // 递归向右字树前序遍历
        if (node.getRight()!=null){
            preErgodicTree(node.getRight());
        }
    }

}
