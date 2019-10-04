package cn.tedu.store.bean;

import java.io.Serializable;

public class Instock implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2284952000934703960L;
	private Integer id;
	private String inName;// 入库名称
	private String inType;// 入库类型
	private String inSpecifications;// 入库类型
	private String inCost;// 入库成本
	private String inPricing;// 入库乐器定价
	private String inQty;// 入库乐器数量
	private String inManufacturers;// 入库乐器厂商
	private String inUpdatetime;// 更新时间
	private String inCreatetime;// 入库时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInName() {
		return inName;
	}
	public void setInName(String inName) {
		this.inName = inName;
	}
	public String getInType() {
		return inType;
	}
	public void setInType(String inType) {
		this.inType = inType;
	}
	public String getInSpecifications() {
		return inSpecifications;
	}
	public void setInSpecifications(String inSpecifications) {
		this.inSpecifications = inSpecifications;
	}
	public String getInCost() {
		return inCost;
	}
	public void setInCost(String inCost) {
		this.inCost = inCost;
	}
	public String getInPricing() {
		return inPricing;
	}
	public void setInPricing(String inPricing) {
		this.inPricing = inPricing;
	}
	public String getInQty() {
		return inQty;
	}
	public void setInQty(String inQty) {
		this.inQty = inQty;
	}
	public String getInManufacturers() {
		return inManufacturers;
	}
	public void setInManufacturers(String inManufacturers) {
		this.inManufacturers = inManufacturers;
	}
	public String getInUpdatetime() {
		return inUpdatetime;
	}
	public void setInUpdatetime(String inUpdatetime) {
		this.inUpdatetime = inUpdatetime;
	}
	public String getInCreatetime() {
		return inCreatetime;
	}
	public void setInCreatetime(String inCreatetime) {
		this.inCreatetime = inCreatetime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inCost == null) ? 0 : inCost.hashCode());
		result = prime * result + ((inCreatetime == null) ? 0 : inCreatetime.hashCode());
		result = prime * result + ((inManufacturers == null) ? 0 : inManufacturers.hashCode());
		result = prime * result + ((inName == null) ? 0 : inName.hashCode());
		result = prime * result + ((inPricing == null) ? 0 : inPricing.hashCode());
		result = prime * result + ((inQty == null) ? 0 : inQty.hashCode());
		result = prime * result + ((inSpecifications == null) ? 0 : inSpecifications.hashCode());
		result = prime * result + ((inType == null) ? 0 : inType.hashCode());
		result = prime * result + ((inUpdatetime == null) ? 0 : inUpdatetime.hashCode());
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
		Instock other = (Instock) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inCost == null) {
			if (other.inCost != null)
				return false;
		} else if (!inCost.equals(other.inCost))
			return false;
		if (inCreatetime == null) {
			if (other.inCreatetime != null)
				return false;
		} else if (!inCreatetime.equals(other.inCreatetime))
			return false;
		if (inManufacturers == null) {
			if (other.inManufacturers != null)
				return false;
		} else if (!inManufacturers.equals(other.inManufacturers))
			return false;
		if (inName == null) {
			if (other.inName != null)
				return false;
		} else if (!inName.equals(other.inName))
			return false;
		if (inPricing == null) {
			if (other.inPricing != null)
				return false;
		} else if (!inPricing.equals(other.inPricing))
			return false;
		if (inQty == null) {
			if (other.inQty != null)
				return false;
		} else if (!inQty.equals(other.inQty))
			return false;
		if (inSpecifications == null) {
			if (other.inSpecifications != null)
				return false;
		} else if (!inSpecifications.equals(other.inSpecifications))
			return false;
		if (inType == null) {
			if (other.inType != null)
				return false;
		} else if (!inType.equals(other.inType))
			return false;
		if (inUpdatetime == null) {
			if (other.inUpdatetime != null)
				return false;
		} else if (!inUpdatetime.equals(other.inUpdatetime))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Instock [id=" + id + ", inName=" + inName + ", inType=" + inType + ", inSpecifications="
				+ inSpecifications + ", inCost=" + inCost + ", inPricing=" + inPricing + ", inQty=" + inQty
				+ ", inManufacturers=" + inManufacturers + ", inUpdatetime=" + inUpdatetime
				+ ", inCreatetime=" + inCreatetime + "]";
	}
	
}
