package parksSimModel;
import simulationModelling.ScheduledAction;

class RaccoonCustArrivals extends ScheduledAction{
	
	ThemeParks model;
	
	protected RaccoonCustArrivals(ThemeParks md)
	{
		//super(md);
		model = md;
	}
	
	
	@Override
	protected double timeSequence() {
		return model.rvp.duCArrRaccoon();;
	}

	@Override
	protected void actionEvent() {
		// Q.Boarding[RACCOON].n <-- Q.Boarding[RACCOON].n + 1
		model.qBoarding[Constants.RACCOON] // ? ++
	}
	


}
