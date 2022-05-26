package com.company;

public class Main {

    public static void main(String[] args) {
        //LL型
        llCase();
        //LR
        lrCase();
        //RL
        rlCase();
        //RR
        rrCase();
    }

    public static void llCase() {
        AVLTree avlTree = new AVLTree();
        avlTree.put(3);
        avlTree.put(4);
        avlTree.put(2);
        avlTree.put(1);
        //      (3)
        //    (2) (4)
        //   (1)
        //移除4的時候會重新平衡
        System.out.println( avlTree.remove(4));
        //       (2)
        //    (1)   (3)
    }


    public static void lrCase() {
        AVLTree avlTree = new AVLTree();
        avlTree.put(5);
        avlTree.put(3);
        //      (5)
        //    (3)
        //插入4的時候會重新平衡
        avlTree.put(4);
        //      (4)
        //    (3) (5)
        System.out.println(avlTree.get(4));
    }

    public static void rlCase() {
        AVLTree avlTree = new AVLTree();
        avlTree.put(5);
        avlTree.put(4);
        avlTree.put(7);
        avlTree.put(6);
        //      (5)
        //   (4)   (7)
        //       (6)
        //移除4的時候會重新平衡
        System.out.println(avlTree.remove(4));
        //      (6)
        //    (5) (7)
    }

    public static void rrCase() {
        AVLTree avlTree = new AVLTree();
        avlTree.put(5);
        avlTree.put(6);
        //      (5)
        //         (6)
        //插入7的時候會重新平衡
        avlTree.put(7);
        //      (6)
        //    (5) (7);
        System.out.println(avlTree.get(7));
    }
}
