package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.filters.LargeTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.screenElements.AboutAppScreen;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;

@LargeTest 
@RunWith(AllureAndroidJUnit4.class)
public class AboutMenuTests extends BaseTest {

    @Test
    @DisplayName("Отображение экрана - About")
    @Description("При нажатии на кнопку About  в меню серху открывается информация о приложении")
    public void shouldAboutMenuDisplayed (){
        AboutSteps.enterAboutMenu();
        AboutAppScreen.versionValue.check(matches(isDisplayed()));
    }
}
