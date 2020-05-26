package net.jdft2.core.util;

public class LongHelper {
	public static Long getValue(Object obj) throws Exception {
		if(obj instanceof String) {
			return Long.valueOf((String)obj);
		} else if(obj instanceof Long) {
			return (Long)obj;
		} else if(obj instanceof Integer) {
			return ((Integer)obj).longValue();
		} else  {
			throw new Exception("can not convert to Integer :" + obj);
		}
		
	}
}
