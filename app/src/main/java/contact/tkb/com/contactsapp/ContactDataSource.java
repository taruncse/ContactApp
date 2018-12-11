package contact.tkb.com.contactsapp;


import android.content.Context;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

public class ContactDataSource extends PageKeyedDataSource<Integer, ContactModel> {

    public static final int PAGE_SIZE = 50;
    private static final int FIRST_PAGE = 1;


    int startIndex = 0;
    int endIndex = 10;
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, ContactModel> callback) {

         List<ContactModel> contactList = Utils.getListByLimit(startIndex,endIndex);
         if (contactList != null){
             callback.onResult(contactList, null, FIRST_PAGE + 1);
         }

    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, ContactModel> callback) {

        /*Snackbar.make(findViewById(R.id.myCoordinatorLayout), R.string.email_sent,
                Snackbar.LENGTH_SHORT)
                .show();*/
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, ContactModel> callback) {
        startIndex += 11;
        endIndex += 10;

        List<ContactModel> contactList = Utils.getListByLimit(startIndex,endIndex);
        if (contactList != null){
            Integer key = params.key > 10 ? params.key + 1 : null;
            callback.onResult(contactList, key);
        }
    }
}
