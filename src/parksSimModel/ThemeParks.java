package parksSimModel;

import java.util.ArrayList;


import simulationModelling.AOSimulationModel;
import simulationModelling.Behaviour;
import simulationModelling.SequelActivity;

//
// The Simulation model Class
public class ThemeParks extends AOSimulationModel
{
	// Constants available from Constants class
	/* Parameter */
        // Define the parameters
	// RG.numCars see Train Class
	int numTrains;				// number of trains in the system (parameter)
	int loadPlan;			// customer loadplan: ONE_SIDE, TWO_SIDE, WAIT (parameter)
	
	
	// !? I added those, not in CM! - or better in Constants?
	static final int ONE_SIDE = 0;
	static final int TWO_SIDE = 1;
	static final int WAIT = 2;
		
	//	See Train Class: RG.Train.numTrains, RG.Train.numCars, RG.Train.loadPlan		
	

	/*-------------Entity Data Structures-------------------*/
	/* Group and Queue Entities */
	// Define the reference variables to the various 
	// entities with scope Set and Unary
	// Objects can be created here or in the Initialise Action
	
	// ? all ArrayLists?, What about numTrains?
	protected Train [] rgTrain = new Train[numTrains];		// RG.Train
	protected Boarding [] qBoarding = new Boarding[4];	    // Q.Boarding
	protected TrainLine [] qTrainLine = new TrainLine[4];	// Q.TrainLine
	
	// ? there are 4 TrainLines, but a TrainLine is supposed to contain several Trains - how to implement that?
	
	
	/* Input Variables */
	// Define any Independent Input Variables here
	
	// References to RVP and DVP objects
	protected RVPs rvp;  // Reference to rvp object - object created in constructor
	protected DVPs dvp = new DVPs(this);  // Reference to dvp object
	protected UDPs udp = new UDPs(this);

	// Output object
	protected Output output = new Output(this);
	
	// Output values - define the public methods that return values
	// required for experimentation.


	// Constructor
	public ThemeParks(double t0time, double tftime, /*define other args,*/ Seeds sd)
	{
		// Initialise parameters here
		
		// Create RVP object with given seed
		rvp = new RVPs(this,sd);
		
		// rgCounter and qCustLine objects created in Initalise Action
		
		// Initialise the simulation model
		initAOSimulModel(t0time,tftime);   

		     // Schedule the first arrivals and employee scheduling
		Initialise init = new Initialise(this);
		scheduleAction(init);  // Should always be first one scheduled.
		// Schedule other scheduled actions and acitvities here
	}

	/************  Implementation of Data Modules***********/	
	/*
	 * Testing preconditions
	 */
	protected void testPreconditions(Behaviour behObj)
	{
		reschedule (behObj);
		// Check preconditions of Conditional Activities

		// Check preconditions of Interruptions in Extended Activities
	}
	
	public void eventOccured()
	{
		//this.showSBL();
		// Can add other debug code to monitor the status of the system
		// See examples for suggestions on setup logging

		// Setup an updateTrjSequences() method in the Output class
		// and call here if you have Trajectory Sets
		// updateTrjSequences() 
	}

	// Standard Procedure to start Sequel Activities with no parameters
	protected void spStart(SequelActivity seqAct)
	{
		seqAct.startingEvent();
		scheduleActivity(seqAct);
	}	

}


