package teamtreehouse.com.stormy.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by benjakuben on 2/5/15.
 */
public class Day implements Parcelable { //we want to implement Parcelable here so type in "implements Parcelabel", then alt+enter to implement methods
    private long mTime;
    private String mSummary;
    private double mTemperatureMax;
    private String mIcon;
    private String mTimezone;

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public int getTemperatureMax() {
        return (int)Math.round(mTemperatureMax);
    }

    public void setTemperatureMax(double temperatureMax) {
        mTemperatureMax = temperatureMax;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getTimezone() {
        return mTimezone;
    }

    public void setTimezone(String timezone) {
        mTimezone = timezone;
    }

    public int getIconId() {
        return Forecast.getIconId(mIcon);
    }

    public String getDayOfTheWeek() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
        formatter.setTimeZone(TimeZone.getTimeZone(mTimezone));
        Date dateTime = new Date(mTime * 1000);
        return formatter.format(dateTime);
    }

    @Override
    public int describeContents() { //leave this method alone because we don't need it.
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) { //writeToParcel wraps it up, but we need to unwrap it...*
        //write data of object into the destination Parcel parameter aka "writeToParcel(Parcel dest, int flags)
        // do it with each piece of data that you want to persist
        dest.writeLong(mTime);
        dest.writeString(mSummary);
        dest.writeDouble(mTemperatureMax);
        dest.writeString(mIcon);
        dest.writeString(mTimezone);
    }

    private Day(Parcel in) { //*unwrap it/un parcel it.
        // we want to order this data in the exact same order as we did in writeToParcel(){ }  :
        mTime = in.readLong();  .
        mSummary = in.readString();
        mTemperatureMax = in.readDouble();
        mIcon = in.readString();
        mTimezone = in.readString();
    }

    public Day() { } //[7]last step: create a default constructor //with the private constructor we added, it cannot be applied to the given types. So we have to create a default constructor back here in the Day class.

    // Creator Field:
    public static final Creator<Day> CREATOR = new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel source) {
            return new Day(source);
        }

        @Override
        public Day[] newArray(int size) {
            return new Day[size];
        }
        //Our Day class is now parcelable, its time to unparcel it in DailyForecastActivity.java
    };
}











