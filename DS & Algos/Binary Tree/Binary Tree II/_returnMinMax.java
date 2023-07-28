public class _returnMinMax {


    public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		if(root == null){
			return new Pair<>(Integer.MAX_VALUE , Integer.MIN_VALUE);
		}
		 Pair<Integer, Integer> Lo = getMinAndMax(root.left);
		Pair<Integer, Integer> Ro = getMinAndMax(root.right);

		int min  = Math.min(root.data , Math.min(Lo.minimum,Ro.minimum));
		int max = Math.max(root.data , Math.max(Lo.maximum,Ro.maximum));

		return new Pair<>(min,max);
		  
	}

    
}

class Pair<T, U> {
    T minimum;
    U maximum;

    public Pair(T minimum, U maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

}
