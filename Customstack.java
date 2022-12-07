import java.util.*;
class MyStack{

      int[] data;
      int size = 0;
      private static final int DEFAULT_SIZE = 10;

      int top = -1;

      public MyStack(){
      	this(DEFAULT_SIZE);
      }
      public MyStack(int size){
      	this.data = new int[size];
      }

       public boolean isfull()
      {
      	return top  == data.length - 1;
      }
      public boolean isEmpty(){
      	return top == -1;
      }

//PUSH Element
       public boolean push(int element){
      	if(isfull())
      	{
      		System.out.println("Stack is Full");
      		return false;
      	}
      	top++;
      	data[top] = element;
      	size++;
      	
      	return true;
      }
//POP Element     
 public int pop()
      {
      	if(isEmpty())
      	{
      		System.out.println("Stack is Empty");
      		return -1;
      	}
      	int value = data[top];
      	top--;
      	size--;
      	return value;
      }

//Top Most Element
      public int peek()
      {
      	if (top == -1) {
      		System.out.println("Stack is Empty");
      		return;
      	}

      	return data[top];

      }

//Display Element
      void display()
      {
      	//int i = top;
      	if (top == -1) {
      		System.out.println("Stack is Empty");
      		return;
      		
      	}
      	for(int i = top ; i >= 0 ; i--){
      		System.out.print(data[i]+"  ");
      	}
      	System.out.print("Size => " + size);
      }

}
class Customstack{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyStack stack = new MyStack();
		char choice;
		do{
				System.out.println("\n Enter Which Operation Do you Want to Do:  ");
				System.out.println("\t 1. Push Element in to the Stack ");
				System.out.println("\t 2. Pop Element From the Stack ");
				System.out.println("\t 3. Display Element   ");
				System.out.println("\t 4. Display TopMost Element from the Stack");
			        System.out.println("\t 5. Check Weather Stack is Full? ");
			        System.out.println("\t 6. Check Weather Stack Is Empty?");

				int ch = sc.nextInt();
				switch(ch){

					case 1 :
							System.out.println("Enter value");
							int val = sc.nextInt();
							System.out.println(stack.push(val));
							break;

					case 2:
							System.out.println("Deleted Element " + stack.pop());
							break;

					case 3:
							stack.display();
							break;

					case 4:
							System.out.println("Top Most Element => "+ stack.peek());
					
					case 5:
						System.out.println("Stack is Full =>" + stack.isFull());
						break;

					case 6:
						System.out.println("Stack Is Empty =>" + stack.isEmpty());
						break;

					default :
						System.out.println("Wrong Choice");

				}
		

	System.out.println("\nDo You Want to perform any Other Operation : ");
	choice = sc.next().charAt(0);
   } while( choice == 'y' || choice == 'Y');

	}
		
}
