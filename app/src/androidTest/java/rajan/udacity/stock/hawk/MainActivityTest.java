package rajan.udacity.stock.hawk;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import java.util.List;

import rajan.udacity.stock.hawk.data.model.multiple.Stocks;
import rajan.udacity.stock.hawk.test.common.TestComponentRule;
import rajan.udacity.stock.hawk.test.common.TestDataFactory;
import rajan.udacity.stock.hawk.ui.main.MainActivity;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    public final TestComponentRule component =
            new TestComponentRule(InstrumentationRegistry.getTargetContext());
    public final ActivityTestRule<MainActivity> main =
            new ActivityTestRule<MainActivity>(MainActivity.class, false, false) {
                @Override
                protected Intent getActivityIntent() {
                    // Override the default intent so we pass a false flag for syncing so it doesn't
                    // start a sync service in the background that would affect  the behaviour of
                    // this test.
                    return MainActivity.getStartIntent(
                            InstrumentationRegistry.getTargetContext(), false);
                }
            };

    // TestComponentRule needs to go first to make sure the Dagger ApplicationTestComponent is set
    // in the Application before any Activity is launched.
    @Rule
    public final TestRule chain = RuleChain.outerRule(component).around(main);

    @Test
    public void listOfStocksShows() {
        List<Stocks> testDataStocks = TestDataFactory.makeListRibots(20);
       /* when(component.getMockDataManager().getRibots())
                .thenReturn(Observable.just(testDataRibots));*/

        main.launchActivity(null);

        int position = 0;
        /*for (Stocks stock : testDataStocks) {
            onView(withId(R.id.recycler_view))
                    .perform(RecyclerViewActions.scrollToPosition(position));
            String name = String.format("%s %s", stock.profile().name().first(),
                    stock.profile().name().last());
            onView(withText(name))
                    .check(matches(isDisplayed()));
            onView(withText(stock.profile().email()))
                    .check(matches(isDisplayed()));
            position++;
        }*/
    }

}