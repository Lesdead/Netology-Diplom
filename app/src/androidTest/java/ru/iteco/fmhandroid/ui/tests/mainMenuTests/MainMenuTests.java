package ru.iteco.fmhandroid.ui.tests.mainMenuTests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

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
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.steps.AuthScreenSteps;
import ru.iteco.fmhandroid.ui.steps.MainMenuSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MainMenuTests {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

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
    @DisplayName("Отображение экрана - Главное меню")
    @Description("Проверка кнопки main - Главное меню")
    public void shouldMainMenuView() throws InterruptedException {
        AuthScreenSteps.ValidDataEnter();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.aboutOfMenu.check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Нажатие на кнопку - News")
    @Description("В главном меню открыть вкладку news и убедиться что новости в ленте присутствуют")
    public void shouldNewsListOpen() throws InterruptedException {
        AuthScreenSteps.ValidDataEnter();
        MainScreen.buttonToExpandOrHideNewsPart.perform(click());
        MainScreen.containerListForNews.check(matches(isDisplayed()));
    }
}
