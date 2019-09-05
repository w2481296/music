package cn.tedu.store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface TotalMapper {
	//��ѯ�����
	List<Map<String, Object>> queryallinstock(@Param("inName")String inName, @Param("inTime1")String inTime1,@Param("inTime2") String inTime2);
	//��ѯ�ܳ���
	List<Map<String, Object>> queryalloutstock(@Param("inName")String inName, @Param("inTime1")String inTime1,@Param("inTime2") String inTime2);
	//��ѯ�ܿ��¼
	List<Map<String, Object>> queryallstock(@Param("insName")String insName, @Param("insTime1")String insTime1, @Param("insTime2")String insTime2);
	//��ѯ������
	List<Map<String, Object>> queryallmoney(@Param("insName")String insName, @Param("insTime1")String insTime1, @Param("insTime2")String insTime2);
}
