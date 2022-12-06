
import java.util.*;

class Searching{

public static boolean linear(int[] arr, int size, int element){

	for(int i=0;i<size;i++)
	{
			if(arr[i] == element){
				return true;
			}

	}
	return false;
}

public static boolean binary(int[] arr, int size, int element){

	int start = 0;
	int end = size-1;

	while(start <= end){

		int mid = start +(end - start) / 2;
		if(element > arr[mid])
		{
			start = mid + 1;
		}
		else if(element < arr[mid])
		{
			end = mid - 1;		
		}
		else{
			return true;
		}
	}
	return false;

}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Size of Array  ");
		int size = sc.nextInt();
		int[] arr = new int[size];
		System.out.println("Enter Array Elements in Sorted Order => ");
		for(int i = 0;i < size ; i++){
			arr[i]=sc.nextInt();
		}
		char choice;
		do{

		System.out.println("Which Algorithm you Want to use to Search Elements ");
		System.out.println("\t 1. LinearSearch");
		System.out.println("\t 2. BinarySearch");
		int ch = sc.nextInt();
		switch(ch)
		{
			case 1:
					System.out.println("Enter Element Do you Want to search=> ");
		            int item = sc.nextInt();
					System.out.println(linear(arr,size,item));
					break;
			case 2:
					System.out.println("Enter Element Do you Want to search=> ");
					int item1 = sc.nextInt();
					System.out.println(binary(arr,size,item1));
					break;
			default :
						System.out.println("Wrong Choice");
		}
		System.out.println("Do You Want to Perform any other operation :  ");
		choice = sc.next().charAt(0);;
	}while(choice == 'Y' || choice == 'y');
		
	}
}