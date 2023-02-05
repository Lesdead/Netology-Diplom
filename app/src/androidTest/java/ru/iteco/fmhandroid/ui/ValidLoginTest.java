package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ValidLoginTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void emptyTest(){}

    @Test
    public void viewLoginScreenTest() throws InterruptedException {
        Thread.sleep(5000);
        ViewInteraction textView = onView(withText("Authorization"));
        textView.check(matches(withText("Authorization")));
    }

    @Test
    public void viewLogin2Text() throws InterruptedException {
        Thread.sleep(5000);
        ViewInteraction textInputEditText = onView(withId(R.id.login_text_input_layout));
        textInputEditText.perform(replaceText("login2"), closeSoftKeyboard());

        ViewInteraction editText = onView(withText("login2"));
        editText.check(matches(withText("login2")));
    }

    @Test
    public void validLoginTest() throws InterruptedException {
        Thread.sleep(5000);
        ViewInteraction textInputEditText = onView(withId(R.id.login_text_input_layout));
        textInputEditText.perform(replaceText("login2"), closeSoftKeyboard());

        ViewInteraction textInputEditText2 = onView( withId(R.id.password_text_input_layout));
        textInputEditText2.perform(replaceText("password2"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withText("Sign in"));
        materialButton.perform(click());

        Thread.sleep(5000);
        ViewInteraction imageView = onView(withId(R.id.trademark_image_view));
        imageView.check(matches(isDisplayed()));
    }
}
