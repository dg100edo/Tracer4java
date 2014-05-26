package ist.meic.pa.traceinformation;

/**
 * {@link TraceableOperation}
 * Abstract class that represent any operation that can be traced
 */
public abstract class TraceableOperation implements TraceInformation {	
	
	protected String file;
	protected int line;
	protected String behavior;
		
	public TraceableOperation(String file, int line, String behavior){
		this.file = file;
		this.line = line;
		this.behavior = behavior;
	}
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}

}
