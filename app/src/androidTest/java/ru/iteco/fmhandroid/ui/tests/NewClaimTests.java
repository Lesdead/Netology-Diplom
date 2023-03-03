package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.dataHelper.DataHelper.needWait;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationScreen;
import ru.iteco.fmhandroid.ui.screenElements.ClaimCreationAndEditingScreen;
import ru.iteco.fmhandroid.ui.screenElements.ClaimsScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.steps.ClaimsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewClaimTests extends BaseTest {

    @Test
    @DisplayName("Создание притензии")
    @Description("Создание притензии и заполнение полей валидными значениями")
    public void shouldAddNewClaim(){
//        needWait(3000);
        ClaimsSteps.createNewClaim();
        MainScreen.menuButton.perform(click());
        needWait(1000);
        MainScreen.menuOfMenu.perform(click());
        needWait(3000);
        MainScreen.allClaimsButton.perform(click());
        ClaimsScreen.firstClaimCard.perform(click());
        needWait(3000);
        ClaimsScreen.titleTextOfClaim.check(matches(withText("Test1")));
        ClaimsSteps.closeTestClaim();
    }

    @Test
    @DisplayName("Отмена создания притензии")
    @Description("Нажатие на кнопку отмены притензии")
    public void shouldCancelButton(){
        ClaimsSteps.openCreateNewClaimMenu();
        ClaimCreationAndEditingScreen.cancelButton.perform(click());
        ClaimCreationAndEditingScreen.okButton.perform(click());
        ClaimsScreen.titleOfClaimsBlock.check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Оставить поле Title пустым")
    @Description("Оставить поле Title пустым и попробывать создать притензию")
    public void shouldLeaveTitleEmpty(){
        ClaimsSteps.createNewClaimWithoutTitle();
        ClaimCreationAndEditingScreen.fillEmptyFieldsMessage.check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Ввод данных на кириллице")
    @Description("Ввод в поле Title текста на кирилице")
    public void shouldEnterCyrillicSymbols(){
        ClaimsSteps.createNewClaimCyrillicSymbols();
        ClaimsScreen.firstClaimCard.perform(click());
        ClaimsScreen.titleTextOfClaim.check(matches(withText("Тест1")));
        ClaimsSteps.closeTestClaim();
    }


}
