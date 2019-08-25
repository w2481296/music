package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;

public interface CartMapper {
	void insertCart(Cart cart);
	List<CartVo> selectByUid(Integer uid);
	//批量删除
	void deleteByIds(Integer[] ids);
	//单个删除
	void deleteById(Integer id);
	//修改数量
	void updateById(@Param("id")Integer id,@Param("num") Integer num);
}
