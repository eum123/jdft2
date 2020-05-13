package net.jdft2.fixedlength.field;

import net.jdft2.core.field.Field;
import net.jdft2.core.field.Order;

@Order(order = {"hong", "address"})
public class SampleField {
	@Field(size=10)
	private String name = "hong";
	
	@Field(size=20)
	private String address = "address";
}
