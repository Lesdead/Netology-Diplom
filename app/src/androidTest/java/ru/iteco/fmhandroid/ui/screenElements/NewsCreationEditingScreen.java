package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;

public class NewsCreationEditingScreen {
    public static ViewInteraction titleCreatingWindow = onView(withId(R.id.custom_app_bar_sub_title_text_view));
    public static ViewInteraction categoryTextInputOfNews = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public static ViewInteraction titleTextInputOfNews = onView(withId(R.id.news_item_title_text_input_edit_text));
    public static ViewInteraction dateInputOfNews = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public static ViewInteraction okButton = onView(withText("OK"));
    public static ViewInteraction timeInputOfNews = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public static ViewInteraction descriptionTextInputOfNews = onView(withId(R.id.news_item_description_text_input_edit_text));
    public static ViewInteraction saveButtonOfNews = onView(withId(R.id.save_button));
}
