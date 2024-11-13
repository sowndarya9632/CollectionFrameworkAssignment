package com.day5;

import java.util.*;

public class InsurancePolicyManager {
    private Map<String, InsurancePolicy> policiesMap;
    private LinkedHashMap<String, InsurancePolicy> linkedPoliciesMap;
    private TreeMap<Date, List<InsurancePolicy>> treePoliciesMap;

    public InsurancePolicyManager() {
        this.policiesMap = new HashMap<>();
        this.linkedPoliciesMap = new LinkedHashMap<>();
        this.treePoliciesMap = new TreeMap<>();
    }

    public void addPolicy(InsurancePolicy policy) {
        policiesMap.put(policy.getPolicyNumber(), policy);
        linkedPoliciesMap.put(policy.getPolicyNumber(), policy);

        treePoliciesMap.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    public InsurancePolicy getPolicy(String policyNumber) {
        return policiesMap.get(policyNumber);
    }

    public List<InsurancePolicy> listPoliciesExpiringSoon() {
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, 30);
        Date expiryCutoff = cal.getTime();

        for (Map.Entry<Date, List<InsurancePolicy>> entry : treePoliciesMap.headMap(expiryCutoff, true).entrySet()) {
            for (InsurancePolicy policy : entry.getValue()) {
                expiringPolicies.add(policy);
            }
        }
        return expiringPolicies;
    }

    public List<InsurancePolicy> listPoliciesByPolicyholder(String name) {
        List<InsurancePolicy> result = new ArrayList<>();
        for (InsurancePolicy policy : policiesMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(name)) {
                result.add(policy);
            }
        }
        return result;
    }

    public void removeExpiredPolicies() {
        Date today = new Date();

        // Remove expired policies from treePoliciesMap
        Iterator<Map.Entry<Date, List<InsurancePolicy>>> iterator = treePoliciesMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Date, List<InsurancePolicy>> entry = iterator.next();
            if (entry.getKey().before(today)) {
                iterator.remove(); // Remove entry from TreeMap
            }
        }

        // Remove expired policies from policiesMap and linkedPoliciesMap
        List<String> expiredPolicyNumbers = new ArrayList<>();
        for (InsurancePolicy policy : policiesMap.values()) {
            if (policy.getExpiryDate().before(today)) {
                expiredPolicyNumbers.add(policy.getPolicyNumber());
            }
        }

        // Remove expired policies from both maps
        for (String policyNumber : expiredPolicyNumbers) {
            policiesMap.remove(policyNumber);
            linkedPoliciesMap.remove(policyNumber);
        }
    }

    public void printAllPolicies() {
        for (InsurancePolicy policy : linkedPoliciesMap.values()) {
            System.out.println(policy);
        }
    }
}
