package parksSimModel;

class UDPs 
{
	ThemeParks model;  // for accessing the clock
	
	// Constructor
	protected UDPs(ThemeParks model) { this.model = model; }

	// Translate User Defined Procedures into methods
    /*-------------------------------------------------
	                       Example
	    protected int ClerkReadyToCheckOut()
        {
        	int num = 0;
        	Clerk checker;
        	while(num < model.NumClerks)
        	{
        		checker = model.Clerks[num];
        		if((checker.currentstatus == Clerk.status.READYCHECKOUT)  && checker.list.size() != 0)
        		{return num;}
        		num +=1;
        	}
        	return -1;
        }
	------------------------------------------------------------*/
	
	// Boarding UDPs
	// TODO: implement UDPs
	
	// Returns the number of people that will board the train at the given station - DO WE STILL NEED THIS?
	/*protected int NumCustomerBoarding(int stnId) {
		if (model.qBoarding[stnId].n > places left in train) 
			return places left in train;
		return model.qBoarding[stnId].n;	
	}*/
	
	
	// Returns if Train is ready to leave
	/*protected boolean DurationTrainFull(int id) { // ? also need station ID?
		if ((number of passengers <= 0.8*model.rgTrain[id].totalCapacity) ||  train waiting behind it || model.dvp.BoardingTime() <= 2.5) {
			return false;
		}
		return true;
	}*/
	
	
	// Determines the number of customers that can board
	protected int BoardCustomers(int trainId, int stnId) {
		int numCanBoard = model.rgTrain[trainId].totalCapacity - model.rgTrain[trainId].destinations[stnId];
		
		if (numCanBoard > model.qBoarding[stnId].n) {
			numCanBoard = model.qBoarding[stnId].n;
		}
		
		// Distribution of customers to the destinations
		if (trainId == Constants.FROG) {
			model.rgTrain[trainId].destinations[Constants.FROG] = 0;
			model.rgTrain[trainId].destinations[Constants.SKUNK] = (int) (numCanBoard * 0.4);
			model.rgTrain[trainId].destinations[Constants.GATOR] = (int) (numCanBoard * 0.35);
			model.rgTrain[trainId].destinations[Constants.RACCOON] = (int) (numCanBoard * 0.25);
		}
		else if (trainId == Constants.SKUNK) {
			model.rgTrain[trainId].destinations[Constants.FROG] = (int) (numCanBoard * 0.37);
			model.rgTrain[trainId].destinations[Constants.SKUNK] = 0;
			model.rgTrain[trainId].destinations[Constants.GATOR] = (int) (numCanBoard * 0.39);
			model.rgTrain[trainId].destinations[Constants.RACCOON] = (int) (numCanBoard * 0.29);
		}
		else if (trainId == Constants.GATOR) {
			model.rgTrain[trainId].destinations[Constants.FROG] = (int) (numCanBoard * 0.42);
			model.rgTrain[trainId].destinations[Constants.SKUNK] = (int) (numCanBoard * 0.29);
			model.rgTrain[trainId].destinations[Constants.GATOR] = 0;
			model.rgTrain[trainId].destinations[Constants.RACCOON] = (int) (numCanBoard * 0.29);
		}
		else if (trainId == Constants.RACCOON) {
			model.rgTrain[trainId].destinations[Constants.FROG] = (int) (numCanBoard * 0.41);
			model.rgTrain[trainId].destinations[Constants.SKUNK] = (int) (numCanBoard * 0.28);
			model.rgTrain[trainId].destinations[Constants.GATOR] = (int) (numCanBoard * 0.31);
			model.rgTrain[trainId].destinations[Constants.RACCOON] = 0;
		}
		
		return numCanBoard;
	}
	
	// Removes customers from the train
	protected void DeboardCustomers(int trainId, int stnId) {
		model.rgTrain[trainId].destinations[stnId] = 0;
	}
	
	
	// Moving UDP
	// Returns the identifier for the next station from a given station
	protected int GetNextStation(int stnId) {
		if (stnId == Constants.FROG)  return  Constants.SKUNK;
		else if (stnId == Constants.SKUNK)  return  Constants.GATOR;
		else if (stnId == Constants.GATOR)  return  Constants.RACCOON;
		else if (stnId == Constants.RACCOON)  return  Constants.FROG;
		else return stnId; // ? what else to return?
	}
	
}
