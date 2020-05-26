package net.jdft2.fixedlength;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import net.jdft2.core.field.DataType;
import net.jdft2.core.field.FixedLengthField;
import net.jdft2.core.field.Order;
import net.jdft2.core.field.Padding;
import net.jdft2.core.util.ByteHelper;
import net.jdft2.core.util.IntegerHelper;
import net.jdft2.core.util.LongHelper;
import net.jdft2.core.util.StringHelper;

public class FixedLength {
	/**
	 * Object 를 byte[] 로 변환한다.
	 * 
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
				Field field = objClass.getDeclaredField(x);
				out.write(getValue(x, obj, field));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});

		return out.toByteArray();
	}

	private byte[] getValue(String fieldName, Object obj, Field field) throws Exception {
		FixedLengthField ff = field.getAnnotation(FixedLengthField.class);
		field.setAccessible(true);
		
		Object data = field.get(obj);
		
		if(ff.dataType() == DataType.STRING) {
			if(data instanceof List) {
				return getList((List)data);
			} else if(data instanceof Map) {
				throw new Exception("unsupport data type  : ");
			} else {
				String value = StringHelper.getValue(data);
				return getPaddingValue(ff, value);
			}
		} else if (ff.dataType() == DataType.INTEGER) {
			Integer integerValue = IntegerHelper.getValue(data);
			return ByteHelper.toBytes(integerValue.intValue());
		} else if (ff.dataType() == DataType.LONG) {
			Long longValue = LongHelper.getValue(data);
			return ByteHelper.toBytes(longValue.longValue());
		} else {
			
			if(data instanceof List) {
				return getList((List)data);
			} 
			
			throw new Exception("unsupport data type (other object) : " + ff.dataType());
		}

	}
	
	private byte[] getList(List list) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		list.forEach(x -> {
			try {
				out.write(marshall(x));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		});
		
		return out.toByteArray();
	}
	

	private byte[] getPaddingValue(FixedLengthField fixedField, String value) {
		if (fixedField.padding() == Padding.LEFT) {
			return ByteHelper.fillLeft(value.getBytes(), fixedField.size(), fixedField.paddingDelimitor());
				} else {
			return ByteHelper.fillRight(value.getBytes(), fixedField.size(), fixedField.paddingDelimitor());
		}
	}

	/**
	 * byte[]을 Object 형태로 변환
	 * 
	 * @param <T>
	 * @param data
	 * @param clazz
	 * @return
	 */
	public <T> T unmarshall(byte[] data, T clazz) {
		return null;
	}
}
