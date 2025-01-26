
import java.util.Scanner;

public class BSear {
    Node root;
   public static  class Node{
      Node left,right;
      int value;
      int height=0;
      Node (int value){
        this.value=value;
        this.left=null;
        this.right=null;
      }
      public int getValue(){
        return value;
      }
    }
    public boolean isEmpty(Node node){
        return node==null;
    }
    public void insert(int value ){
        
       root=insert(root,value);
    }
    private Node insert(Node node,int value){
        if(node==null) return new Node(value);
        if(value<node.value){
            node.left=insert(node.left, value);
        }
        if(value>node.value){
            node.right=insert(node.right,value);
        }
        else{
            return node;
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        return node;
    }
    public int height(Node node)
    {  if(node==null) return -1;
        return node.height;
    }
    public boolean balance(){
        return balance(root);
    }
    public void populate(int[] nums){
        for(int num:nums){
            this.insert(num);
        }
    }
    // balance
    private boolean balance(Node node) {
        if (node == null) return true;
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balance(node.left) && balance(node.right);
    }
    // display
    public void display(){
        display(root," ");
    }
    private void display(Node node,String details){
     if(node == null ) return;
     System.out.println(node.value + " " + details);
      display(node.left, " Left value of " + node.value);
      display(node.right, " Right value of " + node.value);

    }
    // search 
    public boolean SearchResult(Scanner sc){
        System.out.println("Enter the value to search");
        int value=sc.nextInt();
        return SearchResult(root,value);

    }
    private  boolean SearchResult(Node current,int value){
        if(current==null) return false;
        if(value==current.value) return true;
        return value<current.value ? SearchResult(current.left,value):SearchResult(current.right, value);
    }
    public static void main(String[] args) {
        BSear b=new BSear();
          int nums[]=new int[]{
            8, 4, 12, 2, 6, 10, 14
          };
          Scanner sc=new Scanner(System.in);
          b.populate(nums);
          b.display();
           boolean found =b.SearchResult(sc);
         System.out.print((found ? "found":"Not Found"));
         System.out.println();
         boolean Yes=b.balance();
         System.out.println( "Is tree balanced?"+ (Yes ?" Yes":" No") );
    }
}
