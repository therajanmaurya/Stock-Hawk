package rajan.udacity.stock.hawk.ui.stockgraph;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rajan.udacity.stock.hawk.data.DataManager;
import rajan.udacity.stock.hawk.data.model.financechart.FinanceChartCallBack;
import rajan.udacity.stock.hawk.data.model.financechart.FinanceChartData;
import rajan.udacity.stock.hawk.injection.ConfigPersistent;
import rajan.udacity.stock.hawk.ui.base.BasePresenter;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

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

                        Gson gson=new Gson();

                        String result = null;
                        try {
                            result = financeChartData.string();
                            if (result.startsWith("finance_charts_json_callback( ")) {
                                result = result.substring(29, result.length() - 2);
                            }
                        } catch (IOException | NullPointerException e) {
                            e.printStackTrace();
                        }



                        Type type = new TypeToken<FinanceChartData>() {}.getType();

                         FinanceChartCallBack financeChartData1 =
                                 gson.fromJson(result, FinanceChartCallBack.class);

                        //getMvpView().showFinanceChartData(financeChartData1);
                        Timber.d(financeChartData1.toString());
                        getMvpView().showProgressBar(false);
                    }
                });

    }
}
