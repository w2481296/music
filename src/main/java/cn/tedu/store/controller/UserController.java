package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.bean.ResponseResult;
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
		return "login";
	}

	// 显示修改密码页面
	@RequestMapping("/showPassword.do")
	public String showPassword() {
		return "personal_password";
	}

	// 显示个人信息页面
	@RequestMapping("/showPersonpage.do")
	public String showpersonpage() {
		return "personpage";
	}

	// 异步请求，验证用户名
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username) {
		ResponseResult<Void> rr = null;
		// 1.调用业务层方法
		boolean b = userService.checkUsername(username);
		if (b) {
			rr = new ResponseResult<Void>(0, "用户名不可用");
		} else {
			rr = new ResponseResult<Void>(1, "用户名可以用");
		}
		return rr;

	}

	// ###1.4.4验证手机
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone) {
		ResponseResult<Void> rr = null;
		// 1.调用业务层方法
		if (userService.checkPhone(phone)) {
			rr = new ResponseResult<Void>(0, "手机不可用");
		} else {
			rr = new ResponseResult<Void>(1, "手机可以用");
		}
		return rr;
	}

	// 实现注册按钮功能
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(@RequestParam("uname") String username, @RequestParam("upwd") String password,
			@RequestParam("phone") String phone) {
		// 声明rr对象和user对象
		ResponseResult<Void> rr = null;
		try {
			// 将属性赋值给user对象
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setPhone(phone);
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
	public ResponseResult<Void> login(String username, String password, HttpSession session) {
		ResponseResult<Void> rr = null;
		User user = new User();
		try {
			user = userService.login(username, password);
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
	public ResponseResult<Void> updatePassword(HttpSession session, String oldPwd, String newPwd) {
		ResponseResult<Void> rr = null;
		try {
			userService.changePassword(this.getId(session), oldPwd, newPwd);
			rr = new ResponseResult<>(1, "修改成功");
		} catch (RuntimeException e) {
			rr = new ResponseResult<>(0, e.getMessage());
		}
		return rr;
	}

	// 修改个人信息
	@RequestMapping("/updateUser.do")
	@ResponseBody
	public ResponseResult<Void> updateUser(HttpSession session, String username,  
			String phone) {
		ResponseResult<Void> rr = null;
		try {
			// 调用业务层方法
			userService.updateUser(this.getId(session), username,phone);
			rr = new ResponseResult<>(1, "修改成功");
			// 把session中的user对象替换成修改后的对象
			session.setAttribute("user", userService.getUserById(this.getId(session)));
		} catch (RuntimeException e) {
			rr = new ResponseResult<Void>(0, e.getMessage());
		}
		return rr;

	}

}
