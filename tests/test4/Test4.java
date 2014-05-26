import ist.meic.pa.Trace;

class Test{
	
	private Object myFoo = foo();
	private Object myBar = bar();
	
	public Object foo(){
		return new String("Foo");
	}
	
	public Object bar(){
		return new String("Bar");
	}
	
	public void nothing(Object o){}

	public void nothing(Object o, int i){}
	
	public int identity(int i){
		return i;
	}
		
	public void test(){
		nothing(myFoo);
		nothing(myBar, 1);
		identity(1);
		Trace.print(1);
		Trace.print(myFoo);
		Trace.print(myBar);
	}
}

public class Test4 {

	public static void main(String[] args) {
		(new Test()).test();
	}
}