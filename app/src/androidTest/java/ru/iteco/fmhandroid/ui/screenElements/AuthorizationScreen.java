package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static org.hamcrest.Matchers.allOf;

public class AuthorizationScreen {
    public static ViewInteraction authorization = onView(withText("Authorization"));
    public static ViewInteraction loginInput = onView(allOf(withHint("Login"),
            withParent(withParent(withId(R.id.login_text_input_layout)))));
    public static ViewInteraction passwordInput = onView(allOf(withHint("Password"),
            withParent(withParent(withId(R.id.password_text_input_layout)))));
    public static ViewInteraction signInButton = onView(withId(R.id.enter_button));

//    public static ViewInteraction wrongLoginPassword = onView((withText("Wrong login or password")));
//    public static ViewInteraction emptyLoginOrPass =  onView(withId(R.string.empty_login_or_password));
}
