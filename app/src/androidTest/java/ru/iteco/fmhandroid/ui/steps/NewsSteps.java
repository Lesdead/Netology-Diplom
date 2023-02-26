package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import org.junit.Rule;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.DataHelper.DataHelper;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.screenElements.NewsCreationEditingScreen;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreen;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsSteps {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    public static void enterNewsMenu() throws InterruptedException {
        Allure.step("Вход в меню - Новости");
        AuthScreenSteps.ValidDataEnter();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.newsOfMenu.perform(click());
    }

    public static void openControlPanel() throws InterruptedException {
        Allure.step("Открыть меню редактирования новости");
        enterNewsMenu();
        NewsScreen.editNewsButton.perform(click());
    }

    public static void openCreateNewsScreen() throws InterruptedException {
        Allure.step("Открыть экран создания новости");
        openControlPanel();
        NewsScreen.addNewsButton.perform(click());
    }

    public static void createValidNews() throws InterruptedException {
        Allure.step("Создать валидную новость");
        openCreateNewsScreen();
        NewsCreationEditingScreen.categoryTextInputOfNews.perform(replaceText("Объявление"));
        NewsCreationEditingScreen.titleTextInputOfNews.perform(replaceText(DataHelper.title));
        NewsCreationEditingScreen.dateInputOfNews.perform(click());
        NewsCreationEditingScreen.okButton.perform(click());
        NewsCreationEditingScreen.timeInputOfNews.perform(click());
        NewsCreationEditingScreen.okButton.perform(click());
        NewsCreationEditingScreen.descriptionTextInputOfNews.perform(replaceText(DataHelper.description));
        NewsCreationEditingScreen.saveButtonOfNews.perform(click());
    }

    public static void deleteTestNews(){
        Allure.step("Удалить тестовую новость");
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
        NewsScreen.sortButton.perform(click());NewsScreen.deleteNewsButton(DataHelper.title).perform(click());
        NewsScreen.okButton.perform(click());
    }

    public static void deleteCyrillicTestNews(){
        Allure.step("Удалить тестовую новость на кириллице");
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
        NewsScreen.deleteNewsButton(DataHelper.cyrillicTitle).perform(click());
        NewsScreen.okButton.perform(click());
    }

    public static void useNewsFilter(){
        Allure.step("Открыть меню фильтра новостей");
        NewsScreen.filterNewsButton.perform(click());
        NewsScreen.filterNewsButtonDate.perform(click());
        NewsScreen.okButton.perform(click());
        NewsScreen.filterNewsButtonTime.perform(click());
        NewsScreen.okButton.perform(click());
        NewsScreen.filterOkButton.perform(click());
    }
}
