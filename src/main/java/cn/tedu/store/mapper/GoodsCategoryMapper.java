package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.GoodsCategory;

public interface GoodsCategoryMapper {
	//��ѯ��Ʒ����
	/*
	 * 1.mybatis�����������һ������ô��Ҫ����
	 * 2��������������֣���һ�ְѲ����б��װ��������
	 * 	   �ڶ��֣�@Param��������ӳ��
	 * */
	List<GoodsCategory> selectByParentId(
			@Param("parentId") Integer parentId,
			@Param("offset") Integer offset,
			@Param("count") Integer count);

}
