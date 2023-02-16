package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AboutSteps {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public static void enterAboutMenu() throws InterruptedException {
        AuthScreenSteps.ValidDataEnter();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.aboutOfMenu.perform(click());
    }
}

