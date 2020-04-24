package z00_util;

public class Nk {
	public static String toStr(String str) {
		// null ==> "", 0으로 처리하는 기능 메서드 선언
		return str==null?"":str;
	}
	public static int toInt(String intS) {
		return intS==null||intS.equals("")?0:new Integer(intS);
	}
	public static double toDbl(String dblS) {
		return dblS==null||dblS.equals("")?0.0:new Double(dblS);
	}
	public static String toStr(String str, String init) {
		// null ==> "", 0으로 처리하는 기능 메서드 선언
		return str==null?init:str;
	}
	public static int toInt(String intS, int init) {
		return intS==null||intS.equals("")?init:new Integer(intS);
	}
	public static double toDbl(String dblS, double init) {
		return dblS==null||dblS.equals("")?init:new Double(dblS);
	}
}
