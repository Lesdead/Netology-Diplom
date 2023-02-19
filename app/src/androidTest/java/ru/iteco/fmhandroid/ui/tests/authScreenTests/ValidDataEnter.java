package ru.iteco.fmhandroid.ui.tests.authScreenTests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.steps.AuthScreenSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ValidDataEnter {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void logInCheck() {
        try {
            Thread.sleep(7000);
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


