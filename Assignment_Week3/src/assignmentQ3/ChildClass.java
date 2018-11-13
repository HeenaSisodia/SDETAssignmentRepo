package assignmentQ3;

public class ChildClass extends ParentClass {

	public void test1(){
		System.out.println("Inside Child Public class");
	}
	
	protected void test2(){
		System.out.println("Inside Child protected class");
	}
	
	public void test3(){
		System.out.println("Inside child classs- overriding parent protected class");
	}
	
	public static void main(String args[]){
		
		ChildClass obj1 = new ChildClass();
		ParentClass obj2 = new ParentClass();
		
		obj1.test1();
		obj1.test2();
		obj1.test3();
		obj2.test1();
		obj2.test2();
		obj2.test3();
	}
}
