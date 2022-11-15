package home.cardView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import com.bignerdranch.android.jinling.R;

import java.util.ArrayList;
import java.util.List;

public class CardPageAdapter extends PagerAdapter implements CardAdapter {
    private List<CardView> mViews;
    private List<CardItem> mData;
    private float mBaseElevation;

    public CardPageAdapter(){
        mData=new ArrayList<>();
        mViews=new ArrayList<>();
    }

    public void addCardItem(CardItem item){
        mViews.add(null);
        mData.add(item);
    }

    @Override
    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }


    @Override
    public Object instantiateItem(@NonNull View container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.card_item, (ViewGroup) container, false);
        ((ViewGroup) container).addView(view);
        bind(mData.get(position), view);
        CardView cardView = (CardView) view.findViewById(R.id.cardView);

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(CardItem item, View view) {
        TextView titleTextView = (TextView) view.findViewById(R.id.titleTextView);
        TextView contentTextView = (TextView) view.findViewById(R.id.contentTextView);
        titleTextView.setText(item.getTitle());
        contentTextView.setText(item.getText());

    }
}
