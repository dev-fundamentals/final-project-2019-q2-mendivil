package test.java.project;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.java.project.M4CoffeeMakerAPI;
import logic.java.project.M4Source;
import logic.java.project.M4UserInterface;
import logic.java.project.M4Vessel;
import logic.java.project.Source;
import logic.java.project.UserInterface;
import logic.java.project.Vessel;

public class M4VesselTest {
	
	M4CoffeeMakerAPI api = new M4CoffeeMakerAPI();
	M4UserInterface m4ui = new M4UserInterface(api);
	UserInterface ui = new M4UserInterface(api);
	Source source = new M4Source(api);
	Vessel vessel = new M4Vessel(api);
	M4Source m4source = new M4Source(api);
	M4Vessel m4vessel = new M4Vessel(api);
	
	@Test
	public void isReady_potEmpty_resultTrue() {
		api.potNotEmpty = false;
		boolean expected = true;
		boolean actual = m4vessel.isReady();
		assertEquals(expected, actual);
	}
	
	@Test
	public void isReady_potNotEmpty_resultFalse() {
		api.potNotEmpty = true;
		boolean expected = false;
		boolean actual = m4vessel.isReady();
		assertEquals(expected, actual);
	}

}
