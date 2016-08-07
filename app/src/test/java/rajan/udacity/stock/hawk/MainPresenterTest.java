package rajan.udacity.stock.hawk;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import rx.Observable;
import rajan.udacity.stock.hawk.data.DataManager;
import rajan.udacity.stock.hawk.data.model.Ribot;
import rajan.udacity.stock.hawk.test.common.TestDataFactory;
import rajan.udacity.stock.hawk.ui.main.MainMvpView;
import rajan.udacity.stock.hawk.ui.main.MainPresenter;
import rajan.udacity.stock.hawk.util.RxSchedulersOverrideRule;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock MainMvpView mMockMainMvpView;
    @Mock DataManager mMockDataManager;
    private MainPresenter mMainPresenter;

    @Rule
    public final RxSchedulersOverrideRule mOverrideSchedulersRule = new RxSchedulersOverrideRule();

    @Before
    public void setUp() {
        mMainPresenter = new MainPresenter(mMockDataManager);
        mMainPresenter.attachView(mMockMainMvpView);
    }

    @After
    public void tearDown() {
        mMainPresenter.detachView();
    }

    @Test
    public void loadRibotsReturnsRibots() {
        List<Ribot> ribots = TestDataFactory.makeListRibots(10);
        when(mMockDataManager.getRibots())
                .thenReturn(Observable.just(ribots));

        mMainPresenter.loadRibots();
        verify(mMockMainMvpView).showRibots(ribots);
        verify(mMockMainMvpView, never()).showRibotsEmpty();
        verify(mMockMainMvpView, never()).showError();
    }

    @Test
    public void loadRibotsReturnsEmptyList() {
        when(mMockDataManager.getRibots())
                .thenReturn(Observable.just(Collections.<Ribot>emptyList()));

        mMainPresenter.loadRibots();
        verify(mMockMainMvpView).showRibotsEmpty();
        verify(mMockMainMvpView, never()).showRibots(anyListOf(Ribot.class));
        verify(mMockMainMvpView, never()).showError();
    }

    @Test
    public void loadRibotsFails() {
        when(mMockDataManager.getRibots())
                .thenReturn(Observable.<List<Ribot>>error(new RuntimeException()));

        mMainPresenter.loadRibots();
        verify(mMockMainMvpView).showError();
        verify(mMockMainMvpView, never()).showRibotsEmpty();
        verify(mMockMainMvpView, never()).showRibots(anyListOf(Ribot.class));
    }

}