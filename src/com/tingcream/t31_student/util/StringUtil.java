package com.tingcream.t31_student.util;

public class StringUtil {
	
	/**
	 * 判断字符串是否不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		if(str!=null && !str.trim().equals("")) {
			return true;
		}else {
			return false ;
		}
	}
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		return  !isNotBlank(str);
	}
 
}
