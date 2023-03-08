package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.filters.LargeTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.steps.AuthScreenSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ValidDataTests  extends BaseTest {

    @Test
    @DisplayName("Отображение экрана авторизации")
    @Description("При запуске приложения открывается экран с поллями воода логина и пароля")
    public void shouldLoginScreenDisplayed(){
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
        AuthorizationScreen.signInButton.check(matches(isDisplayed()));
    }
}


