package expense.tracker;

import android.widget.ImageView;

public class TransactionData {

    private ImageView icon;
    private String transactionType;
    private int amount;
    private String desc;

    public TransactionData(ImageView icon, String transactionType, int amount, String desc)
    {
        this.icon = icon;
        this.transactionType = transactionType;
        this.amount = amount;
        this.desc = desc;
    }

}
