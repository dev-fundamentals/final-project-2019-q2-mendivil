package logic.java.project;

public abstract class UserInterface {
	
	private Source source;
	private Vessel vessel;
	private boolean isComplete;
	
	public UserInterface() {
		isComplete = true;
	}
	
	public void init(Source source, Vessel vessel) {
		this.source = source;
		this.vessel = vessel;
	}
	
	public void complete() {
		isComplete = true;
		completeCycle();
	}
	
	protected void startBrewing() {
		if (source.isReady() && vessel.isReady()) {
			isComplete = false;
			System.out.println("UI: Starting the source");
			source.start();
			System.out.println("UI: Starting the vessel");
			vessel.start();
		} else {
			System.out.println("UI: Source or Vessel are not ready.");
		}
	}
	
	public abstract void done();
	public abstract void completeCycle();

}
