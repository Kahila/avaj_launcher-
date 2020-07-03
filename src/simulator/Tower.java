package simulator;

import simulator.vehicles.Flyable;
//import 

public class Tower{
	private Flyable observers[];

	public void register(Flyable flyable) {
		
	}

	public void unregister(Flyable flyable) {
		flyable.updateCondition();
	}
	
	protected void conditionsChanged() {
		
	}
}
