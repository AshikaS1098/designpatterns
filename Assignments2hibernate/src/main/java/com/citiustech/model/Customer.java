package com.citiustech.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Customer {
	@Id
	private Integer customerId;
	private String customerName;
	private Date customerDOB;
	public Locker getLocker() {
		return locker;
	}

	public void setLocker(Locker locker) {
		this.locker = locker;
	}

	private String customerAdd;
	private String customerPhone;
	
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerDOB=" + customerDOB
				+ ", customerAdd=" + customerAdd + ", customerPhone=" + customerPhone + ", locker=" + locker + "]";
	}

	//@OneToOne
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="custLockerId")
	private Locker locker;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer custId, String custName, Date custDOB, String custAdd, String custPhone, Locker locker) {
		super();
		this.customerId = custId;
		this.setCustomerName(custName);
		this.setCustomerDOB(custDOB);
		this.setCustomerAdd(custAdd);
		this.setCustomerPhone(custPhone);
		this.locker = locker;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getCustomerDOB() {
		return customerDOB;
	}

	public void setCustomerDOB(Date customerDOB) {
		this.customerDOB = customerDOB;
	}

	public String getCustomerAdd() {
		return customerAdd;
	}

	public void setCustomerAdd(String customerAdd) {
		this.customerAdd = customerAdd;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public void setCustomerId(int customerId2) {
		// TODO Auto-generated method stub
		
	}

}