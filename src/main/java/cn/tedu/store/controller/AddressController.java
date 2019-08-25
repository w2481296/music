package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IAddressService;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController {
	@Resource
	private IAddressService addService;

	@RequestMapping("/showAddress.do")
	public String showAddress() {
		return "addressAdmin";
	}

	// 异步请求完成 添加收货人信息
	@RequestMapping("/addAddress.do")
	@ResponseBody
	public ResponseResult<Void> addAddress(HttpSession session, @RequestParam("receiverName") String recvname,
			@RequestParam("receiverState") String recvprovince, @RequestParam("receiverCity") String recvcity,
			@RequestParam("receiverDistrict") String recvarea, @RequestParam("receiverAddress") String recvaddress,
			@RequestParam("receiverMobile") String recvphone, @RequestParam("receiverPhone") String recvtel,
			@RequestParam("receiverZip") String recvzip, @RequestParam("addressName") String recvtag) {
		ResponseResult<Void> rr = new ResponseResult<>(1, "添加成功");
		Address address = new Address();
		address.setRecvaddress(recvaddress);
		address.setRecvarea(recvarea);
		address.setRecvcity(recvcity);
		address.setRecvname(recvname);
		address.setRecvphone(recvphone);
		address.setRecvprovince(recvprovince);
		address.setRecvtag(recvtag);
		address.setRecvtel(recvtel);
		address.setRecvzip(recvzip);
		address.setUid(this.getId(session));
		addService.addAddress(address);
		return rr;
	}

	@RequestMapping("/getByUid.do")
	@ResponseBody
	public ResponseResult<List<Address>> getByUid(HttpSession session) {
		ResponseResult<List<Address>> rr = new ResponseResult<List<Address>>(1, "成功");
		List<Address> list = addService.getByUid(this.getId(session));
		rr.setData(list);
		return rr;

	}

	@RequestMapping("/setDefault.do")
	@ResponseBody
	public ResponseResult<Void> setDefault(HttpSession session, Integer id) {
		ResponseResult<Void> rr = null;
		try {
			addService.setDefault(this.getId(session), id);
			rr = new ResponseResult<Void>(1, "成功");
		} catch (RuntimeException e) {
			rr = new ResponseResult<Void>(0, e.getMessage());
		}
		return rr;

	}

	@RequestMapping("/goUpdate.do")
	@ResponseBody
	public ResponseResult<Address> setinfo(Integer id) {
		ResponseResult<Address> rr = new ResponseResult<Address>(1, "成功");
		Address address=addService.getById(id);
		rr.setData(address);
		return rr;

	}
	@RequestMapping("/updateAddress.do")
	@ResponseBody
	public ResponseResult<Address> setaddress(Integer id,@RequestParam("receiverName") String recvname,
			@RequestParam("receiverState") String recvprovince, @RequestParam("receiverCity") String recvcity,
			@RequestParam("receiverDistrict") String recvarea, @RequestParam("receiverAddress") String recvaddress,
			@RequestParam("receiverMobile") String recvphone, @RequestParam("receiverPhone") String recvtel,
			@RequestParam("receiverZip") String recvzip, @RequestParam("addressName") String recvtag) {
		ResponseResult<Address> rr = new ResponseResult<Address>(1, "成功");
		Address address = new Address();
		address.setId(id);
		address.setRecvaddress(recvaddress);
		address.setRecvarea(recvarea);
		address.setRecvcity(recvcity);
		address.setRecvname(recvname);
		address.setRecvphone(recvphone);
		address.setRecvprovince(recvprovince);
		address.setRecvtag(recvtag);
		address.setRecvtel(recvtel);
		address.setRecvzip(recvzip);
		addService.updateAddress(address);
		rr.setData(address);
		return rr;
		
	}
	@RequestMapping("/godelete.do")
	@ResponseBody
	public ResponseResult<Void> deleteaddress(Integer id) {
		ResponseResult<Void> rr = new ResponseResult<Void>(1, "成功");
		addService.removeAddress(id);
		return rr;

	}
}