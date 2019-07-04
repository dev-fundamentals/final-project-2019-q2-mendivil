package logic.java.project;

public abstract class Source {
	private UserInterface ui;
	private Vessel vessel;
	protected boolean isBrewing;
	
	public Source() {
		isBrewing = false;
	}
	
	public void init(UserInterface ui, Vessel vessel) {
		this.ui = ui;
		this.vessel = vessel;
	}
	
	public void start() {
		isBrewing = true;
		startBrewing();
	}
	
	public void done() {
		isBrewing = false;
	}
	
	protected void declareDone() {
		ui.done();
		vessel.done();
		isBrewing = false;
	}
	
	public abstract boolean isReady();
	public abstract void startBrewing();
	public abstract void pause();
	public abstract void resume();
}
