import java.util.*;

class DoublyLL{

  private Node head;
  private int size;

  public DoublyLL(){
  	this.size = size;

  }

class Node{

	private int val;
	private Node next;
	private Node prev;

	public Node( int val)
	{
		this.val = val;
	}

	public Node( int val ,Node next , Node prev)
	{
		this.val = val;
		this.next = next;
		this.prev = prev;

	}
}
//Insert Element At First

	public void insertAtFirst(int val){

		Node node = new Node(val);

		node.next = head;
		node.prev = null;

		//when we insert at very first it may be give null exception  

		if(head != null){
			head.prev = node ; //null.prev
		}

		head = node;
		size++;
	}

//Insert Element At End

	public  void insertAtEnd(int val){
		Node node = new Node(val);
		Node temp = head;
		while(temp.next != null)
		{
			temp = temp.next;
		}
		node.next = null;
		temp.next = node;
		node.prev =temp;
		size++;

	}
 

//Insert Element At Specified Index

	public void insertAtMiddle(int val , int index){

		if(index == 0)
		{
			insertAtFirst(val);
			return;
		}
		if(index == size-1)
		{
			insertAtEnd(val);
			return;
		}
		Node p = get(index);

		Node node = new Node(val);
		p.next.prev = node;
		node.next = p.next;
		node.prev = p;
		p.next = node;
		size++;


	}

//Delete First Element From List

	public void deleteFirst(){
		if(head == null){
			System.out.println("List is Empty");
			return;
		}
		int data = head.val;
		head = head.next;
		head.prev = null;
		size--;
		System.out.println("Deleted Element => "+ data);


	}

//Delete Last Element From List

	public void deleteLast(){

		Node temp = head;
		while(temp.next !=null)
		{
			temp = temp.next;
		}
		int data = temp.val;
		temp = temp.prev;
		temp.next = null;
		System.out.println("Deleted Element => " + data);
		size--;
	}


//Delete Element using Specified Index
	public void deleteIndex(int index){

		if(index < 0 || index > size-1)
		{
			System.out.println("You Entered Wrong Index");
		}
		if(index == 0)
		{
			deleteFirst();
			return;
		}
		if(index == size-1){
			deleteLast();
			return;
		}
		Node temp = head;
		for(int i = 0;i < index - 1;i++){
			temp = temp.next;
		}
		int data = temp.next.val;
		temp.next = temp.next.next;
		temp.next.prev = temp;
		System.out.println("Deleted Element =>" + data);
		size--;


	}

//Search Specified Elemnet 
	public boolean search(int val){
		Node temp = head;
		while(temp != null){

			if( val == temp.val)
			{
				return true;
			}
			temp = temp.next;

		}
		return false;
	}

//Display Element

	public void display(){
		Node temp = head;

	while(temp != null){
		System.out.print(temp.val + " ");
		temp = temp.next;
	}
	System.out.println("Size => "+ size);
	}

	public Node get(int index){
		Node p =  head;
		for(int i = 0;i< index -1; i++)
		{
			p = p.next;

		}
		return p;
	}


public static void main(String[] args) {

			DoublyLL list = new DoublyLL();
			Scanner sc = new Scanner(System.in);
			char ch;

		
			do{
				System.out.println("\nEnter Which Operation Do you Want to Do:  ");
				System.out.println("\t 1. Insert Element At First  ");
				System.out.println("\t 2. Insert Element At End  ");
				System.out.println("\t 3. Insert Element At Specified Index   ");
				System.out.println("\t 4. Delete First Element From List   ");
				System.out.println("\t 5. Delete Last Elemnet From List   ");
			    System.out.println("\t 6. Delete Element using Specified Index ");
			    System.out.println("\t 7. Search Specified Elemnet ");
				System.out.println("\t 8. Display List   ");

				System.out.println("Enter Choice ");
				int choice = sc.nextInt();
				switch (choice) {

					case 1:
							System.out.println("Enter value ");
							int ele = sc.nextInt();
							list.insertAtFirst(ele);
							break;

					case 2:
							System.out.println("Enter value ");
							int ele2 = sc.nextInt();
							list.insertAtEnd(ele2);
							break;

					case 3:
							System.out.println("Enter value and Index Where you want to Add an Elemnet");
							int ele3 = sc.nextInt();
							int index = sc.nextInt();
							list.insertAtMiddle(ele3 , index);
							break;

					case 4:     
							list.deleteFirst();
						    break;

					case 5:    
							list.deleteLast();
							break;

					case 6:     
						    System.out.println("Enter index");
					    	int i = sc.nextInt();
							list.deleteIndex(i);
							break;
						

					case 7:     
					
							System.out.println("Enter Element do you Want to Search");
							int item = sc.nextInt(); 
							System.out.println(list.search(item));
							break;
			
					case 8:     
							list.display();
							break;

					default :
						System.out.println("Wrong Choice");


					
				}
				System.out.println("Do You Want to Perform any other operation :  ");
				ch=sc.next().charAt(0);
				
				}while(ch == 'Y' || ch == 'y');

}
}