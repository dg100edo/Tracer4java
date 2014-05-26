package ist.meic.pa.traceinformation;

/**
 * {@link ObjectAsArgument}
 * {@link TraceInformation} that represent a Operation that an object is returned as argument of an method (or contructor)
 */
public class ObjectAsArgument extends TraceableOperation {
			
	public ObjectAsArgument(String file, int line, String behavior){
		super(file, line, behavior);
	}

	@Override
	public String print() {
		return "  -> " + behavior + " on " + file + ":" + line + "\n"; 
	}
}
