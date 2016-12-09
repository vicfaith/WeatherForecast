package au.com.vicfaith.android.weatherforecast.view.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BindingViewHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding binding;

    ViewDataBinding getBinding() {
        return binding;
    }

    public BindingViewHolder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }
}