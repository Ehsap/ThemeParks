package parksSimModel;

class DVPs 
{
	ThemeParks model;  // for accessing the clock
	
	// Constructor
	protected DVPs(ThemeParks model) { this.model = model; }

	// Translate deterministic value procedures into methods
        /* -------------------------------------------------
	                       Example
	protected double getEmpNum()  // for getting next value of EmpNum(t)
	{
	   double nextTime;
	   if(model.clock == 0.0) nextTime = 90.0;
	   else if(model.clock == 90.0) nextTime = 210.0;
	   else if(model.clock == 210.0) nextTime = 420.0;
	   else if(model.clock == 420.0) nextTime = 540.0;
	   else nextTime = -1.0;  // stop scheduling
	   return(nextTime);
	}
	------------------------------------------------------------*/


	// Boarding DVP
	protected double BoardingTime () {
		if (model.loadPlan == ThemeParks.ONE_SIDE) {
			return 2;
		}
		else if (model.loadPlan == ThemeParks.TWO_SIDE) {
			return 1.25;
		}
		else return 2.5; // Train waiting policy is enabled then 
	}
	
	// Moving DVP
	protected int TrainTravelDuration(int stnId) {
		if (stnId == Constants.FROG) return 5;
		else if (stnId == Constants.SKUNK) return 8;
		else if (stnId == Constants.GATOR) return 7;
		// else if (stnId == Constants.RACCOON) return 6;
		else return 6; //  ? RACCOON
	}

}