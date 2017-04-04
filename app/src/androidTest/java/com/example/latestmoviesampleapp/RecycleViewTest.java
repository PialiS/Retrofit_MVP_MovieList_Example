package com.example.latestmoviesampleapp;


import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.latestmoviesampleapp.main.activity.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
@RunWith(AndroidJUnit4.class)
public class RecycleViewTest {
    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule=new ActivityTestRule<>(MainActivity.class);

    private static final String MOVIE_TITLE = "Kong: Skull Island";
    private static final String MOVIE_RELEASE_DATE = "2017-03-08";
    private static final String MOVIE_RATING="6.1";
    private static final String MOVIE_GENRE="Science,Fiction,Action,Adventure,Fantacy";



    @Test
    public void testClickAtPosition(){

        onView(withId(R.id.movies_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(4, click()));
        onView(withId(R.id.name_text)).check(matches(withText(MOVIE_TITLE)));
        onView(withId(R.id.genre_text)).check(matches(withText(MOVIE_GENRE)));
        onView(withId(R.id.rating_text)).check(matches(withText(MOVIE_RATING)));
        onView(withId(R.id.release_date_text)).check(matches(withText(MOVIE_RELEASE_DATE)));

    }
}
