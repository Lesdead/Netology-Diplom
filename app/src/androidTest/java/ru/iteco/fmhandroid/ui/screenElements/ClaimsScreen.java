package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import static ru.iteco.fmhandroid.ui.helper.MainHelper.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ClaimsScreen {

    // Элементы раскрытой заявки
    public static ViewInteraction titleTextOfClaim = onView(withId(R.id.title_text_view));
    public static ViewInteraction executorTextOfClaim = onView(withId(R.id.executor_name_text_view));
    public static ViewInteraction planeDateOfClaim = onView(withId(R.id.plane_date_text_view));
    public static ViewInteraction editClaimButton = onView(withId(R.id.edit_processing_image_button));
    public static ViewInteraction closeClaim = onView(withId(R.id.close_image_button));
    public static void newTestComment(String comment) {onView(withText(comment)).check(matches(isDisplayed()));}

    // Добавить комментарий
    public static ViewInteraction buttonToAddComment = onView(withId(R.id.add_comment_image_button));

    // Claims
    // Название блока
    public static ViewInteraction titleOfClaimsBlock = onView(withText("Claims"));
    // Создание заявки
    public static ViewInteraction addNewClaimButton = onView(withId(R.id.add_new_claim_material_button));
    // Переход к заявке
    public static ViewInteraction firstClaimCard = onView(withIndex(withId(R.id.claim_list_card), 0));
    // Разное
    public static ViewInteraction containerForClaims = onView(withId(R.id.claim_list_recycler_view));
    public static ViewInteraction filtersButton = onView(withId(R.id.filters_material_button));

    public static ViewInteraction filterWindowTitle = onView(withId(R.id.claim_filter_dialog_title));
    //////////////////////////////////////

    public static ViewInteraction titleLabel = onView(withId(R.id.title_label_text_view));
    public static ViewInteraction executorLabel = onView(withId(R.id.executor_name_label_text_view));
    public static ViewInteraction dateLabel = onView(withId(R.id.plane_date_label_text_view));
    public static ViewInteraction claimTime = onView(withId(R.id.plan_time_text_view));
    public static ViewInteraction description = onView(withId(R.id.description_material_card_view));
    public static ViewInteraction descriptionText = onView(withId(R.id.description_text_view));
    public static ViewInteraction authorLabel = onView(withId(R.id.author_label_text_view));
    public static ViewInteraction authorName = onView(withId(R.id.author_name_text_view));
    public static ViewInteraction createdLabel = onView(withId(R.id.create_data_label_text_view));
    public static ViewInteraction dateCreated = onView(withId(R.id.create_data_text_view));
    public static ViewInteraction timeCreated = onView(withId(R.id.create_time_text_view));
    public static ViewInteraction statusIcon = onView(withId(R.id.status_icon_image_view));
    public static ViewInteraction statusChangingComment = onView(withId(R.id.editText));


    public static ViewInteraction claimList(int index) {
            return onView(withIndex(withId(R.id.claim_list_card), index));
    }



    public static ViewInteraction takeToWorkClaim = onView(withText("take to work"));
    public static ViewInteraction cancelClaim = onView(withText("Cancel"));
    public static ViewInteraction throwOffClaim = onView(withText("Throw off"));
    public static ViewInteraction toExecuteClaim = onView(withText("To execute"));

    public static ViewInteraction changeStatusBtn = onView(withId(R.id.status_processing_image_button));

    public static ViewInteraction commentDescription(int position) {
        return onView(withIndex(withId(R.id.comment_description_text_view), position));
    }

    public static ViewInteraction editComment(int index) {
        return onView(allOf(withIndex(withId(R.id.edit_comment_image_button), index),
                withContentDescription("button edit comment")));
    }

}
