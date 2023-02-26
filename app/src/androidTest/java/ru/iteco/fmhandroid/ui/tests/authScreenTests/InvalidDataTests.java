package ru.iteco.fmhandroid.ui.tests.authScreenTests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;
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
import ru.iteco.fmhandroid.ui.DataHelper.DataHelper;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class InvalidDataTests {

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
    @DisplayName("Ввод невадилных данных (login1), (password1)")
    @Description("Ввод в поля логина и пароля значений (login1) и (password1)")
    public void shouldEnterLogin1Password1() throws InterruptedException {
        Thread.sleep(5000);
        AuthorizationScreen.loginInput.perform(replaceText(DataHelper.noValidLoginStep));
        AuthorizationScreen.passwordInput.perform(replaceText(DataHelper.noValidPassStep));
        AuthorizationScreen.signInButton.perform(click());
        AuthorizationScreen.authorization.check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Ввод невадилных данных только (password1)")
    @Description("Валидное заполнение только одного поля(login2)(password1)")
    public void shouldOnlyOneValidField() throws InterruptedException {
        Thread.sleep(5000);
        AuthorizationScreen.loginInput.perform(replaceText(DataHelper.validLoginStep));
        AuthorizationScreen.passwordInput.perform(replaceText(DataHelper.noValidPassStep));
        AuthorizationScreen.signInButton.perform(click());
        AuthorizationScreen.authorization.check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Вход пустыми полями")
    @Description("Оставить поля пустыми")
    public void shouldEnterEmptyFields() throws InterruptedException {
        Thread.sleep(5000);
        ViewInteraction signInButton = onView(withId(R.id.enter_button));
        signInButton.perform(click());
        AuthorizationScreen.authorization.check(matches(isDisplayed()));
    }
}
