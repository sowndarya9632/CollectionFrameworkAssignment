package com.day5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {

	public static void main(String[] args) throws ParseException {
		InsurancePolicyManager manager = new InsurancePolicyManager();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Adding policies
        manager.addPolicy(new InsurancePolicy("POL001", "Alice", sdf.parse("2024-10-20")));
        manager.addPolicy(new InsurancePolicy("POL002", "Bob", sdf.parse("2024-11-15")));
        manager.addPolicy(new InsurancePolicy("POL003", "Alice", sdf.parse("2024-09-30")));
        manager.addPolicy(new InsurancePolicy("POL004", "Charlie", sdf.parse("2024-10-10")));

        // Print all policies
        System.out.println("All Policies:");
        manager.printAllPolicies();

        // Retrieve a specific policy
        System.out.println("\nRetrieving POL002:");
        System.out.println(manager.getPolicy("POL002"));

        // List policies expiring soon
        System.out.println("\nPolicies expiring within the next 30 days:");
        List<InsurancePolicy> expiringPolicies = manager.listPoliciesExpiringSoon();
        for (InsurancePolicy policy : expiringPolicies) {
            System.out.println(policy);
        }

        // List policies for a specific policyholder
        System.out.println("\nPolicies for Alice:");
        List<InsurancePolicy> alicePolicies = manager.listPoliciesByPolicyholder("Alice");
        for (InsurancePolicy policy : alicePolicies) {
            System.out.println(policy);
        }

        // Remove expired policies
        manager.removeExpiredPolicies();
        System.out.println("\nPolicies after removing expired ones:");
        manager.printAllPolicies();
	}

}
