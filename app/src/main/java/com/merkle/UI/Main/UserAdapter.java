package com.merkle.UI.Main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        TextView tvUsername, tvName, tvEmail;

        public ViewHolder(View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.username);
            tvName = itemView.findViewById(R.id.tv1);
            tvEmail = itemView.findViewById(R.id.tv2);
        }
    }
}
