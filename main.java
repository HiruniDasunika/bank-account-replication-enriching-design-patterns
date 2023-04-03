import account.Account;
import account.types.IsuruUdana;
import account.types.Parinatha;
import account.types.Yes;
import manager.AccountManager;
import upgrade.AccountAdapter;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Account> accountList;
    private static AccountAdapter accountAdapter = new AccountAdapter();

    public static void main(String args[]){
        accountList = new ArrayList<>();
        menuHandler();
    }

    public static void menuHandler(){
        boolean inputExit = false;
        do{
            AccountManager accountManager = new AccountManager();

            System.out.println("\n*************************\n"+
                    "Welcome to People's Bank \n" +
                    "*************************\n"+
                    "\n"+
                    "[1] Create account \n" +
                    "[2] View account \n" +
                    "[3] Deposit \n" +
                    "[4] Withdraw \n" +
                    "[5] Transfer \n" +
                    "[6] Upgrade account \n" +
                    "[7] Exit \n");
            System.out.println("Enter your option:");
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input){
                case 1 :
                    Account newAccount1 = accountManager.createAccount();
                    accountList.add(newAccount1);
                    break;
                // case 3 : accountManager.deposit();break;
                case 6 :
                    updateAccountWhenUpgrade(findAccountType(findUpgradeAccount()));
                    break;
                case 7 : inputExit = true;break;

                default:
                    System.out.println("Please enter valid number \n");break;
            }
        }while(!inputExit);



    }

    public static Account findUpgradeAccount(){
        System.out.println("Enter account number: ");
        String accountNo = scanner.nextLine();
        System.out.println("acc no: " + accountNo);
        for(int i=0;i<accountList.size();i++){
            System.out.println(accountList.get(i).getAccountNo());
            if(accountList.get(i).getAccountNo().compareToIgnoreCase(accountNo.toString()) == 0){
                System.out.println(accountList.get(i));
                return accountList.get(i);
            }else{
                System.out.println("This account number is not a valid account number11 \n");
            }
        }
        return null;
    }

    public static void updateAccountWhenUpgrade(Account newAccount){


        for(int i=0; i<accountList.size();i++){
            System.out.println(accountList.get(i).getAccountNo().trim().toString());
            if(accountList.get(i).getAccountNo().trim().toString() == newAccount.getAccountNo().trim().toString()){
                accountList.set(i,newAccount);
                System.out.println("Account upgraded successfully");
            }else{
                System.out.println("This account number is not a valid account number \n");
            }
        }
    }

    public static Account findAccountType(Account account){
        if(account instanceof IsuruUdana){
           return  accountAdapter.upgradeToYes(account);
        }else if(account instanceof Yes){
           return accountAdapter.upgradeToParinatha(account);
        }
        return null;
    }

}
