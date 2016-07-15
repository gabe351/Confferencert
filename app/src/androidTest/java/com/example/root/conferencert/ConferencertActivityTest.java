package com.example.root.conferencert;

import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.widget.Button;
import android.widget.TextView;

import com.robotium.solo.Solo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;

/**
 * Created by root on 14/07/16.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class ConferencertActivityTest {
    @Rule
    public ActivityTestRule<ConferencertActivity> mainActivityRule = new ActivityTestRule<>(ConferencertActivity.class);

    @Test
    public void shouldShowWelcomeText(){
//        Teste verifica se existe uma string com esse texto na screen
        onView(withText("Select one track!")).check(matches(isDisplayed()));
    }
    @Test
    public void clickOnScreenTest() throws Exception {
        onView(withId(R.id.afternoon_a))
                .perform(click());
        onView(withId(R.id.recycler))
                .perform(swipeUp())
                .check(matches(isDisplayed()));
    }
    @Test
    public void dialogOpen(){
        onView(withId(R.id.afternoon_b))
                .perform(click());
        onView(withId(R.id.recycler))
                .perform(click());
    }
    @Test
    public void recyclerViewTests(){
//        onView(R.id.recycler).perform(
//
//                .actionOnItemAtPosition(5, click());
//        );
    }
//    @Test
//    public void test_MainActivityChangeTextView_hi() throws Exception{
//        solo.unlockScreen();
//        TextView morning_a = (TextView) solo.getView(R.id.morning_a);
//        solo.clickOnView(morning_a);
////        solo.waitForText("hi", 1, 2000);
////        TextView tv = (TextView) solo.getView(R.id.main_tv);
//        String result = morning_a
//        assertEquals(result, "All working");
//    }

}
