package net.jdft2.fixedlength.field;

import net.jdft2.core.field.FixedLengthField;
import net.jdft2.core.field.Order;
import net.jdft2.core.field.Padding;

@Order(order = {"name", "address"})
public class SampleField {
	@FixedLengthField(size=10)
	private String name = "hong";
	
	@FixedLengthField(size=20, padding=Padding.LEFT)
	private String address = "address";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
