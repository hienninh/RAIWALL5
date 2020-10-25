package com.vti.frontend;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.vti.Utils.ScannerUtils;
import com.vti.backend.presentationlayer.AccountController;
import com.vti.entity.Account;

/**
 * This class is . Demo Account
 * 
 * @Description: .
 * @author: NinhHien
 * @create_date: Oct 23, 2020
 * @version: 2.0
 * @modifer: NinhHien
 * @modifer_date: Oct 23, 2020
 */
public class Program {
	private static Account account;
	private static ScannerUtils scanner;
	private static AccountController controller;

	public Program() throws ClassNotFoundException, SQLException, IOException {
		account = new Account();
		scanner = new ScannerUtils();
	}

	/**
	 * This method is . set up program choose function Account
	 * 
	 * @Description: .
	 * @author: NinhHien
	 * @create_date: Oct 23, 2020
	 * @version: 2.0
	 * @modifer: NinhHien
	 * @modifer_date: Oct 23, 2020
	 * @param args
	 * @throws Exception
	 */

	public static void main(String[] args) throws Exception {
		controller = new AccountController();
		System.out.println("1: Get List Groups\n" + "2: get Account by ID\n" + "3: is Account Exists by Name\n"
				+ "4: is Account Exists by ID\n" + "5: Create Account\n" + "6: update Account\n" + "7: Delete Account\n"
				+ "8: Exit\n");

		while (true) {
			System.out.println("Moi ban chon chuc nang: ");
			@SuppressWarnings("static-access")
			int choose = scanner.intpositive("Ban phai nhap tu 1 den 8");
			switch (choose) {
			case 1:
				System.out.println("============List account============");
				getListAccounts();
				break;
			case 2:
				System.out.println("============get account by ID============");
				getAccountByID();
				break;
			case 3:
				System.out.println(" ============is Account Exists by userName============");
				isAccountExistsByName();
				break;
			case 4:
				System.out.println("============is Account Exists by ID============");
				isAccountExistsbyID();
				break;
			case 5:
				System.out.println("============Create account============");
				createAccount();
				break;
			case 6:
				System.out.println("============Update account============ ");
				updateAccountByID();
				break;
			case 7:
				System.out.println("============Delete account============ ");
				deleteAccount();
				break;
			case 8:
				return;
			default:
				System.out.println("input wrong, please input again!");
				break;
			}
		}
	}

	/**
	 * This method is : Demo get list Account
	 * 
	 * @Description: .
	 * @author: NinhHien
	 * @create_date: Oct 23, 2020
	 * @version: 2.0
	 * @modifer: NinhHien
	 * @modifer_date: Oct 23, 2020
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
//get list Account
	@SuppressWarnings("unused")
	private static void getListAccounts() throws SQLException, ClassNotFoundException, IOException {
		List<Account> accounts = controller.getListAccounts();
		for (Account account1 : accounts) {
			System.out.println(account1);
		}
	}

	/**
	 * This method is : Demo get Account by ID
	 * 
	 * @Description: .
	 * @author: NinhHien
	 * @create_date: Oct 23, 2020
	 * @version: 2.0
	 * @modifer: NinhHien
	 * @modifer_date: Oct 23, 2020
	 * @param args
	 * @throws Exception
	 */
// Validation: getAccountById
	@SuppressWarnings("unused")
	private static void getAccountByID() throws SQLException, Exception {
		System.out.print("Moi nhap vao id: ");
		int id = ScannerUtils.intpositive("Ban phai nhap vao so nguyen: ");
		Account account = controller.getAccountByID(id);
		System.out.println(account);
	}

	/**
	 * This method is demo check Account is exist by userName
	 * 
	 * @Description: .
	 * @author: NinhHien
	 * @create_date: Oct 23, 2020
	 * @version: 2.0
	 * @modifer: NinhHien
	 * @modifer_date: Oct 23, 2020
	 * @param args
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private static void isAccountExistsByName() throws Exception {
		while (true) {
			System.out.print("Moi ban nhap userName: ");
			String username = ScannerUtils.inputString();
			try {
				System.out.println(controller.isAccountExists(username));
				return;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				System.out.println();
			}
		}
	}

	/**
	 * This method is . demo check Account is exist by ID
	 * 
	 * @Description: .
	 * @author: NinhHien
	 * @create_date: Oct 23, 2020
	 * @version: 2.0
	 * @throws SQLException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @modifer: NinhHien
	 * @modifer_date: Oct 23, 2020
	 */
	@SuppressWarnings("unused")
	private static void isAccountExistsbyID() throws SQLException, ClassNotFoundException, IOException {

		System.out.print("Moi ban nhap vao ID: ");
		int id = ScannerUtils.intpositive("Ban phai nhap so nguyen duong ");
		System.out.println(controller.isAccountExists(id));
	}

	/**
	 * This method is . Create Account
	 * 
	 * @Description: .
	 * @author: NinhHien
	 * @create_date: Oct 23, 2020
	 * @version: 2.0
	 * @modifer: NinhHien
	 * @modifer_date: Oct 23, 2020
	 * @param args
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private static void createAccount() throws Exception {
		System.out.print("Moi ban nhap email: ");
		String email = ScannerUtils.email("Email phai co duoi @gmail.com");
		while (true) {
			System.out.print("Moi ban nhap UserName: ");
			String userName = ScannerUtils.inputString();

			System.out.print("Moi ban nhap ten day du: ");
			String fullName = ScannerUtils.inputFullName();
			try {
				controller.createAccount(email, userName, fullName);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	/**
	 * This method is . Update account
	 * 
	 * @Description: .
	 * @author: NinhHien
	 * @create_date: Oct 23, 2020
	 * @version: 2.0
	 * @throws Exception
	 * @modifer: NinhHien
	 * @modifer_date: Oct 23, 2020
	 */
	@SuppressWarnings("unused")
	private static void updateAccountByID() throws Exception {
		while (true) {
			System.out.print("Moi ban nhap vao ID: ");
			int id = ScannerUtils.intpositive("Ban phai nhap so nguyen duong ");
			System.out.print("Moi ban nhap UserName: ");
			String newUserName = ScannerUtils.inputString();
			try {
				controller.updateAccountByID(id, newUserName);
				return;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * This method is .
	 * 
	 * @Description: .
	 * @author: NinhHien
	 * @create_date: Oct 23, 2020
	 * @version: 2.0
	 * @throws Exception
	 * @modifer: NinhHien
	 * @modifer_date: Oct 23, 2020
	 */
	@SuppressWarnings("unused")
	private static void deleteAccount() throws Exception {
		while (true) {
			System.out.print("Moi ban nhap vao ID: ");
			int id = ScannerUtils.intpositive("Ban phai nhap so nguyen duong ");
			try {
				controller.deleteAccount(id);
				return;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
