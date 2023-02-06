package ru.iteco.fmhandroid.ui.authScreen;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EnterValidData {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void enterLogin1Password1() throws InterruptedException {
        Thread.sleep(5000);
        ViewInteraction loginFrame = onView(withId(R.id.login_text_input_layout));
        loginFrame.perform(replaceText("login2"));

        ViewInteraction passwordFrame = onView(withId(R.id.password_text_input_layout));
        passwordFrame.perform(replaceText("password2"), closeSoftKeyboard());

        ViewInteraction signInButton = onView(withId(R.id.enter_button));
        signInButton.perform(click());

        Thread.sleep(2000);
        ViewInteraction imageView = onView(withId(R.id.trademark_image_view));
        imageView.check(matches(isDisplayed()));
    }
}
