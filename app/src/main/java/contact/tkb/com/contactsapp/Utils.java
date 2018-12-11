package contact.tkb.com.contactsapp;

import android.content.Context;
import android.widget.LinearLayout;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static  List<ContactModel> contactList;
    private static List<ContactModel> loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = ContactApplication.get().getApplicationContext().getAssets().open(Constants.JSON_FILE_NAME);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            ObjectMapper mapper = new ObjectMapper();

            List<ContactModel> myObjects = mapper.readValue(json, new TypeReference<List<ContactModel>>(){});
            return myObjects;

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static List<ContactModel> getListByLimit(int startIndex, int endIndex) {
        if (contactList == null){
            contactList =  loadJSONFromAsset();
        }

        List<ContactModel> sublist = contactList.subList(startIndex, endIndex);
        return sublist;
    }
}