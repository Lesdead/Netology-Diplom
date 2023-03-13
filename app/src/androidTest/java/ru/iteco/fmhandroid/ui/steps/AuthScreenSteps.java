package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.filters.LargeTest;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.dataHelper.DataHelper;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.tests.BaseTest;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthScreenSteps extends BaseTest {
    public static void ValidDataEnter() {
        Allure.step("Ввод валидных данных логина и пароля");
        AuthorizationScreen.loginInput.perform(replaceText(DataHelper.validLoginStep));
        AuthorizationScreen.passwordInput.perform(replaceText(DataHelper.validPassStep));
        AuthorizationScreen.signInButton.perform(click());
        DataHelper.wait(MainScreen.authorizationButton).check(ViewAssertions.matches(isDisplayed()));
    }
}

