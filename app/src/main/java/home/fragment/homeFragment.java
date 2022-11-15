package home.fragment;

import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.LinearLayout;

import androidx.viewpager.widget.ViewPager;

import com.bignerdranch.android.jinling.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import home.cardView.CardItem;
import home.cardView.CardPageAdapter;
import home.cardView.ShadowTransformer;
import home.fragment.BaseFragment;

public class homeFragment extends BaseFragment {
    private Fragment[] fragments;
    private int lastFragmentIndex=0;
    private ViewPager viewPager;

    private LinearLayout lin_road;
    private LinearLayout lin_message;
    private LinearLayout lin_light;

    private View view;
    private CardPageAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;




    @Override
    public View initView() {

//        mCardAdapter = new CardPageAdapter();
//        mCardAdapter.addCardItem(new CardItem(R.string.title_1, R.string.text_1));
//        mCardAdapter.addCardItem(new CardItem(R.string.title_2, R.string.text_1));
//        mCardAdapter.addCardItem(new CardItem(R.string.title_3, R.string.text_1));
//        mCardAdapter.addCardItem(new CardItem(R.string.title_4, R.string.text_1));
//
//        mCardShadowTransformer = new ShadowTransformer(viewPager, mCardAdapter);
//        mCardShadowTransformer.enableScaling(true);
//
//        viewPager.setAdapter(mCardAdapter);
//        viewPager.setPageTransformer(false, mCardShadowTransformer);
//        viewPager.setOffscreenPageLimit(3);






        BottomNavigationView bottomNavigationView=mActivity.findViewById(R.id.main_bottom);
        view=View.inflate(mActivity,R.layout.home_fragment,null);
        viewPager=(ViewPager)view.findViewById(R.id.cardView);

        lin_road=(LinearLayout) view.findViewById(R.id.lin_road);
        lin_message=(LinearLayout) view.findViewById(R.id.lin_message);
        lin_light=(LinearLayout) view.findViewById(R.id.lin_light);
        lin_road.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mActivity.switchFragment(2);

                bottomNavigationView.getMenu().getItem(2).setChecked(true);
            }
        });
        lin_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivity.switchFragment(1);
                bottomNavigationView.getMenu().getItem(1).setChecked(true);
            }
        });
//        lin_light.setOnClickListener(onclicklistener);


        return view;

    }


    @Override
    public void initData() {
        //请求网络
        getDataFromNet();

    }

    private void getDataFromNet() {
//        OkHttpUtils
//                .get()
//                .url(Constants.HOME_URL)
//                .id(100)
//                .build()
//                .execute(new MyStringCallback());
    }


}