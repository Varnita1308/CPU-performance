import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author varnita jain, micky vue
 *This is a thread class for computation intensive thread
 */
public class ThreadComp extends Threads {
	 static int arr[] = {13, 7, 6, 45, 21, 9, 101, 102, 54, 2, 
			 78, 23, 77, 55, 8, 10, 23, 90, 110, 3, 
			 33, 99, 89, 79, 69, 111, 100, 103, 70, 88, 
			 64, 43, 126, 110, 1, 200, 199, 197, 196,119}; 
	 
	 public String threadName;
	 
	 /**
	  * 
	  * @param ThreadName gives thread name
	  * constructor to create a thread
	  */
	 public ThreadComp(String ThreadName) {
		 threadName = ThreadName;
		// TODO Auto-generated constructor stub
		System.out.println("Creating : "+ threadName);
	 }
	 
	 /**
	 * This method is computation intensive
	 */
	 public void run() {
		 System.out.println("Running " + threadName);
		 
		/* // Print array before merge sort
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("Sorting an array:");
			printArray(arr,0,arr.length-1);*/
		 
		  //-------------------------------MERGE SORT-----------------------------------------------
	    
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("Sorting an array:");
			//printArray(arr,0,arr.length-1);
			System.out.println("");
			System.out.println("----------------------------------------------------------------------");
	
			//CALLING MERGE SORT function
			System.out.println(threadName + " calling merge sort");
					
			for (int a = 0; a < 250; a++) {
				mergeSort(0, arr.length - 1);
				// Print array after sorting
				System.out.println("\nArray sorted by:" + threadName);
				printArray(arr, 0, arr.length - 1);
			}		
			
			//exiting Thread
			System.out.println("Exiting : " + threadName);
	 }
	 
		// function for merge sort
		/**
		 * 
		 * @param start : starting point of array
		 * @param end : end of array = length of array
		 */
		public static void mergeSort(int start,int end)
		{
			//calculate mid 
			int mid=(start+end)/2;
			if(start<end)
			{
				// Sorting left half of array
				mergeSort(start,mid);
				// Sort right half of array
				mergeSort(mid+1,end);
				// Merge both halves of sorted array
				merge(start,mid,end);
			}
	 
		}
	 
	 
		/**
		 * 
		 * @param start : start of array
		 * @param mid : (start+end)/2
		 * @param end : end of array
		 */
		public static void merge(int start, int mid, int end) {
			// Initializing temporary array and index of array
			int[] tempArray=new int[arr.length];
			int tempArrayIndex=start;
	 
		/*	
			System.out.print("Before Merging:  ");
			printArray(arr,start,end);
	 */
			int startIndex=start;
			int midIndex=mid+1;
	 
			//loop starts from start of array to end of array
			while(startIndex<=mid && midIndex<=end)
			{
				//moving in left array till we reach mid point
				if(arr[startIndex]< arr[midIndex])
				{
					tempArray[tempArrayIndex++]=arr[startIndex++];
				}
				else
				{
					tempArray[tempArrayIndex++]=arr[midIndex++];
				}
			}
	 
			// Copy remaining elements
			while(startIndex<=mid)
			{
				tempArray[tempArrayIndex++]=arr[startIndex++];
			}
			while(midIndex<=end)
			{
				tempArray[tempArrayIndex++]=arr[midIndex++];
			}
	 
			// Copy tempArray to actual array after sorting 
			for (int i = start; i <=end; i++) {
				arr[i]=tempArray[i];
			}
	 
/*			System.out.print("After merging:   ");
			printArray(tempArray,start,end);
			System.out.println();*/
		}
	 
		/**
		 * 
		 * @param arr
		 * @param start
		 * @param end
		 */
		public static void printArray(int arr[],int start,int end)
		{
			for (int i = start; i <=end; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}