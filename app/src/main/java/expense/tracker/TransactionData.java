package expense.tracker;

public class TransactionData {

    private int icon;
    private String transactionType;
    private String amount;
    private String desc;

    public TransactionData(int icon, String transactionType, String amount, String desc)
    {
        this.icon = icon;
        this.transactionType = transactionType;
        this.amount = amount;
        this.desc = desc;
    }

    public int getIcon() {
        return icon;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getAmount() {
        return amount;
    }

    public String getDesc() {
        return desc;
    }
}
