package contact.tkb.com.contactsapp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Utils {

    public static List<ContactModel> loadJSONFromAsset() {
        String json ;
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
}