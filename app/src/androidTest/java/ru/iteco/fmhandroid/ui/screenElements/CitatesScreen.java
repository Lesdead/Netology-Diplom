package ru.iteco.fmhandroid.ui.screenElements;

import androidx.test.espresso.ViewInteraction;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class CitatesScreen {
    public static ViewInteraction firstMissionTitleValue = onView(withText("«Хоспис для меня - это то, каким должен быть мир.\""));
}
