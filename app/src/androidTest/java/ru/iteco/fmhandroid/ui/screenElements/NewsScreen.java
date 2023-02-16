package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

public class NewsScreen {
    public static ViewInteraction titleOfNewsBlock = onView(withText("News"));
    public static ViewInteraction editNewsButton = onView(withId(R.id.edit_news_material_button));
    public static ViewInteraction addNewsButton = onView(withId(R.id.add_news_image_view));
    public static ViewInteraction newTestNews = onView(withText(NewsSteps.title));
    public static ViewInteraction newTestNewsCyrillicTitle = onView(withText(NewsSteps.cyrillicTitle));
    public static ViewInteraction filterNewsButton = onView(withId(R.id.filter_news_material_button));
    public static ViewInteraction filterNewsButtonDate = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public static ViewInteraction filterNewsButtonTime = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    public static ViewInteraction okButton = onView(withText("OK"));
    public static ViewInteraction filterOkButton = onView(withId(R.id.filter_button));

    public static ViewInteraction deleteNewsButton(String newsTitle) {
        return onView(allOf(withId(R.id.delete_news_item_image_view), withParent(withParent(allOf(withId(R.id.news_item_material_card_view), withChild(withChild(withText(newsTitle))))))));
    }

    public static ViewInteraction editNewsButton(String newsTitle) {
        return onView(allOf(withId(R.id.edit_news_item_image_view), withParent(withParent(allOf(withId(R.id.news_item_material_card_view), withChild(withChild(withText(newsTitle))))))));
    }

    public static ViewInteraction openDescNewsButton(String newsTitle) {
        return onView(allOf(withId(R.id.view_news_item_image_view), withParent(withParent(allOf(withId(R.id.news_item_material_card_view), withChild(withChild(withText(newsTitle))))))));
    }

    public static ViewInteraction openDescNewsField(String newsTitle) {
        return onView(allOf(withId(R.id.news_item_description_text_view), withParent(withParent(allOf(withId(R.id.news_item_material_card_view), withChild(withChild(withText(newsTitle))))))));
    }
}
