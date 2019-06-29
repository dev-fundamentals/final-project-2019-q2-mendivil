package logic.java.project;

public class M4Vessel extends Vessel {

	private CoffeeMakerAPI api;
	private int lastPotStatus;
	
	public M4Vessel(CoffeeMakerAPI api) {
		// TODO Auto-generated constructor stub
		this.api = api;
		lastPotStatus = api.POT_EMPTY;
	}
	
	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		System.out.println("M4Vessel: Checking warmer plate status...");
		int plateStatus = api.getWarmerPlateStatus();
		if (plateStatus != api.POT_EMPTY) {
			System.out.println("ALERT! The pot is not empty, please empties the water from the pot.");
		}
		return plateStatus == api.POT_EMPTY;
	}
	
	public void check(boolean servingCoffee) {
		System.out.println("3. ////////// Checking M4Vessel...");
		System.out.println("M4Vessel: Checking warmer plate status...");
		int potStatus = api.getWarmerPlateStatus();
		if (potStatus != lastPotStatus) {
			if (isBrewing) {
				System.out.println("Still brewing");
				this.handleBrewingEvent(potStatus);
			} else if (!isComplete) {
				// serving coffee
				if (servingCoffee) {
					potStatus = api.POT_EMPTY;
				}
				System.out.println("Is not complete yet");
				this.handleIncompleteEvent(potStatus);
			}
			System.out.println("M4Vessel: Warmer plate status is " + potStatus);
			lastPotStatus = potStatus;
		} else {
			System.out.println("ALERT! The pot is empty");
		}
	}
	
	public void handleBrewingEvent(int potStatus) {
		if (potStatus == api.POT_NOT_EMPTY) {
			System.out.println("M4Vessel: Pot is still full");
			containerAvailable();
			System.out.println("M4Vessel: Resuming the brewing");
			api.setWarmerState(api.WARMER_ON);
		} else if (potStatus == api.WARMER_EMPTY) {
			System.out.println("M4Vessel: Warmer is empty.");
			containerUnvailable();
			System.out.println("M4Vessel: Turning off the warmer");
			api.setWarmerState(api.WARMER_OFF);
		} else {
			System.out.println("M4Vessel: Pot is empty");
			containerAvailable();
			System.out.println("M4Vessel: Resuming the brewing");
			api.setWarmerState(api.WARMER_OFF);
		}
	}
	
	public void handleIncompleteEvent(int potStatus) {
		if (potStatus == api.POT_NOT_EMPTY) {
			System.out.println("M4Vessel: Pot is still full");
			api.setWarmerState(api.WARMER_ON);
		} else if (potStatus == api.WARMER_EMPTY) {
			System.out.println("M4Vessel: Warmer is empty.");
			System.out.println("M4Vessel: Turning off the warmer");
			api.setWarmerState(api.WARMER_OFF);
		} else {
			System.out.println("M4Vessel: The pot is empty");
			System.out.println("Turning off the warmer");
			api.setWarmerState(api.WARMER_OFF);
			System.out.println("M4Vessel: Declaring complete...");
			declareComplete();
		}
	}

}
