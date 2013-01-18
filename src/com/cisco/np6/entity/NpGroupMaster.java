package com.cisco.np6.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the NP_GROUP_MASTER database table.
 * 
 */

@Entity
@NamedNativeQueries({
	@NamedNativeQuery(
	name = "findGrpIdByCustId",
	query = "select ng.group_id from np_group_master ng where ng.cust_id is null and ng.VIEWER_GROUP =1",
	resultClass = NpGroupMaster.class
	)
	/*,
	@NamedNativeQuery(name = "getAllUsers",
    query = "select * from np_group_master",
    resultClass = NpGroupMaster.class)*/
})
@Table(name="NP_GROUP_MASTER")
public class NpGroupMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="GROUP_ID")
	private Long groupId;

	@Column(name="CHASSIS_PID")
	private String chassisPid;

	@Column(name="COLLECTOR_ID")
	private String collectorId;

	@Column(name="CPY_KEY")
	private BigDecimal cpyKey;

    @Temporal( TemporalType.DATE)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	@Column(name="CUST_ID")
	private String custId;

	@Column(name="DEVICE_TYPE_LIST")
	private String deviceTypeList;

	@Column(name="DEVICENAME_PATTERN")
	private String devicenamePattern;

	@Column(name="EXCLUDE_GROUP_LIST")
	private String excludeGroupList;

	@Column(name="FAN_PID")
	private String fanPid;

	@Column(name="FAN_PID_OPT")
	private String fanPidOpt;

	@Column(name="FEATURE_LIST")
	private String featureList;

	@Column(name="FEATURE_OPT")
	private String featureOpt;

	@Column(name="FEATURE_SET")
	private String featureSet;

	@Column(name="FLASH_CHECK_VALUE")
	private BigDecimal flashCheckValue;

	@Column(name="FLASH_OPERATOR")
	private String flashOperator;

	@Column(name="GROUP_CREATOR")
	private String groupCreator;

	@Column(name="GROUP_DESC")
	private String groupDesc;

	@Column(name="GROUP_NAME")
	private String groupName;

	@Column(name="IMAGE_NAME")
	private String imageName;

	@Column(name="IMAGE_NAME_REGEX")
	private String imageNameRegex;

	@Column(name="IP_ADDRESS")
	private String ipAddress;

	@Column(name="MEMORY_CHECK_VALUE")
	private BigDecimal memoryCheckValue;

	@Column(name="MEMORY_OPERATOR")
	private String memoryOperator;

	@Column(name="MODULE_LIST")
	private String moduleList;

	@Column(name="MODULE_OPT")
	private String moduleOpt;

	@Column(name="MODULE_PID")
	private String modulePid;

	@Column(name="MODULE_PID_OPT")
	private String modulePidOpt;

	@Column(name="NETWORK_ELEMENT_TYPE")
	private String networkElementType;

	@Column(name="OS_VERSION")
	private String osVersion;

	@Column(name="OSTYPE_LIST")
	private String ostypeList;

    @Lob()
	@Column(name="PRODUCT_GROUP_LIST")
	private String productGroupList;

    @Lob()
	@Column(name="PRODUCT_TYPE_LIST")
	private String productTypeList;

	@Column(name="PS_PID")
	private String psPid;

	@Column(name="PS_PID_OPT")
	private String psPidOpt;

	@Column(name="REGEX_PATTERN")
	private String regexPattern;

	@Column(name="RME_FIELD1")
	private String rmeField1;

	@Column(name="RME_FIELD2")
	private String rmeField2;

	@Column(name="RME_FIELD3")
	private String rmeField3;

	@Column(name="RME_FIELD4")
	private String rmeField4;

	@Column(name="SYS_LOCATION")
	private String sysLocation;

	@Column(name="SYSNAME_PATTERN")
	private String sysnamePattern;

	@Column(name="SYSNAME_REGEX_FLAG")
	private String sysnameRegexFlag;

	@Column(name="TECHNOLOGY_LIST")
	private String technologyList;

	@Column(name="TECHNOLOGY_OPT")
	private String technologyOpt;

    @Temporal( TemporalType.DATE)
	@Column(name="UPDATE_DATE")
	private Date updateDate;

	@Column(name="VIEWER_GROUP")
	private BigDecimal viewerGroup;

    public NpGroupMaster() {
    }

	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getChassisPid() {
		return this.chassisPid;
	}

	public void setChassisPid(String chassisPid) {
		this.chassisPid = chassisPid;
	}

	public String getCollectorId() {
		return this.collectorId;
	}

	public void setCollectorId(String collectorId) {
		this.collectorId = collectorId;
	}

	public BigDecimal getCpyKey() {
		return this.cpyKey;
	}

	public void setCpyKey(BigDecimal cpyKey) {
		this.cpyKey = cpyKey;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getCustId() {
		return this.custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getDeviceTypeList() {
		return this.deviceTypeList;
	}

	public void setDeviceTypeList(String deviceTypeList) {
		this.deviceTypeList = deviceTypeList;
	}

	public String getDevicenamePattern() {
		return this.devicenamePattern;
	}

	public void setDevicenamePattern(String devicenamePattern) {
		this.devicenamePattern = devicenamePattern;
	}

	public String getExcludeGroupList() {
		return this.excludeGroupList;
	}

	public void setExcludeGroupList(String excludeGroupList) {
		this.excludeGroupList = excludeGroupList;
	}

	public String getFanPid() {
		return this.fanPid;
	}

	public void setFanPid(String fanPid) {
		this.fanPid = fanPid;
	}

	public String getFanPidOpt() {
		return this.fanPidOpt;
	}

	public void setFanPidOpt(String fanPidOpt) {
		this.fanPidOpt = fanPidOpt;
	}

	public String getFeatureList() {
		return this.featureList;
	}

	public void setFeatureList(String featureList) {
		this.featureList = featureList;
	}

	public String getFeatureOpt() {
		return this.featureOpt;
	}

	public void setFeatureOpt(String featureOpt) {
		this.featureOpt = featureOpt;
	}

	public String getFeatureSet() {
		return this.featureSet;
	}

	public void setFeatureSet(String featureSet) {
		this.featureSet = featureSet;
	}

	public BigDecimal getFlashCheckValue() {
		return this.flashCheckValue;
	}

	public void setFlashCheckValue(BigDecimal flashCheckValue) {
		this.flashCheckValue = flashCheckValue;
	}

	public String getFlashOperator() {
		return this.flashOperator;
	}

	public void setFlashOperator(String flashOperator) {
		this.flashOperator = flashOperator;
	}

	public String getGroupCreator() {
		return this.groupCreator;
	}

	public void setGroupCreator(String groupCreator) {
		this.groupCreator = groupCreator;
	}

	public String getGroupDesc() {
		return this.groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageNameRegex() {
		return this.imageNameRegex;
	}

	public void setImageNameRegex(String imageNameRegex) {
		this.imageNameRegex = imageNameRegex;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public BigDecimal getMemoryCheckValue() {
		return this.memoryCheckValue;
	}

	public void setMemoryCheckValue(BigDecimal memoryCheckValue) {
		this.memoryCheckValue = memoryCheckValue;
	}

	public String getMemoryOperator() {
		return this.memoryOperator;
	}

	public void setMemoryOperator(String memoryOperator) {
		this.memoryOperator = memoryOperator;
	}

	public String getModuleList() {
		return this.moduleList;
	}

	public void setModuleList(String moduleList) {
		this.moduleList = moduleList;
	}

	public String getModuleOpt() {
		return this.moduleOpt;
	}

	public void setModuleOpt(String moduleOpt) {
		this.moduleOpt = moduleOpt;
	}

	public String getModulePid() {
		return this.modulePid;
	}

	public void setModulePid(String modulePid) {
		this.modulePid = modulePid;
	}

	public String getModulePidOpt() {
		return this.modulePidOpt;
	}

	public void setModulePidOpt(String modulePidOpt) {
		this.modulePidOpt = modulePidOpt;
	}

	public String getNetworkElementType() {
		return this.networkElementType;
	}

	public void setNetworkElementType(String networkElementType) {
		this.networkElementType = networkElementType;
	}

	public String getOsVersion() {
		return this.osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getOstypeList() {
		return this.ostypeList;
	}

	public void setOstypeList(String ostypeList) {
		this.ostypeList = ostypeList;
	}

	public String getProductGroupList() {
		return this.productGroupList;
	}

	public void setProductGroupList(String productGroupList) {
		this.productGroupList = productGroupList;
	}

	public String getProductTypeList() {
		return this.productTypeList;
	}

	public void setProductTypeList(String productTypeList) {
		this.productTypeList = productTypeList;
	}

	public String getPsPid() {
		return this.psPid;
	}

	public void setPsPid(String psPid) {
		this.psPid = psPid;
	}

	public String getPsPidOpt() {
		return this.psPidOpt;
	}

	public void setPsPidOpt(String psPidOpt) {
		this.psPidOpt = psPidOpt;
	}

	public String getRegexPattern() {
		return this.regexPattern;
	}

	public void setRegexPattern(String regexPattern) {
		this.regexPattern = regexPattern;
	}

	public String getRmeField1() {
		return this.rmeField1;
	}

	public void setRmeField1(String rmeField1) {
		this.rmeField1 = rmeField1;
	}

	public String getRmeField2() {
		return this.rmeField2;
	}

	public void setRmeField2(String rmeField2) {
		this.rmeField2 = rmeField2;
	}

	public String getRmeField3() {
		return this.rmeField3;
	}

	public void setRmeField3(String rmeField3) {
		this.rmeField3 = rmeField3;
	}

	public String getRmeField4() {
		return this.rmeField4;
	}

	public void setRmeField4(String rmeField4) {
		this.rmeField4 = rmeField4;
	}

	public String getSysLocation() {
		return this.sysLocation;
	}

	public void setSysLocation(String sysLocation) {
		this.sysLocation = sysLocation;
	}

	public String getSysnamePattern() {
		return this.sysnamePattern;
	}

	public void setSysnamePattern(String sysnamePattern) {
		this.sysnamePattern = sysnamePattern;
	}

	public String getSysnameRegexFlag() {
		return this.sysnameRegexFlag;
	}

	public void setSysnameRegexFlag(String sysnameRegexFlag) {
		this.sysnameRegexFlag = sysnameRegexFlag;
	}

	public String getTechnologyList() {
		return this.technologyList;
	}

	public void setTechnologyList(String technologyList) {
		this.technologyList = technologyList;
	}

	public String getTechnologyOpt() {
		return this.technologyOpt;
	}

	public void setTechnologyOpt(String technologyOpt) {
		this.technologyOpt = technologyOpt;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public BigDecimal getViewerGroup() {
		return this.viewerGroup;
	}

	public void setViewerGroup(BigDecimal viewerGroup) {
		this.viewerGroup = viewerGroup;
	}

}