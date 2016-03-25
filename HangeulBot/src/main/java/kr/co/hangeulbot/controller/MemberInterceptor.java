package kr.co.hangeulbot.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		Boolean flag = true;
		HttpSession session =  request.getSession();
		if(session!=null){
			if(session.getAttribute("loginUserInfo")!=null){
				flag = true;
			}else{
				response.sendRedirect("goLoginPage.do");
				flag = false;
			}
		}else{
			response.sendRedirect("goLoginPage.do");
			flag = false;
		}
		return flag;
	}
}

