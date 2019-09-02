package cn.tedu.store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Instock;
import cn.tedu.store.bean.Instruments;

public interface InstockMapper {
	//查询乐器信息
	List<Map<String, Object>> selectinstockByName(@Param("inName")String inName,@Param("inTime1")String inTime1,@Param("inTime2")String inTime2);
	//删除乐器信息
	void delMainInstockById(@Param("insid2")Integer insid2);
	//批量删除
	void delMainInsstockById(@Param("ids2")Integer[] ids2);
	//查询信息根据id
	List<Map<String, Object>> queryinstockById(@Param("ids2")Integer ids2);
	//修改入库信息
	void updateinstock(Instock instock);
	//添加入库乐器
	void addinstock(Instock instock);
	//判断是否是新乐器
	List<Map<String, Object>> queryByName(Instock instock);

	//新乐器添加到乐器表
	void updateoldinfo(Instock instock);
	//旧乐器更新乐器表
	void insertInfo(Instock instock);
	
	
	

	
}
