package parksSimModel;

import cern.jet.random.Exponential;
import cern.jet.random.engine.MersenneTwister;

class RVPs 
{
	ThemeParks model; // for accessing the clock
    // Data Models - i.e. random veriate generators for distributions
	// are created using Colt classes, define 
	// reference variables here and create the objects in the
	// constructor with seeds


	// Constructor
	protected RVPs(ThemeParks model, Seeds sd) 
	{ 
		this.model = model; 
		// Set up distribution functions
		interArrDistFrog = new Exponential(1.0/MEAN_INTER_ARR_FROG, new MersenneTwister(sd.seed1)); // ???
		interArrDistFrog = new Exponential(1.0/MEAN_INTER_ARR_SKUNK, new MersenneTwister(sd.seed1));
		interArrDistFrog = new Exponential(1.0/MEAN_INTER_ARR_GATOR, new MersenneTwister(sd.seed1));
		interArrDistFrog = new Exponential(1.0/MEAN_INTER_ARR_RACCOON, new MersenneTwister(sd.seed1));
	}
	
	/* Random Variate Procedure for Arrivals */
	private Exponential interArrDistFrog;  // Exponential distribution for interarrival times
	//private final double MEAN_INTER_ARR_FROG; // ? Do we need the constants? Does it make sense to define 12 constants each?
	private Exponential interArrDistSkunk;  
	//private final double MEAN_INTER_ARR_SKUNK;
	private Exponential interArrDistGator;  
	//private final double MEAN_INTER_ARR_GATOR;
	private Exponential interArrDistRaccoon;  
	//private final double MEAN_INTER_ARR_RACCOON;
	
	
	// next arrival time for a customer to the FROG boarding queue
	protected double duCArrFrog()  // for getting next value of duInput
	{
	    double nxtInterArr;

        nxtInterArr = interArrDistFrog.nextDouble();
        double mean;
        
        if(model.getClock() < 60) mean = 0.133;
  	  	else if (model.getClock() > 60 && model.getClock() < 120) mean = 0.2;
  	  	else if (model.getClock() > 120 && model.getClock() < 180) mean = 0.218;
  	  	else if (model.getClock() > 180 && model.getClock() < 240) mean = 0.211;
  	  	else if (model.getClock() > 240 && model.getClock() < 300) mean = 0.194;
  	  	else if (model.getClock() > 300 && model.getClock() < 360) mean = 0.188;
  	  	else if (model.getClock() > 360 && model.getClock() < 420) mean = 0.214;
  	  	else if (model.getClock() > 420 && model.getClock() < 480) mean = 0.231;
  	  	else if (model.getClock() > 480 && model.getClock() < 540) mean = 0.207;
  	  	else if (model.getClock() > 540 && model.getClock() < 600) mean = 0.19;
  	  	else if (model.getClock() > 600 && model.getClock() < 660) mean = 0.156;
  	  	else if (model.getClock() > 660 && model.getClock() < 720) mean = 0.145;
  	  	//else mean = ;
        
	    // Note that interarrival time is added to current
	    // clock value to get the next arrival time.
        nxtInterArr = model.getClock()+interArrDistFrog.nextDouble(1.0/mean);
        if(nxtInterArr > model.closingTime) 	// ? Do we need to define the closing time like in Kojo's Kitchen (Initialise)
      	  nxtInterArr = -1.0;  // Ends time sequence
  	  	return(nxtInterArr);
	}
	
	// next arrival time for a customer to the SKUNK boarding queue
	protected double duCArrSkunk()  // for getting next value of duInput
	{
	    double nxtInterArr;

        nxtInterArr = interArrDistSkunk.nextDouble();
        double mean;
        
        if(model.getClock() < 60) mean = 0.15;
  	  	else if (model.getClock() > 60 && model.getClock() < 120) mean = 0.171;
  	  	else if (model.getClock() > 120 && model.getClock() < 180) mean = 0.24;
  	  	else if (model.getClock() > 180 && model.getClock() < 240) mean = 0.218;
  	  	else if (model.getClock() > 240 && model.getClock() < 300) mean = 0.207;
  	  	else if (model.getClock() > 300 && model.getClock() < 360) mean = 0.197;
  	  	else if (model.getClock() > 360 && model.getClock() < 420) mean = 0.2;
  	  	else if (model.getClock() > 420 && model.getClock() < 480) mean = 0.214;
  	  	else if (model.getClock() > 480 && model.getClock() < 540) mean = 0.194;
  	  	else if (model.getClock() > 540 && model.getClock() < 600) mean = 0.188;
  	  	else if (model.getClock() > 600 && model.getClock() < 660) mean = 0.167;
  	  	else if (model.getClock() > 660 && model.getClock() < 720) mean = 0.148;
  	  	//else mean = ;
        
	    // Note that interarrival time is added to current
	    // clock value to get the next arrival time.
        nxtInterArr = model.getClock()+interArrDistSkunk.nextDouble(1.0/mean);
        if(nxtInterArr > model.closingTime) 
      	  nxtInterArr = -1.0;  // Ends time sequence
  	  	return(nxtInterArr);
	}
	
	// next arrival time for a customer to the GATOR boarding queue
	protected double duCArrGator()  // for getting next value of duInput
	{
	    double nxtInterArr;

        nxtInterArr = interArrDistGator.nextDouble();
        double mean;
        
        if(model.getClock() < 60) mean = 0.185;
  	  	else if (model.getClock() > 60 && model.getClock() < 120) mean = 0.176;
  	  	else if (model.getClock() > 120 && model.getClock() < 180) mean = 0.231;
  	  	else if (model.getClock() > 180 && model.getClock() < 240) mean = 0.286;
  	  	else if (model.getClock() > 240 && model.getClock() < 300) mean = 0.25;
  	  	else if (model.getClock() > 300 && model.getClock() < 360) mean = 0.214;
  	  	else if (model.getClock() > 360 && model.getClock() < 420) mean = 0.207;
  	  	else if (model.getClock() > 420 && model.getClock() < 480) mean = 0.218;
  	  	else if (model.getClock() > 480 && model.getClock() < 540) mean = 0.203;
  	  	else if (model.getClock() > 540 && model.getClock() < 600) mean = 0.181;
  	  	else if (model.getClock() > 600 && model.getClock() < 660) mean = 0.152;
  	  	else if (model.getClock() > 660 && model.getClock() < 720) mean = 0.14;
  	  	//else mean = ;
        
	    // Note that interarrival time is added to current
	    // clock value to get the next arrival time.
        nxtInterArr = model.getClock()+interArrDistGator.nextDouble(1.0/mean);
        if(nxtInterArr > model.closingTime) 
      	  nxtInterArr = -1.0;  // Ends time sequence
  	  	return(nxtInterArr);
	}	

	// next arrival time for a customer to the RACCOON boarding queue
	protected double duCArrRaccoon()  // for getting next value of duInput
	{
	    double nxtInterArr;

        nxtInterArr = interArrDistRaccoon.nextDouble();
        double mean;
        
        if(model.getClock() < 60) mean = 0.156;
  	  	else if (model.getClock() > 60 && model.getClock() < 120) mean = 0.188;
  	  	else if (model.getClock() > 120 && model.getClock() < 180) mean = 0.214;
  	  	else if (model.getClock() > 180 && model.getClock() < 240) mean = 0.226;
  	  	else if (model.getClock() > 240 && model.getClock() < 300) mean = 0.207;
  	  	else if (model.getClock() > 300 && model.getClock() < 360) mean = 0.190;
  	  	else if (model.getClock() > 360 && model.getClock() < 420) mean = 0.2;
  	  	else if (model.getClock() > 420 && model.getClock() < 480) mean = 0.188;
  	  	else if (model.getClock() > 480 && model.getClock() < 540) mean = 0.214;
  	  	else if (model.getClock() > 540 && model.getClock() < 600) mean = 0.194;
  	  	else if (model.getClock() > 600 && model.getClock() < 660) mean = 0.167;
  	  	else if (model.getClock() > 660 && model.getClock() < 720) mean = 0.152;
  	  	//else mean = ;
        
	    // Note that interarrival time is added to current
	    // clock value to get the next arrival time.
        nxtInterArr = model.getClock()+interArrDistRaccoon.nextDouble(1.0/mean);
        if(nxtInterArr > model.closingTime) 
      	  nxtInterArr = -1.0;  // Ends time sequence
  	  	return(nxtInterArr);
	}		
}
