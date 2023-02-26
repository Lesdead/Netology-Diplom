package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import org.junit.Rule;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.DataHelper.DataHelper;
import ru.iteco.fmhandroid.ui.screenElements.ClaimCreationAndEditingScreen;
import ru.iteco.fmhandroid.ui.screenElements.ClaimsScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsSteps {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    public static void enterClaimsMenu() throws InterruptedException {
        AuthScreenSteps.ValidDataEnter();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.claimsOfMenu.perform(click());
    }

    public static void openFirstClaim() throws InterruptedException {
        AuthScreenSteps.ValidDataEnter();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.claimsOfMenu.perform(click());
        ClaimsScreen.firstClaimCard.perform(click());
        Thread.sleep(500);
    }

    public static void openCreateNewClaimMenu() throws InterruptedException {
        AuthScreenSteps.ValidDataEnter();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.claimsOfMenu.perform(click());
        ClaimsScreen.addNewClaimButton.perform(click());
    }

    public static void createNewClaim() throws InterruptedException {
        AuthScreenSteps.ValidDataEnter();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.claimsOfMenu.perform(click());
        ClaimsScreen.addNewClaimButton.perform(click());
        Thread.sleep(500);
        ClaimCreationAndEditingScreen.titleTextInputOfClaim.perform(replaceText("Test1"));
        ClaimCreationAndEditingScreen.buttonForShowingDropdownMenu.perform(click());
        ClaimCreationAndEditingScreen.executorName.perform(click());
        ClaimCreationAndEditingScreen.dateInPlanOfClaim.perform(replaceText(DataHelper.oldDateClaim));
        ClaimCreationAndEditingScreen.timeInPlanOfClaim.perform(click());
        ClaimCreationAndEditingScreen.okButton.perform(click());
        ClaimCreationAndEditingScreen.descriptionTextInputOfClaim.perform(replaceText("Test1"));
        ClaimCreationAndEditingScreen.saveButtonOfClaim.perform(click());
    }

    public static void createNewClaimWithoutTitle() throws InterruptedException {
        AuthScreenSteps.ValidDataEnter();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.claimsOfMenu.perform(click());
        ClaimsScreen.addNewClaimButton.perform(click());
        Thread.sleep(500);
        ClaimCreationAndEditingScreen.titleTextInputOfClaim.perform(replaceText(""));
        ClaimCreationAndEditingScreen.buttonForShowingDropdownMenu.perform(click());
        ClaimCreationAndEditingScreen.executorName.perform(click());
        ClaimCreationAndEditingScreen.dateInPlanOfClaim.perform(replaceText(DataHelper.oldDateClaim));
        ClaimCreationAndEditingScreen.timeInPlanOfClaim.perform(click());
        ClaimCreationAndEditingScreen.okButton.perform(click());
        ClaimCreationAndEditingScreen.descriptionTextInputOfClaim.perform(replaceText("Test1"));
        ClaimCreationAndEditingScreen.saveButtonOfClaim.perform(click());
    }

    public static void createNewClaimCyrillicSymbols() throws InterruptedException {
        AuthScreenSteps.ValidDataEnter();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.claimsOfMenu.perform(click());
        ClaimsScreen.addNewClaimButton.perform(click());
        Thread.sleep(500);
        ClaimCreationAndEditingScreen.titleTextInputOfClaim.perform(replaceText("Тест1"));
        ClaimCreationAndEditingScreen.buttonForShowingDropdownMenu.perform(click());
        ClaimCreationAndEditingScreen.executorName.perform(click());
        ClaimCreationAndEditingScreen.dateInPlanOfClaim.perform(replaceText(DataHelper.oldDateClaim));
        ClaimCreationAndEditingScreen.timeInPlanOfClaim.perform(click());
        ClaimCreationAndEditingScreen.okButton.perform(click());
        ClaimCreationAndEditingScreen.descriptionTextInputOfClaim.perform(replaceText("Test1"));
        ClaimCreationAndEditingScreen.saveButtonOfClaim.perform(click());
    }

    public static void closeTestClaim(){
        ClaimsScreen.editStatusButton.perform(click());
        ClaimsScreen.toExecuteStatusButton.perform(click());
        ClaimsScreen.commentField.perform(replaceText("Эту притензию можно удалить, она тестовая"));
        ClaimsScreen.okButton.perform(click());
    }

    public static void closeEditedTestClaim(){
        ClaimsScreen.editStatusButton.perform(click());
        ClaimsScreen.cancelStatusButton.perform(click());
    }
}

