package ist.meic.pa;

import ist.meic.pa.traceinformation.Storage;
import ist.meic.pa.traceinformation.TraceInformations;

import java.io.PrintStream;

/**
 * {@link Trace}
 * Provide the method print(Object : object) that can be use to print trace informations of the Object object
 * The print method get trace informations of the object from class Storage and print it
 */
public class Trace {
	
	private static PrintStream printStream = System.err;
	
	public static void print(Object object){
		TraceInformations traceInformations = Storage.getTraceInformationsOfObject(object);
		if(traceInformations == null || traceInformations.isEmpty()){
			printStream.println("Tracing for " + object + " is nonexist!");
		}else{
			printStream.println("Tracing for " + object);
			printStream.print(traceInformations.print());
		}
	}
}
