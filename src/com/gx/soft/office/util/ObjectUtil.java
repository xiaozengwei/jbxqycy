package com.gx.soft.office.util;

import java.lang.reflect.Field;

public class ObjectUtil {
	
	protected ObjectUtil(){
	}
	
	/**
	 * 判断对象的所有属性是否全是null
	 * @param object(对象)
	 * @return
	 */
	public static boolean propertyPd(Object object){
		Class changeClass = object.getClass();
		Field[] fields = changeClass.getDeclaredFields();
		boolean flag = false;
		for (Field f : fields) {
            f.setAccessible(true);// 设置属性是可以访问的(私有的也可以)
			try {
				Object val = f.get(object);// 得到属性值
				if(val != null) {// 只要有1个属性不为空,那么就不是所有的属性值都为空
					flag = true;
	            }
			} catch (Exception e) {
				e.printStackTrace();
			} 
        }
		return flag;
	}

}
