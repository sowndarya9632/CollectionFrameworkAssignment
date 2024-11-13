package com.day5;
import java.time.LocalDate;

class Policy {
    private String policyId;
    private String policyType;
    private double premium;
    private double coverageAmount;
    private LocalDate expiryDate;

    public Policy(String policyId, String policyType, double premium, double coverageAmount, LocalDate expiryDate) {
        this.policyId = policyId;
        this.policyType = policyType;
        this.premium = premium;
        this.coverageAmount = coverageAmount;
        this.expiryDate = expiryDate;
    }

    public String getPolicyId() {
        return policyId;
    }

    public String getPolicyType() {
        return policyType;
    }

    public double getPremium() {
        return premium;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Policy ID: " + policyId + ", Type: " + policyType +
               ", Premium: " + premium + ", Coverage: " + coverageAmount +
               ", Expiry Date: " + expiryDate;
    }
}

public class PolicyManagementSystem {

	public static void main(String[] args) {
		PolicyManager policyManager = new PolicyManager();

        // Adding policies
        policyManager.addPolicy(new Policy("P001", "Health", 5000, 200000, LocalDate.of(2025, 5, 10)));
        policyManager.addPolicy(new Policy("P002", "Car", 3000, 100000, LocalDate.of(2023, 3, 15)));
        policyManager.addPolicy(new Policy("P003", "Home", 4000, 250000, LocalDate.of(2024, 8, 20)));
        policyManager.addPolicy(new Policy("P004", "Travel", 1500, 50000, LocalDate.of(2023, 1, 10)));
        policyManager.addPolicy(new Policy("P005", "Health", 7000, 300000, LocalDate.of(2025, 6, 30)));

        // Display policies by expiry date
        policyManager.displayPoliciesByExpiryDate();

        // Display policies in insertion order
        policyManager.displayPoliciesInInsertionOrder(); 
	}

}
