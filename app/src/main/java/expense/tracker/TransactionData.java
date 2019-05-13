package expense.tracker;

public class TransactionData {

    private int icon;
    private String transactionType;
    private String amount;
    private String desc;
    private String currency;

    public TransactionData(int icon, String transactionType, String amount, String currency, String desc)
    {
        this.icon = icon;
        this.transactionType = transactionType;
        this.amount = amount;
        this.desc = desc;
        this.currency = currency;
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

    public String getCurrency() {
        return currency;
    }
}
