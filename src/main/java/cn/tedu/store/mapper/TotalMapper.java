package cn.tedu.store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface TotalMapper {
	//查询总入库
	List<Map<String, Object>> queryallinstock(@Param("inName")String inName, @Param("inTime1")String inTime1,@Param("inTime2") String inTime2);
	//查询总出库
	List<Map<String, Object>> queryalloutstock(@Param("inName")String inName, @Param("inTime1")String inTime1,@Param("inTime2") String inTime2);
	//查询总库记录
	List<Map<String, Object>> queryallstock(@Param("insName")String insName, @Param("insTime1")String insTime1, @Param("insTime2")String insTime2);
	//查询总账务
	List<Map<String, Object>> queryallmoney(@Param("insName")String insName, @Param("insTime1")String insTime1, @Param("insTime2")String insTime2);
}
