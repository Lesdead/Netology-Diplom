package ru.iteco.fmhandroid.ui.screenElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.helper.MainHelper;

public class ClaimsScreen {

    // Элементы раскрытой заявки (предварительно перейти в заявку)
    public static ViewInteraction titleTextOfClaim = onView(withId(R.id.title_text_view));
    public static ViewInteraction executorTextOfClaim = onView(withId(R.id.executor_name_text_view));
    public static ViewInteraction planeDateOfClaim = onView(withId(R.id.plane_date_text_view));
    // Другое
    public static ViewInteraction buttonToAddComment = onView(withId(R.id.add_comment_image_button));

    // Claims
    // Название блока
    public static ViewInteraction titleOfClaimsBlock = onView(withText("Claims"));
    // Создание заявки
    public static ViewInteraction addNewClaimButton = onView(withId(R.id.add_new_claim_material_button));
    // Переход к заявке
    public static ViewInteraction firstClaimCard = onView(MainHelper.withIndex(withId(R.id.claim_list_card), 0));
    // Разное
    public static ViewInteraction containerForClaims = onView(withId(R.id.claim_list_recycler_view));
    public static ViewInteraction filtersButton = onView(withId(R.id.filters_material_button));

}
