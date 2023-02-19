package ru.iteco.fmhandroid.ui.tests.citationsTests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

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
import ru.iteco.fmhandroid.ui.screenElements.CitationsScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.steps.CitationSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class CitationsListScreen {

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
    public void shouldCitationMenuIsDisplayed() throws InterruptedException {
        CitationSteps.enterCitationsMenu();
        CitationsScreen.secondMissionTitleValue.check(matches(isDisplayed()));
    }

    @Test
    public void shouldOpenFirstCitation() throws InterruptedException {
        CitationSteps.enterCitationsMenu();
        CitationsScreen.secondMissionTitleValue.perform(click());
        Thread.sleep(5000);
        CitationsScreen.secondCitationOpenButton.check(matches(isDisplayed()));
    }
}
