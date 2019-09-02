package cn.tedu.store.bean;

import java.io.Serializable;

public class vipuser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1390589299020504223L;
	private Integer id;
	private String vipName;
	private String vipGender;
	private String vipAge;
	private String vipPhone;
	private String vipIntegral;
	private String vipCreatetime;
	private String vipUpdatetime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVipName() {
		return vipName;
	}
	public void setVipName(String vipName) {
		this.vipName = vipName;
	}
	public String getVipGender() {
		return vipGender;
	}
	public void setVipGender(String vipGender) {
		this.vipGender = vipGender;
	}
	public String getVipAge() {
		return vipAge;
	}
	public void setVipAge(String vipAge) {
		this.vipAge = vipAge;
	}
	public String getVipPhone() {
		return vipPhone;
	}
	public void setVipPhone(String vipPhone) {
		this.vipPhone = vipPhone;
	}
	public String getVipIntegral() {
		return vipIntegral;
	}
	public void setVipIntegral(String vipIntegral) {
		this.vipIntegral = vipIntegral;
	}
	public String getVipCreatetime() {
		return vipCreatetime;
	}
	public void setVipCreatetime(String vipCreatetime) {
		this.vipCreatetime = vipCreatetime;
	}
	public String getVipUpdatetime() {
		return vipUpdatetime;
	}
	public void setVipUpdatetime(String vipUpdatetime) {
		this.vipUpdatetime = vipUpdatetime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((vipAge == null) ? 0 : vipAge.hashCode());
		result = prime * result + ((vipCreatetime == null) ? 0 : vipCreatetime.hashCode());
		result = prime * result + ((vipGender == null) ? 0 : vipGender.hashCode());
		result = prime * result + ((vipIntegral == null) ? 0 : vipIntegral.hashCode());
		result = prime * result + ((vipName == null) ? 0 : vipName.hashCode());
		result = prime * result + ((vipPhone == null) ? 0 : vipPhone.hashCode());
		result = prime * result + ((vipUpdatetime == null) ? 0 : vipUpdatetime.hashCode());
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
		vipuser other = (vipuser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (vipAge == null) {
			if (other.vipAge != null)
				return false;
		} else if (!vipAge.equals(other.vipAge))
			return false;
		if (vipCreatetime == null) {
			if (other.vipCreatetime != null)
				return false;
		} else if (!vipCreatetime.equals(other.vipCreatetime))
			return false;
		if (vipGender == null) {
			if (other.vipGender != null)
				return false;
		} else if (!vipGender.equals(other.vipGender))
			return false;
		if (vipIntegral == null) {
			if (other.vipIntegral != null)
				return false;
		} else if (!vipIntegral.equals(other.vipIntegral))
			return false;
		if (vipName == null) {
			if (other.vipName != null)
				return false;
		} else if (!vipName.equals(other.vipName))
			return false;
		if (vipPhone == null) {
			if (other.vipPhone != null)
				return false;
		} else if (!vipPhone.equals(other.vipPhone))
			return false;
		if (vipUpdatetime == null) {
			if (other.vipUpdatetime != null)
				return false;
		} else if (!vipUpdatetime.equals(other.vipUpdatetime))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "vipuser [id=" + id + ", vipName=" + vipName + ", vipGender=" + vipGender + ", vipAge=" + vipAge
				+ ", vipPhone=" + vipPhone + ", vipIntegral=" + vipIntegral + ", vipCreatetime=" + vipCreatetime
				+ ", vipUpdatetime=" + vipUpdatetime + "]";
	}
	
}
