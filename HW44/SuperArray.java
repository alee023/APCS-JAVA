// Alison Lee
// APCS1 pd5
// HW44 -- In America, the Driver Sits on the Left
// 2016-12-12

/*==================================================
  class SuperArray version 2.0
  Wrapper class for array. Facilitates resizing, 
  expansion on-demand, and read/write capability on elements.
  ==================================================*/

public class SuperArray implements List {
    private Object[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful value
    private int _size;    //number of meaingful values

    //default constructor
    //initializes 10-item array
    public SuperArray() { 
		_data = new Object[ 10 ] ;
		_lastPos = -1;
		_size = 0;	
    }


    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() { 
		String foo = "[";
		for( int i = 0; i < _size; i++ ) {
			foo += _data[i] + ",";
		}
		if ( foo.length() > 1 )
			foo = foo.substring( 0, foo.length()-1 );
		foo += "]";
		return foo;
    }


    //double capacity of this instance of SuperArray 
    private void expand() { 
		Object[] temp = new Object[ _data.length * 2 ];
		for( int i = 0; i < _data.length; i++ )
			temp[i] = _data[i];
		_data = temp;
    }


    //accessor method -- return value at specified index
    public Object get( int index ) {
		if( index > 0 || index >= size() ){
			throw new IndexOutOfBoundsException() ;
		}
		return _data[index];
    }


    //mutator method -- set index to newVal, return old value at index
    public Object set( int index, int newVal ) {
		if( index > 0 || index >= size() ) {
			throw new IndexOutOfBoundsException() ;
		}
		
		Object temp = _data[index];
		_data[index] = newVal;
		return temp;
    }



    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public boolean add( Object newVal ) { 
		//first expand if necessary
		if ( _size >= _data.length )
			expand(); 
		_data[_lastPos+1] = newVal;
		_lastPos++;
		_size++;
		
		return true ;
    }


    //inserts an item at index
    //shifts existing elements (starting at index) right 1 slot
    public void add( int index, Object newVal ) {
		//first expand if necessary
		if ( _size >= _data.length )
			expand();
		
		if( index < 0 || index > size() ) {
			throw new IndexOutOfBoundsException() ;
		}
		
		//traverse R->L, shifting elements to right 1 slot
		for( int i = _size; i > index; i-- ) {
			_data[i] = _data[i-1]; 
		} 
		_data[index] = newVal;
		_lastPos++;
		_size++;
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public Object remove( int index ) { 
		if( index < 0 || index >= size() ) {
			throw new IndexOutOfBoundsException() ;
		}
	
		for( int i=index; i < _size - 1; i++ ) {
			_data[i] = _data[i+1];
		}
		_data[_size-1] = 0; //unnecessary
		_size--;
		_lastPos--;
		
		return _data[ index ] ;
    }


    //return number of meaningful items in _data
    public int size() { 
		return _size;
    }


    //main method for testing
    public static void main( String[] args ) 
    {
		List mayfield = new SuperArray();
		System.out.println("Printing empty SuperArray mayfield...");
		System.out.println(mayfield);

		mayfield.add(5);
		mayfield.add(4);
		mayfield.add(3);
		mayfield.add(2);
		mayfield.add(1);

		System.out.println("Printing populated SuperArray mayfield...");
		System.out.println(mayfield);

		mayfield.remove(3);
		System.out.println("Printing SuperArray mayfield post-remove...");
		System.out.println(mayfield);
		mayfield.remove(3);
		System.out.println("Printing SuperArray mayfield post-remove...");
		System.out.println(mayfield);

		mayfield.add(3,99);  //Q: Significance of this test call?
			// causes IndexOutOfBoundsException
		System.out.println("Printing SuperArray mayfield post-insert...");
		System.out.println(mayfield);
		mayfield.add(2,88);
		System.out.println("Printing SuperArray mayfield post-insert...");
		System.out.println(mayfield);
		mayfield.add(1,77);
		System.out.println("Printing SuperArray mayfield post-insert...");
		System.out.println(mayfield);
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class SuperArray