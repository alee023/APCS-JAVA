// Alison Lee
// APCS1 pd5
// HW46 -- ascending
// 2016-12-14

/*============================================
  class OrderedArrayList
  Wrapper class for ArrayList.
  Imposes the restriction that stored items 
  must remain sorted in ascending order
  ============================================*/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;


public class OrderedArrayList {

    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;


    // default constructor initializes instance variable _data
    public OrderedArrayList() {
		_data = new ArrayList< Comparable>() ;
    }


    public String toString() { 
		return _data.toString() ;
    }


    public Comparable remove( int index ) { 
		return _data.remove( index ) ;
    }


    public int size() { 
		return _data.size() ;
    }

    
    public Comparable get( int index ) { 
		return _data.get( index ) ;
    }


    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public void addLinear( Comparable newVal ) { 
		// if _data is empty, the for loop will not run so we will have to add the value. This if block should be executed only one time - for the first valToAdd
		if( _data.size() == 0 ) { // if _data is empty
			_data.add( newVal ) ;
		}
		
		// if _data isn't empty. Meaning that the above if block was already executed
		else {
			for( int i = 0 ; i <_data.size() ; i ++ ) {
				// if newVal < _data[ i ], newVal is greater than the _data[ indices before i ], so newVal should be inserted at position i
				if( newVal.compareTo( _data.get( i )) < 0 ) {
					_data.add( i , newVal ) ;
					break ;
				}
				
				// but what if newVal is greater than ALL the values in _data? The if block right above will not execute. You'll have to add newVal to the end of _data
				else if( newVal.compareTo( _data.get( _data.size() - 1 )) > 0 ) {
					_data.add( newVal ) ;
					break ;
				}
			}
		}
    }


    // main method solely for testing purposes
    public static void main( String[] args ) {
		
		OrderedArrayList Franz = new OrderedArrayList();

		System.out.println("\nValues to add via addLinear() calls:");

		// testing linear search
		for( int i = 0; i < 15; i++ ) {
			int valToAdd = (int)( 50 * Math.random() );
			System.out.println( valToAdd );
			Franz.addLinear( valToAdd );
		}

		System.out.println("\nafter population via addLinear() calls:");
		System.out.println( Franz );
		System.out.println();

    }

}//end class OrderedArrayList
 
