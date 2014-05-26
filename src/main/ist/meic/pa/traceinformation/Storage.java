package ist.meic.pa.traceinformation;

import java.util.IdentityHashMap;

/**
 * {@link Storage}
 * Store {@link TraceInformations} of objects
 * [Before start store {@link TraceInformations} of an Object object we need call initTraceInformationsOfObject(object)] 
 */
public class Storage {
		
	private static IdentityHashMap<Object, TraceInformations> traceInformationsOfObjects;
	
	static{
		traceInformationsOfObjects = new IdentityHashMap<Object, TraceInformations>(); 
	}
		
	private static IdentityHashMap<Object, TraceInformations> getTraceInformationsOfObjects(){
		return traceInformationsOfObjects;
	}
	
	public static void initTraceInformationsOfObject(Object object){
		setTraceInformationsOfObject(object, new TraceInformations());
	}
	
	public static void setTraceInformationsOfObject(Object object, TraceInformations traceInformations){
		getTraceInformationsOfObjects().put(object, traceInformations);
	}
	
	public static TraceInformations getTraceInformationsOfObject(Object object){
		return getTraceInformationsOfObjects().get(object);
	}
		
	public static void addTraceInformationToObject(Object object, TraceInformation traceInformation){
		TraceInformations objectTraceInformations = getTraceInformationsOfObject(object);
		if(object != null && objectTraceInformations != null && !object.getClass().isPrimitive())
			objectTraceInformations.addTraceInformation(traceInformation);
	}
	
	public static void addTraceInformationToObjects(Object [] objects, TraceInformation traceInformation){
		for(Object object : objects){
			TraceInformations objectTraceInformations = getTraceInformationsOfObject(object);
			if(object != null && objectTraceInformations != null && !object.getClass().isPrimitive())
				objectTraceInformations.addTraceInformation(traceInformation);
		}
	}
}