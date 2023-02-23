package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import org.junit.Rule;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationScreen;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthScreenSteps {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    public static void ValidDataEnter() throws InterruptedException {
        Thread.sleep(5000);
        AuthorizationScreen.loginInput.perform(replaceText("login2"));
        AuthorizationScreen.passwordInput.perform(replaceText("password2"));
        AuthorizationScreen.signInButton.perform(click());
        Thread.sleep(2000);
    }
}

