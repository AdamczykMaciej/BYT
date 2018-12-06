import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.*;
import java.util.*;

public class ConfigurationTest{

	@Test
	public void testGoodInput() throws IOException {
		String data = "interval = 10\nduration = 100\ndeparture = 200\n";

		Properties input = testLoadInput(data);

		Configuration props = new Configuration();
		try {
			props.load(input);
		} catch (ConfigurationException e) {
			assertTrue(false);
			return;
		}

		assertEquals(props.interval, 10);
		assertEquals(props.duration, 100);
		assertEquals(props.departure, 200);
	}
	@Test
	public void testNegativeValues() throws IOException {
		testProcessBadInput("interval = -10\nduration = 100\ndeparture = 200\n");
		testProcessBadInput("interval = 10\nduration = -100\ndeparture = 200\n");
		testProcessBadInput("interval = 10\nduration = 100\ndeparture = -200\n");
	}
	@Test
	public void testInvalidDuration() throws IOException {
		testProcessBadInput("interval = 10\nduration = 99\ndeparture = 200\n");
	}
	@Test
	public void testInvalidDeparture() throws IOException {
		
		testProcessBadInput("interval = 10\nduration = 100\ndeparture = 199\n");
	}
	
	public void testProcessBadInput(String data) throws IOException {
		Properties input = testLoadInput(data);

		boolean failed = false;
		Configuration props = new Configuration();
		try {
			props.load(input);
		} catch (ConfigurationException e) {
			failed = true;
		}
		assertTrue(failed);
	}

	public Properties testLoadInput(String data) throws IOException {
		InputStream is = new StringBufferInputStream(data);

		Properties input = new Properties();
		input.load(is);
		is.close();

		return input;
	}
}
