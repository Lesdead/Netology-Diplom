package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;

import ru.iteco.fmhandroid.R;
import androidx.test.espresso.ViewInteraction;

public class CommentScreen {
    public static ViewInteraction commentTestInputEditText = onView(allOf(withHint("Comment"),
            withParent(withParent(withId(R.id.comment_text_input_layout)))));
    public static ViewInteraction saveButton = onView(withId(R.id.save_button));
}
