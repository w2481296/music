package cn.tedu.store.service;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.bean.Address;
//表示接口的所有实现类的都实现事务
@Transactional
public interface IAddressService {
	void addAddress(Address address);
	List<Address> getByUid(Integer uid);
	void setDefault(Integer uid,Integer id);
	Address getById(Integer id);
	void updateAddress(Address address);
	void removeAddress(Integer id);
}
