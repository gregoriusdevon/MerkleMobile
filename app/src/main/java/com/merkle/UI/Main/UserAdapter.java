package com.merkle.UI.Main;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.merkle.Data.Helper.Utils;
import com.merkle.Data.Model.Users.User;
import com.merkle.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private final Context context;
    private final List<User> userList;

    public UserAdapter(Context context, List<User> users) {
        this.context = context;
        this.userList = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.container_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = userList.get(position);

        holder.tvUsername.setText(user.getUsername());
        holder.tvName.setText(user.getName().getFirstname() + " " + user.getName().getLastname());
        holder.tvEmail.setText(user.getEmail());

        holder.cardView.setOnClickListener(v -> {
            Utils.preventTwoClick(v);
            AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AlertDialogTheme);
            View view = LayoutInflater.from(context).inflate(R.layout.dialog_user, v.findViewById(R.id.layoutDialogContainer));
            builder.setView(view);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

            ((TextView) view.findViewById(R.id.tvFillNama)).setText(user.getName().getFirstname() + " " + user.getName().getLastname());
            ((TextView) view.findViewById(R.id.tvID)).setText("ID         : " + user.getId());
            ((TextView) view.findViewById(R.id.tvUsername)).setText("Username        : " + user.getUsername());
            ((TextView) view.findViewById(R.id.tvEmail)).setText("Email                 : " + user.getEmail());
            ((TextView) view.findViewById(R.id.tvFillAlamat)).setText(user.getAddress().getStreet() + ", " + user.getAddress().getCity());
            ((TextView) view.findViewById(R.id.tvNoTelp)).setText("Nomor Ponsel  : " + user.getPhone());
            ((TextView) view.findViewById(R.id.tvZipcode)).setText("Zipcode            : " + user.getAddress().getZipcode());

            view.findViewById(R.id.clear4).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();
                }
            });

            if (alertDialog.getWindow() != null) {
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            }
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
        return userList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView cardView;
        TextView tvUsername, tvName, tvEmail;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv1);
            tvEmail = itemView.findViewById(R.id.tv2);
            cardView = itemView.findViewById(R.id.cardView);
            tvUsername = itemView.findViewById(R.id.username);
        }
    }
}
