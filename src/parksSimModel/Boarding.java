package parksSimModel;
import simulationModelling.ConditionalActivity;

class Boarding extends ConditionalActivity {
	
	ThemeParks model;
	int n; // number of customers waiting to board
	int stnId;

	@Override
	protected double duration() {
		return model.dvp.BoardingTime();
	}

	@Override
	public void startingEvent() {
		// model.qTrainLine[stnId]...model = Train.BOARDING; // ? Q.TrainLine[stnId].Train[0].boarding <-- TRUE
	}

	// TODO: ? Interruption
	
	@Override
	protected void terminatingEvent() {
		model.udp.BoardCustomers(trainId, stnId); // ? where get trainId from?
		model.udp.DeboardCustomers(trainId, stnId);
		// ? SP.Start(Moving,Q.TrainLine[stnId])
		
	}
	
}
