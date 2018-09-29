package java_questions;

import java.util.HashSet;

public class Cesar_desafio {
	
  //*************QUESTION 1.   Replacing characters in place:
  /* Time complexity:
   * O(length) - Walking original string
   * O(1) - Creating target string incrementally
   */
  /* Space complexity:
   * O(n + m) - n= length, m = 2*number of spaces
   */
  public static char[] replaceSpaceInString(char[] str, int length) {
    int spaceCounter = 0;

    //First lets calculate number of spaces
    for (int i = 0; i < length; i++) {
      if (str[i] == ' ') 
        spaceCounter++;
    }

    //calculate new size
    int newLength = length + 2*spaceCounter;

    char[] newArray = new char[newLength+1];
    newArray[newLength] = '\0';

    int newArrayPosition = 0;

    for (int i = 0; i < length; i++) {
      if (str[i] == ' ') {
        newArray[newArrayPosition] = '&';
    newArray[newArrayPosition+1] = '3';
    newArray[newArrayPosition+2] = '2';
    newArrayPosition = newArrayPosition + 3;
      }
      else {
    newArray[newArrayPosition] = str[i];
    newArrayPosition++;
      }
    }               
    return newArray;
  }
  
  //*************QUESTION 2. Check words with jumbled letters :
  /* Time complexity:
   * O(length) - Walking original string
   */
  /* Space complexity:
   * O(2*n) - n= length String
   */
  public static boolean partialPermutation(String firstString, String secondString){

    //Checking if either string is empty.
    if(firstString.isEmpty() || secondString.isEmpty())
        return false;

    //Checking if one string is larger than the other.
    if (firstString.length() != secondString.length()) 
    	return false;
     

    //same first letter
    if (firstString.charAt(0) != secondString.charAt(0))
      return false;
    
    int length = firstString.length();
    
    //if more than 3 letters
    if (length>3){ 

      int contPermutation = 0;
      //Now you begin comparing each char in the Strings.
      // Begin iterating at the same char increase permutation counting
      //otherwise continue iterating.
      for (int i = 0; i < length; i++){
    	if(firstString.charAt(i) != secondString.charAt(i))
    			contPermutation++;
      }
    	
      //if permutation counting is up to 2/3 of the letters return false 
      if (contPermutation > (2*length/3))
    		return false;
    }
    return true;
  }

	//*************QUESTION3. Check words with typos:
    /*Time complexity: O(n)
      Auxiliary Space: O(1)
    */
	public static boolean oneOrZeroTypos(String s1, String s2) {
	   
		// Find lengths of given strings
	   int m = s1.length(), n = s2.length();
	
	   // If difference between lengths is 
	   // more than 1, then strings can't 
	   // be at one distance
	   if (Math.abs(m - n) > 1)
	       return false;
	
	   int count = 0; // Count of edits
	
	   int i = 0, j = 0;
	   while (i < m && j < n)
	   {
	       // If current characters don't match
	       if (s1.charAt(i) != s2.charAt(j))
	       {
	           if (count == 1)
	               return false;
	
	           // If length of one string is
	           // more, then only possible edit
	           // is to remove a character
	           if (m > n)
	               i++;
	           else if (m< n)
	               j++;
	           else // Iflengths of both strings
	               // is same
	           {
	               i++;
	               j++;
	           }
	            
	           // Increment count of edits 
	           count++;
	       }
	
	       else // If current characters match
	       {
	           i++;
	           j++;
	       }
	   }
	
	   // If last character is extra 
	   // in any string
	   if (i < m || j < n)
	       count++;
	
	   return count == 1;
	}

	//*************QUESTION 4. It's the MPPSearchView android application itself

	static class node
	{
		String message;
		node next;

		public node(String message)
		{
			this.message = message;
		}
	}

	//*************5. Remove duplicates on email thread
	/*Time complexity: O(n)
	Auxiliary Space: O(n)*/
	static void removeDuplicate(node head)
	{
		// Hash to store seen values
		HashSet<String> hs = new HashSet<>();

		/* Pick elements one by one */
		node current = head;
		node prev = null;
		while (current != null)
		{
			String curval = current.message;

			// If current value is seen before
			if (hs.contains(curval)) {
				prev.next = current.next;
			} else {
				hs.add(curval);
				prev = current;
			}
			current = current.next;
		}

	}

	/* Function to print nodes in a given linked list */
	static void printList(node head)
	{
		while (head != null)
		{
			System.out.print(head.message + " ");
			head = head.next;
		}
	}

	//*************QUESTION 6. Not Enough Time to do it

	//*************QUESTION 7. Check for Linked List Intersection
	/*Time complexity: O(n+m) where n = size of first list, m= size of second list
	 * Space Complexity: O(n)
	 */
	static node intersecNode(node list1, node list2)
	{
		// Hash to store seen values
		HashSet<String> hs = new HashSet<>();

		/* Pick elements one by one */
		node current = list1;
		node prev = null;
		while (current != null)
		{
			String curval = current.message;

			// If current value is seen before
			if (!hs.contains(curval)) {
				hs.add(curval);
			}
			current = current.next;
		}

		boolean found = false;
		current = list2;
		while ((current != null) || found == true)
		{
			String curval = current.message;

			// If current value is seen before
			if (hs.contains(curval)) {
				return current;
			}
			current = current.next;
		}
		return null;

	}

	/*  public static void main(String[] args) {
		char[] teste1 = {'U','s','e','r',' ','i','s',' ','n','o','t',' ','a','l','l','o','w','e','d',' '};
	    //expected: “User&32is&32not&32allowed”
		System.out.println(replaceSpaceInString(teste1, 19));

		char[] teste2 = {'a','b','c','d',' ','e','f','g',' ','h',' ','j'};
	    System.out.println(replaceSpaceInString(teste2, teste2.length));

	    //expected: you, yuo -> true
	    System.out.println(partialPermutation("you","yuo"));

	    //expected: probably, porbalby -> true
	    System.out.println(partialPermutation("probably","porbalby"));

	    //expected: despite, desptie -> true
	    System.out.println(partialPermutation("despite","desptie"));

	    //expected: moon, nmoo -> false
	    System.out.println(partialPermutation("moon","nmoo"));


	    //expected: misspellings, mpeissngslli -> false
	    System.out.println(partialPermutation("misspellings","mpeissngslli"));

	    //expected: pale, ple -> true
	    System.out.println(oneOrZeroTypos("pale","ple"));

	    //expected: pales, pale -> true
	    System.out.println(oneOrZeroTypos("pales","pale"));

	    //expected: pale, bale -> true
	    System.out.println(oneOrZeroTypos("pale","bale"));

	    //expected: pale, bake -> true
	    System.out.println(oneOrZeroTypos("pale","bake"));


        // The constructed linked list is:
        //10->12->11->11->12->11->10
	node start = new node("message10");
	start.next = new node("message12");
	start.next.next = new node("message11");
	start.next.next.next = new node("message11");
	start.next.next.next.next = new node("message12");
	start.next.next.next.next.next = new node("message11");
	start.next.next.next.next.next.next = new node("message10");

       System.out.println("Linked list before removing duplicates :");
	printList(start);

	removeDuplicate(start);

       System.out.println("\nLinked list after removing duplicates :");
	printList(start);

	node list1 = new node("messageC");
	list1.next = new node("messageA");
	list1.next.next = new node("messageE");
	list1.next.next.next = new node("messageH");
	list1.next.next.next.next = new node("messageJ");
	list1.next.next.next.next.next = new node("messageB");
	list1.next.next.next.next.next.next = new node("messageA");

	node list2 = new node("messageD");
	list2.next = new node("messageF");
	list2.next.next = new node("messageJ");
	list2.next.next.next = new node("messageB");
	list2.next.next.next.next = new node("messageA");
       System.out.println("\nFisrt nLinked list:");
	printList(list1);
       System.out.println("\nSecond nLinked list:");
	printList(list2);
	node intersec = intersecNode(list1, list2);
       System.out.println("\nIntersec Node:");
	printList(intersec);
}*/


}
