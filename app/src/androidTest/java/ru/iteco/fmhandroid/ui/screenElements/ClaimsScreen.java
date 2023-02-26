package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.DataHelper.DataHelper.withIndex;

import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;

public class ClaimsScreen {
    public static void newTestComment(String comment) {onView(withText(comment)).check(matches(isDisplayed()));}
    public static ViewInteraction titleTextOfClaim = onView(withId(R.id.title_text_view));
    public static ViewInteraction editClaimButton = onView(withId(R.id.edit_processing_image_button));
    public static ViewInteraction closeClaim = onView(withId(R.id.close_image_button));
    public static ViewInteraction buttonToAddComment = onView(withId(R.id.add_comment_image_button));
    public static ViewInteraction titleOfClaimsBlock = onView(withText("Claims"));
    public static ViewInteraction addNewClaimButton = onView(withId(R.id.add_new_claim_material_button));
    public static ViewInteraction filtersButton = onView(withId(R.id.filters_material_button));
    public static ViewInteraction filterWindowTitle = onView(withId(R.id.claim_filter_dialog_title));
    public static ViewInteraction editStatusButton = onView(withId(R.id.status_processing_image_button));
    public static ViewInteraction toExecuteStatusButton = onView(withText("To execute"));
    public static ViewInteraction throwOffStatusButton = onView(withText("Throw off"));
    public static ViewInteraction cancelStatusButton = onView(withText("Cancel"));
    public static ViewInteraction commentField = onView(withId(R.id.editText));
    public static ViewInteraction okButton = onView(withText("OK"));
    public static ViewInteraction firstClaimCard = onView(withIndex(withId(R.id.claim_list_card), 0));
    public static ViewInteraction firstClaimTopicText = onView(withIndex(withText("Topic"), 0));
}
