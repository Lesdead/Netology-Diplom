package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
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

import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationScreen;
import ru.iteco.fmhandroid.ui.screenElements.ClaimCreationAndEditingScreen;
import ru.iteco.fmhandroid.ui.screenElements.ClaimsScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class ClaimsSteps {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public static void enterClaimsMenu() throws InterruptedException {
        AuthScreenSteps.ValidDataEnter();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.claimsOfMenu.perform(click());
    }

    @Test
    public static void openFirstClaim() throws InterruptedException {
        AuthScreenSteps.ValidDataEnter();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.claimsOfMenu.perform(click());
        ClaimsScreen.firstClaimCard.perform(click());
        Thread.sleep(500);
    }

    @Test
    public static void openCreateNewClaimMenu() throws InterruptedException {
        AuthScreenSteps.ValidDataEnter();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.claimsOfMenu.perform(click());
        ClaimsScreen.addNewClaimButton.perform(click());
    }

    @Test
    public static void createNewClaim() throws InterruptedException {
        AuthScreenSteps.ValidDataEnter();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.claimsOfMenu.perform(click());
        ClaimsScreen.addNewClaimButton.perform(click());
        Thread.sleep(500);
        ClaimCreationAndEditingScreen.titleTextInputOfClaim.perform(replaceText("Test1"));
        ClaimCreationAndEditingScreen.buttonForShowingDropdownMenu.perform(click());
        ClaimCreationAndEditingScreen.executorName.perform(click());
        ClaimCreationAndEditingScreen.dateInPlanOfClaim.perform(click());
        ClaimCreationAndEditingScreen.okButton.perform(click());
        ClaimCreationAndEditingScreen.timeInPlanOfClaim.perform(click());
        ClaimCreationAndEditingScreen.okButton.perform(click());
        ClaimCreationAndEditingScreen.descriptionTextInputOfClaim.perform(replaceText("Test1"));
        ClaimCreationAndEditingScreen.saveButtonOfClaim.perform(click());
    }

}

