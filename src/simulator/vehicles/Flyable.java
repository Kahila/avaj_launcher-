package simulator.vehicles;

import simulator.WeatherTower;

public interface Flyable {
	void updateCondition();
	public void registerTower(WeatherTower weatherTower);
}
