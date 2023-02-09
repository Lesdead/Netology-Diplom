package ru.iteco.fmhandroid.ui.tests.authScreenTests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationScreen;
import ru.iteco.fmhandroid.ui.steps.AuthScreenSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class InvalidDataEnter {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void shouldEnterLogin1Password1() throws InterruptedException {
        Thread.sleep(5000);
        AuthorizationScreen.loginInput.perform(replaceText("login1"));
        AuthorizationScreen.passwordInput.perform(replaceText("password1"));
        AuthorizationScreen.signInButton.perform(click());
        Thread.sleep(2000);
        //проверка на "Wrong login or password"
    }

    @Test
    public void shouldOnlyOneValidField() throws InterruptedException {
        Thread.sleep(5000);
        ViewInteraction loginFrame = onView(withId(R.id.login_text_input_layout));
        loginFrame.perform(replaceText("login2"));
        ViewInteraction passwordFrame = onView(withId(R.id.password_text_input_layout));
        passwordFrame.perform(replaceText("password99"), closeSoftKeyboard());
        ViewInteraction signInButton = onView(withId(R.id.enter_button));
        signInButton.perform(click());
        Thread.sleep(2000);
        //проверка на "Wrong login or password"
    }

    @Test
    public void shouldEnterEmptyFields() throws InterruptedException {
        Thread.sleep(5000);
        ViewInteraction signInButton = onView(withId(R.id.enter_button));
        signInButton.perform(click());
        Thread.sleep(2000);
        //проверка на "Login and password cannot be empty"
    }
}
