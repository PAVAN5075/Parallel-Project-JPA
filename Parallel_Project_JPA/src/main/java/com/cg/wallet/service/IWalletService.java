package com.cg.wallet.service;

import com.cg.wallet.bean.Account;
import com.cg.wallet.exception.WalletException;

public interface IWalletService {
	String createAccount(Account acc) throws WalletException;

	double showBalance(String mobileNo) throws WalletException;

	Account deposit(String mobileNo, double depositAmt) throws WalletException;

	Account withdraw(String mobileNo, double withdrawAmt)
			throws WalletException;

	boolean fundTransfer(String sourceMobileNo, String destMobileNo,
			double transferAmt) throws WalletException;

	Account printTransactionDetails(String mobileNo) throws WalletException;
}
