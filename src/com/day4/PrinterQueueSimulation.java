package com.day4;

import java.util.Comparator;
import java.util.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

class PrintJob {
    private String documentName;
    private int priority; // Lower number means higher priority

    public PrintJob(String documentName, int priority) {
        this.documentName = documentName;
        this.priority = priority;
    }

    public String getDocumentName() {
        return documentName;
    }

    public int getPriority() {
        return priority;
    }
}

public class PrinterQueueSimulation {

    public static void main(String[] args) {
        // PriorityQueue with a custom comparator to prioritize jobs
        PriorityQueue<PrintJob> printerQueue = new PriorityQueue<>(Comparator.comparingInt(PrintJob::getPriority));

        // Adding print jobs to the queue
        printerQueue.add(new PrintJob("Document1", 2));
        printerQueue.add(new PrintJob("Document2", 1));
        printerQueue.add(new PrintJob("Document3", 3));
        printerQueue.add(new PrintJob("Document4", 1));
        
        // Simulating printing
        System.out.println("Printing jobs in order of priority:");
        while (!printerQueue.isEmpty()) {
            PrintJob job = printerQueue.poll(); // Get and remove the job with the highest priority
            System.out.println("Printing: " + job.getDocumentName() + " with priority " + job.getPriority());
        }
    }
}
