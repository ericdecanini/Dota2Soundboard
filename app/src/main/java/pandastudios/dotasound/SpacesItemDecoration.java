package pandastudios.dotasound;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;
    private boolean threeColumns;

    public SpacesItemDecoration(int space, int numColumns) {
        this.space = space;
        this.threeColumns = numColumns == 3;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;

        // Add top margin only for the first item to avoid double space between items
        boolean condition = threeColumns ? parent.getChildLayoutPosition(view) == 0 || parent.getChildLayoutPosition(view) == 1
                || parent.getChildLayoutPosition(view) == 2 : parent.getChildLayoutPosition(view) == 0 || parent.getChildLayoutPosition(view) == 1;

        if (condition) {
            outRect.top = space;
        } else {
            outRect.top = 0;
        }
    }
}