package rajan.udacity.stock.hawk;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import rajan.udacity.stock.hawk.data.DataManager;
import rajan.udacity.stock.hawk.data.local.DatabaseHelper;
import rajan.udacity.stock.hawk.data.local.PreferencesHelper;
import rajan.udacity.stock.hawk.data.remote.StocksService;

/**
 * This test class performs local unit tests without dependencies on the Android framework
 * For testing methods in the DataManager follow this approach:
 * 1. Stub mock helper classes that your method relies on. e.g. RetrofitServices or DatabaseHelper
 * 2. Test the Observable using TestSubscriber
 * 3. Optionally write a SEPARATE test that verifies that your method is calling the right helper
 * using Mockito.verify()
 */
@RunWith(MockitoJUnitRunner.class)
public class DataManagerTest {

    @Mock DatabaseHelper mMockDatabaseHelper;
    @Mock PreferencesHelper mMockPreferencesHelper;
    @Mock
    StocksService mMockRibotsService;
    private DataManager mDataManager;

    @Before
    public void setUp() {
        mDataManager = new DataManager(mMockRibotsService, mMockPreferencesHelper,
                mMockDatabaseHelper);
    }

    /*@Test
    public void syncRibotsEmitsValues() {
        List<Stocks> ribots = Arrays.asList(TestDataFactory.makeRibot("r1"),
                TestDataFactory.makeRibot("r2"));
        stubSyncRibotsHelperCalls(ribots);

        TestSubscriber<Stocks> result = new TestSubscriber<>();
        mDataManager.syncRibots().subscribe(result);
        result.assertNoErrors();
        result.assertReceivedOnNext(ribots);
    }

    @Test
    public void syncRibotsCallsApiAndDatabase() {
        List<Stocks> ribots = Arrays.asList(TestDataFactory.makeRibot("r1"),
                TestDataFactory.makeRibot("r2"));
        stubSyncRibotsHelperCalls(ribots);

        mDataManager.syncRibots().subscribe();
        // Verify right calls to helper methods
        verify(mMockRibotsService).getStocks();
        verify(mMockDatabaseHelper).setStocks(ribots);
    }

    @Test
    public void syncRibotsDoesNotCallDatabaseWhenApiFails() {
        when(mMockRibotsService.getStocks())
                .thenReturn(Observable.<List<Stocks>>error(new RuntimeException()));

        mDataManager.syncRibots().subscribe(new TestSubscriber<Stocks>());
        // Verify right calls to helper methods
        verify(mMockRibotsService).getStocks();
        verify(mMockDatabaseHelper, never()).setStocks(anyListOf(Stocks.class));
    }

    private void stubSyncRibotsHelperCalls(List<Stocks> ribots) {
        // Stub calls to the ribot service and database helper.
        when(mMockRibotsService.getStocks())
                .thenReturn(Observable.just(ribots));
        when(mMockDatabaseHelper.setStocks(ribots))
                .thenReturn(Observable.from(ribots));
    }*/

}
