package ru.iteco.fmhandroid.ui.tests.newsTests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.screenElements.NewsCreationEditingScreen;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreen;
import ru.iteco.fmhandroid.ui.steps.MainMenuSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AddEditNewsScreen {

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
    public void shouldNewValidNewsCreated() throws InterruptedException {
        NewsSteps.createValidNews();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.newsOfMenu.perform(click());
        NewsScreen.newTestNews.check(matches(isDisplayed()));
        NewsSteps.deleteTestNews();
    }

    @Test
    public void shouldNewNewsWithoutCategory() throws InterruptedException {
        NewsSteps.openCreateNewsScreen();
        NewsCreationEditingScreen.categoryTextInputOfNews.perform(replaceText("Объявление"));
        NewsCreationEditingScreen.titleTextInputOfNews.perform(replaceText(NewsSteps.title));
        NewsCreationEditingScreen.dateInputOfNews.perform(click());
        NewsCreationEditingScreen.okButton.perform(click());
        NewsCreationEditingScreen.timeInputOfNews.perform(click());
        NewsCreationEditingScreen.okButton.perform(click());
        NewsCreationEditingScreen.saveButtonOfNews.perform(click());
        NewsCreationEditingScreen.titleCreatingWindow.check(matches(isDisplayed()));
    }

    @Test
    public void shouldNewNewsCyrillicTitle() throws InterruptedException {
        NewsSteps.openCreateNewsScreen();
        NewsCreationEditingScreen.categoryTextInputOfNews.perform(replaceText("Объявление"));
        NewsCreationEditingScreen.titleTextInputOfNews.perform(replaceText(NewsSteps.cyrillicTitle));
        NewsCreationEditingScreen.dateInputOfNews.perform(click());
        NewsCreationEditingScreen.okButton.perform(click());
        NewsCreationEditingScreen.timeInputOfNews.perform(click());
        NewsCreationEditingScreen.okButton.perform(click());
        NewsCreationEditingScreen.descriptionTextInputOfNews.perform(replaceText(NewsSteps.description));
        NewsCreationEditingScreen.saveButtonOfNews.perform(click());
        NewsScreen.newTestNewsCyrillicTitle.check(matches(isDisplayed()));
        NewsSteps.deleteCyrillicTestNews();
    }

    @Test
    public void shouldCreateAndChangeNewsCategory() throws InterruptedException {
        NewsSteps.createValidNews();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.newsOfMenu.perform(click());
        NewsScreen.editNewsButton.perform(click());
        NewsScreen.filterNewsButton.perform(click());
        NewsScreen.filterNewsButtonDate.perform(click());
        NewsScreen.okButton.perform(click());
        NewsScreen.filterNewsButtonTime.perform(click());
        NewsScreen.okButton.perform(click());
        NewsScreen.filterOkButton.perform(click());
        NewsScreen.editNewsButton(NewsSteps.title).perform(click());
        NewsCreationEditingScreen.categoryTextInputOfNews.perform(replaceText("День рождения"));
        NewsCreationEditingScreen.saveButtonOfNews.perform(click());
        NewsScreen.newTestNews.check(matches(isDisplayed()));
        NewsSteps.deleteTestNews();
    }

    @Test
    public void shouldCreateAndChangeDescriptionData() throws InterruptedException {
        NewsSteps.createValidNews();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.newsOfMenu.perform(click());
        NewsScreen.editNewsButton.perform(click());
        NewsScreen.filterNewsButton.perform(click());
        NewsScreen.filterNewsButtonDate.perform(click());
        NewsScreen.okButton.perform(click());
        NewsScreen.filterNewsButtonTime.perform(click());
        NewsScreen.okButton.perform(click());
        NewsScreen.filterOkButton.perform(click());
        NewsScreen.editNewsButton(NewsSteps.title).perform(click());
        NewsCreationEditingScreen.descriptionTextInputOfNews.perform(replaceText("qwerty"));
        NewsCreationEditingScreen.saveButtonOfNews.perform(click());
        NewsScreen.openDescNewsButton(NewsSteps.title).perform(click());
        NewsScreen.openDescNewsField(NewsSteps.title).check(matches(isDisplayed()));
        NewsSteps.deleteTestNews();
    }
}
