package model.entities;

import model.exceptions.DomainException;

public class Account {

	private Integer number;
	private String holder;
	protected Double balance;
	private double withdrawLimit;

	public Account() {

	}

	public Account(Integer number, String holder, Double balance, double withdrawLimit) {
		super();
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void deposit(Double amount) {

		balance += amount;

	}

	private void validateWithdraw(double amount) {
		if (amount > getWithdrawLimit()) {
			throw new DomainException("withdrawal error: The amount exceeds withdraw limit");
		}
		if (amount > getBalance()) {
			throw new DomainException("withdrawal error: Not enough balance");
		}
	}

	public void withdraw(double amount) {
		validateWithdraw(amount);
		balance -= amount;

	}

}
