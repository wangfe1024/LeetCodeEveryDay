package year2021.month8.jz37;

import java.util.LinkedList;
import java.util.Queue;

public class MyCodec {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        TreeNode root2 = null;
        TreeNode root3 = new TreeNode(1);
        TreeNode root4 = new TreeNode(1, new TreeNode(2), null);
        Codec codec = new Codec();
        disp(codec.deserialize(codec.serialize(root1)));
        disp(codec.deserialize(codec.serialize(root2)));
        disp(codec.deserialize(codec.serialize(root3)));
        disp(codec.deserialize(codec.serialize(root4)));

    }

    private static void disp(TreeNode root) {
        dfsDisp(root);
        System.out.println();
    }

    private static void dfsDisp(TreeNode root) {
        if (root == null) {
            System.out.print("NULL ");
            return;
        }
        System.out.print(root.val + " ");
        dfsDisp(root.left);
        dfsDisp(root.right);
    }

}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    sb.append("NULL,");
                    continue;
                }
                sb.append(poll.val).append(",");
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);   // remove the last ","
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("NULL".equals(data)) {
            return null;
        }
        String[] split = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.offer(root);
        for (int i = 1; i < split.length; i += 2) {
            TreeNode node = queue.poll();
            if (!"NULL".equals(split[i])) {
                int leftVal = Integer.parseInt(split[i]);
                TreeNode left = new TreeNode(leftVal);
                node.left = left;
                queue.offer(left);
            }
            if (!"NULL".equals(split[i + 1])) {
                int rightVal = Integer.parseInt(split[i + 1]);
                TreeNode right = new TreeNode(rightVal);
                node.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
