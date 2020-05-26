package net.jdft2.fixedlength.field;

import static org.junit.Assert.assertEquals;

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
	
	@Test
	public void longTest() {
		FixedLength fixedLength = new FixedLength();
		LongSampleField field = new LongSampleField();
		field.setAge("10");
		field.setHouseCount(2);
		
		byte[] fiexed = fixedLength.marshall(field);
		
		assertEquals(16, fiexed.length);
	}
}
