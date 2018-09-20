package com.training.insurance;

public class LifeInsurance extends Insurance {

	private int ageOfPolicyHolder;

	public LifeInsurance(long policyNumber, String policyHolderName, int ageOfPolicyHolder) {
		super(policyNumber, policyHolderName);
		this.ageOfPolicyHolder = ageOfPolicyHolder;
	}

	@Override
	public double calculatePremium() {
		
		double premium;
		
		if(this.ageOfPolicyHolder > 50) {
			premium = 500;
		} else if (this.ageOfPolicyHolder > 25) {
			premium = 600;
		} else {
			premium = 700;
		}
		
		return premium;
		
	}

}
