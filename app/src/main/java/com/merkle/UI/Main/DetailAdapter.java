package com.merkle.UI.Main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.merkle.Data.Model.Carts.ProductsItem;
import com.merkle.R;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder> {
    private final Context context;
    private final List<ProductsItem> cartList;

    public DetailAdapter(Context context, List<ProductsItem> carts) {
        this.context = context;
        this.cartList = carts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.container_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ProductsItem carts = cartList.get(position);

        holder.tvProductId.setText("ProductId: " + String.valueOf(carts.getProductId()));
        holder.tvQuantity.setText("Quantity: " + String.valueOf(carts.getQuantity()));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout constraintLayout;
        TextView tvProductId, tvQuantity;

        public ViewHolder(View itemView) {
            super(itemView);
            tvProductId = itemView.findViewById(R.id.productId);
            tvQuantity = itemView.findViewById(R.id.quantity);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
        }
    }
}
