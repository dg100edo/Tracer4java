import ist.meic.pa.Trace;

class Test{
	
	public void test(){
		Trace.print(1);
		Trace.print(new Integer(1));
		Trace.print("Literal String");
		Trace.print(new String("Ola"));
		Trace.print(new String("Ola"));
	}
}

public class Test3 {

	public static void main(String[] args) {
		(new Test()).test();
	}
}