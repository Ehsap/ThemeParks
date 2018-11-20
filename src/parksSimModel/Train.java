package parksSimModel;

class Train {
	
	// Attributes
	int numCars;				// number of cars per train (parameter)
	
	int totalCapacity;		// maximum amount of passengers that the train can carry
	int [] destinations = new int[4]; 	// list of four values [n0, n1, n2, n3] that represent the number of customers on the train, 
												// where ni is the amount that will deboard at station GATOR, SKUNK, FROG or RACCOON
	int trainState;		// MOVING: train is in transit, BOARDING: deboard and board passengers, WAITING: waiting in a line of trains after moving
	
	// !? I added those, not in CM! - or better in Constants?
	static final int WAITING = 0;
	static final int BOARDING = 1;
	static final int MOVING = 2;

}
