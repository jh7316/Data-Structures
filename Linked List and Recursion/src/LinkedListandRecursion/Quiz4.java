package LinkedListandRecursion;

import java.util.LinkedList;
import java.util.NoSuchElementException;



class Link
	{
	public int iData;              // data item
	public double dData;           // data item


	public Link next;              // next link in list
	//-------------------------------------------------------------
	public Link(int id, double dd) // constructor
	   {
	   iData = id;                 // initialize data
	   dData = dd;                 // ('next' is automatically
	   }                           //  set to null)
	//-------------------------------------------------------------



	public void displayLink()      // display ourself
	   {
	   System.out.print("{" + iData + ", " + dData + "} ");
	   }
	}  // end class Link
	////////////////////////////////////////////////////////////////



	class LinkList
	{
	private Link first;            // ref to first link on list

	//-------------------------------------------------------------
	public LinkList()              // constructor
	   {
	   first = null;               // no links on list yet
	   }
	//-------------------------------------------------------------
	public boolean isEmpty()       // true if list is empty
	   {
	   return (first==null);
	   }
	//-------------------------------------------------------------
	//insert at start of list
	public void insertFirst(int id, double dd)
	   {                           
	      Link newLink = new Link(id,dd);
	      newLink.next=first;
	      first=newLink;
		  
	   }  
	//-------------------------------------------------------------
	public Link deleteFirst()     
	   {                           
		 if (first == null)
		throw new NoSuchElementException(); 
		  Link Deleted = first;
		  first=first.next;
		  return Deleted;
		  
	   }	  
	//-------------------------------------------------------------
	public void displayList()
	   {
	   
	   //display all the elements in the lists
	   System.out.println("List: first-->Last");
	   Link current=first;
	   while(current!=null) {
		   current.displayLink();
		   current=current.next;
	   }
		
		System.out.println("");
		
	   }
		 
		// ------------------------------------------------------------- 
		 
	//-------------------------------------------------------------
	public void displaytheLastNODEiData()
	   {
	   
	   //display the last node's iData
		Link current=first;
		 while(current.next!=null) {
			   current=current.next;
		   }
		 
		 System.out.println(current.iData);
			

	   }
	 
	//------------------------------------------------------------- 
	 
		public int findMin(){


	 //returns the minimum iData in the list
		int minIData=first.iData;
		Link current=first;
		while(current.next!=null) {
			if(current.next.iData<minIData) {
				minIData=current.next.iData;
			}
			current=current.next;
			
		}
		return minIData;

	} 
		 
	//------------------------------------------------------------- 
		
	//This method is not originally included, but added as an additional method
	public Link delete(int key)    // delete link with given key
	     {                           // (assumes non-empty list)
	     Link current = first;              // search for link
	     Link previous = first;
	     while(current.iData != key)
	        {
	        if(current.next == null)
	           return null;                 // didn't find it
	        else
	           {
	           previous = current;          // go to next link
	           current = current.next;
	           }
	        }                               // found it
	     if(current == first)               // if first link,
	        first = first.next;             //    change first
	     else                               // otherwise,
	        previous.next = current.next;   //    bypass it
	     return current;
	     }
	//------------------------------------------------------------- 
	 
	public void DeleteElementwithiData(int a){

	 //this method will delete any node with iData == a. 
	 //if there are many, the method will have to delete all of them.
	 Link current = first; 
	 Link previous = first; 
	 while(current!=null) {
		 if(current.iData==a) {
			 if(current==first) {
				 first=first.next;
				 previous=first.next;
			 }else {
				 previous.next=current.next;
			 }
			
		 }
		 
		 previous = current;
		 current = current.next;
		 
	 }
		
	 
	} 
	 
	//------------------------------------------------------------- 
	 	 
	public void removeDuplicates(){


	 //this method will scan through the list and remove 
	 //duplicates. (if the list is: 2->3->2->4->3->5->90 the method should
	 //keep on copy of each duplicate, so the list become:
	 //2->3->4->5-90
	 //if there are no duplicates then the method does not need do anything
		
		
		Link current=first;
		Link current1=null;
		Link current1prev=null;

		while(current!=null) {
			current1=current.next;
			current1prev=current;
			while(current1!=null) {
				if(current1.iData==current.iData) {
				        current1prev.next = current1.next;
					
				}
				current1prev=current1prev.next;
				current1=current1.next;
			}
			current=current.next;
		
		}

	} 
		 
	//-------------------------------------------------------------

	public void sortList(){


	//write an algorithm that I will sort the list in-place
	//do not use arrays. 
		//using bubble sort: 
		 Link current = first, index = null;
		 
	     int temp;

	     if (first == null) {
	         return;
	     }
	     else {
	         while (current != null) {
	             // Node index will point to node next to
	             // current
	             index = current.next;

	             while (index != null) {
	                 // If current node's data is greater
	                 // than index's node data, swap the data
	                 // between them
	                 if (current.iData > index.iData) {
	                     temp = current.iData;
	                     current.iData = index.iData;
	                     index.iData = temp;
	                 }

	                 index = index.next;
	             }
	             current = current.next;
	         }
	     }
		
		
		
		

	}}
	

	 // end class LinkList
	////////////////////////////////////////////////////////////////

	     // end main()

class Quiz4{
	public static void main(String[] args)
	   {
	   LinkList theList = new LinkList();  // make new list
	   //this code is for you to use to test you code
	   //feel free to modify it. 

	   theList.insertFirst(22, 8.99);  
	   theList.insertFirst(77, 2.99);// insert four items
	   theList.insertFirst(66, 6.99);
	   theList.insertFirst(44, 2.99);
	   theList.insertFirst(77, 2.99);
	   theList.insertFirst(55, 2.99);
	   theList.insertFirst(12, 8.99);
	   theList.insertFirst(66, 8.99);
	   //... add more elements if you want..


	   //CALL and TEST YOUR METHODS HERE 
	   //theList.DeleteElementwithiData(22);
	   theList.removeDuplicates();
	   theList.DeleteElementwithiData(22);
	   theList.sortList();
	   
	   theList.displaytheLastNODEiData();
	   
	   int i = theList.findMin();
	   System.out.println("Smallest iData:"+i);
	   
	   theList.displayList();
	   

	                // end class LinkListApp
	////////////////////////////////////////////////////////////////
	   }}


