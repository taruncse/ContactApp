package contact.tkb.com.contactsapp;

import android.app.Application;

public class ContactApplication extends Application {
    private static ContactApplication instance;
    public static ContactApplication get() { return instance; }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}