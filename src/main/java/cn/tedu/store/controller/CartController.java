package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.CartService;
import cn.tedu.store.service.ICartService;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseController {
	@Resource
	private ICartService cartService;

	@RequestMapping("/addCart.do")
	@ResponseBody
	public ResponseResult<Void> addCart(HttpSession session, String goodsId, Integer num) {
		ResponseResult<Void> rr = new ResponseResult<>(1, "添加成功");
		Cart cart = new Cart();
		cart.setUid(this.getId(session));
		cart.setGoodsId(goodsId);
		cart.setNum(num);
		cartService.addCart(cart);
		return rr;
	}

	@RequestMapping("/showCart.do")
	public String showCart(HttpSession session, ModelMap map) {
		List<CartVo> list = cartService.getByUid(this.getId(session));
		map.addAttribute("listVo", list);
		return "cart";
	}

	@RequestMapping("removeByIds.do")
	public String removeByIds(Integer[] ids) {
		cartService.removeByIds(ids);
		return "redirect:../cart/showCart.do";
	}
	@RequestMapping("removeById.do")
	public String removeByIds(Integer id) {
		cartService.removeById(id);
		return "redirect:../cart/showCart.do";
	}
	@RequestMapping("updateById.do")
	@ResponseBody
	public ResponseResult<Void> updateById(Integer id,Integer num) {
		ResponseResult<Void>rr=new ResponseResult<>(1, "成功");
		cartService.updateById(id, num);
		return rr;
	}
}
