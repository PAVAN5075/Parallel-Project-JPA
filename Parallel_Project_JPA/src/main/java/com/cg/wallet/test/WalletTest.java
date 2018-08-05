package com.cg.wallet.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.wallet.bean.Account;
import com.cg.wallet.exception.WalletException;
import com.cg.wallet.service.IWalletService;
import com.cg.wallet.service.WalletServiceImpl;

public class WalletTest {
		private IWalletService service;
		
	@Before
	public void init() {
		service = new WalletServiceImpl();
	}

	@Test
	public void testCreateAccountForMobile() {
		Account ac = new Account();
		ac.setMobileno("1234");
		ac.setName("Sam");
		ac.setEmail("sam@gmail.com");
		ac.setBalance(200.0);
		try {
			service.createAccount(ac);
		} 
		catch (WalletException e) {
			Assert.assertNotEquals("Enter a 10 digit Mobile No.", e.getMessage());
		}
	}

/*	@Test
	public void testCreateAccountForName() {
		Account ac = new Account();
		ac.setMobileno("9949222222");
		ac.setName("James007");
		ac.setEmail("James007@gmail.com");
		ac.setBalance(500.0);
		try {
			service.createAccount(ac);

		} 
		catch (WalletException e) {	
			Assert.assertEquals("Name should start with capital letter and should not contain numbers",e.getMessage());
		}
	}*/

	@Test
	public void testCreateAccountForNameIsEmpty() {
		Account ac = new Account();
		ac.setMobileno("9999999999");
		ac.setName("");
		ac.setEmail("vikky@gmail.com");
		ac.setBalance(200.0);
		try {
			service.createAccount(ac);
		} 
		catch (WalletException e) {
			Assert.assertEquals("Name cannot be empty", e.getMessage());
		}
	}

	@Test
	public void testCreateAccountForEmailId() {
		Account ac = new Account();
		ac.setMobileno("9949123456");
		ac.setName("Deepika");
		ac.setEmail("deepika@.23gmail.com");
		ac.setBalance(200.0);
		try {
			service.createAccount(ac);
		} 
		catch (WalletException e) {
			Assert.assertEquals("Enter valid emailid", e.getMessage());
		}
	}

	
	@Test
	public void testCreateAccountForBalance() {
		Account ac = new Account();
		ac.setMobileno("9949585858");
		ac.setName("Samson");
		ac.setEmail("samson@gmail.com");
		ac.setBalance(0);
		try {
			service.createAccount(ac);

		} 
		catch (WalletException e) {
			Assert.assertEquals("Balance should be greater than zero", e.getMessage());
		}
	}


	@Test
	public void testCreateAccount() {
		Account ac = new Account();
		ac.setMobileno("1234567890");
		ac.setName("Simon");
		ac.setEmail("simon@gmail.com");
		ac.setBalance(200.0);
			try {
				String s=service.createAccount(ac);
				Assert.assertNotNull(s);
			} 
			catch (WalletException e) {
				System.out.println(e.getMessage());
			}
	}


/*	@Test
	public void testShowBalanceForMobileNo() {
		Account ac=new Account();
		ac.setMobileno("994856");
		try {
			service.showBalance("9949222222");

		} 
		catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}*/

/*	@Test
	public void testShowBalanceForMobileNoDoesNotExist() {
		Account ac=new Account();
		ac.setMobileno("9949565656");
		try {
			service.showBalance("9949565656");
		} 
		catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("The mobile number does not exist",e.getMessage());
		}
	}*/	

/*	@Test
	public void testShowBalanceForName() {
		Account ac=new Account();
		ac.setMobileno("9949565656");
		try {
			service.showBalance(ac.getMobileno());
			assertEquals("John", ac.getName());
		} 
		catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("The mobile number does not exist",e.getMessage());
		}
	}*/

	@Test
	public void testDepositForMobileNo() {
		Account ac=new Account();
		ac.setMobileno("9949454");
		try {
			service.deposit(ac.getMobileno(),230);
		}
		catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}

/*	@Test
	public void testDepositForMobileNoDoesNotExist() {
		Account ac=new Account();
		ac.setMobileno("9949543210");
		try {
			service.deposit(ac.getMobileno(),230);

		} 
		catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("The mobile number does not exist",e.getMessage());
		}
	}*/

	@Test
	public void testDepositForDepositAmt1() {
		Account ac=new Account();
		ac.setMobileno("9949111111");
		try {
			service.deposit(ac.getMobileno(),-230);
		} catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("Deposit amount must be greater than zero",e.getMessage());
		}
	}

/*	@Test
	public void testDeposit() {
		Account ac=new Account();
		ac.setMobileno("9949666666");
		try {
			Account ac1=service.deposit(ac.getMobileno(),230);
			assertNotNull(ac1);
		} 
		catch (WalletException e) {
			System.out.println(e.getMessage());
		}
	}*/

	@Test
	public void testWithDrawForMobileNo() {
		Account ac=new Account();
		ac.setMobileno("9999999");
		try {
			service.withdraw(ac.getMobileno(), 230);

		} 
		catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}

/*	@Test
	public void testWithdrawForMobileNoDoesNotExist() {
		Account ac=new Account();
		ac.setMobileno("9848111111");
		try {
			service.withdraw(ac.getMobileno(), 230);
		} 
		catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("The mobile number does not exist",e.getMessage());
		}
	}*/
	
/*	@Test
	public void testWithdrawForAmt() {
		Account ac=new Account();
		ac.setMobileno("9949111111");
		try {
			service.withdraw(ac.getMobileno(),-230);
		} 
		catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("The amount to be withdrawn should not be greater than available balance and greater than zero",e.getMessage());
		}
	}*/

	@Test
	public void testFundTransferForMobileNo() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setMobileno("9949787878");
		ac2.setMobileno("1234");
		try {
			service.fundTransfer(ac.getMobileno(),ac2.getMobileno(), 230);
		} 
		catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}

/*	@Test
	public void testFundTransferForMobileNoDoesNotExist() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setMobileno("9949565656");
		ac2.setMobileno("9949787878");
		try {
			service.fundTransfer(ac.getMobileno(), ac2.getMobileno(),  230);
		} 
		catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("The mobile number does not exist",e.getMessage());
		}
	}*/

/*	@Test
	public void testFundTransferForAmt() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setMobileno("9949222222");
		ac2.setMobileno("9949333333");
		try {
			service.fundTransfer(ac.getMobileno(), ac2.getMobileno(),-230);

		} 
		catch (WalletException e) {
			// TODO Auto-generated catch block
			Assert.assertEquals("The amount to be withdrawn should not be greater than available balance and greater than zero",e.getMessage());
		}
	}*/

/*	@Test
	public void testFundTransfer() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setMobileno("9949111111");
		ac2.setMobileno("9949222222");
		try {
			assertTrue(service.fundTransfer(ac.getMobileno(), ac2.getMobileno(), 200));

		} 
		catch (WalletException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}*/

/*	@Test
	public void testPrinttransactionDetails() {
		Account ac=new Account();
		ac.setMobileno("9949222222");
		try {
			Account acc=service.printTransactionDetails(ac.getMobileno());
			assertNotNull(acc);
		} 
		catch (WalletException e) {
			System.out.println(e.getMessage());
		}
	}*/
	
}
