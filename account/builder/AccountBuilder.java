package account.builder;

import account.Account;
import account.AccountHolder;
import account.types.IsuruUdana;
import account.types.Parinatha;
import account.types.Wanitha;
import account.types.Yes;

import java.util.Date;
import java.util.Scanner;

public class AccountBuilder {
    private Scanner scanner = new Scanner(System.in);

    /**
     * This method create the account object step by step
     * @return created account
     */
    public Account createAccount(){
        Account newAccount = this.createAccountHandler(this.setAccountType());
        System.out.println(newAccount);
        System.out.println("Successfully created your account!\n");
        return newAccount;

    }

    /**
     * This method returns the appropriate account type object for given object
     * @param account account that you want
     * @return appropriate account object
     */
    public Account createAccountHandler(Account account){
        if(account instanceof IsuruUdana){
            return this.createIsuruUdanaAccount(account);
        }else if(account instanceof Yes){
            return this.createYesAccount(account);
        }else if(account instanceof Parinatha){
            return this.createParinathaAccount(account);
        }else{
            return this.createWanithaAccount(account);
        }


    }

    /**
     * This method returns account object by account type
     * @return account type
     */
    private Account setAccountType(){
        boolean isValidInput = true;
        do{
            System.out.println("Which account do you want to create? \n" +
                    "[0] Isuru Udana Account \n" +
                    "[1] Yes Account \n" +
                    "[2] Parinatha Account \n" +
                    "[3] Wanitha Account \n" +
                    "Select and enter appropriate number for your account type: ");
            int input = this.scanner.nextInt();
            this.scanner.nextLine();
            if(input == 0){
                return new IsuruUdana();
            }else if(input == 1){
                return new Yes();
            }else if(input == 2){
                return new Parinatha();
            }else if(input == 3){
                return new Wanitha();
            }else{
                isValidInput = false;
                System.out.println("Not a valid input. Re-enter your account type: ");
            }
        }while(!isValidInput);
        return  null;
    }

    /**
     * This method get the account holder's name
     * @return account holder's name
     */
    private String setHolderName(){
        boolean isValidInput = true;
        System.out.println("Enter account holder's name ");
        do{
            String input = this.scanner.nextLine();
            // account holder's name should not be blank or empty
            if(!input.isBlank()){
                return input;
            }else{
                isValidInput = false;
                System.out.println("Not a valid name. Re-enter account holder's name: ");
            }
        }while(!isValidInput);
        return null;


    }

    /**
     * This method get the account holder's birthday
     * @return account holder's birthday
     */
    private Date setBirthday(){
        boolean isValidInput = true;
        int year = 1900;
        int month = 1;
        int date = 1;
        System.out.println("Enter account holder's birthday");
        System.out.println("Enter the four digits of your birthdate year: ");
        do{
            int yyyy = this.scanner.nextInt();
            this.scanner.nextLine();
            // birth year should be less than oor equal to current year
            if(yyyy <= (new Date().getYear() +1900)){
                year = yyyy;
            }else{
                isValidInput = false;
                System.out.println("Not a valid year. Re-enter birth year: ");
            }
        }while(!isValidInput);

        System.out.println("Enter the number your birthdate month (i.e. 1 for January) : ");
        do{
            int mm = this.scanner.nextInt();
            this.scanner.nextLine();
            // birth month should be a valid month i.e. month should be in between 1,12 number
            if(mm > 0 && mm < 13){
                month = mm;
            }else{
                isValidInput = false;
                System.out.println("Not a valid month. Re-enter birth month: ");
            }
        }while(!isValidInput);

        System.out.println("Enter your birth day : ");
        do{
            int dd = this.scanner.nextInt();
            this.scanner.nextLine();
            // date should be a valid date
            if(dd > 0 && dd < 32){
                date = dd;
            }else{
                isValidInput = false;
                System.out.println("Not a valid date. Re-enter birth date: ");
            }
        }while(!isValidInput);

        Date dob = new Date(year,month,date);
        return dob;
    }

    /**
     * This method get the account holder's NIC number
     * @return account holder's NIC number
     */
    public String  setHolderNIC(){
        boolean isValidInput = true;
        System.out.println("Enter account holder's NIC");
        do{
            String input = this.scanner.nextLine();
            // NIC number should be a valid  NIC number
            if(!input.isBlank() && (input.length()==10 || input.length()==12)){
                return input;
            }else{
                isValidInput = false;
                System.out.println("Not a valid NIC. Re-enter NIC number: ");
            }
        }while(!isValidInput);
        return null;
    }

    /**
     * This method get the account holder's guardian name
     * @return account holder's guardian name
     */
    public String  setGuardianName(){
        boolean isValidInput = true;
        System.out.println("Enter account holder's guardian name: ");
        do{
            String input = this.scanner.nextLine();
            // Guardian's name should be valid name
            if(!input.isBlank()){
                return input;
            }else{
                isValidInput = false;
                System.out.println("Not a valid name. Re-enter guardian name: ");
            }
        }while(!isValidInput);
        return null;
    }

    /**
     * This method get the account holder's guardian NIC number
     * @return account holder's guardian NIC number
     */
    public String  seGuardianNIC(){
        boolean isValidInput = true;
        System.out.println("Enter account holder's guardian NIC");
        do{
            String input = this.scanner.nextLine();
            // NIC number should be a valid  NIC number
            if(!input.isBlank() && (input.length()==10 || input.length()==12)){
                return input;
            }else{
                isValidInput = false;
                System.out.println("Not a valid NIC. Re-enter account holder's guardian NIC number: ");
            }
        }while(!isValidInput);
        return null;
    }

    /**
     * This method get the account holder's address
     * @return account holder's address
     */
    public String  setAddress(){
        boolean isValidInput = true;
        System.out.println("Enter account holder's address: ");
        do{
            String input = this.scanner.nextLine();
            // Address should be valid name
            if(!input.isBlank()){
                return input;
            }else{
                isValidInput = false;
                System.out.println("Not a valid address. Re-enter account holder's address: ");
            }
        }while(!isValidInput);
        return null;
    }

    /**
     * This method generate the account number
     * @return account number
     */
    public String generateAccountNumber(){
        long id = new Date().getTime();
        String accountNumber = Long.toString(id);
        return accountNumber;
    }

    /**
     * This method create Normal account holder object with NIC nuumber
     * @return account holder object with assign their parameters
     */
    private AccountHolder createNormalAccountHolder(){
        AccountHolder accountHolder = new AccountHolder();
        accountHolder.setHolderName(this.setHolderName());
        accountHolder.setHolderAddress(this.setAddress());
        accountHolder.setHolderDOB(this.setBirthday());
        accountHolder.setHolderNIC(this.setHolderNIC());
        return accountHolder;

    }

    /**
     * This method create the child account hlder object without NIC number
     * @return account holder object with assign their parameters
     */
    private AccountHolder creatChildAccountHolder(){
        AccountHolder accountHolder = new AccountHolder();
        accountHolder.setHolderName(this.setHolderName());
        accountHolder.setHolderAddress(this.setAddress());
        accountHolder.setHolderDOB(this.setBirthday());
        return accountHolder;

    }

    /**
     * This method returns the Isuru Udana account object with their attributes
     * @param isuruUdanaAccount
     * @return Isuru Udana account object with attributes
     */
    private Account createIsuruUdanaAccount(Account isuruUdanaAccount){
        IsuruUdana isuruUdana = (IsuruUdana) isuruUdanaAccount;
        isuruUdana.setAccountHolder(this.creatChildAccountHolder());
        isuruUdana.setAccountNo(this.generateAccountNumber());
        isuruUdana.setAmount(this.setOpeningBalance());
        isuruUdana.setInterestRate(0.1);
        isuruUdana.setGuradianName(this.setGuardianName());
        isuruUdana.setGuardianNIC(this.seGuardianNIC());
        return isuruUdana;
    }

    /**
     * This method creates the Yes account object with their attributes
     * @param yesAccount
     * @return Yes account object with attributes
     */
    private Account createYesAccount(Account yesAccount){
        yesAccount.setAccountHolder(this.createNormalAccountHolder());
        yesAccount.setAccountNo(this.generateAccountNumber());
        yesAccount.setAmount(this.setOpeningBalance());
        yesAccount.setInterestRate(0.2);
        return yesAccount;
    }

    /**
     * This method creates the Parinatha account object with their attributes
     * @param parinathaAccount
     * @return Parinatha account object with attributes
     */
    private Account createParinathaAccount(Account parinathaAccount){
        parinathaAccount.setAccountHolder(this.createNormalAccountHolder());
        parinathaAccount.setAccountNo(this.generateAccountNumber());
        parinathaAccount.setAmount(this.setOpeningBalance());
        parinathaAccount.setInterestRate(0.2);
        return parinathaAccount;
    }

    /**
     * This method creates the Wanitha account object with their parameters
     * @param wanithaAccount
     * @return Wanitha account object with attributes
     */
    private Account createWanithaAccount(Account wanithaAccount){
        wanithaAccount.setAccountHolder(this.createNormalAccountHolder());
        wanithaAccount.setAccountNo(this.generateAccountNumber());
        wanithaAccount.setAmount(this.setOpeningBalance());
        wanithaAccount.setInterestRate(0.2);
        return wanithaAccount;
    }

    /**
     * This method get the opening balance of a account from user
     * @return opening balance
     */
    private double setOpeningBalance(){
        boolean isValidInput = true;
        System.out.println("Enter your opening balance: ");
        do{
            double input = this.scanner.nextDouble();
            this.scanner.nextLine();
            if(input >= 1000){
                return input;
            }else{
                isValidInput = false;
                System.out.println("Minimum amount is 1000. Re-enter amount: ");
            }

        }while(!isValidInput);
        return 0;


    }



    private String getAccountNumber(){
        System.out.println("Enter account number: ");
        boolean isValidInput = true;
        do{
            String input = this.scanner.nextLine();

            if(!input.isBlank()){
                return input;
            }else{
                isValidInput = false;
                System.out.println("Enter valid account number: \n");
            }
        }while(!isValidInput);
        return null;
    }

    private double setDepositAmount(){
        System.out.println("Enter deposit amount: ");
        boolean isValidInput = true;
        do{
            double input = this.scanner.nextDouble();
            this.scanner.nextLine();

            if(input>0){
                return input;
            }else{
                isValidInput = false;
                System.out.println("Deposit valid amount: ");
            }
        }while(!isValidInput);
        System.out.println("Successfully deposit! \n");
        return 0;
    }
}
