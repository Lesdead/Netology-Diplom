package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.dataHelper.DataHelper.needWait;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import org.junit.Before;
import org.junit.Rule;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.dataHelper.DataHelper;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;

public class BaseTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void logInCheck() {
        try {
            DataHelper.elementWaiting(withId(R.id.enter_button),5000);
        } catch (Exception e) {
            MainScreen.authorizationButton.perform(click());
            MainScreen.logOutButton.perform(click());
        }
    }
}
