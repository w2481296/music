package cn.tedu.store.bean;

import java.io.Serializable;

public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4663190133229120092L;
	private Integer id;
	private Integer uid;
	private String recvname;
	private String recvprovince;
	private String recvcity;
	private String recvarea;
	private String recvdistrict;
	private String recvaddress;
	private String recvphone;
	private String recvtel;
	private String recvzip;
	private String recvtag;
	private Integer isDefault;//1Ä¬ÈÏ¡£0·ÇÄ¬ÈÏ
	private String createuser;
	private String createtime;
	private String modifieduser;
	private String modifiedtime;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the uid
	 */
	public Integer getUid() {
		return uid;
	}

	/**
	 * @param uid
	 *            the uid to set
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	/**
	 * @return the recvname
	 */
	public String getRecvname() {
		return recvname;
	}

	/**
	 * @param recvname
	 *            the recvname to set
	 */
	public void setRecvname(String recvname) {
		this.recvname = recvname;
	}

	/**
	 * @return the recvprovince
	 */
	public String getRecvprovince() {
		return recvprovince;
	}

	/**
	 * @param recvprovince
	 *            the recvprovince to set
	 */
	public void setRecvprovince(String recvprovince) {
		this.recvprovince = recvprovince;
	}

	/**
	 * @return the recvcity
	 */
	public String getRecvcity() {
		return recvcity;
	}

	/**
	 * @param recvcity
	 *            the recvcity to set
	 */
	public void setRecvcity(String recvcity) {
		this.recvcity = recvcity;
	}

	/**
	 * @return the recvarea
	 */
	public String getRecvarea() {
		return recvarea;
	}

	/**
	 * @param recvarea
	 *            the recvarea to set
	 */
	public void setRecvarea(String recvarea) {
		this.recvarea = recvarea;
	}

	/**
	 * @return the recvdistrict
	 */
	public String getRecvdistrict() {
		return recvdistrict;
	}

	/**
	 * @param recvdistrict
	 *            the recvdistrict to set
	 */
	public void setRecvdistrict(String recvdistrict) {
		this.recvdistrict = recvdistrict;
	}

	/**
	 * @return the recvaddress
	 */
	public String getRecvaddress() {
		return recvaddress;
	}

	/**
	 * @param recvaddress
	 *            the recvaddress to set
	 */
	public void setRecvaddress(String recvaddress) {
		this.recvaddress = recvaddress;
	}

	/**
	 * @return the recvphone
	 */
	public String getRecvphone() {
		return recvphone;
	}

	/**
	 * @param recvphone
	 *            the recvphone to set
	 */
	public void setRecvphone(String recvphone) {
		this.recvphone = recvphone;
	}

	/**
	 * @return the recvtel
	 */
	public String getRecvtel() {
		return recvtel;
	}

	/**
	 * @param recvtel
	 *            the recvtel to set
	 */
	public void setRecvtel(String recvtel) {
		this.recvtel = recvtel;
	}

	/**
	 * @return the recvzip
	 */
	public String getRecvzip() {
		return recvzip;
	}

	/**
	 * @param recvzip
	 *            the recvzip to set
	 */
	public void setRecvzip(String recvzip) {
		this.recvzip = recvzip;
	}

	/**
	 * @return the recvtag
	 */
	public String getRecvtag() {
		return recvtag;
	}

	/**
	 * @param recvtag
	 *            the recvtag to set
	 */
	public void setRecvtag(String recvtag) {
		this.recvtag = recvtag;
	}

	/**
	 * @return the isDefault
	 */
	public Integer getIsDefault() {
		return isDefault;
	}

	/**
	 * @param isDefault
	 *            the isDefault to set
	 */
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * @return the createuser
	 */
	public String getCreateuser() {
		return createuser;
	}

	/**
	 * @param createuser
	 *            the createuser to set
	 */
	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

	/**
	 * @return the createtime
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * @param createtime
	 *            the createtime to set
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	/**
	 * @return the modifieduser
	 */
	public String getModifieduser() {
		return modifieduser;
	}

	/**
	 * @param modifieduser
	 *            the modifieduser to set
	 */
	public void setModifieduser(String modifieduser) {
		this.modifieduser = modifieduser;
	}

	/**
	 * @return the modifiedtime
	 */
	public String getModifiedtime() {
		return modifiedtime;
	}

	/**
	 * @param modifiedtime
	 *            the modifiedtime to set
	 */
	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createtime == null) ? 0 : createtime.hashCode());
		result = prime * result + ((createuser == null) ? 0 : createuser.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isDefault == null) ? 0 : isDefault.hashCode());
		result = prime * result + ((modifiedtime == null) ? 0 : modifiedtime.hashCode());
		result = prime * result + ((modifieduser == null) ? 0 : modifieduser.hashCode());
		result = prime * result + ((recvaddress == null) ? 0 : recvaddress.hashCode());
		result = prime * result + ((recvarea == null) ? 0 : recvarea.hashCode());
		result = prime * result + ((recvcity == null) ? 0 : recvcity.hashCode());
		result = prime * result + ((recvdistrict == null) ? 0 : recvdistrict.hashCode());
		result = prime * result + ((recvname == null) ? 0 : recvname.hashCode());
		result = prime * result + ((recvphone == null) ? 0 : recvphone.hashCode());
		result = prime * result + ((recvprovince == null) ? 0 : recvprovince.hashCode());
		result = prime * result + ((recvtag == null) ? 0 : recvtag.hashCode());
		result = prime * result + ((recvtel == null) ? 0 : recvtel.hashCode());
		result = prime * result + ((recvzip == null) ? 0 : recvzip.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (createtime == null) {
			if (other.createtime != null)
				return false;
		} else if (!createtime.equals(other.createtime))
			return false;
		if (createuser == null) {
			if (other.createuser != null)
				return false;
		} else if (!createuser.equals(other.createuser))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isDefault == null) {
			if (other.isDefault != null)
				return false;
		} else if (!isDefault.equals(other.isDefault))
			return false;
		if (modifiedtime == null) {
			if (other.modifiedtime != null)
				return false;
		} else if (!modifiedtime.equals(other.modifiedtime))
			return false;
		if (modifieduser == null) {
			if (other.modifieduser != null)
				return false;
		} else if (!modifieduser.equals(other.modifieduser))
			return false;
		if (recvaddress == null) {
			if (other.recvaddress != null)
				return false;
		} else if (!recvaddress.equals(other.recvaddress))
			return false;
		if (recvarea == null) {
			if (other.recvarea != null)
				return false;
		} else if (!recvarea.equals(other.recvarea))
			return false;
		if (recvcity == null) {
			if (other.recvcity != null)
				return false;
		} else if (!recvcity.equals(other.recvcity))
			return false;
		if (recvdistrict == null) {
			if (other.recvdistrict != null)
				return false;
		} else if (!recvdistrict.equals(other.recvdistrict))
			return false;
		if (recvname == null) {
			if (other.recvname != null)
				return false;
		} else if (!recvname.equals(other.recvname))
			return false;
		if (recvphone == null) {
			if (other.recvphone != null)
				return false;
		} else if (!recvphone.equals(other.recvphone))
			return false;
		if (recvprovince == null) {
			if (other.recvprovince != null)
				return false;
		} else if (!recvprovince.equals(other.recvprovince))
			return false;
		if (recvtag == null) {
			if (other.recvtag != null)
				return false;
		} else if (!recvtag.equals(other.recvtag))
			return false;
		if (recvtel == null) {
			if (other.recvtel != null)
				return false;
		} else if (!recvtel.equals(other.recvtel))
			return false;
		if (recvzip == null) {
			if (other.recvzip != null)
				return false;
		} else if (!recvzip.equals(other.recvzip))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [id=" + id + ", uid=" + uid + ", recvname=" + recvname + ", recvprovince=" + recvprovince
				+ ", recvcity=" + recvcity + ", recvarea=" + recvarea + ", recvdistrict=" + recvdistrict
				+ ", recvaddress=" + recvaddress + ", recvphone=" + recvphone + ", recvtel=" + recvtel + ", recvzip="
				+ recvzip + ", recvtag=" + recvtag + ", isDefault=" + isDefault + ", createuser=" + createuser
				+ ", createtime=" + createtime + ", modifieduser=" + modifieduser + ", modifiedtime=" + modifiedtime
				+ "]";
	}

}
