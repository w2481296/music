package cn.tedu.store.bean;

import java.io.Serializable;

public class Instruments implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2663083388473782045L;
	private Integer id;
	private String insName;// ��������
	private String insType;// ��������
	private String insSpecifications;// ��������
	private String insCost;// �����ɱ�
	private String insPricing;// ��������
	private String insQty;// �������
	private String insManufacturers;// ��������
	private String insParts;// �����������
	private String insRemake;// ��ע
	private String insUpdatetime;// ����ʱ��
	private String insCreatetime;// ���ʱ��
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
	public String getInsSpecifications() {
		return insSpecifications;
	}
	public void setInsSpecifications(String insSpecifications) {
		this.insSpecifications = insSpecifications;
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
	public String getInsQty() {
		return insQty;
	}
	public void setInsQty(String insQty) {
		this.insQty = insQty;
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
	public String getInsUpdatetime() {
		return insUpdatetime;
	}
	public void setInsUpdatetime(String insUpdatetime) {
		this.insUpdatetime = insUpdatetime;
	}
	public String getInsCreatetime() {
		return insCreatetime;
	}
	public void setInsCreatetime(String insCreatetime) {
		this.insCreatetime = insCreatetime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((insCost == null) ? 0 : insCost.hashCode());
		result = prime * result + ((insCreatetime == null) ? 0 : insCreatetime.hashCode());
		result = prime * result + ((insManufacturers == null) ? 0 : insManufacturers.hashCode());
		result = prime * result + ((insName == null) ? 0 : insName.hashCode());
		result = prime * result + ((insParts == null) ? 0 : insParts.hashCode());
		result = prime * result + ((insPricing == null) ? 0 : insPricing.hashCode());
		result = prime * result + ((insQty == null) ? 0 : insQty.hashCode());
		result = prime * result + ((insRemake == null) ? 0 : insRemake.hashCode());
		result = prime * result + ((insSpecifications == null) ? 0 : insSpecifications.hashCode());
		result = prime * result + ((insType == null) ? 0 : insType.hashCode());
		result = prime * result + ((insUpdatetime == null) ? 0 : insUpdatetime.hashCode());
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
		if (insCreatetime == null) {
			if (other.insCreatetime != null)
				return false;
		} else if (!insCreatetime.equals(other.insCreatetime))
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
		if (insQty == null) {
			if (other.insQty != null)
				return false;
		} else if (!insQty.equals(other.insQty))
			return false;
		if (insRemake == null) {
			if (other.insRemake != null)
				return false;
		} else if (!insRemake.equals(other.insRemake))
			return false;
		if (insSpecifications == null) {
			if (other.insSpecifications != null)
				return false;
		} else if (!insSpecifications.equals(other.insSpecifications))
			return false;
		if (insType == null) {
			if (other.insType != null)
				return false;
		} else if (!insType.equals(other.insType))
			return false;
		if (insUpdatetime == null) {
			if (other.insUpdatetime != null)
				return false;
		} else if (!insUpdatetime.equals(other.insUpdatetime))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Instruments [id=" + id + ", insName=" + insName + ", insType=" + insType + ", insSpecifications="
				+ insSpecifications + ", insCost=" + insCost + ", insPricing=" + insPricing + ", insQty=" + insQty
				+ ", insManufacturers=" + insManufacturers + ", insParts=" + insParts + ", insRemake=" + insRemake
				+ ", insUpdatetime=" + insUpdatetime + ", insCreatetime=" + insCreatetime + "]";
	}
	
}
