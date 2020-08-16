package simulator.vehicles;

import simulator.WeatherTower;

public interface Flyable {
	public  void updateCondition();
	public void registerTower(WeatherTower weatherTower);
}
