package cn.tedu.store.bean;

import java.io.Serializable;

public class Outstock implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1466835101794253159L;
	private Integer id;
	private String OutName;// ��Ʒ����
	private String OutType;// ��Ʒ����
	private String OutSpecifications;// ��Ʒ���
	private String OutCost;// ��Ʒ�ɱ�
	private String OutPricing;// ��Ʒ����
	private String OutQty;// ��Ʒ����
	private String OutRemain;// ��Ʒʣ��
	private String OutProfit;// ��Ʒ����
	private String OutManufacturers;// ��Ʒ����
	private String OutUpdatetime;// ����ʱ��
	private String OutCreatetime;// ����ʱ��
	private String OutVip;// ��Ա����
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOutName() {
		return OutName;
	}
	public void setOutName(String outName) {
		OutName = outName;
	}
	public String getOutType() {
		return OutType;
	}
	public void setOutType(String outType) {
		OutType = outType;
	}
	public String getOutSpecifications() {
		return OutSpecifications;
	}
	public void setOutSpecifications(String outSpecifications) {
		OutSpecifications = outSpecifications;
	}
	public String getOutCost() {
		return OutCost;
	}
	public void setOutCost(String outCost) {
		OutCost = outCost;
	}
	public String getOutPricing() {
		return OutPricing;
	}
	public void setOutPricing(String outPricing) {
		OutPricing = outPricing;
	}
	public String getOutQty() {
		return OutQty;
	}
	public void setOutQty(String outQty) {
		OutQty = outQty;
	}
	public String getOutRemain() {
		return OutRemain;
	}
	public void setOutRemain(String outRemain) {
		OutRemain = outRemain;
	}
	public String getOutProfit() {
		return OutProfit;
	}
	public void setOutProfit(String outProfit) {
		OutProfit = outProfit;
	}
	public String getOutManufacturers() {
		return OutManufacturers;
	}
	public void setOutManufacturers(String outManufacturers) {
		OutManufacturers = outManufacturers;
	}
	public String getOutUpdatetime() {
		return OutUpdatetime;
	}
	public void setOutUpdatetime(String outUpdatetime) {
		OutUpdatetime = outUpdatetime;
	}
	public String getOutCreatetime() {
		return OutCreatetime;
	}
	public void setOutCreatetime(String outCreatetime) {
		OutCreatetime = outCreatetime;
	}
	public String getOutVip() {
		return OutVip;
	}
	public void setOutVip(String outVip) {
		OutVip = outVip;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((OutCost == null) ? 0 : OutCost.hashCode());
		result = prime * result + ((OutCreatetime == null) ? 0 : OutCreatetime.hashCode());
		result = prime * result + ((OutManufacturers == null) ? 0 : OutManufacturers.hashCode());
		result = prime * result + ((OutName == null) ? 0 : OutName.hashCode());
		result = prime * result + ((OutPricing == null) ? 0 : OutPricing.hashCode());
		result = prime * result + ((OutProfit == null) ? 0 : OutProfit.hashCode());
		result = prime * result + ((OutQty == null) ? 0 : OutQty.hashCode());
		result = prime * result + ((OutRemain == null) ? 0 : OutRemain.hashCode());
		result = prime * result + ((OutSpecifications == null) ? 0 : OutSpecifications.hashCode());
		result = prime * result + ((OutType == null) ? 0 : OutType.hashCode());
		result = prime * result + ((OutUpdatetime == null) ? 0 : OutUpdatetime.hashCode());
		result = prime * result + ((OutVip == null) ? 0 : OutVip.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Outstock other = (Outstock) obj;
		if (OutCost == null) {
			if (other.OutCost != null)
				return false;
		} else if (!OutCost.equals(other.OutCost))
			return false;
		if (OutCreatetime == null) {
			if (other.OutCreatetime != null)
				return false;
		} else if (!OutCreatetime.equals(other.OutCreatetime))
			return false;
		if (OutManufacturers == null) {
			if (other.OutManufacturers != null)
				return false;
		} else if (!OutManufacturers.equals(other.OutManufacturers))
			return false;
		if (OutName == null) {
			if (other.OutName != null)
				return false;
		} else if (!OutName.equals(other.OutName))
			return false;
		if (OutPricing == null) {
			if (other.OutPricing != null)
				return false;
		} else if (!OutPricing.equals(other.OutPricing))
			return false;
		if (OutProfit == null) {
			if (other.OutProfit != null)
				return false;
		} else if (!OutProfit.equals(other.OutProfit))
			return false;
		if (OutQty == null) {
			if (other.OutQty != null)
				return false;
		} else if (!OutQty.equals(other.OutQty))
			return false;
		if (OutRemain == null) {
			if (other.OutRemain != null)
				return false;
		} else if (!OutRemain.equals(other.OutRemain))
			return false;
		if (OutSpecifications == null) {
			if (other.OutSpecifications != null)
				return false;
		} else if (!OutSpecifications.equals(other.OutSpecifications))
			return false;
		if (OutType == null) {
			if (other.OutType != null)
				return false;
		} else if (!OutType.equals(other.OutType))
			return false;
		if (OutUpdatetime == null) {
			if (other.OutUpdatetime != null)
				return false;
		} else if (!OutUpdatetime.equals(other.OutUpdatetime))
			return false;
		if (OutVip == null) {
			if (other.OutVip != null)
				return false;
		} else if (!OutVip.equals(other.OutVip))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Outstock [id=" + id + ", OutName=" + OutName + ", OutType=" + OutType + ", OutSpecifications="
				+ OutSpecifications + ", OutCost=" + OutCost + ", OutPricing=" + OutPricing + ", OutQty=" + OutQty
				+ ", OutRemain=" + OutRemain + ", OutProfit=" + OutProfit + ", OutManufacturers=" + OutManufacturers
				+ ", OutUpdatetime=" + OutUpdatetime + ", OutCreatetime=" + OutCreatetime + ", OutVip=" + OutVip + "]";
	}
	
}
