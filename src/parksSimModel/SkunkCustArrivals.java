package parksSimModel;
import simulationModelling.ScheduledAction;

class SkunkCustArrivals extends ScheduledAction {

	ThemeParks model;
	
	protected SkunkCustArrivals(ThemeParks md)
	{
		//super(md);
		model = md;
	}
	
	
	@Override
	protected double timeSequence() {
		return model.rvp.duCArrSkunk();;
	}

	@Override
	protected void actionEvent() {
		// Q.Boarding[SKUNK].n <-- Q.Boarding[SKUNK].n + 1
		model.qBoarding[Constants.SKUNK] // ? ++
	}
}
