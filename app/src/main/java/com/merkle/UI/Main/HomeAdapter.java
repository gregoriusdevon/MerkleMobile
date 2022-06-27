package com.merkle.UI.Main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.merkle.Data.Helper.Utils;
import com.merkle.Data.Model.Carts.Cart;
import com.merkle.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private final Context context;
    private final List<Cart> cartList;

    public HomeAdapter(Context context, List<Cart> carts) {
        this.context = context;
        this.cartList = carts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.container_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Cart cart = cartList.get(position);

        holder.tvDate.setText(cart.getDate());
        holder.tvId.setText("ID #" + String.valueOf(cart.getId()));
        holder.tvUserId.setText("UserID #" + String.valueOf(cart.getUserId()));

        holder.constraintLayout.setOnClickListener(v -> {
            Utils.preventTwoClick(v);
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("id", cart.getId());
            context.startActivity(intent);
        });
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
        TextView tvDate, tvId, tvUserId;

        public ViewHolder(View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.date);
            tvId = itemView.findViewById(R.id.id);
            tvUserId = itemView.findViewById(R.id.userId);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
        }
    }
}
