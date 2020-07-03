package simulator.vehicles;

import weather.Coordinates;

public class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private long idCounter = 0;
	
	protected  Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}
	
	
	/**this method creates Id's for the flyables
	 * 
	 * @return
	 */
	private long nextId(){
		return (idCounter++);
	}
}