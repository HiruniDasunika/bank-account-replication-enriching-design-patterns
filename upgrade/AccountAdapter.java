package upgrade;

import account.Account;
import account.types.Parinatha;
import account.types.Wanitha;
import account.types.Yes;
import manager.AccountManager;

public class AccountAdapter {


    /**
     * This method upgrade given account in to yes account and returns the converted Yes account.
     * @param account
     * @return yes account
     */
    public Account upgradeToYes(Account account){
        Account newAccount =  new Yes();
        newAccount.setAccountNo(account.getAccountNo());
        newAccount.setAccountHolder(account.getAccountHolder());
        newAccount.setAmount(account.getAmount());
        newAccount.setInterestRate(account.getInterestRate());
        return newAccount;

    }

    /**
     * This method upgrade given account in to parinatha account and returns the converted parinatha account.
     * @param account
     * @return parinatha account
     */
    public Account upgradeToParinatha(Account account){
        Account newAccount =  new Parinatha();
        newAccount.setAccountNo(account.getAccountNo());
        newAccount.setAccountHolder(account.getAccountHolder());
        newAccount.setAmount(account.getAmount());
        newAccount.setInterestRate(account.getInterestRate());
        return newAccount;

    }
}
