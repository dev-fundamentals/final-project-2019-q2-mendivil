package logic.java.project;

public class M4UserInterface extends UserInterface {
	
	private CoffeeMakerAPI api;
	public boolean ready = false;
	
	public M4UserInterface(CoffeeMakerAPI api) {
		// TODO Auto-generated constructor stub
		this.api = api;
	}
	
	public void check() {
		System.out.println("1. ////////// Checking M4UserInterface...");
		int buttonStatus = api.getBrewButtonStatus();
		if (buttonStatus == api.BREW_BUTTON_PUSHED) {
			startBrewing();
			ready = true;
		} else {
			ready = false;
			System.out.println("ALERT! Brew button is not pushed. Please push brew button to continue...");
		}
	}

	@Override
	public void done() {
		// TODO Auto-generated method stub
		System.out.println("M4UserInterface: Turning on the indicator light");
		api.setIndicatorState(api.INDICATOR_ON);
	}

	@Override
	public void completeCycle() {
		// TODO Auto-generated method stub
		System.out.println("M4UserInterface: Turning off the indicator light");
		api.setIndicatorState(api.INDICATOR_OFF);
	}

}
