package com.day5;

import java.time.LocalDate;
import java.util.*;

class PolicyManager {
	private Map<String, Policy> policiesById;
	private Map<LocalDate, List<Policy>> policiesByExpiryDate;
	private LinkedHashMap<String, Policy> policiesByInsertionOrder;

	public PolicyManager() {
		policiesById = new HashMap<>();
		policiesByExpiryDate = new TreeMap<>();
		policiesByInsertionOrder = new LinkedHashMap<>();
	}

	// Add a policy
	public void addPolicy(Policy policy) {
		policiesById.put(policy.getPolicyId(), policy);

		// Add to TreeMap for expiry date
		policiesByExpiryDate.putIfAbsent(policy.getExpiryDate(), new ArrayList<>());
		policiesByExpiryDate.get(policy.getExpiryDate()).add(policy);

		// Add to LinkedHashMap for insertion order
		policiesByInsertionOrder.put(policy.getPolicyId(), policy);
	}

	// Get a policy by ID
	public Policy getPolicyById(String policyId) {
		return policiesById.get(policyId);
	}

	// Display policies sorted by expiry date
	public void displayPoliciesByExpiryDate() {
		System.out.println("Policies sorted by expiry date:");
		for (Map.Entry<LocalDate, List<Policy>> entry : policiesByExpiryDate.entrySet()) {
			System.out.println("Expiry Date: " + entry.getKey());
			for (Policy policy : entry.getValue()) {
				System.out.println("  " + policy);
			}
		}
	}

	// Display policies in insertion order
	public void displayPoliciesInInsertionOrder() {
		System.out.println("Policies in insertion order:");
		for (Policy policy : policiesByInsertionOrder.values()) {
			System.out.println(policy);
		}
	}
}
