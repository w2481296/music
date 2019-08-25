package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Goods;

public interface GoodsMapper {
	//��ѯ��Ʒ��Ϣ
	List<Goods> selectByCategoryId(
			@Param("categoryId") Integer categoryId,
			@Param("offset") Integer offset,
			@Param("count") Integer count);

	Integer selectCount(Integer categoryId);
	
	Goods selectById(String id);
}
