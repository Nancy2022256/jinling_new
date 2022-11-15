package home.fragment;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bignerdranch.android.jinling.MainActivity;

public abstract class BaseFragment extends Fragment {
    public Context mContext;
    public MainActivity mActivity;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mActivity=(MainActivity) getActivity();
        View view=initView();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 有子类实现，实现特有效果
     * @return
     */
    public abstract View initView();

    /**
     * 初始化数据
     */
    public void initData() {

    }


}

