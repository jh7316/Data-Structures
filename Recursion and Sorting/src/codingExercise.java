public class codingExercise {
	
	
	//Section 1: Arrays
	
	
	//Exercise 1: Check if reversed 
	public static int isReverse(String a, String b) {
		//remove all white spaces, ignore upper cases 
		String aNew=a.replaceAll(" ","").toLowerCase();
		
		//create new string to store reverse of a
		String aReverse=""; 
	
		//using reversed for loop, add characters of a into aReverse in a reverse order 
		for(int i=a.length()-1;i>-1;i--) {
			aReverse+=aNew.charAt(i);
		}
		
		//check if b equals the reverse of a
		if(aReverse.equals(b.replaceAll(" ","").toLowerCase())) {
			return 1;
		}else {
			return 0;
		}
		
	}
	
	
	//Exercise 2: Leave shortest words 
	public static String shortestWords(String a) {
		
		//Create empty string to store the shortest words 
		String finalStr="";
		
		//split the string by empty spaces and store the words into an array 
		String[] Arr1=a.split(" ");
		for(int i=0;i<(Arr1.length/3);i++) {
			//first, set the first of the three words as the (local) shortest word 
			String x=Arr1[i*3];
			
			//using if statement, change the shortest word if the next word is shorter than the current shortest word 
			if(x.length()>Arr1[i*3+1].length()) {
				x=Arr1[i*3+1];
			}
			if(x.length()>Arr1[i*3+2].length()) {
				x=Arr1[i*3+2];
			}
			
			//add the shortest word to the final string 
			finalStr+= x+" ";

		}
		
		return finalStr;
		
		
	}
	
	
	//Section 2: Recursion 
	
	
	//Exercise 1: Finding maximum number 
	public static double findMax(double[] x, int start, int end) {
		
		
		//Base case: if the array is split up until the end and there is nothing more to split, return the element of the given index 
		if(end==start) {
			return x[start];
		}
		
		//Calculate the current middle index 
		int mid=(start+end)/2;
		
		//divide the array into two and execute findMax on both subarrays 
		double max1=findMax(x,start,mid);
		double max2=findMax(x,mid+1,end);
		
		//comparison 
		if(max1>=max2) {
			return max1;
		}else {
			return max2;
		}
	

}
	
	
	//Exercise 2: Number of zeros in the binary representations of N 
	// I used the fact that the number of zeros of an integer n is equal to that of n//2, and plus one if n is even. 
	public static int numZeros(int n) {
		if(n==0) {
			return 1;
		}else if(n==1) {
			return 0;
		}else {
			return numZeros(n/2)+numZeros(n%2);
		}
	  
	}
	
	//Exercise 3: Check if a word is palindrome 
	public static  boolean isPalindrome(String x) {
		
		 if(x.length()<=1) {
			 //base case: 
			 //when it reaches the end, it means the word is palindrome. Return true 
			 return true;
		 }
	     if(x.charAt(0) == x.charAt(x.length()-1)) {
	    	 //recursion: 
	    	 //if the first and last characters match, then move on to the second and second last characters, and so on. 
	    	 return isPalindrome(x.substring(1, x.length()-1));
	     }else {
	    	 //if they do not match, the word is not a palindrome. 
	    	 return false;
	     }
	}
	
	
	
	//Section 3: Sorting
	
	//1. Bubble sort non-recursive
	public static double[] bubble1(double [] x) {
		
			for(int i=0;i<x.length-1;i++) {
				for(int j=0;j<x.length-1-i;j++)
				//check if the current element is greater than the next element 
				if(x[j]>x[j+1]) {
				    //swap the elements 
					double t=x[j];
					x[j]=x[j+1];
					x[j+1]=t;
				}
			}
	
		return x;
		
	}
	
	
	//2. Bubble sort recursive 
	
	//Assumption: i is 0, n is length of the array x minus one 
	public static double[] bubble2(double[] x, int i, int n) {
		//base case: if n has reached 0, end the recursion 
		if(n==0) {
			return x;
		}

		//recursion 
		
		//compare the current and next element 
		if(x[i]>x[i+1]) {
			double temp=x[i];
			x[i]=x[i+1];
			x[i+1]=temp;
		}
		
		//increment i, move onto the next element 
		i++;
		
		
		
		//if i has reached the end of the array, disregard the last element and repeat the process for the first n-1 elements.  
		if(i==n) {
			i=0;
			n--;
		}
		
		
		
		return bubble2(x, i,n);
		
	}
	
	//3. Selection sort
	
	public static double[] selection(double[] x) {
		
		//iterate from the first to second last element 
		for(int i=0;i<x.length-2;i++) {
			
			// as default, set the index of the minimum element as i
			int minIndex=i;
			//iterate from i+1th to the last element, and check if an element is smaller than the current minimum element 
			for(int j=i+1;j<x.length-1;j++){
				
				if(x[j]<x[minIndex]) {
					minIndex=j;
				}
			}
			//swap the ith element with the minimum element 
			double temp=x[i];
			x[i]=x[minIndex];
			x[minIndex]=temp;
		}
		
		return x;
	}
	
	
	
	//4. Insertion sort
	
	public static double[] insertion(double[] x) {
		
		//iterating from the second to the last element 
		for(int i=1;i<x.length-1;i++) {
			int j=i-1;
			//while the current element is greater then the ith element, shift the element to the right 
			while(x[j]>x[i]&&j>=0) {
				x[j+1]=x[j];
				j--;
			}
			x[j+1]=x[i];
		}
		
		return x;
		
		
	}
	
	
	//5. Merge sort
	
	
	//merge method: it merges the 2 arrays l and r into the given array x, in an ascending order. 
	public static void merge(double[] x, double[] l, double [] r) {
		int i=0;
		int j=0;
		
		
		while(i<l.length&&j<r.length){
			
			//compares l[i] and r[j], then inserts the smaller one into the array x
			if(l[i]<r[j]) {
				x[i+j]=l[i];
				i++;
			}else {
				x[i+j]=r[j];
				j++;
			}
		}
		
		//insert the remaining elements from either l or r
		while(i<l.length) {
			x[i+j]=l[i];
			i++;
		}
		while(j<r.length) {
			x[i+j]=r[j];
			j++;
		}
	   
		
		
	}
	
	
	//mergeSort method: recursive
	public static void mergeSort(double[] x, int n) {
		
		//base case
	    if (n<2) {
	        return;
	    }
	    
	    //define the current middle index 
	    int mid = n/2;
	    
	    //divide the array into two subarrays l and r using the index mid
	    double[] l = new double[mid];
	    double[] r = new double[n-mid];

	    for (int i=0; i<mid;i++) {
	        l[i]=x[i];
	    }
	    for (int i=mid; i<n; i++) {
	        r[i-mid] = x[i];
	    }
	    
	    //recursive case: repeat the dividing process 
	    mergeSort(l, mid);
	    mergeSort(r, n-mid);
	    
	    //merging process 
	    merge(x, l, r);
	}
	
	
	
	//6. Quick sort
	
	
	//partition method : process of choosing a pivot and putting all smaller elements to the left and larger elements to the right 
	public static int partition(double[] x, int first, int last) {
		
		//last element is chosen as a pivot as default 
		double piv=x[last];
	     
	    int i=first-1;
	 
	    for(int j=first; j<last; j++)
	    {
	        if (x[j]<piv)
	        {
	            i++;
	            double temp=x[i];
	            x[i]=x[j];
	            x[j]=temp;
	        }
	    }
	    
	    double temp1=x[last];
	    x[last]=x[i+1];
	    x[i+1]=temp1;
	    
	    return i+1;
		
		
	}

	
	//quickSort method: recursive 
	public static void quickSort(double[] x, int first, int last ) {
		
		//the recursive process continues only when first index < last index. 
		if (first<last) {
	        int p = partition(x, first, last);

	        quickSort(x, first, p-1);
	        quickSort(x, p+1, last);
	    }
	
		
	}
	
	
	public static void main(String[] args) {
		//test for Arrays: Exercise One 
		System.out.println(isReverse("elgoog","google"));
		System.out.println(isReverse("data","ata"));
		
		//test for Arrays: Exercise Two 
		System.out.println(shortestWords("Other entries include a historic district in Charlottesville Virginia cut-flower greenhouse complex"));
		
		
		double[] testArr1= {5,1,2,4,46,75,23,5};
		
		//test for Recursion: Exercise One 
		System.out.println(findMax(testArr1, 0, 7));
		
		//test for Recursion: Exercise Two 
		System.out.println(numZeros(97));
		
		//test for Recursion: Exercise Three
		System.out.println(isPalindrome("kayak"));
		
		
		double[] testArr2= {4,77,98,30,20,50,77,22,49,2};
		
		//test for Sorting: 
		//1. Bubble Sort Non-Recursive
		double[] bubble1Test = bubble1(testArr2);
		for(int i=0;i<10;i++) {
			System.out.print(bubble1Test[i]+" ");
		}
		System.out.println();
		
		
		
		//2. Bubble Sort Recursive 
		double[] bubble2Test = bubble2(testArr2, 0, 9);
		for(int i=0;i<10;i++) {
			System.out.print(bubble2Test[i]+" ");
		}
		System.out.println();
		
		
		
		//3. Selection Sort
		double[] selectionTest = selection(testArr2);
		for(int i=0;i<10;i++) {
			System.out.print(selectionTest[i]+" ");
		}
		System.out.println();
		
		//4. Insertion Sort
		double[] insertionTest = insertion(testArr2);
		for(int i=0;i<10;i++) {
			System.out.print(insertionTest[i]+" ");
		}
		System.out.println();
		
		
		
		//5. Merge Sort
		double[] testArr2Merge= {4,77,98,30,20,50,77,22,49,2};
		mergeSort(testArr2Merge,10);
		for(int i=0;i<10;i++) {
			System.out.print(testArr2Merge[i]+" ");
		}
		System.out.println();
		
		
		
		
		//6. Quick Sort 
		double[] testArr2Quick= {4,77,98,30,20,50,77,22,49,2};
		quickSort(testArr2Quick,0,9);
		for(int i=0;i<10;i++) {
			System.out.print(testArr2Quick[i]+" ");
		}
	
		
		
		
		
		
	}
	
	
	
}