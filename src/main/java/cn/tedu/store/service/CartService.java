package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.mapper.CartMapper;
@Service
public class CartService implements ICartService {
	@Resource
	private CartMapper cartMapper;
	
	public void addCart(Cart cart) {
		cartMapper.insertCart(cart);
	}

	public List<CartVo> getByUid(Integer uid) {
		List<CartVo>list=cartMapper.selectByUid(uid);
		return list;
	}

	public void removeByIds(Integer[] ids) {
		cartMapper.deleteByIds(ids);
	}

	public void removeById(Integer id) {
		cartMapper.deleteById(id);
	}

	public void updateById(Integer id, Integer num) {
		cartMapper.updateById(id, num);
	}

}
