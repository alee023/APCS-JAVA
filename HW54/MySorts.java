// Alison Lee
// APCS1 pd5
// HW54 -- Never Fear, Big O Is Here!
// 2017-01-04


import java.util.ArrayList;

public class MySorts {

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
		ArrayList<Integer> retAL = new ArrayList<Integer>();
		while( size > 0 ) {
			//     offset + rand int on interval [lo,hi]
			retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
			size--;
		}
		return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
		int randomIndex;
		//setup for traversal fr right to left
		for( int i = al.size()-1; i > 0; i-- ) {
			//pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
			//swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	
    // BUBBLE SORT
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
	
	/* This sorting algorithm looks at the first element (i=0)first. It compares it to the element right after it (at index 1). If data[i] is more than that (data[i+1]), then they will be swapped.
	
	If the size of data increases, then the # of comparisons per pass will increase to size-1. The number of passes will also increase, to size-1. O(x^2) */
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> data ) {
		int passes = 0 ;
		// an unsorted list should have size - 1 passes
		while( passes < data.size() - 1 ) {
			for( int i = 0 ; i < data.size() - 1 ; i ++ ) {
				if( data.get( i ).compareTo( data.get( i + 1 )) > 0 ) {
					data.set( i , data.set( i + 1 , data.get( i )) );   
				}
			}
			passes += 1 ;
		}
		
		ArrayList<Comparable> arr = new ArrayList<Comparable>( data ) ;
		return arr ;
    }//end bubbleSort
	
	// ===================================================================
	
	// SELECTION SORT
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order 
	/* This algorithm will first find and "select" (as in store the index of) the smallest element in data after iterating through it. Knowing it to be the smallest, it will swap with the first element. Afterwards, it finds the second smallest element, and swap with the second element. Third swaps with third, and so on. As it works, the array gets sorted from left to right.
		
	If the size of data increases, it will have to parse through a larger set finding the minimum. HOWEVER, it seems to be more efficient than bubbleSort. The number of passes and things to compare both do increase, similar to bubbleSort's situation. O(x^2)*/
    public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> data ) {
	//note: this version places greatest value at rightmost end,
	//maxPos will point to position of SELECTION (greatest value)
		int maxPos ;
		int passes = 0 ;
		while( passes < data.size() - 1 ) {
			maxPos = 0 ;
			for( int i = 0 ; i < data.size() - passes ; i ++ ) {
				if( data.get( i ).compareTo( data.get( maxPos )) > 0 ) {
					maxPos = i ;
				}
			}
			data.set( maxPos , data.set( data.size() - 1 - passes , data.get( maxPos ) ) ) ;
			
			passes += 1 ;
		}
		
		ArrayList<Comparable> arr = new ArrayList<Comparable>( data ) ;
		return arr ;
	}
    //end selectionSort
	
	// ===================================================================
	
	// INSERTION SORT
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
	/* There is a sorted and unsorted area with a partition (index) that increases. This algorithm compares the element at THAT index (i) to the element right before it data[i-1]. If it is less than the one before it, it will compare itself to the the element before the previous data[i-2]. It will continue until it is greater than the element at data[i-n]. Once it does, it will swap itself with data[i-n+1]. The partition moves down.
	
	If the size of data increases, the # of comparisons will increase inside each pass which will increase as well. O(n^2)*/
    public static ArrayList<Comparable> insertionSort( ArrayList<Comparable> data ) {
		int passes = 0 ;
		int part = 1 ;
		// the position of the number originally at position part.		
		int current ; 
		
		while( passes < data.size() - 1 ) {
			current = part ;
			int x = 0 ;
			boolean y = true ;
			while( x < part && y == true ) {
				if( data.get( current ).compareTo( data.get( current - 1 )) < 0 ) {
					data.set( current , data.set( current - 1 , data.get( current ))) ;
					current -= 1 ;
				} 
				else {
					y = false ;
				}
				x ++ ;
			}
			
			passes += 1 ;
			part += 1 ;
		}
		
		ArrayList<Comparable> arr = new ArrayList<Comparable>( data ) ;
		return arr ;
    }//end insertionSortV
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static void main(String [] args)
    {
		/*
		ArrayList glen = new ArrayList<Integer>();
		glen.add(7);
		glen.add(1);
		glen.add(5);
		glen.add(12);
		glen.add(3);
		System.out.println( "ArrayList glen before sorting:\n" + glen );
		ArrayList glenSorted = bubbleSort( glen );
		System.out.println( "sorted version of ArrayList glen:\n" 
		+ glenSorted );
		System.out.println( "ArrayList glen after sorting:\n" + glen );
		*/
		
		
		ArrayList coco = populate( 10, 1, 1000 );
		System.out.println( "ArrayList coco before sorting:\n" + coco );;
		ArrayList cocoSorted = bubbleSort( coco );
		System.out.println( "sorted version of ArrayList coco:\n" 
		+ cocoSorted );
		System.out.println( "ArrayList coco after sorting:\n" + coco );
		
    }//end main
	

}//end class BubbleSort
