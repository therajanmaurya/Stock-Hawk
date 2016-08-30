package rajan.udacity.stock.hawk.ui.widget;

import javax.inject.Inject;

import rajan.udacity.stock.hawk.data.DataManager;
import rajan.udacity.stock.hawk.data.model.multiple.Stocks;
import rajan.udacity.stock.hawk.ui.base.BasePresenter;
import rajan.udacity.stock.hawk.util.RxUtil;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Rajan Maurya on 30/08/16.
 */
public class ListRemoteViewFactoryPresenter extends BasePresenter<ListRemoteViewFactoryMvpView> {

    private final DataManager mDataManager;
    private Subscription mSubscription;

    @Inject
    public ListRemoteViewFactoryPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(ListRemoteViewFactoryMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void loadStocks() {
        checkViewAttached();
        RxUtil.unsubscribe(mSubscription);
        mSubscription = mDataManager.getStocks()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Stocks>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, "There was an error loading the stocks.");
                        getMvpView().showError();
                    }

                    @Override
                    public void onNext(Stocks stocks) {
                        showStocks(stocks);
                    }
                });
    }

    private void showStocks(Stocks stocks) {
        if (stocks == null) {
            getMvpView().showStocksEmpty();
        } else {
            getMvpView().showStocks(stocks.getQuery().getResult().getQuote());
        }
    }

}
