package app.controller;

import org.apache.poi.ss.formula.functions.FinanceLib;


public class calHelper {
	
	private int NbrOfYears;
	private double LoanAmount;
	private double AdditionalPayment;
	private double InterestRate;
	
	
	
	
	public calHelper(double LoanAmount,
			double AdditionalPayment, 
			int NbrOfYears, 
			double InterestRate){
		this.LoanAmount = LoanAmount;
		this.AdditionalPayment = AdditionalPayment;
		this.NbrOfYears = NbrOfYears;
		this.InterestRate = InterestRate;
	}

	public double getAdditionalPayment(){
		return AdditionalPayment;
	}
	
	
	

	public void setAdditionalPayment(double additionalPayment) {
		AdditionalPayment = additionalPayment;
	}

	public double getNbrOfYears(){
		return NbrOfYears;
	}

	public void setNbrOfYears(int d){
		NbrOfYears = d;
	}

	public double getInterestRate(){
		return InterestRate;
	}

	public void setInterestRate(double interestRate){
		InterestRate = interestRate;
	}

	public void setLoanAmount(double loanAmount){
		LoanAmount = loanAmount;
	}
	
	public double CalInterest(double amount){
		double rate = InterestRate/12;
		double interest = amount*rate;
		return interest;
	}
	public double CalPMT(){
		double r = InterestRate/12;
		double n = NbrOfYears*12;
		
		
		
		double p = LoanAmount;
		double f = 0;
		boolean t = false;
		
		
		double ConstantPayment = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		return ConstantPayment;
	}
	
	
	
	
	
	
	
	
	
	
	public double CalTotalPay(){
		double interest = 0;
		double PPMT = 0;
		double pv = LoanAmount;
		
		while(PPMT + AdditionalPayment < pv){
			double PMT = CalPMT();
			PPMT = PMT - CalInterest(pv);
			
			
			
			
			pv -= PPMT + AdditionalPayment;
			interest += PMT-PPMT;
			
			
			
			System.out.println(PPMT+AdditionalPayment);
		}

		Double FinalInterest = CalInterest(pv);
		
		return interest + LoanAmount + FinalInterest;
	}
	
	
	
	
	
	
	
	
	
	public double CalTotalInterest(){
		
		
		
		
		
		double TotalInterest = CalTotalPay() - LoanAmount;
		return TotalInterest;
	}
}


	
