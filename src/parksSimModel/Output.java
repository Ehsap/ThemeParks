package parksSimModel;

class Output 
{
	ThemeParks model;
	
	protected Output(ThemeParks md) { model = md; }
    // Use OutputSequence class to define Trajectory and Sample Sequences
    // Trajectory Sequences

    // Sample Sequences

    // DSOVs available in the OutputSequence objects
    // If seperate methods required to process Trajectory or Sample
    // Sequences - add them here

    // SSOVs
	protected int numType1;
	protected int numType2;
	protected int numType3;
	protected int numType4;
	
	protected double percentType1;
	protected double percentType2;
	protected double percentType3;
	protected double percentType4;
	
	protected double getPercentage (int numType) {
		return numType/(numType1 + numType2 + numType3 + numType4);
	}
}
