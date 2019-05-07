package expense.tracker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter{

    private List tTransactionData;
    private Context tContext;


    public TransactionAdapter(Context tContext, List tTransactionData)
    {
        this.tTransactionData = tTransactionData;
        this.tContext = tContext;



    }
    @Override
    public TransactionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,
                parent, false);
        return new TransactionViewHolder(view);


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class TransactionViewHolder extends RecyclerView.ViewHolder {
    ImageView Icon;
    TextView transactionType;
    TextView amount;
    TextView desc;

    public TransactionViewHolder(View itemView) {
        super(itemView);
        Icon = itemView.findViewById(R.id.iconItem);
        transactionType = itemView.findViewById(R.id.transactionTypeItem);
        amount = itemView.findViewById(R.id.amount);
        desc = itemView.findViewById(R.id.description);
    }
}
