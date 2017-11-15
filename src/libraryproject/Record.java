/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryproject;
import java.util.*;
/**
 *
 * @author majin_000
 */
public class Record {
        private String recordId;
	private String username;
	private Date borrowTime;
	private Date dueTime;
	private int bid;
	private double penalty;
        public static double penaltyRate = 0.01;
        private int isReturn;

    public Record() {
        recordId = "";
	username = "";
	borrowTime = null;
	dueTime = null;
	bid = 0;
	penalty = 0;
        isReturn = 0;
    }

    public int getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(int isReturn) {
        this.isReturn = isReturn;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Date getDueTime() {
        return dueTime;
    }

    public void setDueTime(Date dueTime) {
        this.dueTime = dueTime;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public double getPenalty() {
        penalty = doCalculatePenalty();
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }
    
    public double doCalculatePenalty() {
        double penaltyAmount = 0;
        Date currentTime = new Date();
        double days = Math.ceil((currentTime.getTime() - dueTime.getTime()) / (1000 * 60 * 60 * 24));
        if (days > 0) {
           penaltyAmount = days * penaltyRate;
        }
        return penaltyAmount;
    }
        
        
        
}
