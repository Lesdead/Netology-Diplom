package ru.iteco.fmhandroid.ui.tests.newsTests;

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
import ru.iteco.fmhandroid.ui.screenElements.NewsCreationEditingScreen;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreen;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsTests {

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
    @DisplayName("Отображение экрана - Новости")
    @Description("После открытия меню с новостями появляется лента с новостями созданными ранее")
    public void shouldNewsMenuScreen() throws InterruptedException {
        NewsSteps.enterNewsMenu();
        NewsScreen.titleOfNewsBlock.check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Открытие Панели инструментов")
    @Description("Проверка что после нажатия на кнопку редактирования, лента новостей меняется и появляется возможность удалать, создавать или редактировать каждую новость")
    public void shouldControlPanelOpened() throws InterruptedException {
        NewsSteps.openControlPanel();
        NewsScreen.addNewsButton.check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Кнопка создания новости")
    @Description("Проверка кнопки создания статьи (+)")
    public void shouldAddNewsButton() throws InterruptedException {
        NewsSteps.openCreateNewsScreen();
        NewsCreationEditingScreen.titleCreatingWindow.check(matches(isDisplayed()));
    }
}
