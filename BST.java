

class BST {

   
    Node root;
  public static  class Node{
        Node left,right;
        int val;
        int height;
        public Node(int val){
            this.val=val;
            this.left=null;
            this.right=null;
            this.height=0;
        }
        public int getValue(){
        return val;
        }
    }
    public BST(){

    }

        public boolean isEmpty(){
            return root==null;
        }
        
        public void insert(int val){
         root=insert(root,val);
        }
        private Node insert(Node node,int val){
           if(node==null){
            node=new Node(val);
            return node;
           }
           if(val<node.val){
              node.left=insert(node.left,val);
           }
           if(val>node.val){
               node.right=insert(node.right,val);
            }
           node.height=Math.max(height(node.left),height(node.right)) + 1;
            return node;
        }
        public int height(Node node){
            if(node==null) return -1;
            return node.height;
        }
        public boolean balanced(){
            return balanced(root);
        }
        private boolean balanced(Node node){
            if(node==null) return true;
            return Math.abs(height(node.left)-height(node.right))<=1 && balanced(node.left)&& balanced(node.right);
        }
        public void populate(int[] nums){
            for(int i=0;i<nums.length;i++){
                this.insert(nums[i]);
            }
        }
        public void populateSorted(int nums[]){
              populateSorted(nums,0,nums.length);
        }
        private void populateSorted(int[] nums,int start,int end){
            if(start>=end) return;
            int mid=(start+end)/2;
            this.insert(nums[mid]);
            populateSorted(nums, start, mid);
            populateSorted(nums, mid+1, end);
        }
        public void display(){
            display(this.root,"Root Node");
        }
        private void display(Node node,String details){
          if(node==null) return ;
           System.out.println(details + " " + node.val);
           display(node.left, "Left value of "+ node.val);
           display(node.right, "right value of "+ node.val);
        }
    public static void main(String[] args) {
        int nums[]=new int[]{4,6,7,8,9,10,12};
        BST bt=new BST();
        bt.populateSorted(nums);
        bt.display();
        BST bt2=new BST();
        int nums2[]=new int[]{5,13,9,6,14,8};
        bt2.populate(nums2);
        bt2.display();
    }
}
