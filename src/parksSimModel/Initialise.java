package parksSimModel;

import simulationModelling.ScheduledAction;

class Initialise extends ScheduledAction
{
	ThemeParks model;
	
	// Constructor
	protected Initialise(ThemeParks model) { this.model = model; }

	double [] ts = { 0.0, -1.0 }; // -1.0 ends scheduling
	int tsix = 0;  // set index to first entry.
	protected double timeSequence() 
	{
		return ts[tsix++];  // only invoked at t=0
	}

	protected void actionEvent() 
	{
		// System Initialisation
                // Add initilisation instructions
		model.qBoardingLine[Constants.FROG].n = 0;
		model.qBoardingLine[Constants.SKUNK].n = 0;
		model.qBoardingLine[Constants.GATOR].n = 0; 
		model.qBoardingLine[Constants.RACCOON].n = 0; 
		
		model.qTrainLine[Constants.FROG].n = 0;
		model.qTrainLine[Constants.SKUNK].n = 0; 
		model.qTrainLine[Constants.GATOR].n = 0; 
		model.qTrainLine[Constants.RACCOON].n = 0; 

		// Distribution of Trains around the TrainLines		
		int stnId = Constants.FROG;
		
		for (int i=0; i < model.numTrains-1; i++) {	
			model.qTrainLine[stnId].spInsertQue(model.rgTrain[i]);
			stnId = (stnId+1)%4;
		}
		
		int[] defaultDestinations = {0,0,0,0};
		// Set all Train Attributes to default
		for (int i=0; i < model.rgTrain.length-1; i++) {
			model.rgTrain[i].totalCapacity = model.numCars[i] * 25;
			model.rgTrain[i].destinations = defaultDestinations;		
			model.rgTrain[i].trainState = Train.WAITING;
		}

	}
	

}
