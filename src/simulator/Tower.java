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
import java.util.ArrayList;
import java.util.List;

public class Tower{
	private List<Flyable> observers = new ArrayList<>();
	
	public void register(Flyable flyable) {//register all the observers that need to know of changes
		observers.add(flyable);
		
		if (flyable instanceof JetPlane) {
			System.out.printf("Tower says: JetPlane#%s(%d) registered to weather tower\n", ((JetPlane)flyable).getName(), ((JetPlane)flyable).getId());
		}else if (flyable instanceof Helicopter) {
			System.out.printf("Tower says: Helicopter#%s(%d) registered to weather tower\n", ((Helicopter)flyable).getName(), ((Helicopter)flyable).getId());
		}else if (flyable instanceof Baloon) {
			System.out.printf("Tower says: Baloon#%s(%d) registered to weather tower\n", ((Baloon)flyable).getName(), ((Baloon)flyable).getId());
		}
	}

	public void unregister(Flyable flyable) {//remove all the observers that don't want to know changes
		long id = 0;
		if (flyable instanceof Aircraft)
			id =  ((Aircraft)flyable).getId();
		int i = 0;
		for (Flyable ob : observers) {
			if (ob instanceof Aircraft) {
				if (((Aircraft)ob).getId() == id)
					break;
			}
			i++;
		}if (i > 0) {
			if (flyable instanceof JetPlane) {
				System.out.printf("Tower says: JetPlane#%s(%d) unregistered from weather tower\n", ((JetPlane)flyable).getName(), ((JetPlane)flyable).getId());
			}else if (flyable instanceof Helicopter) {
				System.out.printf("Tower says: Helicopter#%s(%d) unregistered from weather tower\n", ((Helicopter)flyable).getName(), ((Helicopter)flyable).getId());
			}else if (flyable instanceof Baloon) {
				System.out.printf("Tower says: Baloon#%s(%d) unregistered from weather tower\n", ((Baloon)flyable).getName(), ((Baloon)flyable).getId());
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
