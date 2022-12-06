
import java.util.*;
class SinglyLL{

private Node head;
private Node tail;
private int size;

Singly()
{
	this.size = 0;
}
//Insertion at First
public void insertFirstNode(int val){

	Node node = new Node(val);
	node.next = head;
	head = node;
	
	if(tail == null)
	{
		tail=head;
	}
   size += 1;

}
//Insertion at End
public void insertAtEnd(int val){

	if(tail == null){
		insertFirstNode(val);
		return;
	}
	Node node = new Node(val);
	tail.next = node;
	tail = node;
	size++;
}

//Insertion at Middle
public void insertAtmiddle(int val,int index){


if(index < 0 || index > size )
{
	System.out.println("You entered Wrong Index");
}
Node temp =head;
if(index == 0)
{
	insertFirstNode(val);
	return;
}
if(index == size){
	insertAtEnd(val);
		return;
}
	for(int i = 0; i < index - 1; i++)
	{
		temp=temp.next;
	}
	Node node = new Node(val);
	node.next = temp.next;
	temp.next = node;

	size++;

}

//Delete First Elemnet
public void deleteFirst(){

	if(head == null)
	{
		return;
	}
	int data = head.val;
	head =  head.next;
	System.out.println("Deleted Element=>"+data);
	size--;
}
//Get SecondLast Node 
public Node get(int index){

	Node node = head;
	for(int i = 0;i < index; i++){
		node=node.next;
	}
	return node;
}
//Delete Last Elment
public void deleteLast(){

	if(tail == null)
	{
		return;
	}
	Node SecondLast = get(size-2);
	
	int data = tail.val;
	tail = SecondLast;
	tail.next = null;

	System.out.println("Deleted Element=>"+data);
	size--;
}
//Delete Element At Specified Index
public void deleteIndex(int  index){

	if(index < 0 || index > size )
	{
		System.out.println("You Entered Wrong Index");
		return;
	}
	if(index == 0)
	{
		deleteFirst();
		return;
	}
	if(index == size)
	{
		deleteLast();
		return;
	}
	Node temp = head;
	for(int i = 0;i < index - 1; i++){
		temp=temp.next;
	}
	int data = temp.next.val;
	temp.next = temp.next.next;
	System.out.println("Deleted Element=>"+data);
	size--;


}
//Search Specified Element
public boolean search(int item){

Node node = head;
while(node != null){

	if(node.val == item){
		return true;

	}
	node = node.next;


}
return false;
}



//Display List
public void display(){

	Node temp;
	temp = head;
	while(temp != null){
		System.out.print(temp.val + " ");
		temp=temp.next;
	}
	System.out.println("Size => "+ size);
}


	class Node{

		private int val;
		private Node next;

		public Node(int val){

			this.val = val;
		}

		public Node(int val, Node next){

			this.val = val;
			this.next = next;
		}

}

public static void main(String[] args) {
 
		Singly list = new Singly();
		
        Scanner sc = new Scanner(System.in);
		
		char ch;
		
	    //System.out.println("\n 1. Which Operation Do you Want to Perform   ");
	   do{

	   	System.out.println("Enter Which Operation Do you Want to Do:  ");
		System.out.println("\t 1. Insert Element At First  ");
		System.out.println("\t 2. Insert Element At End  ");
		System.out.println("\t 3. Insert Element At Specified Index   ");
		System.out.println("\t 4. Delete First Element From List   ");
		System.out.println("\t 5. Delete Last Elemnet From List   ");
	    System.out.println("\t 6. Delete Element using Specified Index ");
	    System.out.println("\t 7. Search Specified Elemnet ");
		System.out.println("\t 8. Display List   ");
		int choice;
		choice=sc.nextInt();
		switch(choice)
		{
			case 1:	    System.out.println("Enter value");
						int val = sc.nextInt();

						list.insertFirstNode(val);
			            break;

			case 2:		
						System.out.println("Enter value");
						int val1 = sc.nextInt(); 
						list.insertAtEnd(val1);
						break;

			case 3:		
						System.out.println("Enter value and Index Where you want to Add an Elemnet");
						int val2 = sc.nextInt();
						int i = sc.nextInt();

						list.insertAtmiddle(val2,i);	
						break;	
			
			case 4:     list.deleteFirst();
						break;

			case 5:     list.deleteLast();
						break;

			case 6:     
						System.out.println("Enter index");
					    int index = sc.nextInt();
						list.deleteIndex(index);
						break;
						

			case 7:     
					
						System.out.println("Enter Element do you Want to Search");
						int item = sc.nextInt(); 
						System.out.println(list.search(item));
						break;
			
			case 8:     list.display();
						break;

		    

		}

		System.out.println("Do You Want to Perform any other operation :  ");
		ch=sc.next().charAt(0);;
	}while(ch == 'Y' || ch == 'y');
		
	}
}