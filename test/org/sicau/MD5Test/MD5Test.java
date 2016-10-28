package org.sicau.MD5Test;

import org.junit.Test;
import org.sicau.util.Tools;

public class MD5Test {
	
	
	
	@Test
	public void testMd5(){
		String sec = Tools.MD5Encode("266915", "");
		System.out.println(sec);
	}
}
