package edu.uci.java2.utils;

public class MessageUtil {
	
	private MessageUtil(){}
	
	public static String getAlertMessate(String message){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<script type=\"text/javascript\">");
		stringBuilder.append("alert('");
		stringBuilder.append(message);
		stringBuilder.append("');");
		stringBuilder.append("</script>");
		return stringBuilder.toString();
	}

}
