
public class BinaryTree {

	public static void main(String[] args) {
		BT<Integer> tree = new BT<Integer>();
		for(int i=0;i<30;i++) {
			tree.add(i);
		}
		tree.show();
		tree.clueShow();
		tree.clue();
		tree.clueShow();
		tree.clueShow();
		tree.show();
	}

}
