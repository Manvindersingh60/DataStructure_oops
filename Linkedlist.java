class Node
{
	int data;
	Node next;
}

class Linkedlist
{
	Node head;

	Node getNewNode(int data)
	{
		Node newNode=new Node();
		newNode.data=data;
		return newNode;
	}
	void insertAtHead(int data)
	{
		Node newNode=getNewNode(data);
		newNode.next=head;
		head=newNode;
	}

	void insertAtN(int n,int data)
	{
		if(n==1)
			insertAtHead(data);

		Node newNode=getNewNode(data);
		Node current=this.head;

		for(int i=1;i<=n-2;i++)				//move the pointer to (n-1)th node
			current=current.next;

		newNode.next=current.next;
		current.next=newNode;
	}

	void printAll()
	{
		if(head==null)
		{
			System.out.println("Empty List");
			return;
		}

		System.out.print("List: ");
		Node current=this.head;
		while(current!=null)
		{
			System.out.print(current.data+" ");
			current=current.next;
		}
		System.out.println();
	}

	void printRecursive(Node head)			//recursive method to print list 
	{
		if(head==null)
		{
			return;
		}
		System.out.print(head.data+" ");
		printRecursive(head.next);
	}

	void reversePrint(Node head)			//prints the list in reverse order
	{
		if(head==null)
		{
			return;
		}
		reversePrint(head.next);
		System.out.print(head.data+" ");
	}

	void reverse()
	{
		Node prev,curr,fwd;
		prev=null;
		curr=head;
		fwd=null;
		while(curr!=null)
		{
			fwd=curr.next;
			curr.next=prev;
			prev=curr;
			curr=fwd;
		}
		head=prev;
		System.out.println("List reversed");
	}

	void deleteAtN(int n)
	{
		if(n==1)
		{
			head=head.next;
			return;
		}
		Node curr=head;
		for(int i=1;i<n-2;i++)		//move the pointer to (n-1)th node
		{
			curr=curr.next;
		}
		curr.next=curr.next.next;
	}

	public static void main(String[] args)
	{
			Linkedlist list=new Linkedlist();
			list.printAll();
			list.insertAtHead(1);
			list.printAll();
			list.insertAtN(2,2);
			list.printAll();
			list.insertAtN(2,3);
			list.printAll();
			list.insertAtN(3,4);
			list.printAll();
			System.out.print("Recursive Print:");
			list.printRecursive(list.head);
			System.out.print("\nReverse:");
			list.reversePrint(list.head);
			list.reverse();
			list.printAll();
			list.deleteAtN(1);
			list.printAll(); 
	}
}