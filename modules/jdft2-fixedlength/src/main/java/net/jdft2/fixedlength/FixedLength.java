package net.jdft2.fixedlength;

import java.lang.reflect.Field;
import java.util.Arrays;

import net.jdft2.core.field.FixedLengthField;
import net.jdft2.core.field.Order;
import net.jdft2.core.util.ByteHelper;

public class FixedLength {
	public byte[] marshall(Object obj) {
		
		Class<? extends Object> objClass = obj.getClass();
		
		Order order = objClass.getAnnotation(Order.class);
		String[] fieldNames = order.order();
		
		
		Arrays.stream(order.order()).parallel().forEach(x -> {
			try {
				Field field  = objClass.getDeclaredField(x);
				
				getValue(x, obj, field);
				
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException(e);
			}
		});
		
		return null;
	}
	
	private byte[] getValue(String fieldName, Object obj, Field field ) throws Exception {
		FixedLengthField ff = field.getAnnotation(FixedLengthField.class);
		
		if(field.getType() == String.class) {
			String value = (String)field.get(obj);
			
			return ByteHelper.fillLeft(value.getBytes(), ff.size(), ' ');
			
		} else {
			throw new Exception("not impelemnt other field type");
		}
		
		
	}
}
