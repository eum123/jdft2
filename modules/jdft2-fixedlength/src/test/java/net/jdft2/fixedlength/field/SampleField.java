package net.jdft2.fixedlength.field;

import net.jdft2.core.field.FixedLengthField;
import net.jdft2.core.field.Order;

@Order(order = {"hong", "address"})
public class SampleField {
	@FixedLengthField(size=10)
	private String name = "hong";
	
	@FixedLengthField(size=20)
	private String address = "address";
}
