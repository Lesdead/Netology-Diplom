package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

public class CitationsScreen {
    static String mainText = "Хоспис в своем истинном понимании - это творчество";
    static String insideText = "Нет шаблона и стандарта, есть только дух, который живет в разных домах по-разному. Но всегда он добрый, любящий и помогающий.";

    public static ViewInteraction secondMissionTitleValue = onView(withText(mainText));
    public static ViewInteraction secondCitationOpenButton = onView(withText(insideText));

}
