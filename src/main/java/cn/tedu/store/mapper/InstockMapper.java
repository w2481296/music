package cn.tedu.store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Instock;
import cn.tedu.store.bean.Instruments;

public interface InstockMapper {
	//��ѯ������Ϣ
	List<Map<String, Object>> selectinstockByName(@Param("inName")String inName,@Param("inTime1")String inTime1,@Param("inTime2")String inTime2);
	//ɾ��������Ϣ
	void delMainInstockById(@Param("insid2")Integer insid2);
	//����ɾ��
	void delMainInsstockById(@Param("ids2")Integer[] ids2);
	//��ѯ��Ϣ����id
	List<Map<String, Object>> queryinstockById(@Param("ids2")Integer ids2);
	//�޸������Ϣ
	void updateinstock(Instock instock);
	//����������
	void addinstock(Instock instock);
	//�ж��Ƿ���������
	List<Map<String, Object>> queryByName(Instock instock);

	//��������ӵ�������
	void updateoldinfo(Instock instock);
	//����������������
	void insertInfo(Instock instock);
	
	
	

	
}
