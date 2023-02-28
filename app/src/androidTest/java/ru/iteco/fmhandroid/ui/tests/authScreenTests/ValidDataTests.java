package ru.iteco.fmhandroid.ui.tests.authScreenTests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.DataHelper.DataHelper.needWait;

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

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ValidDataTests {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void logInCheck() {
        try {
            needWait(5000);
            AuthorizationScreen.authorization.check(matches(isDisplayed()));
        } catch (Exception e) {
            MainScreen.authorizationButton.perform(click());
            MainScreen.logOutButton.perform(click());
        }
    }

    @Test
    @DisplayName("Отображение экрана авторизации")
    @Description("При запуске приложения открывается экран с поллями воода логина и пароля")
    public void shouldLoginScreenDisplayed(){
        needWait(3000);
        AuthorizationScreen.authorization.check(matches(withText("Authorization")));
    }

    @Test
    @DisplayName("Ввод валидных значений авторизации")
    @Description("Вход в приложение с валидными данными логина и пароля (login2)(password2)")
    public void shouldValidDataEnter(){
        AuthScreenSteps.ValidDataEnter();
        MainScreen.menuButton.check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Выход из приложения")
    @Description("Выход из приложения путем отключения логина  (logOut)")
    public void shouldExitApp(){
        AuthScreenSteps.ValidDataEnter();
        MainScreen.authorizationButton.perform(click());
        MainScreen.logOutButton.perform(click());
        AuthorizationScreen.authorization.check(matches(isDisplayed()));
    }
}


