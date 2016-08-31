package rajan.udacity.stock.hawk.ui.stockgraph;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rajan.udacity.stock.hawk.data.DataManager;
import rajan.udacity.stock.hawk.injection.ConfigPersistent;
import rajan.udacity.stock.hawk.ui.base.BasePresenter;
import rajan.udacity.stock.hawk.util.Utils;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Rajan Maurya on 30/08/16.
 */
@ConfigPersistent
public class StockGraphPresenter extends BasePresenter<StockGraphMvpView> {

    private final DataManager mDataManager;
    private Subscription mSubscription;

    @Inject
    public StockGraphPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(StockGraphMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void loadFinanceChartData(String symbol) {
        checkViewAttached();
        getMvpView().showProgressBar(true);
        if (mSubscription != null) mSubscription.unsubscribe();
        mSubscription = mDataManager.getFinanceChartData(symbol)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showProgressBar(false);
                        getMvpView().showError();
                    }

                    @Override
                    public void onNext(ResponseBody financeChartData) {
                        getMvpView().showFinanceChartData(Utils
                                .getFinanceChartCallback(financeChartData));
                        getMvpView().showProgressBar(false);
                    }
                });

    }
}
