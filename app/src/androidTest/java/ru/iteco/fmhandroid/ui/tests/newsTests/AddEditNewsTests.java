package ru.iteco.fmhandroid.ui.tests.newsTests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.steps.NewsSteps.title;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.screenElements.AuthorizationScreen;
import ru.iteco.fmhandroid.ui.screenElements.MainScreen;
import ru.iteco.fmhandroid.ui.screenElements.NewsCreationEditingScreen;
import ru.iteco.fmhandroid.ui.screenElements.NewsScreen;
import ru.iteco.fmhandroid.ui.steps.MainMenuSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AddEditNewsTests {

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
    @DisplayName("Создание валидной новости")
    @Description("При создании новой статьи заполнение всех полей валидными значениями")
    public void shouldNewValidNewsCreated() throws InterruptedException {
        NewsSteps.createValidNews();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.newsOfMenu.perform(click());
        NewsScreen.newTestNews.check(matches(isDisplayed()));
        NewsSteps.deleteTestNews();
    }

    @Test
    @DisplayName("Удаление статьи")
    @Description("Создание, а затем удаление созданной ранее новости - проверка удаления")
    public void shouldCreateDeleteNews() throws InterruptedException {
        NewsSteps.createValidNews();
        NewsSteps.deleteTestNews();
        NewsScreen.newsListRecycler.check(matches(not(hasDescendant(withText(NewsSteps.title)))));
    }

    @Test
    @DisplayName("Создание ноаости без категории")
    @Description("Создание статьи без заполнения поля -Category")
    public void shouldNewNewsWithoutCategory() throws InterruptedException {
        NewsSteps.openCreateNewsScreen();
        NewsCreationEditingScreen.categoryTextInputOfNews.perform(replaceText("Объявление"));
        NewsCreationEditingScreen.titleTextInputOfNews.perform(replaceText(title));
        NewsCreationEditingScreen.dateInputOfNews.perform(click());
        NewsCreationEditingScreen.okButton.perform(click());
        NewsCreationEditingScreen.timeInputOfNews.perform(click());
        NewsCreationEditingScreen.okButton.perform(click());
        NewsCreationEditingScreen.saveButtonOfNews.perform(click());
        NewsCreationEditingScreen.titleCreatingWindow.check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Создание новости с символами на кириллице")
    @Description("Заполнение поля Title текстом на кирилице")
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
        NewsSteps.useNewsFilter();
        NewsScreen.sortButton.perform(click());
        NewsScreen.newTestNewsCyrillicTitle.check(matches(isDisplayed()));
        NewsSteps.deleteCyrillicTestNews();
    }

    @Test
    @DisplayName("Смена категории статьи")
    @Description("В уже созданной статье поменять значение в поле Category на одно из предложенных")
    public void shouldCreateAndChangeNewsCategory() throws InterruptedException {
        NewsSteps.createValidNews();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.newsOfMenu.perform(click());
        NewsScreen.editNewsButton.perform(click());
        NewsSteps.useNewsFilter();
        NewsScreen.sortButton.perform(click());
        NewsScreen.editNewsButton(title).perform(click());
        NewsCreationEditingScreen.categoryTextInputOfNews.perform(replaceText("День рождения"));
        NewsCreationEditingScreen.saveButtonOfNews.perform(click());
        NewsScreen.newTestNews.check(matches(isDisplayed()));
        NewsSteps.deleteTestNews();
    }

    @Test
    @DisplayName("Смена описания новости")
    @Description("В уже созданной статье поменять текст в поле Description на другой (qwerty)")
    public void shouldCreateAndChangeDescriptionData() throws InterruptedException {
        NewsSteps.createValidNews();
        MainMenuSteps.enterMainMenuButton();
        MainScreen.newsOfMenu.perform(click());
        NewsScreen.editNewsButton.perform(click());
        NewsSteps.useNewsFilter();
        NewsScreen.sortButton.perform(click());
        NewsScreen.editNewsButton(title).perform(click());
        NewsCreationEditingScreen.descriptionTextInputOfNews.perform(replaceText("qwerty"));
        NewsCreationEditingScreen.saveButtonOfNews.perform(click());
        NewsScreen.openDescNewsButton(title).perform(click());
        NewsScreen.openDescNewsField(title).check(matches(isDisplayed()));
        NewsSteps.deleteTestNews();
    }
}
