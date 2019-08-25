package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;

public interface CartMapper {
	void insertCart(Cart cart);
	List<CartVo> selectByUid(Integer uid);
	//����ɾ��
	void deleteByIds(Integer[] ids);
	//����ɾ��
	void deleteById(Integer id);
	//�޸�����
	void updateById(@Param("id")Integer id,@Param("num") Integer num);
}
