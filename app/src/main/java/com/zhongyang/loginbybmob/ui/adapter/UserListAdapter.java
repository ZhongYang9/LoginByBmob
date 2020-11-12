package com.zhongyang.loginbybmob.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhongyang.loginbybmob.R;
import com.zhongyang.loginbybmob.model.domain.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @项目名称 LoginByBmob
 * @类名 UserListAdapter
 * @包名 com.zhongyang.loginbybmob.ui.adapter
 * @创建时间 2020/11/12 20:39
 * @作者 钟阳
 * @描述 显示同户列表的适配器
 */
public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    private List<User> mUsers = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //载布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //绑定数据
        User user = mUsers.get(position);
        holder.setItemData(user);
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    /**
     * 外部传进来的数据
     *
     * @param users
     */
    public void setData(List<User> users) {
        mUsers.clear();
        mUsers.addAll(users);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_account)
        TextView tv_account;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //绑定黄油刀
            ButterKnife.bind(this, itemView);
        }

        public void setItemData(User user) {
            //设置账号显示内容
            tv_account.setText(user.getTelephone());
        }
    }
}
