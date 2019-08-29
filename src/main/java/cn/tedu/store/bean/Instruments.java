package cn.tedu.store.bean;

import java.io.Serializable;

public class Instruments implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5163225600638423135L;
	private Integer id;
	private String insName;// 乐器名称
	private String insType;// 乐器类型
	private String insCost;// 乐器成本
	private String insPricing;// 乐器定价
	private String insManufacturers;// 乐器厂商
	private String insParts;// 乐器所属配件
	private String insRemake;// 备注
	private String insTime;// 时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInsName() {
		return insName;
	}
	public void setInsName(String insName) {
		this.insName = insName;
	}
	public String getInsType() {
		return insType;
	}
	public void setInsType(String insType) {
		this.insType = insType;
	}
	public String getInsCost() {
		return insCost;
	}
	public void setInsCost(String insCost) {
		this.insCost = insCost;
	}
	public String getInsPricing() {
		return insPricing;
	}
	public void setInsPricing(String insPricing) {
		this.insPricing = insPricing;
	}
	public String getInsManufacturers() {
		return insManufacturers;
	}
	public void setInsManufacturers(String insManufacturers) {
		this.insManufacturers = insManufacturers;
	}
	public String getInsParts() {
		return insParts;
	}
	public void setInsParts(String insParts) {
		this.insParts = insParts;
	}
	public String getInsRemake() {
		return insRemake;
	}
	public void setInsRemake(String insRemake) {
		this.insRemake = insRemake;
	}
	public String getInsTime() {
		return insTime;
	}
	public void setInsTime(String insTime) {
		this.insTime = insTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((insCost == null) ? 0 : insCost.hashCode());
		result = prime * result + ((insManufacturers == null) ? 0 : insManufacturers.hashCode());
		result = prime * result + ((insName == null) ? 0 : insName.hashCode());
		result = prime * result + ((insParts == null) ? 0 : insParts.hashCode());
		result = prime * result + ((insPricing == null) ? 0 : insPricing.hashCode());
		result = prime * result + ((insRemake == null) ? 0 : insRemake.hashCode());
		result = prime * result + ((insTime == null) ? 0 : insTime.hashCode());
		result = prime * result + ((insType == null) ? 0 : insType.hashCode());
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
		Instruments other = (Instruments) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (insCost == null) {
			if (other.insCost != null)
				return false;
		} else if (!insCost.equals(other.insCost))
			return false;
		if (insManufacturers == null) {
			if (other.insManufacturers != null)
				return false;
		} else if (!insManufacturers.equals(other.insManufacturers))
			return false;
		if (insName == null) {
			if (other.insName != null)
				return false;
		} else if (!insName.equals(other.insName))
			return false;
		if (insParts == null) {
			if (other.insParts != null)
				return false;
		} else if (!insParts.equals(other.insParts))
			return false;
		if (insPricing == null) {
			if (other.insPricing != null)
				return false;
		} else if (!insPricing.equals(other.insPricing))
			return false;
		if (insRemake == null) {
			if (other.insRemake != null)
				return false;
		} else if (!insRemake.equals(other.insRemake))
			return false;
		if (insTime == null) {
			if (other.insTime != null)
				return false;
		} else if (!insTime.equals(other.insTime))
			return false;
		if (insType == null) {
			if (other.insType != null)
				return false;
		} else if (!insType.equals(other.insType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Instruments [id=" + id + ", insName=" + insName + ", insType=" + insType + ", insCost=" + insCost
				+ ", insPricing=" + insPricing + ", insManufacturers=" + insManufacturers + ", insParts=" + insParts
				+ ", insRemake=" + insRemake + ", insTime=" + insTime + "]";
	}
	
}
