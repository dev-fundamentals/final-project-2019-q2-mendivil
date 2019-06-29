package logic.java.project;

public abstract class Vessel {
	private UserInterface ui;
	private Source source;
	protected boolean isBrewing;
	protected boolean isComplete;
	
	public Vessel() {
		isBrewing = false;
		isComplete = true;
	}
	
	public void init(UserInterface ui, Source source) {
		this.ui = ui;
		this.source = source;
	}
	
	public void start() {
		isBrewing = true;
		isComplete = false;
	}
	
	public void done() {
		isBrewing = false;
	}
	
	public void declareComplete() {
		isComplete = true;
		ui.complete();
	}
	
	protected void containerAvailable() {
		source.resume();
	}
	
	protected void containerUnvailable() {
		source.pause();
	}
	
	public abstract boolean isReady();
}
