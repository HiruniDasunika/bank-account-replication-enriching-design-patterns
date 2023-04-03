package account;

/**
 * This class holds the account details and the functionalities of various types of accounts
 * @author Hiruni Dasunika
 * @version 1.0.0
 */
public abstract class Account {
    private String accountNo;
    private AccountHolder accountHolder;
    private double amount;
    private double interestRate;

    /**
     * creates account object with null reference
     */
    public Account() {
    }

    /**
     * creates accoount object with references
     * @param accountNo
     * @param accountHolder
     * @param amount
     * @param interestRate
     */
    public Account(String accountNo, AccountHolder accountHolder, double amount, double interestRate) {
        this.setAccountNo(accountNo);
        this.setAccountHolder(accountHolder);
        this.setAmount(amount);
        this.setInterestRate(interestRate);
    }

    /**
     * @return  account number
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo account number
     */
    public void setAccountNo(String accountNo) {
        // account number should not be empty
        if(!accountNo.isBlank()){
            this.accountNo = accountNo;
        }else{
            throw new IllegalArgumentException();
        }

    }

    /**
     * @return account holder details
     */
    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    /**
     * @param accountHolder account holder details
     */
    public void setAccountHolder(AccountHolder accountHolder) {
        // account holder object should not be null
        if(accountHolder != null){
            this.accountHolder = accountHolder;
        }else{
            throw new IllegalArgumentException();
        }

    }

    /**
     * @return bank account amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount bank account amount
     */
    public void setAmount(double amount) {
        // bank account amount must be greater than 1000
        if(amount >= 1000){
            this.amount = amount;
        }else{
            throw new IllegalArgumentException();
        }

    }

    /**
     * @return interest rate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * @param interestRate interest rate
     */
    public void setInterestRate(double interestRate) {
        // interest rate should not be zero
        if(interestRate != 0){
            this.interestRate = interestRate;
        }else{
            throw new IllegalArgumentException();
        }

    }

    /**
     * This method deposits given valid amount
     * @param amount amount that want to deposit
     */
    public void deposit(double amount){
        // amount should be greater than zero
        if(amount > 0){
            final double newAmount = this.getAmount() + amount;
            this.setAmount(newAmount);
        }else{
            System.out.println("Deposit valid amount");
        }
    }


    /**
     * This method withdraw the given amount
     * @param amount  amount that want to withdraw
     */
    public void withdraw(double amount){
        // Withdraw amount should be greater than zero and after successful withdrawal account balance should
        // be greater than or equal to 1000
        if(amount > 0 && amount <= (this.getAmount() - 1000) ){
            final double newAmount = this.getAmount() - amount;
            this.setAmount(newAmount);
        }else{
            System.out.println("Withdraw valid amount");
        }
    }

    /**
     * This method transfers given amount to given valid account
     * @param amount amount that wants to transfer
     * @param account account details that wants transfer amount
     * @return success or failure
     */
    public boolean transfer(double amount, Account account){
        // transfer amount should be greater than zero and, it should be less than or equal to current
        // amount - 1000
        if(amount > 0 && (amount <= this.getAmount() - 1000)){
            this.withdraw(amount);
            account.deposit(amount);
            return true;
        }else{
            return false;
        }



    }

    @Override
    public String toString(){
        return "\n **Your account details**\n"+"Account number: " + this.getAccountNo() + "\nAccount holder: "+ this.getAccountHolder().getHolderName();
    }

}
