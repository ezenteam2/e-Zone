package jspexp.z01_vo;
// jspexp.z01_vo.IpList
import java.util.ArrayList;

public class IpList {
	private static ArrayList<String> 
		list = new ArrayList<String>();
	
	public void add(String prod) {
		list.add(prod);
	}
	public ArrayList<String> getList(){
		return list;
	}
}
