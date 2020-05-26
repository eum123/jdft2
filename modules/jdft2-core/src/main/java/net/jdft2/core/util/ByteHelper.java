package net.jdft2.core.util;

import java.io.UnsupportedEncodingException;

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
	
	public static byte[] toBytes(int n) {
		byte[] buf = new byte[4];
		buf[0] = (byte) ((n & 0xff000000) >>> 24); // buf[0] = 0;
		buf[1] = (byte) ((n & 0x00ff0000) >>> 16); // buf[1] = 0;
		buf[2] = (byte) ((n & 0x0000ff00) >>> 8); // buf[2] = 51;
		buf[3] = (byte) ((n & 0x000000ff)); // buf[3] = -97; bytes are
		// signed
		return buf;
	}
	/**
	 * Returns a 8-byte array built from a long.
	 * 
	 * @param n
	 *            The number to convert.
	 * @return A byte[].
	 */
	public static byte[] toBytes(long n) {
		return toBytes(n, new byte[8]);
	}

	/**
	 * Build a 8-byte array from a long. No check is performed on the array
	 * length.
	 * 
	 * @param n
	 *            The number to convert.
	 * @param b
	 *            The array to fill.
	 * @return A byte[].
	 */
	public static byte[] toBytes(long n, byte[] b) {
		b[7] = (byte) (n);
		n >>>= 8;
		b[6] = (byte) (n);
		n >>>= 8;
		b[5] = (byte) (n);
		n >>>= 8;
		b[4] = (byte) (n);
		n >>>= 8;
		b[3] = (byte) (n);
		n >>>= 8;
		b[2] = (byte) (n);
		n >>>= 8;
		b[1] = (byte) (n);
		n >>>= 8;
		b[0] = (byte) (n);

		return b;
	}
	
	public static byte[] toBytes(short n) {
		byte[] buf = new byte[2];
		buf[0] = (byte) ((n & 0x0000ff00) >>> 8); // buf[2] = 51;
		buf[1] = (byte) ((n & 0x000000ff)); // buf[3] = -97; bytes are
		// signed
		return buf;
	}

	public static byte[] toBytes(String data, String charset)
			throws UnsupportedEncodingException {
		if (charset == null) {
			return data.getBytes();
		} else {
			return data.getBytes(charset);
		}
	}
}
