package cn.tedu.store.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.PageQueryBean;
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
	public ResponseResult<Void> login(String username, String password,String cip,String cname, HttpSession session) {
		ResponseResult<Void> rr = null;
		User user = new User();
		try {
			user = userService.login(username, password,cip,cname);
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
	public String updatePassword(String username, String newPwd,String oldPwd) {
		//�Ȳ�ѯ�������Ƿ���ȷ
		String old=userService.queryoldPwd(username);
		if(old.equals(oldPwd)){
			/*����������ȷʱ��������*/
			userService.updateuserNwd(username,newPwd);
		}else{
			return "fail";
		}
		return "success";
	}
	
}
