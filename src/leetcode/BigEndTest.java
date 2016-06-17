package leetcode;

import java.nio.ByteOrder;

public class BigEndTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
		      System.out.println("BIG_ENDIAN");
		    } else {
		      System.out.println("LITTLE_ENDIAN");
		    }
		  }
	}

