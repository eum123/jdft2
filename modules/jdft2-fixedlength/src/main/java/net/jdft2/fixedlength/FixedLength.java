package net.jdft2.fixedlength;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import net.jdft2.core.field.FixedLengthField;
import net.jdft2.core.field.Order;
import net.jdft2.core.util.ByteHelper;

public class FixedLength {
	/**
	 * Object 를 byte[] 로 변환한다.
	 * @param obj
	 * @return
	 */
	public byte[] marshall(Object obj) {
		
		Class<? extends Object> objClass = obj.getClass();
		
		Order order = objClass.getAnnotation(Order.class);
		String[] fieldNames = order.order();
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		Arrays.stream(order.order()).forEach(x -> {
			try {
				Field field  = objClass.getDeclaredField(x);
				out.write(getValue(x, obj, field));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});
		
		return out.toByteArray();
	}
	
	private byte[] getValue(String fieldName, Object obj, Field field ) throws Exception {
		FixedLengthField ff = field.getAnnotation(FixedLengthField.class);
		
		if(field.getType() == String.class) {
			field.setAccessible(true);
			String value = (String)field.get(obj);
			
			field.setAccessible(false);
			return ByteHelper.fillLeft(value.getBytes(), ff.size(), ' ');
			
		} else {
			throw new Exception("not impelemnt other field type");
		}
		
	}
	
	/**
	 * byte[]을 Object 형태로 변환 
	 * @param <T>
	 * @param data
	 * @param clazz
	 * @return
	 */
	public <T> T unmarshall(byte[] data, T clazz) {
		return null;
	}
}
