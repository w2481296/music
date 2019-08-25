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

	// ��ʾ��ͼ
	@RequestMapping("/showRegister.do")
	public String showRegister() {
		return "register";
	}

	/**
	 * ��ʾlogin.jspҳ��Ŀ���������
	 * 
	 */
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		return "login";
	}

	// ��ʾ�޸�����ҳ��
	@RequestMapping("/showPassword.do")
	public String showPassword() {
		return "personal_password";
	}

	// ��ʾ������Ϣҳ��
	@RequestMapping("/showPersonpage.do")
	public String showpersonpage() {
		return "personpage";
	}

	// �첽������֤�û���
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username) {
		ResponseResult<Void> rr = null;
		// 1.����ҵ��㷽��
		boolean b = userService.checkUsername(username);
		if (b) {
			rr = new ResponseResult<Void>(0, "�û���������");
		} else {
			rr = new ResponseResult<Void>(1, "�û���������");
		}
		return rr;

	}

	// ###1.4.4��֤�ֻ�
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone) {
		ResponseResult<Void> rr = null;
		// 1.����ҵ��㷽��
		if (userService.checkPhone(phone)) {
			rr = new ResponseResult<Void>(0, "�ֻ�������");
		} else {
			rr = new ResponseResult<Void>(1, "�ֻ�������");
		}
		return rr;
	}

	// ʵ��ע�ᰴť����
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(@RequestParam("uname") String username, @RequestParam("upwd") String password,
			@RequestParam("phone") String phone) {
		// ����rr�����user����
		ResponseResult<Void> rr = null;
		try {
			// �����Ը�ֵ��user����
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setPhone(phone);
			// ����ҵ��㷽��
			userService.addUser(user);
			rr = new ResponseResult<Void>(1, "��ӳɹ�");
			// ����rr����state:1 message:��ӳɹ�
		} catch (RuntimeException ex) {
			// ����rr����state:0 message:ex.getMessage();
			rr = new ResponseResult<Void>(0, ex.getMessage());
		}
		return rr;
	}

	// ʵ�ֵ�¼����
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String username, String password, HttpSession session) {
		ResponseResult<Void> rr = null;
		User user = new User();
		try {
			user = userService.login(username, password);
			rr = new ResponseResult<>(1, "��¼�ɹ�");
			session.setAttribute("user", user);

		} catch (RuntimeException e) {
			rr = new ResponseResult<>(0, e.getMessage());
		}
		return rr;

	}

	// �˳��Ĺ���
	@RequestMapping("/exit.do")
	public String exit(HttpSession session) {
		// 1.��sessionʧЧ
		session.invalidate();
		// 2.�ض���index.jsp
		return "redirect:../main/showIndex.do";
	}

	// �޸�����ҳ��
	@RequestMapping("/updatePassword.do")
	@ResponseBody
	public ResponseResult<Void> updatePassword(HttpSession session, String oldPwd, String newPwd) {
		ResponseResult<Void> rr = null;
		try {
			userService.changePassword(this.getId(session), oldPwd, newPwd);
			rr = new ResponseResult<>(1, "�޸ĳɹ�");
		} catch (RuntimeException e) {
			rr = new ResponseResult<>(0, e.getMessage());
		}
		return rr;
	}

	// �޸ĸ�����Ϣ
	@RequestMapping("/updateUser.do")
	@ResponseBody
	public ResponseResult<Void> updateUser(HttpSession session, String username,  
			String phone) {
		ResponseResult<Void> rr = null;
		try {
			// ����ҵ��㷽��
			userService.updateUser(this.getId(session), username,phone);
			rr = new ResponseResult<>(1, "�޸ĳɹ�");
			// ��session�е�user�����滻���޸ĺ�Ķ���
			session.setAttribute("user", userService.getUserById(this.getId(session)));
		} catch (RuntimeException e) {
			rr = new ResponseResult<Void>(0, e.getMessage());
		}
		return rr;

	}

}
