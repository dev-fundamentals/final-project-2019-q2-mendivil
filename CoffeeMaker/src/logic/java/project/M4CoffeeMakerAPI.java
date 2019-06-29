package logic.java.project;

public class M4CoffeeMakerAPI implements CoffeeMakerAPI {
	
	public boolean buttonPressed;
	public boolean lightOn;
	public boolean boilerOn;
	public boolean valveClosed;
	public boolean plateOn;
	public boolean boilerEmpty;
	public boolean potPresent;
	public boolean potNotEmpty;
	
	public M4CoffeeMakerAPI() {
		// TODO Auto-generated constructor stub
		buttonPressed = false;
		lightOn = false;
		boilerOn = false;
		plateOn = false;
		potNotEmpty = false;
		
		boilerEmpty = true;
		valveClosed = true;
		potPresent = true;
	}
	
	@Override
	public int getWarmerPlateStatus() {
		// TODO Auto-generated method stub
		if (!potPresent)
			return WARMER_EMPTY;
		else if (boilerEmpty)
			return POT_NOT_EMPTY;
		else
			return POT_EMPTY;
	}
	
	@Override
	public int getBoilerStatus() {
		// TODO Auto-generated method stub
		return boilerEmpty ? BOILER_EMPTY : BOILER_NOT_EMPTY;
	}

	@Override
	public int getBrewButtonStatus() {
		// TODO Auto-generated method stub
		System.out.println("Checking brew button status...");
		if (buttonPressed) {
			buttonPressed = false;
			return BREW_BUTTON_PUSHED;
		} else {
			return BREW_BUTTON_NOT_PUSHED;
		}
	}

	@Override
	public void setBoilerState(int boilerStatus) {
		// TODO Auto-generated method stub
		boilerOn = boilerStatus == BOILER_ON;
	}

	@Override
	public void setWarmerState(int warmerState) {
		// TODO Auto-generated method stub
		plateOn = warmerState == WARMER_ON;
	}

	@Override
	public void setIndicatorState(int indicatorState) {
		// TODO Auto-generated method stub
		lightOn = indicatorState == INDICATOR_ON;
	}

	@Override
	public void setReliefValveState(int reliefValveState) {
		// TODO Auto-generated method stub
		valveClosed = reliefValveState == VALVE_CLOSED;
	}

}
