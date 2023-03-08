package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.dataHelper.DataHelper.elementWaiting;
import static ru.iteco.fmhandroid.ui.dataHelper.DataHelper.needWait;
import static ru.iteco.fmhandroid.ui.dataHelper.DataHelper.waitId;

import androidx.test.espresso.ViewAssertion;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.dataHelper.DataHelper;
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

        elementWaiting(withId(R.id.main_menu_image_button), 2000);
        MainScreen.menuButton.check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Выход из приложения")
    @Description("Выход из приложения путем отключения логина  (logOut)")
    public void shouldExitApp(){
        AuthScreenSteps.ValidDataEnter();

//        elementWaiting(withId(R.id.authorization_image_button), 3000);
//        MainScreen.authorizationButton.perform(click());

//        onView(isRoot()).perform(waitId(R.id.authorization_image_button, 3000));

        MainScreen.logOutButton.perform(click());

        elementWaiting(withId(R.id.enter_button), 2000);
        AuthorizationScreen.enterButton.check(matches(isDisplayed()));
    }
}


