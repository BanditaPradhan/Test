package com.spectrum.sci.spectrumcore.account.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(Include.NON_NULL)
public class AccountDetail {
	@JsonProperty(required=false)
	private double totalCurrentBalance;
	@JsonProperty(required=false)
	private double totalPendingAmount;
	@JsonProperty(required=false)
	private double totalLastPayment;
	@JsonProperty(required=false)
	private double totalAmountDue;
	@JsonProperty(required=false)
	private double ppvAccountBalance;
	@JsonProperty(required=false)
	private double ppvCreditLimit;
	@JsonProperty(required=false)
	private double ppvPending;
	@JsonProperty(required=false)
	private double ppvRemainingCreditLimit;
	@JsonProperty(required=false)
	private String ppvDiscount;
	@JsonProperty(required=false)
	private ReferenceDataType language;
	@JsonProperty(required=false)
	private double lockboxPending;
	@JsonProperty(required=false)
	private String suspensionBeginDate;
	@JsonProperty(required=false)
	private String suspensionEndDate;
	@JsonProperty(required=false)
	private String auditCreationDate;
	@JsonProperty(required=false)
	private ReferenceDataType locationType;
	@JsonProperty(required=false)
	private String bulkFlag;
	@JsonProperty(required=false)
	private ReferenceDataType vipCode;
	@JsonProperty(required=false)
	private ResponsibleParty responsibleParty;
	@JsonProperty(required=false)
	private Identification identification;
	@JsonProperty(required=false)
	private Transfer transfer;
	@JsonProperty(required=false)
	private ArrayList<BillingDetail> billingDetails;
	@JsonProperty(required=false)
	private String equipmentDisableStatus;
	@JsonProperty(required=false)
	private String equipmentDisableDate;
}
