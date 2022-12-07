import java.util.*;
class Myqueue{

	 int[] data ;
	 int front = -1 ;
	 int rear = -1;
	 int size = 0;
	 public static final int DEFAULT_SIZE = 10; 

	public Myqueue()
	{
		this(DEFAULT_SIZE);
	}
	public Myqueue( int size1)
	{
		this.data = new int[size1];
	}

    public boolean isFull(){

    	if(rear ==  DEFAULT_SIZE - 1){
    		return true;
    	}
    	return false;
    }

    public boolean isEmpty(){

    	if( front < 0 || front > rear){
    		return true;
    	}
    	return false;
    }

	public boolean enqueue(int val ){

		if(isFull())
		{
			System.out.println("Queue is Full");
			return false;
		}
		if(front == -1)
		{
			front++;
		}
		rear++;
		data[rear] = val;
		size++;
		return true ;
	}


	public int dequeue(){
		if(isEmpty()){

			return 0;
		}
		else{
			front = 0;
		}
		int element = data[front];
		front++;
		size--;
		return element;
	}


	public int peek(){

		if(front == -1)
		{
			System.out.println("Queue Is Empty");
			return 0;
		}
		return data[front];
	}

	public void display(){

		if (rear == -1) {
      		System.out.println("Queue is Empty");
      		return;
      		
      	}
      	for(int i = front  ; i <= rear ; i++){
      		System.out.print(data[i]+"  ");
      	}
      	System.out.print("Size => " + size);


	}

}

class Customqueue{
	public static void main(String[] args) {
		Myqueue queue = new Myqueue();
		Scanner sc = new Scanner(System.in);
		char choice;

		do{

			System.out.println("\n Which operation Do You want to Preform");
			System.out.println("\t 1. Insert Element In to Queue ");
			System.out.println("\t 2. Delete Element from the Queue");
			System.out.println("\t 3. Top Most Element");
			System.out.println("\t 4. Display Element");
			System.out.println("\t 5. Check Weather Queue is Full? ");
			System.out.println("\t 6. Check Weather Queue Is Empty?");

			int ch = sc.nextInt();
			switch(ch)
			{
				case 1:
						System.out.println("Enter value");
						int val = sc.nextInt();
						System.out.println(queue.enqueue(val));
						break;

				case 2:
						System.out.println("Deleted Element =>" + queue.dequeue());
						break;

				case 3:
						System.out.println("Top Most Element => " + queue.peek());
						break;

				case 4:
						queue.display();
						break;

				case 5:
						System.out.println("Queue is Full =>" + queue.isFull());
						break;

				case 6:
						System.out.println("Queue Is Empty =>" + queue.isEmpty());
						break;

				default :
						System.out.println("Wrong Choice");
	
			}
			System.out.println("\nDo You Want to perform any Other Operation : ");
			choice = sc.next().charAt(0);

		}while(choice == 'y' || choice == 'Y');


	}
}