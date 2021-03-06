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
	_data = new ArrayList<Comparable>();
    }


    public String toString() { 
		return _data.toString(); 
    }


    public Comparable remove( int index ) { 
		return _data.remove(index); 
    }


    public int size() { 
		return _data.size();
    }

    
    public Comparable get( int index ) { 
		return _data.get(index); 
    }


    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public void addLinear( Comparable newVal ) { 
		for( int p = 0; p < _data.size(); p++ ) {
			if ( newVal.compareTo( _data.get(p) ) < 0 ) { 
			//newVal < oal[p]
			_data.add( p, newVal );
			return; //Q:why not break?
			}
		}
		_data.add( newVal ); //newVal > every item in oal, so add to end
    }

	public void addBinary( Comparable newVal ) {
		int start =  0 ;
		int end = _data.size() - 1 ; // inclusive 
		int mid = ( int )(( start + end ) / 2 );
		
		if( _data.size() == 0 ) {
			_data.add( newVal) ;
		}
		else {
			while(( start != end ) && ( newVal.compareTo( _data.get( mid )) != 0 ) ) {
				if( newVal.compareTo( _data.get( mid )) > 0 ) { // newVal > middle
					start = mid + 1 ;
				}
				else if( newVal.compareTo( _data.get( mid )) < 0 ) { // newVal < mid
					end = mid - 1 ;
				}
				mid = ( int )(( start + end ) / 2 ) ;
			}
			
			if( newVal.compareTo( _data.get( start ) ) > 0 ) {
				_data.add( start + 1 , newVal ) ;
			}
			else {
				_data.add( start , newVal ) ;
			}
		}
	}
	
    // main method solely for testing purposes
    public static void main( String[] args ) {

		OrderedArrayList Franz = new OrderedArrayList();

		// testing linear search
		for( int i = 0; i < 5; i++ ) {
			Franz.addLinear( (int)( 50 * Math.random() ) );
			System.out.println( Franz ); 
		}
		
		
		Franz.addBinary(( int )( 50 * Math.random() ) ) ;
		System.out.println( Franz ) ;
	}

}//end class OrderedArrayList
