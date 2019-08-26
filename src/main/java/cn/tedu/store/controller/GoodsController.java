package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.org.apache.regexp.internal.recompile;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Resource
	private IGoodsService goodsService;

	@RequestMapping("/showSearch.do")
	public String showSearch(Integer categoryId, Integer page, ModelMap map) {
		if (page == null) {
			page = 1;
		}
		Integer offset = (page - 1) * 12;
		List<Goods> list = goodsService.getByCategoryId(categoryId, offset, 12);
		map.addAttribute("list", list);
		Integer count = goodsService.getCount(categoryId);
		int pageSize = count % 12 == 0 ? count / 12 : count / 12 + 1;
		map.addAttribute("count", count);
		map.addAttribute("pageSize", pageSize);
		// 把categoryId添加到map中
		map.addAttribute("categoryId", categoryId);
		// 把当前页数存在map给页面做点击页面时使用
		map.addAttribute("curpage", page);
		return "search";
	}

	@RequestMapping("/showProductDetails.do")
	public String showProduct(String id, ModelMap map) {
		Goods goods=goodsService.getById(id);
		map.addAttribute("goods",goods);
		return "product_details";
	}
	

}
