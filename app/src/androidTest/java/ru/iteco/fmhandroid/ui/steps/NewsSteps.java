package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.screenElements.NewsCreationEditingScreen;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreen;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NewsSteps {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    static int titleNumber = (int) ( Math.random() * 1000 );
    public static String title = "testTITLE" + titleNumber;

    static int descNumber = (int) ( Math.random() * 1000 );
    public static String description = "testDESC" + descNumber;

    static int cyrlNumber = (int) ( Math.random() * 1000 );
    public static String cyrillicTitle = "testЗАГОЛОВОК" + cyrlNumber;

    @Test
    public static void enterNewsMenu() throws InterruptedException {
        AuthScreenSteps.ValidDataEnter();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.newsOfMenu.perform(click());
    }

    @Test
    public static void openControlPanel() throws InterruptedException {
        enterNewsMenu();
        NewsScreen.editNewsButton.perform(click());
    }

    @Test
    public static void openCreateNewsScreen() throws InterruptedException {
        openControlPanel();
        NewsScreen.addNewsButton.perform(click());
    }

    @Test
    public static void createValidNews() throws InterruptedException {
        openCreateNewsScreen();
        NewsCreationEditingScreen.categoryTextInputOfNews.perform(replaceText("Объявление"));
        NewsCreationEditingScreen.titleTextInputOfNews.perform(replaceText(title));
        NewsCreationEditingScreen.dateInputOfNews.perform(click());
        NewsCreationEditingScreen.okButton.perform(click());
        NewsCreationEditingScreen.timeInputOfNews.perform(click());
        NewsCreationEditingScreen.okButton.perform(click());
        NewsCreationEditingScreen.descriptionTextInputOfNews.perform(replaceText(description));
        NewsCreationEditingScreen.saveButtonOfNews.perform(click());
    }

    @Test
    public static void deleteTestNews() throws InterruptedException {
        MainMenuSteps.enterMainMenuButton();
        MainScreen.claimsOfMenu.perform(click());
        MainMenuSteps.enterMainMenuButton();
        MainScreen.newsOfMenu.perform(click());
        NewsScreen.editNewsButton.perform(click());
        NewsScreen.filterNewsButton.perform(click());
        NewsScreen.filterNewsButtonDate.perform(click());
        NewsScreen.okButton.perform(click());
        NewsScreen.filterNewsButtonTime.perform(click());
        NewsScreen.okButton.perform(click());
        NewsScreen.filterOkButton.perform(click());
        NewsScreen.sortButton.perform(click());NewsScreen.deleteNewsButton(title).perform(click());
        NewsScreen.okButton.perform(click());
    }

    @Test
    public static void deleteCyrillicTestNews(){
        MainMenuSteps.enterMainMenuButton();
        MainScreen.claimsOfMenu.perform(click());
        MainMenuSteps.enterMainMenuButton();
        MainScreen.newsOfMenu.perform(click());
        NewsScreen.editNewsButton.perform(click());
        NewsScreen.filterNewsButton.perform(click());
        NewsScreen.filterNewsButtonDate.perform(click());
        NewsScreen.okButton.perform(click());
        NewsScreen.filterNewsButtonTime.perform(click());
        NewsScreen.okButton.perform(click());
        NewsScreen.filterOkButton.perform(click());
        NewsScreen.sortButton.perform(click());
        NewsScreen.deleteNewsButton(cyrillicTitle).perform(click());
        NewsScreen.okButton.perform(click());
    }

    @Test
    public static void useNewsFilter(){
        NewsScreen.filterNewsButton.perform(click());
        NewsScreen.filterNewsButtonDate.perform(click());
        NewsScreen.okButton.perform(click());
        NewsScreen.filterNewsButtonTime.perform(click());
        NewsScreen.okButton.perform(click());
        NewsScreen.filterOkButton.perform(click());
    }
}
