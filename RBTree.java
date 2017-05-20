public class RBTree{
	private Node root;
	private Node sent;

	public RBTree(){
		root = null;
		sent = new Node();
	}

	public void insertValue(int toInsert){
		if(valueExists(toInsert)){
			return;
		}
		Node z = new Node(toInsert);
		if(this.root == null){
			z.setLeft(this.sent);
			z.setRight(this.sent);
			z.setParent(this.sent);
			this.root = z;
			this.sent.setLeft(root);
			this.sent.setRight(root);
			return;
		}

		Node y = sent;
		Node x = root;

		while(x != this.sent){
			y = x;
			if(z.getValue() < x.getValue()){
				x = x.getLeft();
			}
			else{
				x = x.getRight();
			}
		}
		z.setParent(y);
		if(y == this.sent){
			this.root = z;
		}
		else{
			if(z.getValue() < y.getValue()){
				y.setLeft(z);
			}
			else{
				y.setRight(z);
			}
		}
		z.setLeft(this.sent);
		z.setRight(this.sent);
		z.setIsRed(true);
		insertFix(z);
	}

	public void deleteValue(int toDelete){
		Node z = this.getNodeWithValue(toDelete);
		if(z == null){
			return;
		}
		Node y = z;
		Node x = null;
		boolean yWasRed = y.isRed();
		if(z.getLeft() == this.sent){
			x = z.getRight();
			transplant(z, z.getRight());
		}
		else if(z.getRight() == this.sent){
			x = z.getLeft();
			transplant(z, z.getLeft());
		}
		else{
			y = getMinNode(z);
			yWasRed = y.isRed();
			x = y.getRight();
			if(y.getParent() == z){
				x.setParent(y);
			}
			else{
				transplant(y, y.getRight());
				y.setRight(z.getRight());
				y.getRight().setParent(y);
			}
			transplant(z,y);
			y.setLeft(z.getLeft());
			y.getLeft().setParent(y);
			y.setIsRed(z.isRed());
		}
		if(!yWasRed){
			deleteFix(x);
		}
	}

	public boolean valueExists(int toFind){
		Node toCheck = root;
		while(true){
			if(toCheck == null || toCheck == this.sent){
				return false;
			}
			if(toCheck.getValue() == toFind){
				return true;
			}
			if(toFind < toCheck.getValue()){
				toCheck = toCheck.getLeft();
			}
			else{
				toCheck = toCheck.getRight();
			}
		}
	}

	public void printInOrder(){
		System.out.println("\n");
		printInOrder(this.root);
		System.out.println("\n");

	}

	public Node getRoot(){
		return root;
	}

	public Node getSent(){
		return sent;
	}

	private void printInOrder(Node next){
		if(next.getLeft() != this.sent){
			printInOrder(next.getLeft());
		}
		System.out.println(next);
		if(next.getRight() != this.sent){
			printInOrder(next.getRight());
		}
	}

	private Node getNodeWithValue(int value){
		Node toReturn = root;
		while(true){
			if(toReturn == null || toReturn == this.sent){
				return null;
			}
			if(toReturn.getValue() == value){
				return toReturn;
			}
			if(value < toReturn.getValue()){
				toReturn = toReturn.getLeft();
			}
			else{
				toReturn = toReturn.getRight();
			}
		}
	}
	private Node getMinNode(Node start){
		Node toReturn = start;
		if(toReturn == null){
			return null;
		}
		while(true){
			if(toReturn.getRight() == this.sent){
				return toReturn;
			}
			toReturn = toReturn.getRight();
		}
	}

	private void rotateLeft(Node x){
		System.out.println("left rotate");

		Node y = x.getRight();
		x.setRight(y.getLeft());

		if(y.getLeft() == this.sent){
			y.getLeft().setParent(x);
		}
		y.setParent(x.getParent());

		if(x.getParent() == this.sent){
			this.root = y;
			this.root.setParent(sent);
			this.sent.setLeft(y);
			this.sent.setRight(y);
		}
		else if (x == x.getParent().getLeft()){
			x.getParent().setLeft(y);
		}
		else{
			x.getParent().setRight(y);
		}
		y.setLeft(x);
		x.setParent(y);

	}


	private void rotateRight(Node x){
		System.out.println("Right rotate");

		Node y = x.getLeft();
		x.setLeft(y.getRight());
		if(y.getRight() != this.sent){
			y.getRight().setParent(x);
		}
		y.setParent(x.getParent());
		if(x.getParent() == this.sent){
			this.root = y;

			this.root.setParent(sent);
			this.sent.setLeft(y);
			this.sent.setRight(y);
		}
		else if (x == x.getParent().getRight()){
			x.getParent().setRight(y);
		}
		else{
			x.getParent().setLeft(y);
		}
		y.setRight(x);
		x.setParent(y);
	}

	private void insertFix(Node z){
		while(z.getParent().isRed()){
			if(z.getParent() == z.getParent().getParent().getLeft()){
				Node y = z.getParent().getParent().getRight();
				if(y.isRed()){
					z.getParent().setIsRed(false);
					y.setIsRed(false);
					z.getParent().getParent().setIsRed(true);
					z = z.getParent().getParent();
				}
				else{
					if(z == z.getParent().getRight()){
						z = z.getParent();
						rotateLeft(z);
					}
					z.getParent().setIsRed(false);
					z.getParent().getParent().setIsRed(true);
					rotateRight(z.getParent().getParent());
				}
			}
			else{
				Node y = z.getParent().getParent().getLeft();
				if(y.isRed()){
					z.getParent().setIsRed(false);
					y.setIsRed(false);
					z.getParent().getParent().setIsRed(true);
				}
				else{
					if(z == z.getParent().getLeft()){
						z = z.getParent();
						rotateRight(z);
					}
					z.getParent().setIsRed(false);
					z.getParent().getParent().setIsRed(true);
					rotateLeft(z.getParent().getParent());
				}
			}
			this.root.setIsRed(false);
			if(z == this.sent){
				break;
			}
		}
	}


	private void deleteFix(Node toFix){
		while(toFix != this.root && !toFix.isRed()){
			if(toFix == toFix.getParent().getLeft()){
				Node w = toFix.getParent().getRight();
				if(w.isRed()){
					w.setIsRed(false);
					toFix.getParent().setIsRed(true);
					rotateLeft(toFix.getParent());
					w = toFix.getParent().getRight();
				}
				if(!w.getLeft().isRed() && !w.getRight().isRed()){
					w.setIsRed(true);
					toFix = toFix.getParent();
				}
				else{
					if(!w.getRight().isRed()){
						w.getLeft().setIsRed(false);
						w.setIsRed(true);
						rotateRight(w);
					}
					w.setIsRed(toFix.getParent().isRed());
					toFix.getParent().setIsRed(false);
					w.getRight().setIsRed(false);
					rotateLeft(toFix.getParent());
					toFix = this.root;
				}
			}
			else{
				Node w = toFix.getParent().getLeft();
				if(w.isRed()){
					w.setIsRed(false);
					toFix.getParent().setIsRed(true);
					rotateRight(toFix.getParent());
					w = toFix.getParent().getLeft();
				}
				if(!w.getRight().isRed() && !w.getLeft().isRed()){
					w.setIsRed(true);
					toFix = toFix.getParent();
				}
				else{
					if(!w.getLeft().isRed()){
						w.getRight().setIsRed(false);
						w.setIsRed(true);
						rotateLeft(w);
					}
					w.setIsRed(toFix.getParent().isRed());
					toFix.getParent().setIsRed(false);
					w.getLeft().setIsRed(false);
					rotateRight(toFix.getParent());
					toFix = this.root;
				}
			}
		}
		toFix.setIsRed(false);
	}

	private void transplant(Node u, Node v){
		if(u.getParent() == this.sent){
			this.root = v;
		}
		else if (u == u.getParent().getLeft()){
			u.getParent().setLeft(v);
		}
		else{
			u.getParent().setRight(v);
		}
		v.setParent(u.getParent());

	}


}