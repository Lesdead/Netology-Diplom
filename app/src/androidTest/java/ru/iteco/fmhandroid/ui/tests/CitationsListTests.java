package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
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
import ru.iteco.fmhandroid.ui.screenElements.CitationsScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.steps.CitationSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class CitationsListTests  extends BaseTest {

    @Test
    @DisplayName("Отображение экрана - Цитаты")
    @Description("При нажатии на кнопку в виде бабочки (тематические цитаты) открывается лента с цитатами")
    public void shouldCitationMenuIsDisplayed(){
        CitationSteps.enterCitationsMenu();
        CitationsScreen.secondMissionTitleValue.check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Отображение открытия цитаты")
    @Description("При разворачивании второй цитаты отображается ее содержание")
    public void shouldOpenSecondCitation(){
        CitationSteps.enterCitationsMenu();
        CitationsScreen.secondMissionTitleValue.perform(click());
        needWait(5000);
        CitationsScreen.secondCitationOpenButton.check(matches(isDisplayed()));
    }
}
