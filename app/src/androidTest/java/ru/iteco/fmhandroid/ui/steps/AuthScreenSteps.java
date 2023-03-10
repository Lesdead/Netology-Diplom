package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.dataHelper.DataHelper.elementWaiting;
import static ru.iteco.fmhandroid.ui.dataHelper.DataHelper.*;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.dataHelper.DataHelper;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.tests.BaseTest;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthScreenSteps extends BaseTest {

    public static void ValidDataEnter(){
        Allure.step("Ввод валидных данных логина и пароля");
        AuthorizationScreen.loginInput.perform(replaceText(DataHelper.validLoginStep));
        AuthorizationScreen.passwordInput.perform(replaceText(DataHelper.validPassStep));
        AuthorizationScreen.signInButton.perform(click());

        elementWaiting(withId(R.id.authorization_image_button), 3000);
    }

    /////////////////
    public static void ValidDataEnter1() {
        Allure.step("Ввод валидных данных логина и пароля");
        AuthorizationScreen.loginInput.perform(replaceText(DataHelper.validLoginStep));
        AuthorizationScreen.passwordInput.perform(replaceText(DataHelper.validPassStep));

//        DataHelper.wait(AuthorizationScreen.signInButton1).perform(click());
    }
    ////////////////
}

