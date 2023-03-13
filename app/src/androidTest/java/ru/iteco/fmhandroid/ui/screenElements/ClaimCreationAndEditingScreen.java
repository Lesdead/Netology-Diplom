package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import androidx.test.espresso.ViewInteraction;
import org.hamcrest.Matcher;
import ru.iteco.fmhandroid.R;

public class ClaimCreationAndEditingScreen {
    public static ViewInteraction titleTextInputOfClaim = onView(withId(R.id.title_edit_text));
    public static ViewInteraction buttonForShowingDropdownMenu = onView(withContentDescription("Show dropdown menu"));
    public static ViewInteraction executorName = onView(allOf(withId(R.id.date_in_plan_text_input_edit_text)));
    public static ViewInteraction dateInPlanOfClaim = onView(withId(R.id.date_in_plan_text_input_edit_text));
    public static ViewInteraction timeInPlanOfClaim = onView(withId(R.id.time_in_plan_text_input_edit_text));
    public static ViewInteraction okButton = onView(withText("OK"));
    public static ViewInteraction descriptionTextInputOfClaim = onView(withId(R.id.description_edit_text));
    public static ViewInteraction cancelButton = onView(withText("CANCEL"));
    public static ViewInteraction fillEmptyFieldsMessage = onView( withText("Fill empty fields"));

    public static Matcher<View> saveButtonOfClaim = withId(R.id.save_button);
}
