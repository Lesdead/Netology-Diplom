package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import org.junit.Rule;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class MainMenuSteps {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

    public static void enterMainMenuButton(){
        ViewInteraction enterMainMenuButton = onView(withId(R.id.main_menu_image_button));
        enterMainMenuButton.perform(click());
    }
}

