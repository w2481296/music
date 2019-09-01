package cn.tedu.store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.User;
/**
 * �ĸ������е���ͽӿڡ� 
 * @author ����
 * ��ʼʱ�䣺
 *
 */
public interface VipuserMapper {

	List<Map<String, Object>> selectVipInfo(@Param("vipName")String vipName, @Param("vipTime1")String vipTime1, @Param("vipTime2")String vipTime2);

	void delMainInsById(@Param("vipid2")Integer vipid2);

	void delvipsByIds(@Param("ids2")Integer[] ids2);

}
