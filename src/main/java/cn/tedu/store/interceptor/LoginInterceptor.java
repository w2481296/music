package cn.tedu.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.tedu.store.bean.User;

public class LoginInterceptor implements HandlerInterceptor{
	//ִ�п���������֮ǰִ��
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//1.��ȡ��session����
		//��session��ȡ��user
		//2.Object obj==null;˵��û��¼��
		//��ô��ת����¼ҳ�档�ض��򷵻�false
		//3.����return true;
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		if(user==null){
			String path=request.getContextPath()+"/user"+"/showLogin.do";
			response.sendRedirect(path);
			return false;
		}
		return true;
	}
	//���Ʒ���ִ��֮�󣬵�����Ӧҳ��֮ǰ
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}
	//��Ӧҳ��֮��
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
