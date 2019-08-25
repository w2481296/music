package cn.tedu.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.bean.GoodsCategory;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.service.IGoodsService;

@Controller
@RequestMapping("/main")
public class MainController {
	@Resource
	private IGoodsCategoryService IGoodsCategoryService;
	@Resource
	private IGoodsService goodsService;

	// 定义显示页面
	@RequestMapping("/showIndex.do")
	public String showIndex(ModelMap map) {
		List<List<GoodsCategory>> list3 = new ArrayList<>();
		// 调用业务层方法找到二级分类的集合
		List<GoodsCategory> list2 = IGoodsCategoryService.getByParent(161, 0, 3);
		// 遍历list2 集合得到goodsCategory对象的ID,在调用业务层方法（ID，null，null）找到三级分类的集合
		for (int i = 0; i < list2.size(); i++) {
			Integer id = list2.get(i).getId();
			List<GoodsCategory> list = IGoodsCategoryService.getByParent(id, null, null);
			list3.add(list);
		}
		// 完成获取的热卖商品集合
		List<Goods> goodsList = goodsService.getByCategoryId(163, 0, 3);
		map.addAttribute("goodsList", goodsList);

		// 把两个集合添加到map中
		map.addAttribute("list2", list2);
		map.addAttribute("list3", list3);

		// 把list2和3添加到map中
		return "index";
	}
}
