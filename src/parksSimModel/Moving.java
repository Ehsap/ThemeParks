package parksSimModel;
import simulationModelling.ConditionalActivity;

class Moving extends ConditionalActivity{

	ThemeParks model;
	int stnId; // ?
	
	@Override
	protected double duration() {
		return model.dvp.TrainTravelDuration(stnId);
	}

	@Override
	public void startingEvent() {
		int nxtStn = model.udp.GetNextStation(stnId);
		// int trainId = model.qTrainLine[] 	// ? rainId <-- SP.RemoveQue(Q.TrainLine[stnId])
		model.rgTrain[trainId].trainState = Train.MOVING;
		// model.qTrainLine[] // ? SP.InsertQue(SP.TrainLine[nxtStn])
	}

	@Override
	protected void terminatingEvent() {
		// model.qTrainLine[stnId]... = Train.WAITING  // ? Q.TrainLine[stnId].Train[trainid].status <--  WAITING
	}

}
