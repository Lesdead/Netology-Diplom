package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.view.View;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class ClaimCreationAndEditingScreen {

    public static ViewInteraction titleOfClaimsCreatingPage = onView(withText("Creating"));
    public static ViewInteraction titleTextInputOfClaim = onView(withId(R.id.title_edit_text));
    public static ViewInteraction executorTextInput = onView(withId(R.id.executor_drop_menu_text_input_layout));
    public static ViewInteraction buttonForShowingDropdownMenu = onView(withContentDescription("Show dropdown menu"));
    public static ViewInteraction executorName = onView(allOf(withId(R.id.date_in_plan_text_input_edit_text)));
    public static ViewInteraction dateInPlanOfClaim = onView(withId(R.id.date_in_plan_text_input_edit_text));
    public static ViewInteraction timeInPlanOfClaim = onView(withId(R.id.time_in_plan_text_input_edit_text));
    public static ViewInteraction okButton = onView(withText("OK"));
    public static ViewInteraction buttonForSwitchToTextInput = onView(withContentDescription("Switch to text input mode for the time input."));
    public static ViewInteraction descriptionTextInputOfClaim = onView(withId(R.id.description_edit_text));
    public static ViewInteraction saveButtonOfClaim = onView(withId(R.id.save_button));

    public static ViewInteraction cancelButton = onView(withText("CANCEL"));

    public static ViewInteraction fillEmptyFieldsMessage = onView( withText("Fill empty fields"));
}
