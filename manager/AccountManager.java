package manager;

import account.*;
import account.builder.AccountBuilder;
import account.types.IsuruUdana;
import account.types.Parinatha;
import account.types.Wanitha;
import account.types.Yes;
import upgrade.AccountAdapter;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class AccountManager {

    private AccountAdapter accountAdapter = new AccountAdapter();

   // Scanner scanner = new Scanner(System.in);



    public AccountManager(){
    }

    /**
     * This method returns the account builder created account object
     * @return created account
     */
    public Account createAccount() {
        AccountBuilder accountBuilder = new AccountBuilder();
        Account newAccount = accountBuilder.createAccount();

        return newAccount;
    }





//    public void deposit(){
//        String accountNo = this.getAccountNumber();
//        for (Account account : accountList){
//            if(account.getAccountNo() == accountNo){
//                account.deposit(this.setDepositAmount());
//                System.out.println("Successfully deposited !");
//            }else{
//                System.out.println("This account number is not a valid account number \n");
//            }
//        }
//
//    }


}
