package ist.meic.pa;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.Translator;

/**
 * {@link TracerTranslator}
 * Derive from {@link Translator}, Intercept class loading
 * The onLoad method get the {@link CtClass} from the {@link ClassPool} and
 * pass it to an {@link Instrumentor} (instrument method)
 */
public class TracerTranslator implements Translator {
    
	private Instrumentor instrumentor = new Instrumentor();
	
	public void start(ClassPool pool) throws NotFoundException, CannotCompileException {
        // Do nothing
    }
    
    public void onLoad(ClassPool pool, String className) throws NotFoundException, CannotCompileException {
    	CtClass ctClass = pool.get(className);
    	instrumentor.instrument(ctClass);
    }
}