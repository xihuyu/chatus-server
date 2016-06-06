package com.chatus.util;

/**
 * 基础工具类
 * <p>
 * </p>
 * @author fenggaopan 2016年6月6日 下午4:12:40
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} 2016年6月6日
 * @modify by reason:{方法名}:{原因}
 */
public class CommonUtil {
	
	
	/**
	 * 根据传入的类名返回namespace
	 * @author fenggaopan 2016年6月6日 下午4:13:20
	 * @param clazz
	 * @return
	 */
	public static String getStatementId(Class<?> clazz, String statementId) {
		StringBuffer statementIdBuf = new StringBuffer("");
		String nameSpace = clazz.getName().replace(clazz.getPackage().getName() + ".", "");
		statementIdBuf.append(nameSpace);
		statementIdBuf.append(".");
		statementIdBuf.append(statementId);
		return statementIdBuf.toString();
		
	}
	
}
