package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;
import ru.iteco.fmhandroid.ui.dataHelper.DataHelper;

public class CitationsScreen {
    public static ViewInteraction secondMissionTitleValue = onView(withText(DataHelper.mainTextScreen));
    public static ViewInteraction secondCitationOpenButton = onView(withText(DataHelper.insideTextScreen));
}
