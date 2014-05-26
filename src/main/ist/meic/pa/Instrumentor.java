package ist.meic.pa;

import ist.meic.pa.traceinformation.Storage;
import ist.meic.pa.traceinformation.TraceInformations;

import java.util.HashMap;
import java.util.Map;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;
import javassist.expr.NewExpr;

/**
 * {@link Instrumentor}
 * This class instrument a {@link CtClass} with a {@link TracerExprEditor} (derive from {@link ExprEditor})
 * The instrument method ignore some classes that are in ignoreClass Map (some classes need to be ignored
 * for implementation issues)
 */
public class Instrumentor{        
	private static Map<String, Boolean> ignoreClass = new HashMap<String, Boolean>();
	
	static{
		ignoreClass.put(TraceInformations.class.getName(), true);
		ignoreClass.put(Storage.class.getName(), true);
		ignoreClass.put(Trace.class.getName(), true);
		ignoreClass.put(TraceInformations.class.getName(), true);
	}
	
    public void instrument(CtClass ctClass) throws CannotCompileException{
    	if(!ignoreClass(ctClass)){        	
    		ctClass.instrument(new TracerExprEditor());    		
    	}
    }
    
	protected boolean ignoreClass(CtClass ctClass){
		return ctClass.isInterface() || ignoreClass.get(ctClass.getName()) != null;
	}
	
    protected class TracerExprEditor extends ExprEditor{
    	@Override
	    public void edit(NewExpr newExpr) throws CannotCompileException {
	    	try{
	    		String file = newExpr.getFileName();
	    		int line = newExpr.getLineNumber();
	    		String constructorName = newExpr.getConstructor().getLongName();
	    		
	    		String objectAsReturn = String.format("new ist.meic.pa.traceinformation.ObjectAsReturn(\"%s\", %d, \"%s\")", file, line, constructorName);
	    		
	    		String initInfo = "ist.meic.pa.traceinformation.Storage.initTraceInformationsOfObject(($w) $_)";
	    		String addReturnInfo = "ist.meic.pa.traceinformation.Storage.addTraceInformationToObject(($w) $_," + objectAsReturn + ")";
	    		
	    		if(newExpr.getConstructor().isConstructor()){
					newExpr.replace("{ $_ = $proceed($$); " + initInfo + "; " + addReturnInfo + ";}");
				}	
	    	} catch (Exception e) {
				throw new RuntimeException(e);
			}
	    }
    	
    	@Override
	    public void edit(MethodCall methodCall) throws CannotCompileException {
	    	try{
	    		String file = methodCall.getFileName();
	    		int line = methodCall.getLineNumber();
	    		String methodName = methodCall.getMethod().getLongName();
	    		
	    		String objectAsArgument = String.format("new ist.meic.pa.traceinformation.ObjectAsArgument(\"%s\", %d, \"%s\")", file, line, methodName);
	    		String objectAsReturn = String.format("new ist.meic.pa.traceinformation.ObjectAsReturn(\"%s\", %d, \"%s\")", file, line, methodName);
	    		
	    		String addArgumentsInfo = "ist.meic.pa.traceinformation.Storage.addTraceInformationToObjects($args," + objectAsArgument + ")";
	    		String addReturnInfo = "ist.meic.pa.traceinformation.Storage.addTraceInformationToObject(($w) $_," + objectAsReturn + ")";
	    		
	    		methodCall.replace("{" + addArgumentsInfo + "; $_ = $proceed($$); " + addReturnInfo + ";}");
	    	} catch (Exception e) {
				throw new RuntimeException(e);
			}
	    }	    
	};
}