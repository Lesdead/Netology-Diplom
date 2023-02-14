package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.ui.helper.MainHelper;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;


public class NewsScreen {

    // Заголовок блока "Новости"
    public static ViewInteraction titleOfNewsBlock = onView(withText("News"));

    // Элементы раскрытой новости
    public static ViewInteraction firstCardNews = onView(MainHelper.withIndex(withId(R.id.news_item_material_card_view), 0));
    public static ViewInteraction firstCardNews2 = onView(
            allOf(withId(R.id.news_list_recycler_view),
                    MainHelper.childAtPosition(
                            withId(R.id.all_news_cards_block_constraint_layout),
                            0)));
    public static ViewInteraction firstNewsItemTitle = onView(MainHelper.withIndex(withId(R.id.news_item_title_text_view), 0));
    public static ViewInteraction firstNewsItemTitle2 = onView(allOf(withId(R.id.news_item_title_text_view), withParent(withParent(MainHelper.withIndex(withId(R.id.news_item_material_card_view), 0)))));
    public static ViewInteraction firstNewsItemDescription = onView(MainHelper.withIndex(withId(R.id.news_item_description_text_view), 0));
    public static ViewInteraction firstNewsItemDescription2 = onView(allOf(withId(R.id.news_item_description_text_view), withParent(withParent(MainHelper.withIndex(withId(R.id.news_item_material_card_view), 0)))));
    public static ViewInteraction firstNewsItemDate = onView(MainHelper.withIndex(withId(R.id.news_item_date_text_view), 0));

    // Кнопка редактирования новостей
    public static ViewInteraction editNewsButton = onView(withId(R.id.edit_news_material_button));

    // Создание новости
    public static ViewInteraction addNewsButton = onView(withId(R.id.add_news_image_view));

    // Сортировка новостей
    public static ViewInteraction sortNewsButton = onView(withId(R.id.sort_news_material_button));

    public static ViewInteraction refreshButton = onView(withText("REFRESH"));

    public static ViewInteraction deleteNewsButton(String newsTitle) {
        return onView(allOf(withId(R.id.delete_news_item_image_view), withParent(withParent(allOf(withId(R.id.news_item_material_card_view), withChild(withChild(withText(newsTitle))))))));
    }

    public static ViewInteraction editNewsButton(String newsTitle) {
        return onView(allOf(withId(R.id.edit_news_item_image_view), withParent(withParent(allOf(withId(R.id.news_item_material_card_view), withChild(withChild(withText(newsTitle))))))));
    }

    ///////////
    public static ViewInteraction newTestNews = onView(withText(NewsSteps.title));
    public static ViewInteraction newTestNewsCyrillicTitle = onView(withText(NewsSteps.cyrillicTitle));

    // Фильтр новостей
    public static ViewInteraction filterNewsButton = onView(withId(R.id.filter_news_material_button));
    public static ViewInteraction filterNewsButtonDate = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public static ViewInteraction filterNewsButtonTime = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    public static ViewInteraction okButton = onView(withText("OK"));
    public static ViewInteraction filterOkButton = onView(withId(R.id.filter_button));
}
