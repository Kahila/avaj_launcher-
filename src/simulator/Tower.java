/**
 * 
 * @author akalombo
 * @version 1.0
 * @since 2020-08-04
 * @filename Tower
 * */

package simulator;

import simulator.vehicles.Aircraft;
import simulator.vehicles.Baloon;
import simulator.vehicles.Flyable;
import simulator.vehicles.Helicopter;
import simulator.vehicles.JetPlane;
import simulator.Logger;
import java.util.ArrayList;
import java.util.List;

public class Tower{
	private List<Flyable> observers = new ArrayList<>();
	
	public void register(Flyable flyable) {
		observers.add(flyable);
		
		
		if (flyable instanceof JetPlane) {
			Logger.writer("Tower says: JetPlane#"+ ((JetPlane)flyable).getName()+"("+ ((JetPlane)flyable).getId() + ")" + "registered to weather tower.");
		}else if (flyable instanceof Helicopter) {
			Logger.writer("Tower says: Helicopter#"+ ((Helicopter)flyable).getName()+"("+ ((Helicopter)flyable).getId() + ")" + "registered to weather tower.");
		}else if (flyable instanceof Baloon) {
			Logger.writer("Tower says: Baloon#"+ ((Baloon)flyable).getName()+"("+ ((Baloon)flyable).getId() + ")" + "registered to weather tower.");
		}
	}

	public void unregister(Flyable flyable) {
		long id = 1;
			
		if (flyable instanceof Aircraft)
			id =  ((Aircraft)flyable).getId();
		int i = 0;
		for (Flyable ob : observers) {
			if (ob instanceof Aircraft) {
				if (((Aircraft)ob).getId() == id)
					break;
			}
			i++;
		}if (i >= 0) {
			if (flyable instanceof JetPlane) {
				Logger.writer("Tower says: JetPlane#"+ ((JetPlane)flyable).getName()+"("+ ((JetPlane)flyable).getId() + ")" + "unregistered from weather tower.");
			}else if (flyable instanceof Helicopter) {
				Logger.writer("Tower says: Helicopter#"+ ((Helicopter)flyable).getName()+"("+ ((Helicopter)flyable).getId() + ")" + "unregistered from weather tower.");
			}else if (flyable instanceof Baloon) {
				Logger.writer("Tower says: Baloon#"+ ((Baloon)flyable).getName()+"("+ ((Baloon)flyable).getId() + ")" + "unregistered from weather tower.");
			}
			observers.remove(i);
		}
	}
	
	protected void conditionsChanged() {//notify all observers of changes made
		if (observers.isEmpty() == false) {
			for (int i = 0; i < observers.size(); i++) {
				observers.get(i).updateCondition();
			}
		}
	}
}
