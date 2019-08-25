package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;

public interface ICartService {
	void addCart(Cart cart);
	List<CartVo> getByUid(Integer uid);
	void removeByIds(Integer[] ids);
	void removeById(Integer id);
	void updateById(Integer id,Integer num);
}
