import java.util.*;

// There was a bad smell called "Long Method". I used Extract Method to solve the problem. 
public class Configuration {
	public int interval;

	public int duration;

	public int departure;

	public void load(Properties props) throws ConfigurationException {
		
		interval = getInterval(props);

		duration = getDuration(props);

		departure = getDeparture(props);
	}

	private int getDeparture(Properties props) throws ConfigurationException {
		String valueString;
		int value;
		valueString = props.getProperty("departure");
		if (valueString == null) {
			throw new ConfigurationException("departure offset");
		}
		value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("departure > 0");
		}
		if ((value % interval) != 0) {
			throw new ConfigurationException("departure % interval");
		}
		return value;
	}

	private int getDuration(Properties props) throws ConfigurationException {
		String valueString;
		int value;
		valueString = props.getProperty("duration");
		if (valueString == null) {
			throw new ConfigurationException("duration");
		}
		value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("duration > 0");
		}
		if ((value % interval) != 0) {
			throw new ConfigurationException("duration % interval");
		}
		return value;
	}

	private int getInterval(Properties props) throws ConfigurationException {
		String valueString;
		int value;
		valueString = props.getProperty("interval");
		if (valueString == null) {
			throw new ConfigurationException("monitor interval");
		}
		value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("monitor interval > 0");
		}
		return value;
	}
}
