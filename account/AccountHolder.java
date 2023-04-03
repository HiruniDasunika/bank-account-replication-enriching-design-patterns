package account;

import java.util.Date;

/**
 * This class holds the details of account holders
 * @author Hiruni Dasunika
 * @version 1.0.0
 */
public class AccountHolder {
    private String holderName;
    private String holderAddress;
    private Date holderDOB;
    private String holderNIC;

    public AccountHolder() {
    }

    /**
     * Create account holder object with NIC
     * @param holderName
     * @param holderAddress
     * @param holderDOB
     * @param holderNIC
     */
    public AccountHolder(String holderName, String holderAddress, Date holderDOB, String holderNIC) {
        this.setHolderName(holderName);
        this.setHolderAddress(holderAddress);
        this.setHolderDOB(holderDOB);
        this.setHolderNIC(holderNIC);
    }

    /**
     * Create account holder object without NIC
     * @param holderName
     * @param holderAddress
     * @param holderDOB
     */
    public AccountHolder(String holderName, String holderAddress, Date holderDOB) {
        this.setHolderName(holderName);
        this.setHolderAddress(holderAddress);
        this.setHolderDOB(holderDOB);
    }

    /**
     * @return account holder's name
     */

    public String getHolderName() {
        return holderName;
    }

    /**
     * @param holderName account holder's name
     */
    public void setHolderName(String holderName) {
        // account name must be valid String and length should be more than zero
        if(!holderName.isBlank()){
            this.holderName = holderName;
        }else{
            throw new IllegalArgumentException();
        }

    }

    /**
     * @return account holder's address
     */
    public String getHolderAddress() {
        return holderAddress;
    }

    /**
     * @param holderAddress account holder's address
     */
    public void setHolderAddress(String holderAddress) {
        if(!holderAddress.isBlank()){
            this.holderAddress = holderAddress;
        }else{
            throw new IllegalArgumentException();
        }

    }

    /**
     * @return account holder's date of birth
     */
    public Date getHolderDOB() {
        return holderDOB;
    }

    /**
     * @param holderDOB account holder's date of birth
     */
    public void setHolderDOB(Date holderDOB) {
        // account holder's date of birth should be less than current date
        if(holderDOB.compareTo(new Date()) > 0){
            this.holderDOB = holderDOB;
        }else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * @return account holder's NIC
     */
    public String getHolderNIC() {
        return holderNIC;
    }

    /**
     * @param holderNIC account holder's NIC
     */
    public void setHolderNIC(String holderNIC) {
        // account holder's NIC should have length of 10 characters or 12 characters
        if(!holderNIC.isBlank() && (holderNIC.length() == 10 || holderNIC.length() == 12)){
            this.holderNIC = holderNIC;
        }else{
            throw new IllegalArgumentException();
        }
    }

    // TODO: Implement toString to match the printing of account holder object


}
