package model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class UserData implements Parcelable {
    public static ArrayList<User> saveList = new ArrayList<>();

    protected UserData(Parcel in) {
    }

    public static final Creator<UserData> CREATOR = new Creator<UserData>() {
        @Override
        public UserData createFromParcel(Parcel in) {
            return new UserData(in);
        }

        @Override
        public UserData[] newArray(int size) {
            return new UserData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}