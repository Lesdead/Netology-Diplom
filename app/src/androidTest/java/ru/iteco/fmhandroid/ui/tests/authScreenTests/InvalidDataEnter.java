package ru.iteco.fmhandroid.ui.tests.authScreenTests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.steps.AuthScreenSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class InvalidDataEnter {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void logInCheck() {
        try {
            Thread.sleep(3000);
            AuthorizationScreen.authorization.check(matches(isDisplayed()));
        } catch (Exception e) {
            MainScreen.authorizationButton.perform(click());
            MainScreen.logOutButton.perform(click());
        }
    }

    @Test
    public void shouldEnterLogin1Password1() throws InterruptedException {
        Thread.sleep(5000);
        AuthorizationScreen.loginInput.perform(replaceText("login1"));
        AuthorizationScreen.passwordInput.perform(replaceText("password1"));
        AuthorizationScreen.signInButton.perform(click());
        AuthorizationScreen.authorization.check(matches(isDisplayed()));
    }

    @Test
    public void shouldOnlyOneValidField() throws InterruptedException {
        Thread.sleep(5000);
        AuthorizationScreen.loginInput.perform(replaceText("login2"));
        AuthorizationScreen.passwordInput.perform(replaceText("password99"));
        AuthorizationScreen.signInButton.perform(click());
        AuthorizationScreen.authorization.check(matches(isDisplayed()));
    }

    @Test
    public void shouldEnterEmptyFields() throws InterruptedException {
        Thread.sleep(5000);
        ViewInteraction signInButton = onView(withId(R.id.enter_button));
        signInButton.perform(click());
        AuthorizationScreen.authorization.check(matches(isDisplayed()));
    }
}
