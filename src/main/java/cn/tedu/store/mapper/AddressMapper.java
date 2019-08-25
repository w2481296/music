package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.bean.Address;

public interface AddressMapper {
	void insertAddress(Address address);
	List<Address> selectByUid(Integer uid);
	Integer updateByUid(Integer uid);
	Integer updateById(Integer id);
	Address selectById(Integer id);	
	void updateAddress(Address address);
	void deleteById(Integer id);
}
