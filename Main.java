public class Main{
	public static void main(String[] argv){
		/*RBTree test = new RBTree();
		test.insertValue(10);
		test.insertValue(13);
		test.insertValue(8);

		System.out.println("Should be true");
		System.out.println(test.valueExists(10));
		System.out.println(test.valueExists(8));
		System.out.println(test.valueExists(13));
		test.printInOrder();

		System.out.println("Should be false");
		System.out.println(test.valueExists(9));
		System.out.println(test.valueExists(7));
		System.out.println(test.valueExists(12));
		System.out.println(test.valueExists(14));

		System.out.println("Inserting 9,7,12,14");
		test.insertValue(9);
		test.printInOrder();
		test.insertValue(7);
		test.printInOrder();
		test.insertValue(12);
		test.printInOrder();
		test.insertValue(14);
		test.printInOrder();
		System.out.println("Should be true");
		System.out.println(test.valueExists(9));
		System.out.println(test.valueExists(7));
		System.out.println(test.valueExists(12));
		System.out.println(test.valueExists(14));

		System.out.println("Deleting");
		test.deleteValue(9);
		test.deleteValue(7);
		test.deleteValue(11);
		test.deleteValue(13);

		System.out.println("Should be false");
		System.out.println(test.valueExists(9));
		System.out.println(test.valueExists(7));
		System.out.println(test.valueExists(11));
		System.out.println(test.valueExists(13));

		test.printInOrder();*/

		RBTree tree = new RBTree();

/*
		for (int i = 1; i < 6; ++i) {
			tree.insertValue(i);
		}
*/

		for (int i = 93; i > 90; --i) {
			tree.insertValue(i);
		}

		try{
			System.out.println("Root: " + tree.getRoot());

			tree.printInOrder();
		}
		catch (StackOverflowError  e){

		}


	}

	public static String padRight(String s, int n) {
		return String.format("%1$-" + n + "s", s);
	}

	public static String padLeft(String s, int n) {
		return String.format("%1$" + n + "s", s);
	}
}