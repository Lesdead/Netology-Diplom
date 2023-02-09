package ru.iteco.fmhandroid.ui.helper;

import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import android.os.SystemClock;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;

import java.util.concurrent.TimeoutException;

import ru.iteco.fmhandroid.R;

public class MainHelper {

    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            int currentIndex = 0;

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }

    public static void elementWaiting(Matcher matcher, int millis) {
        onView(isRoot()).perform(waitForElement(matcher, millis));
    }

    public static ViewAction waitForElement(final Matcher matcher, final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "wait for a specific view with attribute <" + matcher + "> during " + millis + " millis.";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;
                final Matcher<View> viewMatcher = matcher;

                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        try { // found view with required ID
                            if (viewMatcher.matches(child)) {
                                return;
                            }
                        } catch (NoMatchingViewException e) {
                            // ignore
                        }

                        uiController.loopMainThreadForAtLeast(50);
                    }

                }
                while (System.currentTimeMillis() < endTime);

                // timeout happens
                throw new PerformException.Builder()
                        .withActionDescription(this.getDescription())
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(new TimeoutException())
                        .build();
            }
        };

    }

    public static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    public static boolean isDisplayedWithSwipe(ViewInteraction locator, int recycler, boolean finishSwipe) {
        try {
            locator.check(matches(isDisplayed()));
            return true;
        } catch (NoMatchingViewException ignored) {
        }
        boolean invisible = true;
        int n = 1;
        while (invisible) {
            try {
                if (recycler == 1) {
                    onView(allOf(withId(R.id.news_list_recycler_view), isDisplayed())).perform(actionOnItemAtPosition(n, swipeUp()));
                }
                if (recycler == 2) {
                    onView(allOf(withId(R.id.claim_list_recycler_view), isDisplayed())).perform(actionOnItemAtPosition(n, swipeUp()));
                }
                if (recycler == 3) {
                    onView(allOf(withId(R.id.our_mission_item_list_recycler_view), isDisplayed())).perform(actionOnItemAtPosition(n, swipeUp()));
                }
                if (recycler == 4) {
                    onView(allOf(withId(R.id.claim_comments_list_recycler_view), isDisplayed())).perform(actionOnItemAtPosition(n, swipeUp()));
                }
            } catch (PerformException e) {
                return false;
            }
            try {
                locator.check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));//.check(matches(isDisplayed()));
                invisible = false;
            } catch (NoMatchingViewException ignored) {
            }
            n++;
            if (!invisible & finishSwipe) {
                try {
                    if (recycler == 1) {
                        onView(allOf(withId(R.id.news_list_recycler_view), isDisplayed())).perform(actionOnItemAtPosition(n, swipeUp()));
                    }
                    if (recycler == 2) {
                        onView(allOf(withId(R.id.claim_list_recycler_view), isDisplayed())).perform(actionOnItemAtPosition(n, swipeUp()));
                    }
                    if (recycler == 3) {
                        onView(allOf(withId(R.id.our_mission_item_list_recycler_view), isDisplayed())).perform(actionOnItemAtPosition(n, swipeUp()));
                    }
                    if (recycler == 4) {
                        onView(allOf(withId(R.id.claim_comments_list_recycler_view), isDisplayed())).perform(actionOnItemAtPosition(n, swipeUp()));
                    }
                } catch (PerformException e) {
                    return false;
                }
            }
            if (n > 700) {
                return false;
            }
            SystemClock.sleep(2000);
        }
        return true;
    }

}