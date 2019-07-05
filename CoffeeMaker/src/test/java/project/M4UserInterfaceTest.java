package test.java.project;

import logic.java.project.*;

import static org.junit.Assert.*;

import org.junit.Test;


public class M4UserInterfaceTest {
	
	M4CoffeeMakerAPI api = new M4CoffeeMakerAPI();
	M4UserInterface m4ui = new M4UserInterface(api);
	UserInterface ui = new M4UserInterface(api);
	Source source = new M4Source(api);
	Vessel vessel = new M4Vessel(api);
	
	@Test
	public void check_buttonNotPressed_resultNotStartBrewing() {
		api.buttonPressed = false;
		m4ui.init(source, vessel);
		m4ui.check();
		boolean expected = false;
		boolean actual = m4ui.ready;
		assertEquals(expected, actual);
	}
	
	@Test
	public void check_buttonPressed_resultStartBrewing() {
		api.buttonPressed = true;
		m4ui.init(source, vessel);
		m4ui.check();
		boolean expected = true;
		boolean actual = m4ui.ready;
		assertEquals(expected, actual);
	}

	@Test
	public void done_changeState_resultIndicatorOn() {
		// mock
		api.lightOn = false;
		
		m4ui.done();
		boolean expected = true;
		boolean actual = api.lightOn;
		assertEquals(actual, expected);
	}
	
	@Test
	public void completeCycle_changeState_resultIndicatorOff() {
		api.lightOn = true;
		m4ui.completeCycle();
		boolean expected = false;
		boolean actual = api.lightOn;
		assertEquals(actual, expected);
		
	}
}
