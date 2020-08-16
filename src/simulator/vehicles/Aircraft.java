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
	private long idCounter = 0;
	
	protected  Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}
	
	private long nextId(){
		return (idCounter++);
	}
}