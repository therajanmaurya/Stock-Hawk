package rajan.udacity.stock.hawk;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import rajan.udacity.stock.hawk.util.DefaultConfig;
import rajan.udacity.stock.hawk.util.RxSchedulersOverrideRule;

/**
 * Unit tests integration with a SQLite Database using Robolectric
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = DefaultConfig.EMULATE_SDK)
public class DatabaseHelperTest {

    /*private final DatabaseHelper mDatabaseHelper =
            new DatabaseHelper(new DbOpenHelper(RuntimeEnvironment.application));*/

    @Rule
    public final RxSchedulersOverrideRule mOverrideSchedulersRule = new RxSchedulersOverrideRule();

   /* @Test
    public void setStocks() {
        Stocks ribot1 = TestDataFactory.makeRibot("r1");
        Stocks ribot2 = TestDataFactory.makeRibot("r2");
        List<Stocks> ribots = Arrays.asList(ribot1, ribot2);

        TestSubscriber<Stocks> result = new TestSubscriber<>();
        mDatabaseHelper.setStocks(ribots).subscribe(result);
        result.assertNoErrors();
        result.assertReceivedOnNext(ribots);

        Cursor cursor = mDatabaseHelper.getBriteDb()
                .query("SELECT * FROM " + Db.RibotProfileTable.TABLE_NAME);
        assertEquals(2, cursor.getCount());
        for (Stocks ribot : ribots) {
            cursor.moveToNext();
            assertEquals(ribot.profile(), Db.RibotProfileTable.parseCursor(cursor));
        }
    }

    @Test
    public void getStocks() {
        Stocks ribot1 = TestDataFactory.makeRibot("r1");
        Stocks ribot2 = TestDataFactory.makeRibot("r2");
        List<Stocks> ribots = Arrays.asList(ribot1, ribot2);

        mDatabaseHelper.setStocks(ribots).subscribe();

        TestSubscriber<List<Stocks>> result = new TestSubscriber<>();
        mDatabaseHelper.getStocks().subscribe(result);
        result.assertNoErrors();
        result.assertValue(ribots);
    }*/

}