package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static ru.iteco.fmhandroid.ui.dataHelper.DataHelper.needWait;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import org.junit.Rule;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.dataHelper.DataHelper;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationScreen;
import ru.iteco.fmhandroid.ui.tests.BaseTest;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthScreenSteps extends BaseTest {

    public static void ValidDataEnter(){
        Allure.step("Ввод валидных данных логина и пароля");
        AuthorizationScreen.loginInput.perform(replaceText(DataHelper.validLoginStep));
        AuthorizationScreen.passwordInput.perform(replaceText(DataHelper.validPassStep));
        AuthorizationScreen.signInButton.perform(click());
    }
}

