package com.gmail.kidusmamuye.productrem.ui.home;

import com.gmail.kidusmamuye.productrem.base.mvp.BasePresenter;
import com.gmail.kidusmamuye.productrem.base.mvp.BaseView;

/**
 * Created by KidusMT on 2/20/2018.
 */

public interface HomeContract {

    interface Presenter extends BasePresenter<View>{
        void showContent();//List<Content> content
        void onBackPressed();
        void onContentClicked(int position);
        void onTabClicked();//confusing
        void pullToRefersh();
    }

    interface View extends BaseView<Presenter>{
        void loadContent();//List<Content> content
        void close();
        void OpenContentDetail(int position);
        void changeTab();
        void Refresh();
    }
}
