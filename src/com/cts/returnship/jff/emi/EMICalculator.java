package com.cts.returnship.jff.emi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cts.returnship.jff.model.EMI;

public class EMICalculator {
	public static void main(String[] args) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		// get values from the user
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Principle amount: ");
		double principal = scan.nextDouble();
		System.out.println("Enter the rate of interest in %: ");
		float rateOfInterest = scan.nextFloat();
		System.out.println("Enter no of EMI's: ");
		int noOfEMIs = scan.nextInt();
		System.out.println("Enter the first EMI Due Date <dd-MM-yyy>: ");
		LocalDate emiDue = LocalDate.parse(scan.next(), formatter);
		
		float monthlyInterestRate = rateOfInterest/(12 * 100);
		
		//calculate 
		//emi = [P x R x (1+R)^N]/ [ (1+R)^ (N-1)],
		// interest component = principal*(roi/12)*100
		// principle component = outstanding - interest component
		
		List<EMI> list = new ArrayList<>();
		Double OutstandingPrincipal = principal;
		for (int i=0;i<noOfEMIs;i++) {
			EMI emi = new EMI();
			emi.setEmiID(i+1);
			// calculate EMI based on inputs
			Double r = Math.pow((1+monthlyInterestRate), noOfEMIs);
			Double d = Math.pow((1+monthlyInterestRate),(noOfEMIs));
			Double emiValue = (principal * monthlyInterestRate * r )/ (d-1);
			emi.setEmi(emiValue);
			
			emi.setEmiDueDate(emiDue);
			emiDue = emiDue.plusMonths(1);
			// calculate interest component
			Double interestComponent = OutstandingPrincipal*monthlyInterestRate;
			emi.setInterestComponent(interestComponent);
			// calculate principal component
			Double principalComponent = emiValue - interestComponent;
			emi.setPrincipalComponent(principalComponent);
			
			OutstandingPrincipal = OutstandingPrincipal - principalComponent;
			
			list.add(emi);
		}
		
		for (EMI e : list) {
			System.out.println(e);
		}
		
		scan.close();
	}
}
