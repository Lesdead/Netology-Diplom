package ru.iteco.fmhandroid.ui.tests.authScreenTests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.steps.AuthScreenSteps;
import ru.iteco.fmhandroid.ui.steps.MainMenuSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ValidDataEnter {

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
    public void shouldLoginScreenDisplayed() throws InterruptedException {
        Thread.sleep(3000);
        AuthorizationScreen.authorization.check(matches(withText("Authorization")));
    }

    @Test
    public void shouldValidDataEnter() throws InterruptedException {
        AuthScreenSteps.ValidDataEnter();
        MainScreen.menuButton.check(matches(isDisplayed()));
    }

    @Test
    public void shouldExitApp() throws InterruptedException{
        AuthScreenSteps.ValidDataEnter();
        MainScreen.authorizationButton.perform(click());
        MainScreen.logOutButton.perform(click());
        AuthorizationScreen.authorization.check(matches(isDisplayed()));
    }
}


