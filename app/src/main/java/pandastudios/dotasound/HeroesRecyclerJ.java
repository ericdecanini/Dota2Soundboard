package pandastudios.dotasound;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.willowtreeapps.spruce.Spruce;
import com.willowtreeapps.spruce.sort.DefaultSort;

import java.util.List;

public class HeroesRecyclerJ extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    String LOG_TAG = HeroesRecyclerJ.class.getSimpleName();
    private Context context;
    private List<SectionOrRow> mData;

    private Handler handler = new Handler();
    private long anim_duration_long = 1600L;
    private long anim_duration_short = 150L;

    public HeroesRecyclerJ(Context context, List<SectionOrRow> data) {
        this.context = context;
        mData = data;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        super.getItemViewType(position);
        SectionOrRow item = mData.get(position);
        if(!item.isRow()) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==0) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_hero, parent, false);
            return new SectionViewHolder(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_hero, parent, false);
            return new RowViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final SectionOrRow item = mData.get(position);
        if(item.isRow()) {
            final RowViewHolder h = (RowViewHolder) holder;
            h.name.setText(item.getRow().getName());
            h.image.setImageResource(item.getRow().getImg());

            View portrait = (View) h.image.getParent();

            portrait.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        new Spruce.SpruceBuilder((ViewGroup)view.getParent())
                                .sortWith(new DefaultSort(50L))
                                .animateWith(Animations.Companion.growAnimator(view, anim_duration_short))
                                .start();
                        h.name.setVisibility(View.VISIBLE);
                        idleGrow(view);
                    } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            // Handle OnClick event here
                            sendHeroIntent(item.getRow().getName());
                        }
                        new Spruce.SpruceBuilder((ViewGroup)view.getParent())
                                .sortWith(new DefaultSort(50L))
                                .animateWith(Animations.Companion.shrinkAnimator(view, anim_duration_short))
                                .start();
                        new Spruce.SpruceBuilder((ViewGroup)view)
                                .sortWith(new DefaultSort(50L))
                                .animateWith(Animations.Companion.shrinkAnimatorSmall(view, 10L))
                                .start();
                        h.name.setVisibility(View.GONE);
                        handler.removeCallbacksAndMessages(null);
                    }
                    return true;
                }
            });
        } else {
            SectionViewHolder h = (SectionViewHolder) holder;
            h.headerText.setText(item.getSection());
            if (position == getItemCount() - 1)
                h.header.setVisibility(View.INVISIBLE);
            else h.header.setVisibility(View.VISIBLE);
        }
    }

    private void sendHeroIntent(String heroName) {
        Intent intent = new Intent(context, SoundboardActivity.class);
        intent.putExtra(context.getString(R.string.KEY_HERO), heroName);

        context.startActivity(intent);
    }

    private void idleGrow(final View view) {
        new Spruce.SpruceBuilder((ViewGroup) view)
                .sortWith(new DefaultSort(50L))
                .animateWith(Animations.Companion.growAnimatorSmall(view, anim_duration_long))
                .start();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                idleShrink(view);
            }
        }, anim_duration_long);
    }

    private void idleShrink(final View view) {
        new Spruce.SpruceBuilder((ViewGroup) view)
                .sortWith(new DefaultSort(50L))
                .animateWith(Animations.Companion.shrinkAnimatorSmall(view, anim_duration_long))
                .start();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                idleGrow(view);
            }
        }, anim_duration_long);
    }

    public class RowViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private ImageView image;
        public RowViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
        }
    }

    public class SectionViewHolder extends RecyclerView.ViewHolder{
        private View header;
        private TextView headerText;
        public SectionViewHolder(View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.header);
            headerText = (TextView) itemView.findViewById(R.id.header_text);
        }
    }

}