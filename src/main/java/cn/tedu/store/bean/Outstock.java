package cn.tedu.store.bean;

import java.io.Serializable;

public class Outstock implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8732232972207645670L;
	private Integer id;
	private String OutName;// 商品名称
	private String OutType;// 商品类型
	private String OutSpecifications;// 商品规格
	private String OutCost;// 商品成本
	private String OutPricing;// 商品定价
	private String OutQty;// 商品数量
	private String OutRemain;// 商品剩余
	private String outProfit;// 商品剩余
	private String OutManufacturers;// 商品厂商
	private String OutUpdatetime;// 更新时间
	private String OutCreatetime;// 出库时间
	private String outVip;// 会员姓名
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
		return outProfit;
	}
	public void setOutProfit(String outProfit) {
		this.outProfit = outProfit;
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
		return outVip;
	}
	public void setOutVip(String outVip) {
		this.outVip = outVip;
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
		result = prime * result + ((OutQty == null) ? 0 : OutQty.hashCode());
		result = prime * result + ((OutRemain == null) ? 0 : OutRemain.hashCode());
		result = prime * result + ((OutSpecifications == null) ? 0 : OutSpecifications.hashCode());
		result = prime * result + ((OutType == null) ? 0 : OutType.hashCode());
		result = prime * result + ((OutUpdatetime == null) ? 0 : OutUpdatetime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((outProfit == null) ? 0 : outProfit.hashCode());
		result = prime * result + ((outVip == null) ? 0 : outVip.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (outProfit == null) {
			if (other.outProfit != null)
				return false;
		} else if (!outProfit.equals(other.outProfit))
			return false;
		if (outVip == null) {
			if (other.outVip != null)
				return false;
		} else if (!outVip.equals(other.outVip))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Outstock [id=" + id + ", OutName=" + OutName + ", OutType=" + OutType + ", OutSpecifications="
				+ OutSpecifications + ", OutCost=" + OutCost + ", OutPricing=" + OutPricing + ", OutQty=" + OutQty
				+ ", OutRemain=" + OutRemain + ", outProfit=" + outProfit + ", OutManufacturers=" + OutManufacturers
				+ ", OutUpdatetime=" + OutUpdatetime + ", OutCreatetime=" + OutCreatetime + ", outVip=" + outVip + "]";
	}
	
	
}
