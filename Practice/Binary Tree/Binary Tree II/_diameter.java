public class _diameter {

	static int max = 0;

	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root) { // check if this works 100%
		maxDia(root);
		return max;
	}

	public static int maxDia(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;

		int left = maxDia(root.left);
		int right = maxDia(root.right);

		max = Math.max(max, left + right + 1); // yha +1 ka mtlb nhi pta ???

		return Math.max(left, right) + 1;
	}

	// Coding ninjas solutions

	public static int diameter(BinaryTreeNode<Integer> root) { // CN unoptmised
		if (root == null)
			return 0;

		int ans1 = Main.height(root.left) + Main.height(root.right);
		int ans2 = diameter(root.left);
		int ans3 = diameter(root.right);

		return Math.max(ans3, Math.max(ans1, ans2));
	}

	// optimised now
	// first create a class for pair < height , diameter>

	public static pair<Integer, Integer> diameterOfTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			pair<Integer, Integer> output = new pair<>();
			output.h = 0;
			output.dia = 0;
			return output;
		}

		pair<Integer, Integer> leftOutput = diameterOfTree(root.left);
		pair<Integer, Integer> rightOutput = diameterOfTree(root.right);
		int height = 1 + Math.max(leftOutput.h, rightOutput.h);

		int ans1 = leftOutput.h + rightOutput.h;
		int ans2 = leftOutput.dia;
		int ans3 = rightOutput.dia;

		int diameter = Math.max(ans1, Math.max(ans2, ans3));

		pair<Integer, Integer> ans = new pair<>();
		ans.h = height;
		ans.dia = diameter;

		return ans;
	}

}

class pair<T, U> {
	T h;
	U dia;
}
