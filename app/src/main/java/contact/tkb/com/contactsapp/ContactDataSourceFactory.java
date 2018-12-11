package contact.tkb.com.contactsapp;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

public class ContactDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, ContactModel>> itemLiveDataSource = new MutableLiveData<>();


    @Override
    public DataSource create() {
        ContactDataSource itemDataSource = new ContactDataSource();
        itemLiveDataSource.postValue(itemDataSource);
        return itemDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, ContactModel>> getItemLiveDataSource() {
        return itemLiveDataSource;
    }
}
