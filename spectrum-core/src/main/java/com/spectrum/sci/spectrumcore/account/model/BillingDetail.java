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
public class BillingDetail {
	@JsonProperty(required=false)
	private String currentStatementId;
	@JsonProperty(required=false)
	private String statementCode;
	@JsonProperty(required=false)
	private String cycleDay;
	@JsonProperty(required=false)
	private String fromDate;
	@JsonProperty(required=false)
	private String thruDate ;
	@JsonProperty(required=false)
	private double amountDue;
	@JsonProperty(required=false)
	private ReferenceDataType frequency;
	@JsonProperty(required=false)
	private String taxGroup;
	@JsonProperty(required=false)
	private String dunningGroup;
	@JsonProperty(required=false)
	private String futureDatedFlag;
	@JsonProperty(required=false)
	private String ebppFlag;
	@JsonProperty(required=false)
	private String paperlessFlag;
	@JsonProperty(required=false)
	private String debitDate;
	@JsonProperty(required=false)
	private double currentBalance;
	@JsonProperty(required=false)
	private String lastPaymentDate;
	@JsonProperty(required=false)
	private double lastPaymentAmount;
	@JsonProperty(required=false)
	private String paymentDueDate;
	@JsonProperty(required=false)
	private double pendingPayment;
	@JsonProperty(required=false)
	private double cycle0Amount ;
	@JsonProperty(required=false)
	private double cycle1Amount ;
	@JsonProperty(required=false)
	private double cycle2Amount ;
	@JsonProperty(required=false)
	private double cycle3Amount ;
	@JsonProperty(required=false)
	private double delinquencyAmount ;
	@JsonProperty(required=false)
	private ReferenceDataType delinquencyStatus ;
	@JsonProperty(required=false)
	private int daysDelinquent ;
	@JsonProperty(required=false)
	private String promiseToPayDate ;
	@JsonProperty(required=false)
	private Name billToName ;
	@JsonProperty(required=false)
	private Address billToAddress ;
	@JsonProperty(required=false)
	private ArrayList<Phone> billToPhone ;
	@JsonProperty(required=false)
	private String billingInCareOf ;
	@JsonProperty(required=false)
	private ReferenceDataType statementHold ;
	@JsonProperty(required=false)
	private ReferenceDataType monetaryStatus;
	@JsonProperty(required=false)
	private AutoPaymentDetail autoPayment;
	@JsonProperty(required=false)
	private double promiseAmount;
	@JsonProperty(required=false)
	private String promiseActivityCode;
	@JsonProperty(required=false)
	private String statementNameFormat;
	@JsonProperty(required=false)
	private double billingCurrentBalance ;
	@JsonProperty(required=false)
	private double statementBalance ;
	@JsonProperty(required=false)
	private String billToAddressChangeDate ;
	@JsonProperty(required=false)
	private String electronicFlag ;
	@JsonProperty(required=false)
	private double adjustedDelinquencyAmount;
	@JsonProperty(required=false)
	private double unbilledAmount ;
}
