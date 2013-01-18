import java.io.Serializable;


public class MyHashMap  implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7592092319126471809L;
	
	private static final float DEFAULT_LOAD_FACTOR=0.75f;
	
	//The number of key value pairs contained in this Map
	transient int size;
	
	int threshold;
	
	int loadFactor;
	 
	
	
	

}
