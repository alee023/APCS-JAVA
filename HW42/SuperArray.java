//Team AB -- Alison Lee, Brooke Jin
//APCS1 pd5
//HW42 -- Array of Grade 316
//2016-12-09

/*==================================================
  class SuperArray version 1.0
  Wrapper class for array. Facilitates resizing, 
  expansion, and read/write capability on elements.
  ==================================================*/

public class SuperArray 
{
    private int[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful value
    private int _size;    //number of meaingful values

    //default constructor
    //initializes 10-item array
    public SuperArray() 
    { 
        _data = new int[10];
    }

    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() 
    {
		String retStr = "[";
		for (int n: _data) {
			retStr += n + ", ";
	}
		retStr = retStr.substring(0,retStr.length()-2);
		retStr += "]";
		return retStr;
    }

    //double capacity of this instance of SuperArray 
    private void expand() 
    { 
        int[] doubleData = new int[_data.length * 2];
		for (int n = 0; n < _data.length; n++) {
			doubleData[n] = _data[n];
		}
		_data = doubleData;
    }
    
    //accessor method -- return value at specified index
    public int get( int index ) 
    {
        return _data[index];
    }

    //mutator method -- set index to newVal, return old value at index
    public int set( int index, int newVal ) 
    {
		int oldVal = get(index);
		_data[index] = newVal;
		return oldVal;
    }

    //adds an item after the last item
    public void add(int newVal) {
		if (_lastPos < _data.length-1) {
			_data[ _lastPos + 1 ] = newVal ;
			_lastPos += 1;
		}
		else {
			int[] arr = new int[_data.length + 1];
			for (int i = 0; i < _data.length; i++) {
				arr[i] = _data[i];
			}
			_data = arr;

			_data[_data.length] = newVal;
			_lastPos += 1;
			_size += 1;
		}
    }

    //inserts an item at index
    //shifts existing elements to the right
    public void add(int index, int newVal) {
		int[] arr = new int[_data.length + 1];
		for (int i = 0; i < _data.length-1; i++) {
			if (i < index) {
				arr[i] = _data[i];
			}
			else if (i == index) {
				arr[i] = newVal;
			}
			else { //i > index
				arr[i] = _data[i-1];
			}
		}
		_data = arr;
    }

    //removes the item at index
    //shifts elements left to fill in newly emptied slot
    public void remove(int index) {
		for (int i = index; i < _data.length-1; i++) {
			_data[i] = _data[i+1];
		}
		int[] temp = new int[_data.length-1];
		for (int n = 0; n < temp.length; n++) {
			temp[n] = _data[n];
		}
		_data = temp;
    }

    //returns number of meaningful items in _data
    public int size() {
		int[] temp = new int[_data.length];
		int sizeArr = _data.length;
		for (int n = _data.length-1; n >= 0; n--) {
			if (_data[n] == 0) {
				sizeArr -= 1;
			}
			else {
			break;
			}
		}
		_size = sizeArr;
		return sizeArr;
    }

    //main method for testing
    public static void main( String[] args ) 
    {
	
		SuperArray curtis = new SuperArray();
		System.out.println("Printing empty SuperArray curtis...");
		System.out.println(curtis);

		for( int i = 0; i < curtis._data.length; i++ ) {
			curtis.set(i,i*2);
			curtis._size++;
		}

		System.out.println("Printing populated SuperArray curtis...");
		System.out.println(curtis);

		SuperArray mayfield = new SuperArray();
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

		mayfield.add(3,99);
		System.out.println("Printing SuperArray mayfield post-insert...");
		System.out.println(mayfield);
		mayfield.add(2,88);
		System.out.println("Printing SuperArray mayfield post-insert...");
		System.out.println(mayfield);
		mayfield.add(1,77);
		System.out.println("Printing SuperArray mayfield post-insert...");
		System.out.println(mayfield);
       
    }//end main()

}//end class SuperArray
