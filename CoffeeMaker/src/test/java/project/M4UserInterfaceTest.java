package test.java.project;

import logic.java.project.*;

import static org.junit.Assert.*;

import org.junit.Test;


public class M4UserInterfaceTest {
	
	M4CoffeeMakerAPI api;
	M4UserInterface m4ui = new M4UserInterface(api);
	UserInterface ui;
	Source source;
	Vessel vessel;
	
	/* @Test
	public void check_buttonNotPressed_resultNotStartBrewing() {
		api.buttonPressed = false;
		m4ui.check();
		boolean expected = true;
		boolean actual = ui.isComplete;
		assertEquals(expected, actual);
	}
	
	@Test
	public void check_buttonPressed_resultStartBrewing() {
		api.buttonPressed = true;
		m4ui.check();
		boolean expected = false;
		boolean actual = ui.isComplete;
		assertEquals(expected, actual);
	} */

	@Test
	public void done_changeState_resultIndicatorOn() {
		// mock
		api.lightOn = false;
		
		m4ui.done();
		boolean expected = true;
		boolean actual = api.lightOn;
		assertEquals(actual, expected);
	}
	
	/* @Test
	public void completeCycle_changeState_resultIndicatorOff() {
		api.lightOn = true;
		m4ui.completeCycle();
		boolean expected = false;
		boolean actual = api.lightOn;
		assertEquals(actual, expected);
		
	} */
}
