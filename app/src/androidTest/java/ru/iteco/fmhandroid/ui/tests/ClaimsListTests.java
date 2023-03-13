package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.dataHelper.DataHelper.nestedScrollTo;

import androidx.test.filters.LargeTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.dataHelper.DataHelper;
import ru.iteco.fmhandroid.ui.screenElements.ClaimCreationAndEditingScreen;
import ru.iteco.fmhandroid.ui.screenElements.ClaimsScreen;
import ru.iteco.fmhandroid.ui.screenElements.CommentScreen;
import ru.iteco.fmhandroid.ui.steps.ClaimsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ClaimsListTests  extends BaseTest {

    @Test
    @DisplayName("Отображение экрана - претензии")
    @Description("После открытия меню с претензиями появляется список претензий созданный ранее")
    public void shouldClaimsMenuDisplayed(){
        ClaimsSteps.enterClaimsMenu();
        ClaimsScreen.titleOfClaimsBlock.check(matches(isDisplayed()));
    }

    @Test
    @DisplayName("Раскрытие первой претензии")
    @Description("Разворачивание конкретной претензии с помощью кнопки-стрелочки")
    public void shouldClaimDisplayed(){
        ClaimsSteps.createNewClaim();
        ClaimsScreen.firstClaimCard.perform(click());
        ClaimsScreen.titleTextOfClaim.check(matches(withText("Test1")));
        ClaimsSteps.closeTestClaim();
    }

    @Test
    @DisplayName("Создание валидного комментария к претензии")
    @Description("Создание коментария к претензии с валидным значением")
    public void shouldCreateValidComment(){
        ClaimsSteps.createNewClaim();
        ClaimsScreen.firstClaimCard.perform(click());
        ClaimsScreen.buttonToAddComment.perform(nestedScrollTo());
        ClaimsScreen.buttonToAddComment.perform(click());
        CommentScreen.commentTestInputEditText.perform(replaceText(DataHelper.comment));
        CommentScreen.saveButton.perform(click());
        ClaimsScreen.newTestComment(DataHelper.comment);
        ClaimsSteps.closeTestClaim();
    }

    @Test
    @DisplayName("Смена заголовка претензии")
    @Description("Редактирование уже созданной претензии и внесение в нее новой валидной информации в поле Title")
    public void shouldChangeTitleOfClaim(){
        ClaimsSteps.createNewClaim();
        ClaimsScreen.firstClaimCard.perform(click());
        ClaimsScreen.editStatusButton.perform(click());
        ClaimsScreen.throwOffStatusButton.perform(click());
        ClaimsScreen.commentField.perform(replaceText(DataHelper.comment));
        ClaimsScreen.okButton.perform(click());
        ClaimsScreen.editClaimButton.perform(click());
        ClaimCreationAndEditingScreen.titleTextInputOfClaim.perform(replaceText(DataHelper.title));
        DataHelper.wait(ClaimCreationAndEditingScreen.saveButtonOfClaim).perform(click());
        ClaimsScreen.titleTextOfClaim.check(matches(isDisplayed()));
        ClaimsSteps.closeEditedTestClaim();
    }

    @Test
    @DisplayName("Сворачивание раскрытой претензии")
    @Description("В меню просмотра претензии проверить кнопку возрата к списку претензий")
    public void shouldOpenClaimClosing(){
        ClaimsSteps.createNewClaim();
        ClaimsScreen.firstClaimCard.perform(click());
        ClaimsScreen.closeClaim.perform(click());
        ClaimsScreen.titleOfClaimsBlock.check(matches(isDisplayed()));
        ClaimsScreen.firstClaimTopicText.perform(click());
        ClaimsSteps.closeTestClaim();
    }

    @Test
    @DisplayName("Открытие фильтра претензий")
    @Description("Проверка открытия окна с фильтрами для списка претензий")
    public void shouldOpenFilterClaims(){
        ClaimsSteps.enterClaimsMenu();
        ClaimsScreen.filtersButton.perform(click());
        ClaimsScreen.filterWindowTitle.check(matches(isDisplayed()));
    }
}
