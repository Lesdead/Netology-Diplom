package ru.iteco.fmhandroid.ui.DataHelper;

import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;

import android.view.View;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.widget.NestedScrollView;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.HumanReadables;

import java.util.UUID;

public class DataHelper {

    public static String title = "testTit-" + UUID.randomUUID().toString().substring(0, 4);
    public static String cyrillicTitle = "testCyrT-" + UUID.randomUUID().toString().substring(0, 4);
    public static String description = "testDes-" + UUID.randomUUID().toString().substring(0, 4);
    public static String comment = "testComm-" + UUID.randomUUID().toString().substring(0, 4);

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

    public static ViewAction nestedScrollTo() {
        return new ViewAction() {

            @Override
            public Matcher<View> getConstraints() {
                return Matchers.allOf(
                        isDescendantOfA(isAssignableFrom(NestedScrollView.class)),
                        withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE));
            }

            @Override
            public String getDescription() {
                return "View is not NestedScrollView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                try {
                    NestedScrollView nestedScrollView = (NestedScrollView)
                            findFirstParentLayoutOfClass(view);
                    if (nestedScrollView != null) {
                        nestedScrollView.scrollTo(0, view.getTop());
                    } else {
                        throw new Exception("Unable to find NestedScrollView parent.");
                    }
                } catch (Exception e) {
                    throw new PerformException.Builder()
                            .withActionDescription(this.getDescription())
                            .withViewDescription(HumanReadables.describe(view))
                            .withCause(e)
                            .build();
                }
                uiController.loopMainThreadUntilIdle();
            }
        };
    }

    private static View findFirstParentLayoutOfClass(View view) {
        ViewParent parent = new FrameLayout(view.getContext());
        ViewParent incrementView = null;
        int i = 0;
        while (parent != null && !(parent.getClass() == NestedScrollView.class)) {
            if (i == 0) {
                parent = findParent(view);
            } else {
                parent = findParent(incrementView);
            }
            incrementView = parent;
            i++;
        }
        return (View) parent;
    }

    private static ViewParent findParent(View view) {
        return view.getParent();
    }
    private static ViewParent findParent(ViewParent view) {
        return view.getParent();
    }

    public static String validLoginStep = "login2";
    public static String validPassStep = "password2";
    public static String noValidLoginStep = "login1";
    public static String noValidPassStep = "password1";
    public static String mainTextScreen = "Хоспис в своем истинном понимании - это творчество";
    public static String insideTextScreen = "Нет шаблона и стандарта, есть только дух, который живет в разных домах по-разному. Но всегда он добрый, любящий и помогающий.";
    public static String oldDateClaim = "14.07.1789";
}
