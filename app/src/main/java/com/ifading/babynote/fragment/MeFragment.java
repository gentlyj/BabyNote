package com.ifading.babynote.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ifading.babynote.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created  on 20180319//.
 *
 * @author by yangjingsheng
 */

public class MeFragment extends Fragment {

    private static final String TAG = "CoinMarketFragment";
    @BindView(R.id.main_rv)
    protected RecyclerView mRv;
    @BindView(R.id.swipe_ly)
    protected SwipeRefreshLayout mSwipeLayout;
//    private Retrofit retrofit;
//    private TickerGetRequestInterface request;
    private long mLastLoadDataTime;
//    private HomeAdapter homeAdapter;

    public static MeFragment newInstance(int index) {
        MeFragment fragment = new MeFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coin_market, container, false);
        ButterKnife.bind(this, view);
        initView();
        initData();
        initEvent();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (System.currentTimeMillis() - mLastLoadDataTime > 1 * 60 * 1000) {
            fetchCoinData();
        }
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        mRv.setLayoutManager(linearLayoutManager);

    }

    private void initData() {
//        homeAdapter = new HomeAdapter(R.layout.home_item_view_expended, new ArrayList<CoinResult>());
//        retrofit = new Retrofit.Builder()
//                .baseUrl(ApiConstant.COIN_BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//
//        request = retrofit.create(TickerGetRequestInterface.class);
    }

    private void initEvent() {
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchCoinData();
            }
        });
    }

    private void fetchCoinData() {
//        Call<List<CoinResult>> call = request.getCall();
//        call.enqueue(new Callback<List<CoinResult>>() {
//            @Override
//            public void onResponse(Call<List<CoinResult>> call, Response<List<CoinResult>> response) {
//                Log.d(TAG, response.body().toString());
//                mSwipeLayout.setRefreshing(false);
//                mLastLoadDataTime = System.currentTimeMillis();
//                homeAdapter.setNewData(response.body());
//                mRv.setAdapter(homeAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<CoinResult>> call, Throwable t) {
//                Log.d(TAG, "连接失败,t:" + t.toString());
//                mSwipeLayout.setRefreshing(false);
//            }
//        });
    }



}
