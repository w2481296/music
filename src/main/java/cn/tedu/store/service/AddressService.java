package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;
import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.sun.org.apache.regexp.internal.recompile;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;

@Service
public class AddressService implements IAddressService {
	//获取省市区的名称
	private String getDistrict(Address address){
		String provinceName=dictMapper.selectByProvinceCode(address.getRecvprovince());
		String cityName=dictMapper.selectByCityCode(address.getRecvcity());
		String areaName=dictMapper.selectByAreaCode(address.getRecvarea());
		return provinceName+cityName+areaName;
		
	}
	@Resource
	private AddressMapper addressMapper;
	@Resource
	private DictMapper dictMapper;
	public void addAddress(Address address) {
		//省市区
		//是否默认
		List<Address>list=addressMapper.selectByUid(address.getUid());
		if(list.size()==0){
			address.setIsDefault(1);
		}else{
			address.setIsDefault(0);
		}
		address.setRecvdistrict(getDistrict(address));
		addressMapper.insertAddress(address);
	}
	public List<Address> getByUid(Integer uid) {
		
		return addressMapper.selectByUid(uid);
	}
	public void setDefault(Integer uid, Integer id) {
		Integer n1=addressMapper.updateByUid(uid);
		if(n1==0){
			throw new RuntimeException("uid修改错误");
		}
		Integer n2=addressMapper.updateById(id);
		if(n2==0){
			throw new RuntimeException("id修改错误");
		}
		
	}
	public Address getById(Integer id) {
		Address address=addressMapper.selectById(id);
		return address;
	}
	public void updateAddress(Address address) {
		address.setRecvdistrict(getDistrict(address));
		addressMapper.updateAddress(address);
	}
	public void removeAddress(Integer id) {
		addressMapper.deleteById(id);
	}


}
