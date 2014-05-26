ant

cd tests/test0
javac -cp .:../../tracer.jar Test0.java
java -cp .:../../javassist.jar:../../tracer.jar ist.meic.pa.TraceVM Test0 >& out
diff out expected
rm *.class

cd ../test1
javac -cp .:../../tracer.jar Test1.java
java -cp .:../../javassist.jar:../../tracer.jar ist.meic.pa.TraceVM Test1 >& out
diff out expected
rm *.class

cd ../test2
javac -cp .:../../tracer.jar Test2.java
java -cp .:../../javassist.jar:../../tracer.jar ist.meic.pa.TraceVM Test2 >& out
diff out expected
rm *.class

cd ../test3
javac -cp .:../../tracer.jar Test3.java
java -cp .:../../javassist.jar:../../tracer.jar ist.meic.pa.TraceVM Test3 >& out
diff out expected
rm *.class

cd ../test4
javac -cp .:../../tracer.jar Test4.java
java -cp .:../../javassist.jar:../../tracer.jar ist.meic.pa.TraceVM Test4 >& out
diff out expected
rm *.class
