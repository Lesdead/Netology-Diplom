package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.dataHelper.DataHelper.elementWaiting;
import static ru.iteco.fmhandroid.ui.dataHelper.DataHelper.needWait;

import androidx.test.filters.LargeTest;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.dataHelper.DataHelper;
import ru.iteco.fmhandroid.ui.screenElements.ClaimCreationAndEditingScreen;
import ru.iteco.fmhandroid.ui.screenElements.ClaimsScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.tests.BaseTest;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsSteps extends BaseTest {

    public static void enterClaimsMenu(){
        Allure.step("Вход в меню - Притензии");
        AuthScreenSteps.ValidDataEnter();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.claimsOfMenu.perform(click());
    }

    public static void openFirstClaim(){
        Allure.step("Открытие первой притензии");
        AuthScreenSteps.ValidDataEnter();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.claimsOfMenu.perform(click());
        ClaimsScreen.firstClaimCard.perform(click());
        needWait(500);
    }

    public static void openCreateNewClaimMenu(){
        Allure.step("Открыть экран создания притензии");
        AuthScreenSteps.ValidDataEnter();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.claimsOfMenu.perform(click());
        ClaimsScreen.addNewClaimButton.perform(click());
    }

    public static void createNewClaim(){
        Allure.step("Создание валидной притензии");
        AuthScreenSteps.ValidDataEnter();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.claimsOfMenu.perform(click());
        ClaimsScreen.addNewClaimButton.perform(click());
        ClaimCreationAndEditingScreen.titleTextInputOfClaim.perform(replaceText("Test1"));
        ClaimCreationAndEditingScreen.buttonForShowingDropdownMenu.perform(click());
        ClaimCreationAndEditingScreen.executorName.perform(click());
        ClaimCreationAndEditingScreen.dateInPlanOfClaim.perform(replaceText(DataHelper.oldDateClaim));
        ClaimCreationAndEditingScreen.timeInPlanOfClaim.perform(click());
        ClaimCreationAndEditingScreen.okButton.perform(click());
        ClaimCreationAndEditingScreen.descriptionTextInputOfClaim.perform(replaceText("Test1"));
        needWait(2000);
        ClaimCreationAndEditingScreen.saveButtonOfClaim.perform(click());
        elementWaiting(withId(R.id.add_new_claim_material_button), 3000);
    }

    public static void createNewClaimWithoutTitle(){
        Allure.step("Создание притензии без заголовка");
        AuthScreenSteps.ValidDataEnter();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.claimsOfMenu.perform(click());
        ClaimsScreen.addNewClaimButton.perform(click());
        needWait(500);
        ClaimCreationAndEditingScreen.titleTextInputOfClaim.perform(replaceText(""));
        ClaimCreationAndEditingScreen.buttonForShowingDropdownMenu.perform(click());
        ClaimCreationAndEditingScreen.executorName.perform(click());
        ClaimCreationAndEditingScreen.dateInPlanOfClaim.perform(replaceText(DataHelper.oldDateClaim));
        ClaimCreationAndEditingScreen.timeInPlanOfClaim.perform(click());
        ClaimCreationAndEditingScreen.okButton.perform(click());
        ClaimCreationAndEditingScreen.descriptionTextInputOfClaim.perform(replaceText("Test1"));
        ClaimCreationAndEditingScreen.saveButtonOfClaim.perform(click());
    }

    public static void createNewClaimCyrillicSymbols(){
        Allure.step("Создание притензии на кириллице");
        AuthScreenSteps.ValidDataEnter();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.claimsOfMenu.perform(click());
        ClaimsScreen.addNewClaimButton.perform(click());
        ClaimCreationAndEditingScreen.titleTextInputOfClaim.perform(replaceText("Тест1"));
        ClaimCreationAndEditingScreen.buttonForShowingDropdownMenu.perform(click());
        ClaimCreationAndEditingScreen.executorName.perform(click());
        ClaimCreationAndEditingScreen.dateInPlanOfClaim.perform(replaceText(DataHelper.oldDateClaim));
        ClaimCreationAndEditingScreen.timeInPlanOfClaim.perform(click());
        ClaimCreationAndEditingScreen.okButton.perform(click());
        ClaimCreationAndEditingScreen.descriptionTextInputOfClaim.perform(replaceText("Test1"));
        needWait(2000);
        ClaimCreationAndEditingScreen.saveButtonOfClaim.perform(click());
        elementWaiting(withId(R.id.add_new_claim_material_button), 3000);
    }

    public static void closeTestClaim(){
        Allure.step("Удаление тестовой притензии");
        ClaimsScreen.editStatusButton.perform(click());
        ClaimsScreen.toExecuteStatusButton.perform(click());
        ClaimsScreen.commentField.perform(replaceText("Эту притензию можно удалить, она тестовая"));
        ClaimsScreen.okButton.perform(click());
    }

    public static void closeEditedTestClaim(){
        Allure.step("Закрытие экрана создания притензии");
        ClaimsScreen.editStatusButton.perform(click());
        ClaimsScreen.cancelStatusButton.perform(click());
    }
}

