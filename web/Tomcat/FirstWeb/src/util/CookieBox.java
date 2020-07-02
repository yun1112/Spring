package util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieBox {
	// managing by saving Cookie list in Map
	private Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();

	public CookieBox(HttpServletRequest request) {
		Cookie[] cookies=request.getCookies();
		
		//saving all the cookie data in Map
		for(int i=0;i<cookies.length;i++) {
			//saving data in Map
			cookieMap.put(cookies[i].getName(),cookies[i]);//key, value
		}
	}
	
	public Cookie getCookie(String name) {
		return cookieMap.get(name);//bring it out by key
	}
	
	public String getValue(String name) {
		Cookie cookie=getCookie(name);
		String result=null;
		
		if(cookie!=null) {
			result=cookie.getValue();
		}
		return result;
	}
	
	public boolean exist(String name) {
		return cookieMap.get(name)!=null;//if it's not null, bring the value called 'name' from the cookieMap
	}
	
	//the method making Object called Cookie
	public static Cookie createCookie(String name, String value) {
		return new Cookie(name,value);
	}
}
