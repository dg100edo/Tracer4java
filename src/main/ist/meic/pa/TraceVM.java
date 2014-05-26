package ist.meic.pa;

import javassist.ClassPool;
import javassist.Loader;

/**
 * {@link TraceVM}
 * This class allow us to run a program that we want trace
 * This program expect a name of a java program (and their arguments) and,
 * Create a {@link Loader}, registry a {@link TracerTranslator} and run the
 * program with the provided arguments.
 */
public class TraceVM {
	public static void main(String [] args){
	    if(args.length < 1){
	        System.err.println("You must provide the name of the program that you want to run inside TraceVM");
	    }else{
	        try{
    	        ClassPool pool = ClassPool.getDefault();
    	        Loader classLoader = new Loader(pool);    	        
    	    	classLoader.addTranslator(pool, new TracerTranslator());
    	        String[] restArgs = new String[args.length - 1];
    	        System.arraycopy(args, 1, restArgs, 0, restArgs.length);
                classLoader.run(args[0], restArgs);
	        }catch(Throwable e){
	            throw new RuntimeException(e);
	        }
	    }
    }
}
