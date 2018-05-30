package com.objectlinx.entity;


import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;


/**
 * The persistent class for the CUSTOMER_INFO database table.
 * 
 */
@Entity
@Table(name="CUSTOMER_INFO")
public class CustomerInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((backendServerId == null) ? 0 : backendServerId.hashCode());
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
		result = prime * result
				+ ((customerZone == null) ? 0 : customerZone.hashCode());
		result = prime * result
				+ ((downloadTime == null) ? 0 : downloadTime.hashCode());
		result = prime * result
				+ ((latestConfigs == null) ? 0 : latestConfigs.hashCode());
		result = prime * result
				+ ((latestInventory == null) ? 0 : latestInventory.hashCode());
		result = prime * result
				+ ((natkVersion == null) ? 0 : natkVersion.hashCode());
		result = prime * result
				+ ((serverUrl == null) ? 0 : serverUrl.hashCode());
		result = prime * result
				+ ((timeStamp == null) ? 0 : timeStamp.hashCode());
		result = prime * result
				+ ((totalConfigs == null) ? 0 : totalConfigs.hashCode());
		result = prime * result
				+ ((totalDevices == null) ? 0 : totalDevices.hashCode());
		result = prime * result
				+ ((totalInventory == null) ? 0 : totalInventory.hashCode());
		result = prime * result
				+ ((totalSyslog == null) ? 0 : totalSyslog.hashCode());
		result = prime
				* result
				+ ((totalUnclassified == null) ? 0 : totalUnclassified
						.hashCode());
		result = prime * result
				+ ((uploadStatus == null) ? 0 : uploadStatus.hashCode());
		result = prime * result
				+ ((uploadTime == null) ? 0 : uploadTime.hashCode());
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
		CustomerInfo other = (CustomerInfo) obj;
		if (backendServerId == null) {
			if (other.backendServerId != null)
				return false;
		} else if (!backendServerId.equals(other.backendServerId))
			return false;
		if (custId == null) {
			if (other.custId != null)
				return false;
		} else if (!custId.equals(other.custId))
			return false;
		if (customerZone == null) {
			if (other.customerZone != null)
				return false;
		} else if (!customerZone.equals(other.customerZone))
			return false;
		if (downloadTime == null) {
			if (other.downloadTime != null)
				return false;
		} else if (!downloadTime.equals(other.downloadTime))
			return false;
		if (latestConfigs == null) {
			if (other.latestConfigs != null)
				return false;
		} else if (!latestConfigs.equals(other.latestConfigs))
			return false;
		if (latestInventory == null) {
			if (other.latestInventory != null)
				return false;
		} else if (!latestInventory.equals(other.latestInventory))
			return false;
		if (natkVersion == null) {
			if (other.natkVersion != null)
				return false;
		} else if (!natkVersion.equals(other.natkVersion))
			return false;
		if (serverUrl == null) {
			if (other.serverUrl != null)
				return false;
		} else if (!serverUrl.equals(other.serverUrl))
			return false;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		if (totalConfigs == null) {
			if (other.totalConfigs != null)
				return false;
		} else if (!totalConfigs.equals(other.totalConfigs))
			return false;
		if (totalDevices == null) {
			if (other.totalDevices != null)
				return false;
		} else if (!totalDevices.equals(other.totalDevices))
			return false;
		if (totalInventory == null) {
			if (other.totalInventory != null)
				return false;
		} else if (!totalInventory.equals(other.totalInventory))
			return false;
		if (totalSyslog == null) {
			if (other.totalSyslog != null)
				return false;
		} else if (!totalSyslog.equals(other.totalSyslog))
			return false;
		if (totalUnclassified == null) {
			if (other.totalUnclassified != null)
				return false;
		} else if (!totalUnclassified.equals(other.totalUnclassified))
			return false;
		if (uploadStatus == null) {
			if (other.uploadStatus != null)
				return false;
		} else if (!uploadStatus.equals(other.uploadStatus))
			return false;
		if (uploadTime == null) {
			if (other.uploadTime != null)
				return false;
		} else if (!uploadTime.equals(other.uploadTime))
			return false;
		return true;
	}

	@Column(name="BACKEND_SERVER_ID")
	private BigDecimal backendServerId;

	@Column(name="CUST_ID")
	private String custId;

	@Column(name="CUSTOMER_ZONE")
	private String customerZone;

	@Column(name="DOWNLOAD_TIME")
	private BigDecimal downloadTime;

	@Column(name="LATEST_CONFIGS")
	private BigDecimal latestConfigs;

	@Column(name="LATEST_INVENTORY")
	private BigDecimal latestInventory;

	@Column(name="NATK_VERSION")
	private String natkVersion;

	@Column(name="SERVER_URL")
	private String serverUrl;

	@Column(name="TIME_STAMP")
	private String timeStamp;

	@Column(name="TOTAL_CONFIGS")
	private BigDecimal totalConfigs;

	@Column(name="TOTAL_DEVICES")
	private BigDecimal totalDevices;

	@Column(name="TOTAL_INVENTORY")
	private BigDecimal totalInventory;

	@Column(name="TOTAL_SYSLOG")
	private BigDecimal totalSyslog;

	@Column(name="TOTAL_UNCLASSIFIED")
	private BigDecimal totalUnclassified;

	@Column(name="UPLOAD_STATUS")
	private BigDecimal uploadStatus;

	@Column(name="UPLOAD_TIME")
	private BigDecimal uploadTime;

    public CustomerInfo() {
    }

	public BigDecimal getBackendServerId() {
		return this.backendServerId;
	}

	public void setBackendServerId(BigDecimal backendServerId) {
		this.backendServerId = backendServerId;
	}

	public String getCustId() {
		return this.custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustomerZone() {
		return this.customerZone;
	}

	public void setCustomerZone(String customerZone) {
		this.customerZone = customerZone;
	}

	public BigDecimal getDownloadTime() {
		return this.downloadTime;
	}

	public void setDownloadTime(BigDecimal downloadTime) {
		this.downloadTime = downloadTime;
	}

	public BigDecimal getLatestConfigs() {
		return this.latestConfigs;
	}

	public void setLatestConfigs(BigDecimal latestConfigs) {
		this.latestConfigs = latestConfigs;
	}

	public BigDecimal getLatestInventory() {
		return this.latestInventory;
	}

	public void setLatestInventory(BigDecimal latestInventory) {
		this.latestInventory = latestInventory;
	}

	public String getNatkVersion() {
		return this.natkVersion;
	}

	public void setNatkVersion(String natkVersion) {
		this.natkVersion = natkVersion;
	}

	public String getServerUrl() {
		return this.serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	public String getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public BigDecimal getTotalConfigs() {
		return this.totalConfigs;
	}

	public void setTotalConfigs(BigDecimal totalConfigs) {
		this.totalConfigs = totalConfigs;
	}

	public BigDecimal getTotalDevices() {
		return this.totalDevices;
	}

	public void setTotalDevices(BigDecimal totalDevices) {
		this.totalDevices = totalDevices;
	}

	public BigDecimal getTotalInventory() {
		return this.totalInventory;
	}

	public void setTotalInventory(BigDecimal totalInventory) {
		this.totalInventory = totalInventory;
	}

	public BigDecimal getTotalSyslog() {
		return this.totalSyslog;
	}

	public void setTotalSyslog(BigDecimal totalSyslog) {
		this.totalSyslog = totalSyslog;
	}

	public BigDecimal getTotalUnclassified() {
		return this.totalUnclassified;
	}

	public void setTotalUnclassified(BigDecimal totalUnclassified) {
		this.totalUnclassified = totalUnclassified;
	}

	public BigDecimal getUploadStatus() {
		return this.uploadStatus;
	}

	public void setUploadStatus(BigDecimal uploadStatus) {
		this.uploadStatus = uploadStatus;
	}

	public BigDecimal getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(BigDecimal uploadTime) {
		this.uploadTime = uploadTime;
	}

}