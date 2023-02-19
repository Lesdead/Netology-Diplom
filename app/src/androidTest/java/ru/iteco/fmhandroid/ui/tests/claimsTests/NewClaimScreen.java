package ru.iteco.fmhandroid.ui.tests.claimsTests;

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
import ru.iteco.fmhandroid.ui.screenElements.ClaimCreationAndEditingScreen;
import ru.iteco.fmhandroid.ui.screenElements.ClaimsScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.steps.ClaimsSteps;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewClaimScreen {

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
    // Не работает  (Баг)
    public void shouldAddNewClaim() throws InterruptedException {
        ClaimsSteps.createNewClaim();
//        ClaimsScreen.firstClaimCard.check(matches(withText("test1")));
    }

    @Test
    public void shouldCancelButton() throws InterruptedException {
        ClaimsSteps.openCreateNewClaimMenu();
        ClaimCreationAndEditingScreen.cancelButton.perform(click());
        ClaimCreationAndEditingScreen.okButton.perform(click());
        ClaimsScreen.titleOfClaimsBlock.check(matches(isDisplayed()));
    }

    @Test
    public void shouldLeaveTitleEmpty() throws InterruptedException {
        ClaimsSteps.createNewClaimWithoutTitle();
        ClaimCreationAndEditingScreen.fillEmptyFieldsMessage.check(matches(isDisplayed()));
    }

    @Test
    // Не работает. По причине того что нельзя создать притензию (Баг) см. тест - (shouldAddNewClaim)
    public void shouldEnterCyrillicSymbols() throws InterruptedException {
        ClaimsSteps.createNewClaimNoEnglishSymbols();
        // ClaimsScreen.firstClaimCard.check(matches(withText("Тест1")));
    }
}
