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
	//查总库视图
	List<Map<String, Object>> querystockviewin();

	List<Map<String, Object>> querystockviewout();
	//查总账务图
	List<Map<String, Object>> querystockmviewin();
	List<Map<String, Object>> querystockmviewout();
	//首页信息
	List<Map<String, Object>> instocktop();
	List<Map<String, Object>> outstocktop();
	Map<String, Object> stockcost();
	Map<String, Object> daymoney();
}
