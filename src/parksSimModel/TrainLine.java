package parksSimModel;
import java.util.*;

class TrainLine {
	int n; //
	private ArrayList<Train> trainList = new ArrayList<Train>(); 
	
	protected int getN() { 
		return(trainList.size());
	}
	
	protected void spInsertQue(Train train) {
		trainList.add(train);
	}
	
	protected Train spRemoveQue() {
		Train train = null;
		if (trainList.size() != 0){
			train = trainList.remove(0);
		}
		return train;
	}
	
	//Attributes
	//n and list no explicit attributes. See examples, e.g. KK Counter or Port Berths
}
