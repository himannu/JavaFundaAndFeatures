package com.cts.returnship.jff.model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EMI {
	private Integer emiID;
	private Double emi;
	private LocalDate emiDueDate;
	private Double principalComponent;
	private Double interestComponent;
	
	private static final DecimalFormat df = new DecimalFormat("##");
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	
	public EMI() {
		
	}
	
	public EMI(Integer emiID, Double emi, LocalDate emiDueDate, Double principalComponent, Double interestComponent) {
		super();
		this.emiID = emiID;
		this.emi = emi;
		this.emiDueDate = emiDueDate;
		this.principalComponent = principalComponent;
		this.interestComponent = interestComponent;
	}


	public Integer getEmiID() {
		return emiID;
	}


	public void setEmiID(Integer emiID) {
		this.emiID = emiID;
	}


	public Double getEmi() {
		return emi;
	}


	public void setEmi(Double emi) {
		this.emi = emi;
	}


	public LocalDate getEmiDueDate() {
		return emiDueDate;
	}




	public void setEmiDueDate(LocalDate emiDueDate) {
		this.emiDueDate = emiDueDate;
	}




	public Double getPrincipalComponent() {
		return principalComponent;
	}




	public void setPrincipalComponent(Double principalComponent) {
		this.principalComponent = principalComponent;
	}




	public Double getInterestComponent() {
		return interestComponent;
	}




	public void setInterestComponent(Double interestComponent) {
		this.interestComponent = interestComponent;
	}




	@Override
	public String toString() {
		return "EmiNo: " + emiID + "\t EMI: " + df.format(emi) + "\t Due Date: " +  emiDueDate.format(formatter) + "\t Principal: "
				+ df.format(principalComponent) + "\t Interest: " + df.format(interestComponent);
	}
	
	
}
