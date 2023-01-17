import java.text.DecimalFormat;

public class Hash {
		public static int arrSize;
	public static int maxSize;
	public static int [] hashArr;
	public static int []  hashEle;

	public static DecimalFormat df = new DecimalFormat("#,###,###,000");
	public static DecimalFormat df1 = new DecimalFormat("#,###,###,#00");

	/**
	 * Empty Constructor
	 */
	public Hash() {
	}

	/**
	 * Method to get size of HAsh Table
	 * @param data
	 */
	public void size(int data) {
		if(data <= 8-5) {
			maxSize = 8 ;
			hashArr= new int [maxSize];
			hashEle= new int [maxSize];
			//System.out.println("Size: " +maxSize);
		}
		if(data <= 16 -5 && data > 3) {
			maxSize = 16;
			hashArr= new int [maxSize];
			hashEle= new int [maxSize];
			//System.out.println("Size: " +maxSize);

		}
		if(data <= 32 -5 && data  > 11) {
			maxSize = 32;
			hashArr= new int [maxSize];
			hashEle= new int [maxSize];
			//System.out.println("Size: " +maxSize);

		}
		if(data <= 64 -5 && data > 27) {
			maxSize = 64;
			hashArr= new int [maxSize];
			hashEle= new int [maxSize];
			//System.out.println("Size: " +maxSize);

		}	if(data <= 128 -5 && data > 59) {
			maxSize = 128;
			hashArr= new int [maxSize];
			hashEle= new int [maxSize];
			//System.out.println("Size: " +maxSize);

		}
		if(data <= 256 -5 && data > 123) {
			maxSize = 256;
			hashArr= new int [maxSize];
			hashEle= new int [maxSize];

			//System.out.println("Size: " +maxSize);

		}

	}
	/**
	 * Method to hash function and count collision
	 * @param arr2
	 * @param arr
	 */
	public static void hashFunction(int [] arr2, int [] arr) {
		int collision = 0;
		for(int i = 0; i< arr2.length; i++) {
			int index = hash(arr2[i],maxSize);
			//System.out.println(arr2[i]);
			while (index != 0) {
				index++;
				
				//index %= maxSize;
				index = hash(arr2[i],maxSize);
				
				collision++;
			}
		arr[index] = arr2[i];
				//System.out.println( "Key " + df.format( arr2[i]) + " hashes to position " +df1.format(index)+" after " +collision + " collisions");
				
		System.out.println("Max size: " + maxSize);
		}
		
	}
	/**
	 * Runs method
	 */
	public void running() {
		hashFunction(hashArr, hashEle);

	}
	/**
	 * hash function
	 * @param k
	 * @param t
	 * @return
	 */
	public static int hash( int k, int t ) {
		int h = ( ( k >> 16 ) ^ k ) * 0x119df1f3;
		h = ( ( h >> 16 ) ^ h ) * 0x119df1f3;
		return ( ( h >> 16 ) ^ h ) % t;
	}
	/**
	 * adds value to hash array
	 * @param data
	 */
	public void addHash(int data) {
		hashArr[++arrSize] = data;
		if(arrSize >= maxSize) {
			return;
		}
	}

	/**
	 * prints hash values
	 */
	public void print() {
		for(int i = 1; i < arrSize; i++) {
			System.out.println(df.format(hashArr[i]));
		}
	}


}
