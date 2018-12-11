package contact.tkb.com.contactsapp;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

public class ContactDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, ContactModel>> contactLiveDataSource = new MutableLiveData<>();


    @Override
    public DataSource create() {
        ContactDataSource contactDataSource = new ContactDataSource();
        contactLiveDataSource.postValue(contactDataSource);
        return contactDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, ContactModel>> getContactLiveDataSource() {
        return contactLiveDataSource;
    }
}
