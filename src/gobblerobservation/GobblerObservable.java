package gobblerobservation;

import java.util.Observable;

public class GobblerObservable extends Observable {
	
	public GobblerObservable() {		
		addObserver(new GobblerObserver());
	}
	
	public void setValue(int n) {
		setChanged();
		// notifyObservers(count++);
		notifyObservers(n);
		clearChanged();
	}


}
