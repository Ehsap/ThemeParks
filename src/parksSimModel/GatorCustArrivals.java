package parksSimModel;
import simulationModelling.ScheduledAction;

class GatorCustArrivals extends ScheduledAction{

	ThemeParks model;
	
	protected GatorCustArrivals(ThemeParks md)
	{
		//super(md);
		model = md;
	}
	
	
	@Override
	protected double timeSequence() {
		return model.rvp.duCArrGator();;
	}

	@Override
	protected void actionEvent() {
		// Q.Boarding[GATOR].n <-- Q.Boarding[GATOR].n + 1
		model.qBoarding[Constants.GATOR] // ? ++
	}
}
