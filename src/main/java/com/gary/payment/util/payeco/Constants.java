package com.gary.payment.util.payeco;

/**
 * @author
 */
/**
 * @author
 */
public class Constants {
	// ----商户信息：商户根据对接的实际情况对下面数据进行修改； 以下数据在测试通过后，部署到生产环境，需要替换为生产的数据----
	// 商户编号，由易联产生，邮件发送给商户
	public static String MERCHANT_ID = "302020000058";
	// 商户接收订单通知接口地址；
	public static String MERCHANT_NOTIFY_URL = "http://www.xxxxx.com/Notify.do";
	// 商户RSA私钥，商户自己产生（可采用易联提供RSA工具产生）
	public static String MERCHANT_RSA_PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOAqNu0SFh5Ksz8Mp/vzm1kxiMYoSREXNXGajCHkKJIVwTaxtPaPYq3JiASZbCALrjp9UM0jLsqayDzF51paUt5lbBDRgqabAClUos3X4c7v2uUt98ILDi8ABQV8BrMZE5RKaLcvvr3mhu/JhabXBz2SBflSCSG3K8HQRTDjjp7nAgMBAAECgYBg01suQ6WyJ+oMzdaxiaQMfszpavVEoJXBIFRvPzIXB7aRfWkBJyYkkuxhsDN4FBOJyB9ivFO1x+298m3gJSutfXfSRA9Kq9XrEIQDjJB4PBx8yTVmVckgCJlsWnhuySHf7gapLkfLHQ+GgiUpYUPW0MJczsu7juuMUZdKHJ6rIQJBAPVLJAxXQYI2e8WMfTPR1jqeZXSQ5r4XI0d8wKFMDa68gq3Y3B2CKmWO16faxafJ8oUWJtJJwRQT6YItBVA3DWUCQQDp8vymxQkLCVpyQ+SfG0Ab9mw2G7p2Y3pAYwms7SIOILoADUbJl2UxpyROj9N9Lq2ndZ0rNIWw4iJXigwRuaxbAkEAkiN7TZLqp25YXUCvEyFwFapq3YC6yAO29A9CIJbUDAepf3OU6Eu1gJ4So6F2YtmxEFM7O8vPKWwXkYPLB5hU9QJAHLjWR+s81vwI/KpVMSt5TXWNh38T/2DrK2h9UZuzaKSf8U2v+SP7KoNos7R4tI+8hiisaReDqlm4+aJbJPn0rQJBAK0EQLyG8iks7Ppclq9UBgEx2iKSsg9y60aSt1YwI73wEdW18paBtoUMjQ5GAqCyVmEb01IY6Kn1si43zqHct4o=";

	// ----易联信息： 以下信息区分为测试环境和生产环境，商户根据自己对接情况进行数据选择----
	// 易联服务器地址_测试环境
	public static String PAYECO_URL = "https://testmobile.payeco.com";
	// 易联服务器地址_生产环境
	// public static final String PAYECO_URL = "https://mobile.payeco.com";

	// 订单RSA公钥（易联提供）_测试环境
	public static String PAYECO_RSA_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCRxin1FRmBtwYfwK6XKVVXP0FIcF4HZptHgHu+UuON3Jh6WPXc9fNLdsw5Hcmz3F5mYWYq1/WSRxislOl0U59cEPaef86PqBUW9SWxwdmYKB1MlAn5O9M1vgczBl/YqHvuRzfkIaPqSRew11bJWTjnpkcD0H+22kCGqxtYKmv7kwIDAQAB";
	// 订单RSA公钥（易联提供）_测试环境
	// public static final String PAYECO_RSA_PUBLIC_KEY =
	// "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCoymAVb04bvtIrJxczCT/DYYltVlRjBXEBFDYQpjCgSorM/4vnvVXGRb7cIaWpI5SYR6YKrWjvKTJTzD5merQM8hlbKDucxm0DwEj4JbAJvkmDRTUs/MZuYjBrw8wP7Lnr6D6uThqybENRsaJO4G8tv0WMQZ9WLUOknNv0xOzqFQIDAQAB";

	// 签名数据编码
	public static final String PAYECO_DATA_ENCODE = "UTF-8";

	// 连接超时，10秒
	public static final int CONNECT_TIME_OUT = 10000;

	// 响应超时时间，60秒
	public static final int RESPONSE_TIME_OUT = 60000;

	// 接口版本
	public static final String COMM_INTF_VERSION = "2.0.0";

	/**
	 * 获取XML报文元素，只支持单层的XML，若是存在嵌套重复的元素，只返回开始第一个
	 * 
	 * @param srcXML
	 *            ： xml串
	 * @param element
	 *            ： 元素
	 * @return ： 元素对应的值
	 */
	public static String getXMLValue(String srcXML, String element) {
		String ret = "";
		try {
			String begElement = "<" + element + ">";
			String endElement = "</" + element + ">";
			int begPos = srcXML.indexOf(begElement);
			int endPos = srcXML.indexOf(endElement);
			if (begPos != -1 && endPos != -1 && begPos <= endPos) {
				begPos += begElement.length();
				ret = srcXML.substring(begPos, endPos);
			} else {
				ret = "";
			}
		} catch (Exception e) {
			ret = "";
		}
		return ret;
	}
}
