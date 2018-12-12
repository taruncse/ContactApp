package contact.tkb.com.contactsapp;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

public class ContactDataSource extends PageKeyedDataSource<Integer, ContactModel> {

    public static final int PAGE_SIZE = 50;
    private static final int FIRST_PAGE = 1;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, ContactModel> callback) {

         List<ContactModel> contactList = Utils.loadJSONFromAsset();
         if (contactList != null){
             callback.onResult(contactList, null, FIRST_PAGE + 1);
         }

    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, ContactModel> callback) {


    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, ContactModel> callback) {

    }
}
