package logic.java.project;

public class M4Source extends Source {
	
	private CoffeeMakerAPI api;
	
	public M4Source(CoffeeMakerAPI api) {
		// TODO Auto-generated constructor stub
		this.api = api;
	}

	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		System.out.println("M4Source: Checking boiler status...");
		int boilerStatus = api.getBoilerStatus();
		if (boilerStatus != api.BOILER_NOT_EMPTY) {
			System.out.println("ALERT! The boiler is empty. Please put water in the boiler...");
		}
		return boilerStatus == api.BOILER_NOT_EMPTY;
	}

	@Override
	public void startBrewing() {
		// TODO Auto-generated method stub
		System.out.println("Source: closing the valve");
		api.setReliefValveState(api.VALVE_CLOSED);
		System.out.println("Source: turning on the boiler");
		api.setBoilerState(api.BOILER_ON);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		api.setBoilerState(api.BOILER_OFF);
		api.setReliefValveState(api.VALVE_OPEN);
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		api.setBoilerState(api.BOILER_ON);
		api.setReliefValveState(api.VALVE_CLOSED);
		
	}
	
	public void check() {
		System.out.println("2. ////////// Checking M4Source...");
		int boilerStatus = api.getBoilerStatus();
		if (isBrewing) {
			System.out.println("M4Source: checking boiler status");
			if (boilerStatus == api.BOILER_EMPTY) {
				System.out.println("M4Source: Turning off the boiler");
				api.setBoilerState(api.BOILER_OFF);
				System.out.println("M4Source: Opening the valve");
				api.setReliefValveState(api.VALVE_OPEN);
				declareDone();
			} else {
				System.out.println("ALERT! The boiler is not empty. Please, empty the boiler water");
			}
		} else {
			System.out.println("Source is not brewing yet...");
		}
	}

}
