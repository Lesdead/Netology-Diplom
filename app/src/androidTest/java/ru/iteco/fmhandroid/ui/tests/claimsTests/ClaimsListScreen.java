package ru.iteco.fmhandroid.ui.tests.claimsTests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.helper.MainHelper.nestedScrollTo;

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
import ru.iteco.fmhandroid.ui.screenElements.CommentScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.steps.ClaimsSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)

// Из-за отсутствия возможности создать новую притензию (баг приложения)
// Не получается запустить все тесты сразу, они мешают друг другу
// Но запускаются и проходят по одиночке
public class ClaimsListScreen {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    int titleNumber = (int) ( Math.random() * 1000 );
    String title = "testNum" + titleNumber;

    int comNumber = (int) ( Math.random() * 1000 );
    String comment = "testComm" + comNumber;

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
    public void shouldClaimsMenuDisplayed() throws InterruptedException {
        ClaimsSteps.enterClaimsMenu();
        ClaimsScreen.titleOfClaimsBlock.check(matches(isDisplayed()));
    }

    @Test
    public void shouldClaimDisplayed() throws InterruptedException {
        ClaimsSteps.openFirstClaim();
        ClaimsScreen.titleTextOfClaim.check(matches(isDisplayed()));
    }

    @Test
    public void shouldOpenClaimClosing() throws InterruptedException {
        ClaimsSteps.openFirstClaim();
        ClaimsScreen.closeClaim.perform(nestedScrollTo());
        ClaimsScreen.closeClaim.perform(click());
        ClaimsScreen.titleOfClaimsBlock.check(matches(isDisplayed()));
    }

    @Test
    public void shouldCreateValidComment() throws InterruptedException {
        ClaimsSteps.openFirstClaim();
        ClaimsScreen.buttonToAddComment.perform(nestedScrollTo());
        ClaimsScreen.buttonToAddComment.perform(click());
        CommentScreen.commentTestInputEditText.perform(replaceText(comment));
        CommentScreen.saveButton.perform(click());
        ClaimsScreen.newTestComment(comment);
        Thread.sleep(1000);
    }

    @Test
    public void shouldChangeTitleOfClaim() throws InterruptedException{
        ClaimsSteps.openFirstClaim();
        ClaimsScreen.editClaimButton.perform(nestedScrollTo());
        ClaimsScreen.editClaimButton.perform(click());
        ClaimCreationAndEditingScreen.titleTextInputOfClaim.perform(replaceText(title));
        ClaimCreationAndEditingScreen.saveButtonOfClaim.perform(click());
        ClaimsScreen.editClaimButton.perform(nestedScrollTo());
        ClaimsScreen.titleTextOfClaim.check(matches(isDisplayed()));
    }

    @Test
    public void shouldOpenFilterClaims()throws InterruptedException{
        ClaimsSteps.enterClaimsMenu();
        ClaimsScreen.filtersButton.perform(click());
        ClaimsScreen.filterWindowTitle.check(matches(isDisplayed()));
    }
}
