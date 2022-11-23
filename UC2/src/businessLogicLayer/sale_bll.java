package businessLogicLayer;
import java.sql.SQLException;

import java.util.ArrayList;
import data_access_layer.addMeaning_dao;
import presentationLayer.addMeaningView;
import transfer_obj.meaning;
import transfer_obj.words;

public class sale_bll {
	private static addMeaning_dao addmeaningDao;
	
	public sale_bll()  
	{
		addmeaningDao = new addMeaning_dao();
	    
		
	}
	
	public ArrayList<words> getarray() throws SQLException {
		ArrayList<words> word = addmeaningDao.getallsales();
		
		return word;
		
	}
	public static void Main(String args) throws SQLException {
	   addMeaningView view= new addMeaningView();
	  
	   getlocationplace();
	   try {
		addmeaningDao.addMeaningdb();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public static ArrayList<meaning> getlocationplace() throws SQLException {
		addMeaningView view = new addMeaningView();
	ArrayList<meaning> location = view.getlocation();
	System.out.println("this is in bll class");
      System.out.println(location.get(0).getWord());
      System.out.println(location.get(0).getMeanings());
		return location;
	}
}