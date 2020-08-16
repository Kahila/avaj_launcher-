/**
 * 
 * @author akalombo
 * @version 1.0
 * @since 2020-08-04
 * @filename Aircraft
 * */

package simulator.vehicles;

import simulator.vehicles.Coordinates;

public class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter = 1;
	
	protected  Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		this.id = this.nextId();
	}
	
	private long nextId(){;
		return (idCounter++);
	}
	
	public long getId() {
		return (this.id);
	}
	
	public String getName() {
		return (this.name);
	}
}