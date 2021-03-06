package me.grechka.yamblz.yamblzweatherapp.presentation.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by alexander on 31/07/2017.
 */

public abstract class BaseFragment extends MvpAppCompatFragment {

    private View rootView;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.rootView = inflater.inflate(obtainLayoutView(), container, false);
        unbinder = ButterKnife.bind(this, rootView);
        onViewsCreated(savedInstanceState);
        return rootView;
    }

    @NonNull
    public View getView() {
        return rootView;
    }

    @LayoutRes
    protected abstract int obtainLayoutView();

    protected void onViewsCreated(@Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) unbinder.unbind();
    }
}
