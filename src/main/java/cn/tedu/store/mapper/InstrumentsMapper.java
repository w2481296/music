package cn.tedu.store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Instruments;

public interface InstrumentsMapper {

	//��ѯ������Ϣ
	List<Map<String, Object>> selinstruByName(@Param("insName")String insName,@Param("insTime1")String insTime1,@Param("insTime2")String insTime2);
	//ɾ��������Ϣ
	void delMainInsById(@Param("insid")Integer insid);
	//����ɾ��
	int deletesById(@Param("ids2")Integer[] ids2);
	//��ѯ��Ϣ����id
	List<Map<String, Object>> queryinstruById(@Param("ids2")Integer ids2);
	void updateinfo(Instruments instruments);
}
