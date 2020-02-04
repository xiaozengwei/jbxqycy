package com.gx.soft.common.util;


import java.math.BigDecimal;

/**
 * Double类型的运算
 */
public class DoubleUtil {
	/**
	 * 提供精准的加法运算(四舍五入保留两位有效数字)
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static Double add(Double value1, Double value2) {
		BigDecimal b1 = new BigDecimal(Double.toString(value1));
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		return b1.add(b2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}


	/**
	 * 带小数的精确相减
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static double sub(String value1, String value2) {
		BigDecimal b1 = new BigDecimal(value1);
		BigDecimal b2 = new BigDecimal(value2);
		return b1.subtract(b2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * Double类型精准相乘
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static Double mul(String value1, Double value2) {
		BigDecimal b1 = new BigDecimal(value1);
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		return b1.multiply(b2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static Double mul1(String value1, String value2) {
		BigDecimal b1 = new BigDecimal(value1);
		BigDecimal b2 = new BigDecimal(value2);
		return b1.multiply(b2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
