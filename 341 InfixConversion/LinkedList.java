
public class LinkedList<E> {

	private class Node {
		char info;
		Node left;
		Node right;
		}

		private Node head = null;

		public boolean isEmpty()
		{
		if (head.right == head)
			return true;
		else
			return false;
		}
		
		public void insertHead()
		{
		// Set up the dummy node.
		head = new Node();
		head.right = head;
		head.left = head;

		}



		public void InsertLeft(Node p,char info) {
		Node q,L;
			if( p==null)
				System.out.println("Void insertion");
			else
			{
				q = new Node();
				q.info = info;
				L = p.left;
				L.right = q;
				q.left = L;
				q.right = p;
				p.left = q;
			}
		}

		public void InsertRight(Node p,char info) {
		Node q,R;
			if( p==null)
				System.out.println("Void insertion");
			else
			{
				q = new Node();
				q.info = info;
				R = p.right;
				R.left = q;
				q.right = R;
				q.left = p;
				p.right = q;
			}
		}

		public int Delete(Node p){
			Node L,R;
			int x = 0;
			if (p == null)
			{
				System.out.println("Void Deletion");
			}
			else
			{
				x= p.info;
				L = p.left;
				R = p.right;
				L.right = R;
				R.left = L;
			}
			return x;
		}
		
		public String createUnordered()
		{
			return "HI";
		}
}
