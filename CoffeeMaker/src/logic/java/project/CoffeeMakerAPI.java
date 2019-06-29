package logic.java.project;

public interface CoffeeMakerAPI {
	public static CoffeeMakerAPI api = null;

	// status of the warmer-plate sensor.
	public int getWarmerPlateStatus();

	public static final int WARMER_EMPTY = 0;
	public static final int POT_EMPTY = 1;
	public static final int POT_NOT_EMPTY = 2;

	public enum WarmerPlateStatus {
		WARMER_EMPTY,
		POT_EMPTY,
		POT_NOT_EMPTY
	}

	// status of the boiler switch
	public int getBoilerStatus();

	public static final int BOILER_EMPTY = 0;
	public static final int BOILER_NOT_EMPTY = 1;

	// status of the brew button
	public int getBrewButtonStatus();

	public static final int BREW_BUTTON_PUSHED = 0;
	public static final int BREW_BUTTON_NOT_PUSHED = 1;

	// turns the heating element in the boiler
	public void setBoilerState(int boilerStatus);

	public static final int BOILER_ON = 0;
	public static final int BOILER_OFF = 1;

	// turns the heating element in the warmer plate
	public void setWarmerState(int warmerState);

	public static final int WARMER_ON = 0;
	public static final int WARMER_OFF = 1;

	// turns the indicator light on or off
	public void setIndicatorState(int indicatorState);

	public static final int INDICATOR_ON = 0;
	public static final int INDICATOR_OFF = 1;

	// opens and closes the pressure-relief valve
	public void setReliefValveState(int reliefValveState);

	public static final int VALVE_OPEN = 0;
	public static final int VALVE_CLOSED = 1;
}
