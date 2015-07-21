package teamtreehouse.com.stormy.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.util.Arrays;

import teamtreehouse.com.stormy.R;
import teamtreehouse.com.stormy.adapters.DayAdapter;
import teamtreehouse.com.stormy.weather.Day;

public class DailyForecastActivity extends ListActivity {

    private Day[] mDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);

        Intent intent = getIntent(); //here in OnCreate method we can get the intent that started this activity with the getIntent() method.

        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);//Parcelable is a Java interface that is used in Android to make data easy to transfer from one thing to another.
        mDays = Arrays.copyOf(parcelables, parcelables.length, Day[].class); //convert the above Parcelable[] parcelable into a array of Day objects
        // ^Arrays.copyof() method makes a copy of one array into another
        // ^And the first parameter is the array we want to copy from: "parcelables"
        // ^The second parameter is the length, so we do parcelables.length.
        // ^third parameter: type that we are going to use for the new array we created, which in this case is Day[] class.
        // "Okay, I know this looks a bit weird, but this is how we get an array of items from a parcelable extra on the intent."
        //[7 see Day.java] we need to create a default constructor


        DayAdapter adapter = new DayAdapter(this, mDays);
        setListAdapter(adapter);
    }
}









