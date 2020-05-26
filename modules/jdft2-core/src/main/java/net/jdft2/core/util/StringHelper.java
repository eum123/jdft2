package net.jdft2.core.util;

public class StringHelper {
	public static String getValue(Object obj) {
		if(obj instanceof String) {
			return (String)obj;
		} else  {
			
			return String.valueOf(obj);
		}
		
	}
}
