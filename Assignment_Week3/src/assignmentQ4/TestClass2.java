package assignmentQ4;

public class TestClass2 extends TestClass1 {
	
	public static void main(String args[]){
		
		TestClass2 obj = new TestClass2();
		obj.addField("Name");
		obj.addField("Employee Id");
		obj.addField("address");
		System.out.println("List of fields: " + obj.getListOfFields());
	}

}
