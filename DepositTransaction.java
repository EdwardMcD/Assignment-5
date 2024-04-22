package A2_BaAO.Assign5;
import A2_BaAO.Account;

public class DepositTransaction implements TransactionInterface {
    private Account account;
    private double amount;

    public DepositTransaction(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.deposit(amount);
    }
}