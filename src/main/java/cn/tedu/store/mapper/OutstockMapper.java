package cn.tedu.store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Instock;
import cn.tedu.store.bean.Instruments;
import cn.tedu.store.bean.Outstock;

public interface OutstockMapper {
	//查询出库信息
	List<Map<String, Object>> selectoutstockByName(@Param("inName")String inName,@Param("inTime1") String inTime1, @Param("inTime2")String inTime2);
	//出库删除
	void deloutstockById(@Param("insid2")Integer insid2);
	//出库批量删除
	void deloutstockByIds(@Param("ids2")Integer[] ids2);
	
	
	//添加到出库表
	void addoutstock(Outstock outstock);
	//查询主乐器信息
	List<Map<String, Object>> queryByName(Outstock outstock);
	//查询配件信息
	List<Map<String, Object>> queryByName1(Outstock outstock);
	//更新主乐器信息
	void updatemaininfo(Outstock outstock);
	//更新配件信息
	void updatepartinfo(Outstock outstock);
	//选择商品查询
	List<Map<String, Object>> selectgoodsorname(@Param("outName")String outName);
	//给会员添加积分
	void addvipoutstock(@Param("vipname")String vipname, @Param("fenshu")String fenshu);
	//查询会员当前积分
	String queryvipinfo(@Param("vipname")String vipname);


	
}
