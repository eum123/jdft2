package net.jdft2.fixedlength.field;

import net.jdft2.core.field.DataType;
import net.jdft2.core.field.FixedLengthField;
import net.jdft2.core.field.Order;

@Order(order = {"age", "houseCount"})
public class LongSampleField {
	@FixedLengthField(dataType=DataType.LONG)
	private String age = "10";
	
	@FixedLengthField(dataType=DataType.LONG)
	private Integer houseCount = 1;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Integer getHouseCount() {
		return houseCount;
	}

	public void setHouseCount(Integer houseCount) {
		this.houseCount = houseCount;
	}
}
