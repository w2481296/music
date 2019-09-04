package cn.tedu.store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Instock;
import cn.tedu.store.bean.Instruments;
import cn.tedu.store.bean.Outstock;

public interface OutstockMapper {
	//��ѯ������Ϣ
	List<Map<String, Object>> selectoutstockByName(@Param("inName")String inName,@Param("inTime1") String inTime1, @Param("inTime2")String inTime2);
	//����ɾ��
	void deloutstockById(@Param("insid2")Integer insid2);
	//��������ɾ��
	void deloutstockByIds(@Param("ids2")Integer[] ids2);
	
	
	//��ӵ������
	void addoutstock(Outstock outstock);
	//��ѯ��������Ϣ
	List<Map<String, Object>> queryByName(Outstock outstock);
	//��ѯ�����Ϣ
	List<Map<String, Object>> queryByName1(Outstock outstock);
	//������������Ϣ
	void updatemaininfo(Outstock outstock);
	//���������Ϣ
	void updatepartinfo(Outstock outstock);
	//ѡ����Ʒ��ѯ
	List<Map<String, Object>> selectgoodsorname(@Param("outName")String outName);
	//����Ա��ӻ���
	void addvipoutstock(@Param("vipname")String vipname, @Param("fenshu")String fenshu);
	//��ѯ��Ա��ǰ����
	String queryvipinfo(@Param("vipname")String vipname);


	
}
