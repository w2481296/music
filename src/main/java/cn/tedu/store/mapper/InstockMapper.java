package cn.tedu.store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Instock;
import cn.tedu.store.bean.Instruments;

public interface InstockMapper {
	//查询乐器信息
	List<Map<String, Object>> selectinstockByName(@Param("inName")String inName,@Param("inTime1")String inTime1,@Param("inTime2")String inTime2);
	//查询配件信息
	List<Map<String, Object>> selectinstockByName1(@Param("inName")String inName,@Param("inTime1")String inTime1,@Param("inTime2")String inTime2);
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
	void insertInfo(Instock instock);
	//旧乐器更新乐器表
	void updateoldinfo(Instock instock);
		
	
	//添加入库配件
	void addpartsinstock(Instock instock);
	//判断是否是新配件
	List<Map<String, Object>> querypartsByName(Instock instock);
	//新配件添加到配件表
	void insertpartsInfo(Instock instock);
	//旧配件更新配件表
	void updateoldpartsinfo(Instock instock);
	//根据入库表id查询数量
	Integer querypartsqty(@Param("id")Integer id);
	//导入
	void insertInfoBatch(List<Instock> instockList);
	//根据id更新当前记录得数量
	void updateinstockqty(Instock instock);
	
	//根据入库表id返回对象
	Instock querypartsbean(@Param("insid2")Integer insid2);
	//删除主乐器表信息
	void delMain(Instock instock);
	//删除配件表信息
	void delPart(Instock instock);
	
	
}
