package com.spectrum.sci.spectrumcore.customer.model;

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
public class Customer {	
	private String divisionID;
	private String accountNumber;
	@JsonProperty(required=false)
	private String billingStationLevel0Code;
	private String billingStationLevel1Code;
	private String billingStationLevel2Code;
	private String sourceFTACode;
	@JsonProperty(required=false)
	private String customerNumber;
	private ReferenceDataType customerType;
	private ReferenceDataType customerStatus;
	@JsonProperty(required=false)
	private ReferenceDataType customerCategory;
	@JsonProperty(required=false)
	private String locationNumber;
	@JsonProperty(required=false)
	private Name name;
	@JsonProperty(required=false)
	private ArrayList<Phone> phone;
	@JsonProperty(required=false)
	private ResponsibleParty responsibleParty;
	@JsonProperty(required=false)
	private ArrayList<Address> address;
	@JsonProperty(required=false)
	private Identification identification;
	@JsonProperty(required=false)
	private ArrayList<Email> email;
	@JsonProperty(required=false)
	private String privacyFlag;
	@JsonProperty(required=false)
	private String securityCode;
	@JsonProperty(required=false)
	private ArrayList<String> authorizedUsers;
	@JsonProperty(required=false)
	private String creditClass;
	@JsonProperty(required=false)
	private ArrayList<Comment> customerComments;
	@JsonProperty(required=false)
	private Audit audit;
	@JsonProperty(required=false)
	private String accountCount;
	@JsonProperty(required=false)
	private String dmcaViolationDate;
	@JsonProperty(required=false)
	private String brmAccountNumber;
	@JsonProperty(required=false)
	private String lastModifiedSecCodeDate;
	@JsonProperty(required=false)
	private String lastModifiedSecCodeBy;
}
