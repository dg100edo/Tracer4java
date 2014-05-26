	package ist.meic.pa.traceinformation;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link TraceInformations}
 * Class that have a List of TraceInformation and provide method to add TraceInformations
 * and print all TraceInformation (Composite pattern)
 */
public class TraceInformations implements TraceInformation {
	
	private List<TraceInformation> traceInformations;
	
	public TraceInformations(){
		traceInformations = new ArrayList<TraceInformation>();
	}
	
	public void addTraceInformation(TraceInformation traceInformation){
		traceInformations.add(traceInformation);
	}
	
	public List<TraceInformation> getInformations(){
		return traceInformations;
	}
	
	@Override
	public String print() {
		String result = "";
		for(TraceInformation traceInformation : traceInformations){
			result += traceInformation.print();
		}
		return result;
	}

	public boolean isEmpty() {
		return traceInformations.isEmpty();
	}

}
