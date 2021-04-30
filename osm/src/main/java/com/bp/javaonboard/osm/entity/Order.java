package com.bp.javaonboard.osm.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_TBL")
public class Order {

	@Id
	@Column(name="ORDER_ID")
	private String orderId;
	
	@Column(name="ORDER_HIST_ID")
	private String orderHistId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="ORDER_SOURCE")
	private String orderSource;
	
	@Column(name="ORDER_TYPE")
	private String orderType;
	
	@Column(name="ORDER_STATE")
	private String orderState;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="REFERENCE_NUMBER")
	private String referenceNumber;
	
	@Column(name="PRIORITY")
	private String priority;
	
	@Column(name="NAME_SPACE")
	private String nameSpace;
	
	@Column(name="VERSION")
	private String version;
	
	@Column(name="EXPECTED_START_DATE")
	private String expectedStartDate;
	
	@Column(name="EXPECTED_DURATION")
	private String expectedDuration;
	
	@Column(name="EXPECTED_COMPLETION_DATE")
	private String expectedCompletionDate;
	
	@ManyToOne
	@JoinColumn(name="ACCOUNT_ID")
	private Account account;
	
	
	public Order ( ) {
		
	}

	public Order(String orderId, String orderHistId, String userName, String orderSource, String orderType,
			String orderState, String state, String referenceNumber, String priority, String nameSpace, String version,
			String expectedStartDate, String expectedDuration, String expectedCompletionDate, Account account
			) {
		super();
		this.orderId = orderId;
		this.orderHistId = orderHistId;
		this.userName = userName;
		this.orderSource = orderSource;
		this.orderType = orderType;
		this.orderState = orderState;
		this.state = state;
		this.referenceNumber = referenceNumber;
		this.priority = priority;
		this.nameSpace = nameSpace;
		this.version = version;
		this.expectedStartDate = expectedStartDate;
		this.expectedDuration = expectedDuration;
		this.expectedCompletionDate = expectedCompletionDate;
		this.account = account;
		
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderHistId() {
		return orderHistId;
	}

	public void setOrderHistId(String orderHistId) {
		this.orderHistId = orderHistId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getNameSpace() {
		return nameSpace;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getExpectedStartDate() {
		return expectedStartDate;
	}

	public void setExpectedStartDate(String expectedStartDate) {
		this.expectedStartDate = expectedStartDate;
	}

	public String getExpectedDuration() {
		return expectedDuration;
	}

	public void setExpectedDuration(String expectedDuration) {
		this.expectedDuration = expectedDuration;
	}

	public String getExpectedCompletionDate() {
		return expectedCompletionDate;
	}

	public void setExpectedCompletionDate(String expectedCompletionDate) {
		this.expectedCompletionDate = expectedCompletionDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderHistId=" + orderHistId + ", userName=" + userName
				+ ", orderSource=" + orderSource + ", orderType=" + orderType + ", orderState=" + orderState
				+ ", state=" + state + ", referenceNumber=" + referenceNumber + ", priority=" + priority
				+ ", nameSpace=" + nameSpace + ", version=" + version + ", expectedStartDate=" + expectedStartDate
				+ ", expectedDuration=" + expectedDuration + ", expectedCompletionDate=" + expectedCompletionDate
				+ ", account=" + account +  "]";
	}

	
	
}
