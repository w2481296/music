package cn.tedu.store.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.remoting.RemoteTimeoutException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.PageQueryBean;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.SendMail;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource
	private IUserService userService;

	// 显示视图
	@RequestMapping("/showRegister.do")
	public String showRegister() {
		return "register";
	}

	/**
	 * 显示login.jsp页面的控制器方法
	 * 
	 */
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		return "redirect:/index.jsp";
	}

	// 异步请求，验证用户名
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public String checkUsername(String username, String phone,String email) {
		// 1.调用业务层方法
		boolean b = userService.checkUsername(username);
		if (b) {
			return "0";
		} else if (userService.checkPhone(phone)) {
				return "1";
		}else if(userService.checkEmail(email)){
				return "2";
		}
		return "success";

	}

	// ###1.4.4验证手机
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone) {
		ResponseResult<Void> rr = null;
		// 1.调用业务层方法
		if (userService.checkPhone(phone)) {
			rr = new ResponseResult<Void>(0, "该手机已经注册");
		} else {
			rr = new ResponseResult<Void>(1, "手机可以用");
		}
		return rr;
	}

	// 实现注册按钮功能
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(@RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("phone") String phone, @RequestParam("email") String email) {
		// 声明rr对象和user对象
		ResponseResult<Void> rr = null;
		try {
			// 将属性赋值给user对象
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setPhone(phone);
			user.setEmail(email);
			// 调用业务层方法
			userService.addUser(user);
			rr = new ResponseResult<Void>(1, "添加成功");
			// 创建rr对象，state:1 message:添加成功
		} catch (RuntimeException ex) {
			// 创建rr对象，state:0 message:ex.getMessage();
			rr = new ResponseResult<Void>(0, ex.getMessage());
		}
		return rr;
	}

	// 实现登录功能
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String username, String password, String cip, String cname, HttpSession session) {
		ResponseResult<Void> rr = null;
		User user = new User();
		try {
			user = userService.login(username, password, cip, cname);
			rr = new ResponseResult<>(1, "登录成功");
			session.setAttribute("user", user);

		} catch (RuntimeException e) {
			rr = new ResponseResult<>(0, e.getMessage());
		}
		return rr;

	}

	// 退出的功能
	@RequestMapping("/exit.do")
	public String exit(HttpSession session) {
		// 1.让session失效
		session.invalidate();
		// 2.重定向到index.jsp
		return "redirect:../main/showIndex.do";
	}

	// 修改密码页面
	@RequestMapping("/updatePassword.do")
	@ResponseBody
	public String updatePassword(String username, String newPwd, String oldPwd) {
		// 先查询旧密码是否正确
		String old = userService.queryoldPwd(username);
		if (old.equals(oldPwd)) {
			/* 密码输入正确时更改密码 */
			userService.updateuserNwd(username, newPwd);
		} else {
			return "fail";
		}
		return "success";
	}

	@RequestMapping("/RetrievePassword.do")
	@ResponseBody
	protected String doPost(String uname,String email,HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取用户的邮箱
		User user = null;
		// 实例化一个发送邮件的对象
		SendMail mySendMail = new SendMail();
		// 根据邮箱找到该用户信息
		user = userService.getUserByEmail(email);
		if (user != null) {
			mySendMail.sendMail(email, "乐器店管理系统提醒，您的密码为：" + user.getPassword());
			return "1";
		}
		return "2";
		
	}
}
