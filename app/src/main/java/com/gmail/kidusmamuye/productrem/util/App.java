package com.gmail.kidusmamuye.productrem.util;

import android.app.Application;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.kidusmt.movieapp.data.local.movie.MyObjectBox;

import io.objectbox.BoxStore;

//import com.facebook.FacebookSdk;
//import com.facebook.appevents.AppEventsLogger;

/**
 * Created by KidusMT on 12/22/2017.
 */

public class App extends Application {

    public static BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();

        //Initializes ObjectBox for the first time when application runs
        if (boxStore == null) boxStore = MyObjectBox.builder().androidContext(this).build();

    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
     public static class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
        private int spanCount;
        private int spacing;

        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }

    }

}
