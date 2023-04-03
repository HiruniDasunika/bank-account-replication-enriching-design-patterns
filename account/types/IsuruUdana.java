package account.types;

import account.SavingsAccount;

public class IsuruUdana extends SavingsAccount {
    private String guradianName;
    private String guardianNIC;

    public IsuruUdana() {
        super();
    }

    public IsuruUdana(String guradianName, String guardianNIC) {
        super();
        this.guradianName = guradianName;
        this.guardianNIC = guardianNIC;
    }

    public String getGuradianName() {
        return guradianName;
    }

    public void setGuradianName(String guradianName) {
        this.guradianName = guradianName;
    }

    public String getGuardianNIC() {
        return guardianNIC;
    }

    public void setGuardianNIC(String guardianNIC) {
        this.guardianNIC = guardianNIC;
    }
}
