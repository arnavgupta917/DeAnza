/*
 * Arnav Gupta
 * Class and Section : Su17 CIS D035A 61Z Java Programming
 * Assignment Number : 3
 * Due date : 07/19/17
 * Date Submitted : 07/19/17
 */

import java.io.IOException;

/**
 * 
 * This Franchise class provides api to fill the date of the specific values of all the stores from a text file
 *
 */
public class Franchise {
	static final int MAX_SUPPORTED_STORES = 6;
	private Store[] stores;
	boolean debug;
	public Franchise() {
		stores = new Store[MAX_SUPPORTED_STORES];
		debug = false;
	}
	
	/**
	 * 
	 * Fill the franchise data for all the stores
	 * @param fileName to read the store data  
	 */
	public void fillFranchiseStore(String fileName) throws IOException {
		FileIO fio = new FileIO(fileName);
		fio.initialize();

		//first line of the file is expected to have number of stores data it has
		String storeData = fio.readLine();
		int numStores = Integer.parseInt(storeData);
		if (debug)
			System.out.println("fillFranchiseStore::numStores =" + numStores);

		//Second line is about how the store data is being stored in terms of colums
		storeData = fio.readLine();
		if (debug)
			System.out.println("fillFranchiseStore::store columns =" + storeData);

		//Now read file for all the stores
		int storeCount = 0;		 
		while (storeData != null && storeCount <= MAX_SUPPORTED_STORES) {
			storeData = fio.readLine();
			
			if (storeData != null) {
				//Store store = new Store();
				stores[storeCount] = new Store();
				if (debug)
					System.out.println("storeData=" + storeData);
				stores[storeCount].fillStoreData(storeData);
				storeCount++;
			}
		}
		fio.unInitialize();
	}
	
	/**
	 * 
	 * @param storeNum representing number of store
	 * @return stores data of store represented by the storeNum
	 */
	public Store getStore(int storeNum) {
		return stores[storeNum-1];
	}

	/**
	 * 
	 * @param store object having data of a store 
	 * @param storeNum representing number of store
	 */
	public void setStore(Store store, int storeNum) {
		this.stores[storeNum] = store;
	}

	/**
	 * 
	 * @return number of stores in a data file
	 */
	public int numberOfStores() {   
		return stores.length;
	}

}
