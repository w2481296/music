package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.mapper.GoodsMapper;

@Service
public class GoodsService implements IGoodsService {
	@Resource
	private GoodsMapper goodsMapper;
	public List<Goods> getByCategoryId(Integer categoryId, Integer offset, Integer count) {
		
		return goodsMapper.selectByCategoryId(categoryId, offset, count);
	}
	public Integer getCount(Integer categoryId) {
		return goodsMapper.selectCount(categoryId);
	}
	
	public Goods getById(String id) {
		return goodsMapper.selectById(id);
	}


}
