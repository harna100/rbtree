public class Node{
	private boolean isRed;
	private int value;
	private Node left;
	private Node right;
	private Node parent;

	public Node(){
		isRed = true;
		value = -1;
		left = null;
		right = null;
		parent = null;
	}

	public Node(boolean isRed, int value, Node left, Node right, Node parent) {
		this.isRed = isRed;
		this.value = value;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

	public Node(int value) {
		this.value = value;
		isRed = true;
		left = null;
		right = null;
		parent = null;
	}

	/*@Override
	public String toString() {
		return value + "-" + (isRed()? "Red": "Black") + "-Left: " + left.getValue() + "-Right: " + right.getValue();
	}*/


	@Override
	public String toString() {
		return "[data = " + value + ":Color = " + Main.padRight((isRed()? "Red": "Black"),5) + ":Parent = " + (parent != null? parent.getValue():"00")  + ": LC = " + left.getValue() + ": RC = " + right.getValue() + "]";
	}

	public boolean isRed() {
		return isRed;
	}

	public void setIsRed(boolean red) {
		isRed = red;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
}