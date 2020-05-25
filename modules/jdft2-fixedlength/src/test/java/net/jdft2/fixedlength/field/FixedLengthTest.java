package net.jdft2.fixedlength.field;

import org.junit.Test;

import net.jdft2.fixedlength.FixedLength;

public class FixedLengthTest {
	@Test
	public void test() {
		FixedLength fixedLength = new FixedLength();
		
		SampleField field = new SampleField();
		field.setName("Hong");
		field.setAddress("서울 중구");
		
		byte[] fiexed = fixedLength.marshall(field);
		
		System.out.println(new String(fiexed));
	}
}
