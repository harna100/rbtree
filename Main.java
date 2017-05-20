public class Main{
	public static void main(String[] argv){
		RBTree tree = new RBTree();

		for (int i = 1; i < 50; ++i) {
			tree.insertValue(i);
		}

		for (int i = 1000; i > 90; --i) {
			tree.insertValue(i);
		}

		System.out.println("Root: " + tree.getRoot());
		System.out.println("Sent: " + tree.getSent());
		tree.printInOrder();



	}

	public static String padRight(String s, int n) {
		return String.format("%1$-" + n + "s", s);
	}

	public static String padLeft(String s, int n) {
		return String.format("%1$" + n + "s", s);
	}
}