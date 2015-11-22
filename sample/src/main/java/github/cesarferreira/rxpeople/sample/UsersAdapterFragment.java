package github.cesarferreira.rxpeople.sample;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import github.cesarferreira.rxpeople.RxPeople;
import github.cesarferreira.rxpeople.models.FakeUser;
import github.cesarferreira.rxpeople.utils.Gender;
import github.cesarferreira.rxpeople.utils.Nationality;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class UsersAdapterFragment extends Fragment {

    @Bind(R.id.my_recycler_view)
    RecyclerView mRecyclerView;

    @Bind(R.id.progress_view_container)
    LinearLayout progressContainer;

    private Context mContext;

    public UsersAdapterFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users_adapter, container, false);
        ButterKnife.bind(this, view);

        mContext = getActivity();

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        fetchData();

        return view;
    }


    private void fetchData() {

        showProgress();

        RxPeople.with(mContext)
                .amount(80)
                .nationality(Nationality.BR)
                .gender(Gender.FEMALE)
                .intoObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<FakeUser>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        hideProgress();
                        e.printStackTrace();
                        Toast.makeText(getActivity(), "Error: " + e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(List<FakeUser> posers) {
                        hideProgress();
                        fillAdapter(posers);
                    }
                });

    }

    private void fillAdapter(List<FakeUser> data) {
        RecyclerView.Adapter mAdapter = new UsersAdapter(data);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void hideProgress() {
        progressContainer.setVisibility(View.INVISIBLE);
    }

    private void showProgress() {
        progressContainer.setVisibility(View.VISIBLE);
    }

}
