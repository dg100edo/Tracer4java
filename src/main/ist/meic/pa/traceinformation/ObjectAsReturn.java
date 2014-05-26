package ist.meic.pa.traceinformation;

/**
 * {@link ObjectAsReturn}
 * {@link TraceInformation} that represent a Operation that an object is passed as argument to an method
 */
public class ObjectAsReturn extends TraceableOperation{
		
	public ObjectAsReturn(String file, int line, String behavior){
		super(file, line, behavior);
	}

	@Override
	public String print() {
		return "  <- " + behavior + " on " + file + ":" + line + "\n"; 
	}
}
