class TreeNode {
    int value;
    Node left;
    Node right;
    public TreeNode (int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

function inorderTraversal(root, result = []) {
    if (root !== null) {
        inorderTraversal(root.left, result);
        result.push(root.value);
        inorderTraversal(root.right, result);
    }
    return result;
}

// Example usage
const root = new TreeNode(1);
root.left = new TreeNode(2);
root.right = new TreeNode(3);
root.left.left = new TreeNode(4);
root.left.right = new TreeNode(5);

const result = inorderTraversal(root);
console.log(result);  // Output: [4, 2, 5, 1, 3]
