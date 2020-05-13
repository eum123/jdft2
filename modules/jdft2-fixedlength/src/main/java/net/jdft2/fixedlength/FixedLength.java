package net.jdft2.fixedlength;

import java.lang.reflect.Field;
import java.util.Arrays;

import net.jdft2.core.field.Order;

public class FixedLength {
	public byte[] marshall(Object obj) {
		
		Class<? extends Object> objClass = obj.getClass();
		
		Order order = objClass.getAnnotation(Order.class);
		String[] fieldNames = order.order();
		
		
		Arrays.stream(order.order()).parallel().forEach(x -> {
			try {
				Field field  = objClass.getDeclaredField(x);
				
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException(e);
			}
		});
		
		
		return null;
	}
	
	private byte[] getValue(String fieldName ) {
		return null;
	}
}
