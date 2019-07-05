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

public class M4SourceTest {
	
	M4CoffeeMakerAPI api = new M4CoffeeMakerAPI();
	UserInterface ui = new M4UserInterface(api);
	Source source = new M4Source(api);
	Vessel vessel = new M4Vessel(api);
	M4UserInterface m4ui = new M4UserInterface(api);
	M4Source m4source = new M4Source(api);
	M4Vessel m4vessel = new M4Vessel(api);
	
	@Test
	public void isReady_boilerNotEmpty_resultTrue() {
		api.boilerEmpty = false;
		m4source.init(m4ui, m4vessel);
		boolean expected = true;
		boolean actual = m4source.isReady();
		assertEquals(expected, actual);
	}
	
	@Test
	public void isReady_boilerEmpty_resultFalse() {
		api.boilerEmpty = true;
		boolean expected = false;
		boolean actual = m4source.isReady();
		assertEquals(expected, actual);
	}
	
	@Test
	public void startBrewing_process_resultChangeStates() {
		boolean valveClosed = true;
		boolean boilerOn = true;
		boolean expected = valveClosed && boilerOn;
		m4source.init(m4ui, m4vessel);
		m4source.startBrewing();
		boolean actual = api.valveClosed && api.boilerOn;
		assertEquals(expected, actual);
	}
	
	@Test
	public void check_boilerEmpty_resultChangeStates() {
		//mock
		source.isBrewing = true;
		api.boilerEmpty = true;
		
		boolean valveClosed = false;
		boolean boilerOn = false;
		boolean expected = valveClosed && boilerOn;
		m4source.check();
		boolean actual = !api.valveClosed && !api.boilerOn;
		assertEquals(expected, actual);
	}

}
