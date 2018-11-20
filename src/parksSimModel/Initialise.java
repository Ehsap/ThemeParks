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
		
		// Distribution of Trains around the TrainLines		
		int stnId = Constants.FROG;
		
		for (int i=0; i < model.rgTrain.length-1; i++) {	// ? length? -  where to declare numTrains?
			model.qTrainLine[stnId] = model.rgTrain[i]; // of course, this doesn't work - how does qTrainLine work?
			stnId = (stnId+1)%4;
		}

		// Set all Train Attributes to default
		for (int i=0; i < model.rgTrain.length-1; i++) {
			model.rgTrain[i].totalCapacity = model.rgTrain[i].numCars * 25;
			
			for (int j=0; j < model.rgTrain[i].destinations.length-1; j++) {
				model.rgTrain[i].destinations[j] = 0;
			}			
			
			model.rgTrain[i].trainState = Train.WAITING;	//<-- I introduced this constant
		}

	}
	

}
