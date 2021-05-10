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
public class Account {
	private String divisionID;
	private String accountNumber;
	@JsonProperty(required=false)
	private String customerNumber;
	private String locationNumber;
	@JsonProperty(required=false)
	private String billingStationLevel0Code;
	private String billingStationLevel1Code;
	private String billingStationLevel2Code;
	private String sourceFTACode;
	private ReferenceDataType accountType;
	private String accountStatus;
	private String billerAccountStatus;
	@JsonProperty(required=false)
	private String connectDate;
	@JsonProperty(required=false)
	private String disconnectDate;
	@JsonProperty(required=false)
	private String classification;
	private Name name;
	private Address serviceAddress;
	private ArrayList<Phone> phone;
	private ArrayList<LineOfBusiness> lineOfBusinessDetail;
	@JsonProperty(required=false)
	private String experianPin;
	@JsonProperty(required=false)
	private AccountDetail accountDetail;
	@JsonProperty(required=false)
	private ArrayList<AccountHierarchy> accountHierarchyDetail;
	@JsonProperty(required=false)
	private String nationalIdentifier;
	@JsonProperty(required=false)
	private String accountCategory;
	@JsonProperty(required=false)
	private String accountSegment;

}
