package edu.uci.java2.contoller;

import java.io.PrintWriter;

public class MessageUtil {
	
	private MessageUtil(){}
	
	public static String getAlertMessate(String messae){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<script type=\"text/javascript\">");
		stringBuilder.append("alert('");
		stringBuilder.append(messae);
		stringBuilder.append("');");
		stringBuilder.append("</script>");
		return stringBuilder.toString();
	}

}
