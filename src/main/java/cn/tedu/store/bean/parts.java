package cn.tedu.store.bean;

import java.io.Serializable;

public class parts implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2101061929310558033L;
	private Integer id;
	private String partsName;// 名称
	private String partsType;// 类型
	private String partsSpecifications;// 乐器规格
	private String partsCost;// 成本
	private String partsPricing;// 定价
	private String partsManufacturers;// 厂商
	private String partsRemake;// 备注
	private String partsTime;// 时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPartsName() {
		return partsName;
	}
	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}
	public String getPartsType() {
		return partsType;
	}
	public void setPartsType(String partsType) {
		this.partsType = partsType;
	}
	public String getPartsSpecifications() {
		return partsSpecifications;
	}
	public void setPartsSpecifications(String partsSpecifications) {
		this.partsSpecifications = partsSpecifications;
	}
	public String getPartsCost() {
		return partsCost;
	}
	public void setPartsCost(String partsCost) {
		this.partsCost = partsCost;
	}
	public String getPartsPricing() {
		return partsPricing;
	}
	public void setPartsPricing(String partsPricing) {
		this.partsPricing = partsPricing;
	}
	public String getPartsManufacturers() {
		return partsManufacturers;
	}
	public void setPartsManufacturers(String partsManufacturers) {
		this.partsManufacturers = partsManufacturers;
	}
	public String getPartsRemake() {
		return partsRemake;
	}
	public void setPartsRemake(String partsRemake) {
		this.partsRemake = partsRemake;
	}
	public String getPartsTime() {
		return partsTime;
	}
	public void setPartsTime(String partsTime) {
		this.partsTime = partsTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((partsCost == null) ? 0 : partsCost.hashCode());
		result = prime * result + ((partsManufacturers == null) ? 0 : partsManufacturers.hashCode());
		result = prime * result + ((partsName == null) ? 0 : partsName.hashCode());
		result = prime * result + ((partsPricing == null) ? 0 : partsPricing.hashCode());
		result = prime * result + ((partsRemake == null) ? 0 : partsRemake.hashCode());
		result = prime * result + ((partsSpecifications == null) ? 0 : partsSpecifications.hashCode());
		result = prime * result + ((partsTime == null) ? 0 : partsTime.hashCode());
		result = prime * result + ((partsType == null) ? 0 : partsType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		parts other = (parts) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (partsCost == null) {
			if (other.partsCost != null)
				return false;
		} else if (!partsCost.equals(other.partsCost))
			return false;
		if (partsManufacturers == null) {
			if (other.partsManufacturers != null)
				return false;
		} else if (!partsManufacturers.equals(other.partsManufacturers))
			return false;
		if (partsName == null) {
			if (other.partsName != null)
				return false;
		} else if (!partsName.equals(other.partsName))
			return false;
		if (partsPricing == null) {
			if (other.partsPricing != null)
				return false;
		} else if (!partsPricing.equals(other.partsPricing))
			return false;
		if (partsRemake == null) {
			if (other.partsRemake != null)
				return false;
		} else if (!partsRemake.equals(other.partsRemake))
			return false;
		if (partsSpecifications == null) {
			if (other.partsSpecifications != null)
				return false;
		} else if (!partsSpecifications.equals(other.partsSpecifications))
			return false;
		if (partsTime == null) {
			if (other.partsTime != null)
				return false;
		} else if (!partsTime.equals(other.partsTime))
			return false;
		if (partsType == null) {
			if (other.partsType != null)
				return false;
		} else if (!partsType.equals(other.partsType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "parts [id=" + id + ", partsName=" + partsName + ", partsType=" + partsType + ", partsSpecifications="
				+ partsSpecifications + ", partsCost=" + partsCost + ", partsPricing=" + partsPricing
				+ ", partsManufacturers=" + partsManufacturers + ", partsRemake=" + partsRemake + ", partsTime="
				+ partsTime + "]";
	}

	
	
	
}
