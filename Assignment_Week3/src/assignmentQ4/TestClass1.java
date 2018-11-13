package assignmentQ4;

import java.util.ArrayList;
import java.util.List;

public class TestClass1 {
	
	private List <String> ListItems = new ArrayList<String>();
	
	public void addField(String itm){
		
		ListItems.add(itm);
		
}
	
	public List<String> getListOfFields(){
		
	     	return ListItems;
	}

}
