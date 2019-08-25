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

	// ������ʾҳ��
	@RequestMapping("/showIndex.do")
	public String showIndex(ModelMap map) {
		List<List<GoodsCategory>> list3 = new ArrayList<>();
		// ����ҵ��㷽���ҵ���������ļ���
		List<GoodsCategory> list2 = IGoodsCategoryService.getByParent(161, 0, 3);
		// ����list2 ���ϵõ�goodsCategory�����ID,�ڵ���ҵ��㷽����ID��null��null���ҵ���������ļ���
		for (int i = 0; i < list2.size(); i++) {
			Integer id = list2.get(i).getId();
			List<GoodsCategory> list = IGoodsCategoryService.getByParent(id, null, null);
			list3.add(list);
		}
		// ��ɻ�ȡ��������Ʒ����
		List<Goods> goodsList = goodsService.getByCategoryId(163, 0, 3);
		map.addAttribute("goodsList", goodsList);

		// ������������ӵ�map��
		map.addAttribute("list2", list2);
		map.addAttribute("list3", list3);

		// ��list2��3��ӵ�map��
		return "index";
	}
}
