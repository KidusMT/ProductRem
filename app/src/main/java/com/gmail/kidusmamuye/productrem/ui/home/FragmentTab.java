package com.gmail.kidusmamuye.productrem.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.kidusmamuye.productrem.base.view.BaseFragment;
import com.gmail.kidusmamuye.productrem.data.request.local.Request;

import java.util.List;


public class FragmentTab extends BaseFragment implements HomeContract.View {

    private HomeContract.Presenter presenter;

    private RecyclerView recyclerView;
    private HomeTabAdapter adapter;

    private FloatingActionButton fab_add;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new HomePresenter(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,container, false);

        recyclerView = v.findViewById(R.id.recycler_view_home);

        //The add floating action Button
        fab_add = v.findViewById(R.id.fab);
        fab_add.setOnClickListener(u->presenter.onAddRequestClicked());

        //TODO should initialize the delete button here and call the method in the presenter


//        adapter = new AccidentAdapter(getContext(),accidents);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);

//        recyclerView.setAdapter(expMgr.createWrappedAdapter(new HomeTabAdapter()));

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        //the same as if calling it in the start() method
        presenter.start();
    }

    @Override
    public void openAddPostScreen() {
//        startActivity(new Intent(getActivity(), PostActivity.class));
    }

    @Override
    public void showPostedItems(List<Request> requests) {
        adapter = new HomeTabAdapter(requests, presenter);
        Log.e("-->FragmentTab",""+requests.size());

        //This should never be forgotten
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void toggleExpandRequests(int position) {
        //TODO this will be handled by the expanded recyclerView activity
    }


    @Override
    public void showOfferDetails(int position) {
        //TODO will be done when the detail page for the offer detail is made
//        startActivity(new Intent(getActivity(), DetailAccidentActivity.class)
//                .putExtra("accident_id",accident.getId()));
    }

    @Override
    public void refreshList() {
        //TODO to be implemented when i got time with more complications as necessary
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showNoRecordsLabel() {
        //TODO to be implemented when i got time
    }

    @Override
    public void hideNoRecordsLabel() {
        //TODO to be implemented when i got time
    }
}
