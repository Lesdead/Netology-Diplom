package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.view.View;
import androidx.test.espresso.ViewInteraction;
import org.hamcrest.Matcher;
import ru.iteco.fmhandroid.ui.dataHelper.DataHelper;
import ru.iteco.fmhandroid.R;

public class MainScreen {
    public static ViewInteraction logOutButton = onView(withText("Log out"));
    public static ViewInteraction newsOfMenu = onView(withText("News"));
    public static ViewInteraction aboutOfMenu = onView(withText("About"));
    public static ViewInteraction goToCitationBlockButton = onView(withId(R.id.our_mission_image_button));
    public static ViewInteraction buttonToExpandOrHideNewsPart = onView(DataHelper.withIndex(withId(R.id.expand_material_button), 0));
    public static ViewInteraction containerListForNews = onView(withId(R.id.container_list_news_include_on_fragment_main));

    public static Matcher<View> menuButton = withId(R.id.enter_button);
    public static Matcher<View> claimsOfMenu = withText("Claims");
    public static Matcher<View> authorizationButton = withId(R.id.authorization_image_button);
}
