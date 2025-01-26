
public class Segment {
    Node root;
    public static class Node{
        int data;
        int startI,endI;
        Node left,right;

        public Node(int startI,int endI) {
            this.startI=startI;
            this.endI=endI;
        }
        
    }
    public Segment(int []arr){
      this.root=constructTree(arr,0,arr.length-1);
    }
    private  Node constructTree(int[]arr,int start,int end){
    if(start==end){
        // leaf node
      Node leaf=new Node(start,end);
      leaf.data=arr[start];
      return leaf;
    }
    // for current level;
    int mid=(start+end)/2;
    Node node = new Node(start,end);
    node.left=this.constructTree(arr,start,mid);
    node.right=this.constructTree(arr,mid+1,end);
    node.data=node.left.data+node.right.data;
    return node;
    }
    public void display(){
        display(this.root);
    }
    private void display(Node node){
         String str="";
         if(node.left!=null){
            str+= "Interval "+ node.left.startI + "[" + "-" + node.left.endI + "]" +"data is  " + node.left.data + "=>";
         }
         else{
            str+="No child found";
        }
        // for current node;
        str= str + "Interval =[" + node.startI + "-" + node.endI + "]" + "and data -" + node.data +  "=>";
         if(node.right!=null){
            str+= "Interval "+ node.right.startI + "[" + "-" + node.right.endI + "]" +"data is " + node.right.data ;
         }
         else{
            str+="No child found";
         }

          System.out.println(str + "\n");
        if(node.left!=null){
            display(node.left);
        }
        if(node.right!=null)
        {
            display(node.right);
        }
    }
    public void update(int index, int value) {
        this.root.data = update(this.root, index, value);
      }
      private int update(Node node, int index, int value) {
        if (index >= node.startI&& index <= node.endI){
          if(index == node.startI && index == node.endI) {
            node.data = value;
            return node.data;
          } else {
            int leftAns = update(node.left, index, value);
            int rightAns = update(node.right, index, value);
            node.data = leftAns + rightAns;
            return node.data;
          }
        }
        return node.data;
      }
      public int query(int qsi, int qei) {
        return this.query(this.root, qsi, qei);
      }
      private int query(Node node, int qsi, int qei) {
        if (node == null) {
            return 0; // Base case for null node
        }
    
        if (node.startI >= qsi && node.endI <= qei) {
            // Node is completely inside query range
            return node.data;
        }
    
        if (node.startI > qei || node.endI < qsi) {
            // Node is completely outside query range
            return 0;
        }
    
        // Partial overlap, query left and right children
        int leftSum = query(node.left, qsi, qei);
        int rightSum = query(node.right, qsi, qei);
        return leftSum + rightSum;
    }
      
      public static void main(String[] args) {
          int arr[]={4,5,6,8,-2};
          Segment tree=new Segment(arr);
        //   tree.update(2, 10);
          tree.display();
          System.out.println(tree.query(0, 2));
        }
    }

