import java.util.*;
public class BinaryTree{
    BinaryTree(){

    }
    Node root;
    public static class Node{
        Node left,right=null;
        int val=0;
        Node(int val){
         this.val=val;
         this.left=left;
         this.right=right;
        }
    }
        public void populate(Scanner sc){
            System.out.println("Enter the root node");
            int val=sc.nextInt();
            root=new Node(val);
            populate(sc,root);
        }
        private void populate(Scanner sc,Node node){
            System.out.println("Do you want to enter the left of "+ node.val+"\t");
            boolean left=sc.nextBoolean();
            if(left){
                System.out.println("Enter the value to left of "+node.val);
                int val=sc.nextInt();
                node.left=new Node(val);
                populate(sc, node.left);
            }
            System.out.println("Do you want to enter the right of "+ node.val+"\t");
            boolean right=sc.nextBoolean();
            if(right){
                System.out.println("Enter the value to right of "+node.val);
                int val=sc.nextInt();
                node.right=new Node(val);
                populate(sc, node.right);
            }
            
        }
        public void display(){
            display(root," ");
        }
        private void display(Node node,String space){
            if(node==null) return;
            System.out.print(node.val + space+  " \t");
            display(node.left,space);
            display(node.right,space);
        }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BinaryTree bt=new BinaryTree();
        bt.populate(sc);
        bt.display();
    }
}