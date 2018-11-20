package parksSimModel;
import simulationModelling.ScheduledAction;

class FrogCustArrivals extends ScheduledAction {

	ThemeParks model;
	
	protected FrogCustArrivals(ThemeParks md)
	{
		//super(md);
		model = md;
	}
	
	
	@Override
	protected double timeSequence() {
		return model.rvp.duCArrFrog();;
	}

	@Override
	protected void actionEvent() {
		// Q.Boarding[FROG].n <-- Q.Boarding[FROG].n + 1
		model.qBoarding[Constants.FROG]++;
	}
	

}
