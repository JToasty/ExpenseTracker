package expense.tracker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView tIcon;
    public TextView tTransactionType;
    public TextView tAmount;
    public TextView tDesc;


    public ViewHolder(View itemView) {
        super(itemView);
        tIcon = itemView.findViewById(R.id.iconItem);
        tTransactionType = itemView.findViewById(R.id.transactionTypeItem);
        tAmount = itemView.findViewById(R.id.amount);
        tDesc = itemView.findViewById(R.id.description);
    }
}

public class TransactionAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<TransactionData> tTransactionData;

    public TransactionAdapter(List<TransactionData> tTransactionData)
    {
        this.tTransactionData = tTransactionData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,
                parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tIcon.setImageResource(tTransactionData.get(position).getIcon());
        holder.tTransactionType.setText(tTransactionData.get(position).getTransactionType());
        holder.tAmount.setText(tTransactionData.get(position).getAmount());
        holder.tDesc.setText(tTransactionData.get(position).getDesc());
    }


    @Override
    public int getItemCount() {
        return tTransactionData.size();
    }
}
