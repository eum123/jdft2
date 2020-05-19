package net.jdft2.core.util;

public class ByteHelper {
	/**
	 * 오른쪽에 filler를 추가한다.
	 * 
	 * @param src
	 * @param length
	 * @param filler
	 * @return
	 */
	public static byte[] fillRight(byte[] src, int length, char filler) {
		if (src.length >= length) {
			return src;
		}

		byte[] fillByte = new byte[length - src.length];
		for (int i = 0; i < fillByte.length; i++) {
			fillByte[i] = (byte) filler;
		}

		return append(src, fillByte);
	}

	/**
	 * 왼쪽에 filler를 추가한다.
	 * @param src
	 * @param length
	 * @param filler
	 * @return
	 */
	public static byte[] fillLeft(byte[] src, int length, char filler) {
		if (src.length >= length) {
			return src;
		}

		byte[] fillByte = new byte[length - src.length];
		for (int i = 0; i < fillByte.length; i++) {
			fillByte[i] = (byte) filler;
		}

		return append(fillByte, src);
	}
	
	/**
	 * Appends two bytes array into one.
	 * 
	 * @param a
	 *            A byte[].
	 * @param b
	 *            A byte[].
	 * @return A byte[].
	 */
	public static byte[] append(byte[] a, byte[] b) {
		if (a == null) {
			return b;
		}

		if (b == null) {
			return a;
		}

		byte[] z = new byte[a.length + b.length];
		System.arraycopy(a, 0, z, 0, a.length);
		System.arraycopy(b, 0, z, a.length, b.length);
		return z;
	}
}
