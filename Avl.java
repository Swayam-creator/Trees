class Avl {
    Node root;

    public static class Node {
        Node left, right;
        int val, height;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.height = 0;
        }

        public int getValue() {
            return val;
        }
    }

    public Avl() {
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    private Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }

        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return rotate(node);
    }

    public Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

    public Node leftRotate(Node p) {
        Node c = p.right;
        Node t = c.left;

        c.left = p;
        p.right = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

    private Node rotate(Node node) {
        // For left heavy case
        if (height(node.left) - height(node.right) > 1) {
            // Left-Left case
            if (height(node.left.left) >= height(node.left.right)) {
                return rightRotate(node);
            }
            // Left-Right case
            if (height(node.left.left) < height(node.left.right)) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        // For right heavy case
        if (height(node.left) - height(node.right) < -1) {
            // Right-Right case
            if (height(node.right.right) >= height(node.right.left)) {
                return leftRotate(node);
            }
            // Right-Left case
            if (height(node.right.right) < height(node.right.left)) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    public int height(Node node) {
        if (node == null) return -1;
        return node.height;
    }
    public int height(){
        return height(root);
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) return true;
        return Math.abs(height(node.left) - height(node.right)) <= 1 &&
               balanced(node.left) &&
               balanced(node.right);
    }

    public void populate(int[] nums) {
        for (int num : nums) {
            this.insert(num);
        }
    }

    public void populateSorted(int nums[]) {
        populateSorted(nums, 0, nums.length - 1);
    }

    private void populateSorted(int[] nums, int start, int end) {
        if (start > end) return;
        int mid = (start + end) / 2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid - 1);
        populateSorted(nums, mid + 1, end);
    }

    public void display() {
        display(this.root, "Root Node");
    }

    private void display(Node node, String details) {
        if (node == null) return;
        System.out.println(details + " " + node.val);
        display(node.left, "Left value of " + node.val);
        display(node.right, "right value of " + node.val);
    }

    public static void main(String[] args) {
        
        Avl bt = new Avl();
        int nums[]=new int[10];
       
        for(int i=0;i<nums.length;i++){
           
            bt.insert(i);
        }
        bt.display();
        System.out.println("Height of Tree "+bt.height());
        System.out.println("Is tree balanced? " + bt.balanced());
    }
}
