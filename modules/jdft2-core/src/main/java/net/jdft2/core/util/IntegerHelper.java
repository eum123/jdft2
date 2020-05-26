package net.jdft2.core.util;

public class IntegerHelper {
	public static Integer getValue(Object obj) throws Exception {
		if(obj instanceof String) {
			return Integer.valueOf((String)obj);
		} else if(obj instanceof Integer) {
			return (Integer)obj;
		} else  {
			throw new Exception("can not convert to Integer :" + obj);
		}
		
	}
}
