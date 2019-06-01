public class LinkedListDeque <T> {
	
	private class Node{
		public T item;
		public Node next;
		public Node pre;
		public Node(Node p,T i, Node n){
			pre = p;
			item = i;
			next = n;
		}
	}

	public int size = 0;
	public Node head;
	private Node end;
	private Node temp;

	public void addLast(T item){
		end.next = new Node(end,item,null);
		end = end.next;
		size+=1;

	}
	public void addFirst(T item){
		head.next = new Node(head,item,head.next);
		size+=1;
	}
	public void printDeque(){
		Node temp = head.next;
		while (temp==null)
			{
				System.out.println(temp.item);
				temp=temp.next;
			}
		System.out.println("\n");

	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public T removeFirst(){
		head.next = head.next.next;
		size-=1;
		if (head.next==null){
			return null;
		}
		return head.next.item;
	}
	public T removeLast(){
		end = end.pre;
		size-=1;
		if (end==null){
			return null;
		}
		return end.item;
	}
	public T get(int index){
		if (index>=size){
			return null;
		}
		temp = head.next;

		for (int i =0;i<index;i++){
			temp = temp.next;
		}
		return temp.item;
	}

	private T helper(int index,Node n){
		
		if (index==0){
			return n.item;

		}
		return helper(index-1,n.next);


	}
	public T getRecursive(int index){
		if (index>=size){
			return null;
		}
		temp = head.next;
		return helper(index,temp);
	}

	public LinkedListDeque(){
		head = new Node(null,null,null);
		end = head;
		size = 0;
	} 

	public LinkedListDeque(LinkedListDeque other){
		head = new Node(null,null,null);
		end = head;
		size = 0;
		
		for (int i =0;i < other.size();i++){
		
			
			addLast((T) other.get(i));
			size+=1;
		}
	}

	public boolean isEmpty(){
		if (s==0){
			return true;
		}
		else{
			return false;
		}
	}

	


	

}