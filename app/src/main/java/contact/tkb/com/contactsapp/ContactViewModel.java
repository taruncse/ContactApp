package contact.tkb.com.contactsapp;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

public class ContactViewModel extends ViewModel {

    LiveData<PagedList<ContactModel>> contactPagedList;
    LiveData<PageKeyedDataSource<Integer, ContactModel>> liveDataSource;

    public ContactViewModel() {

        ContactDataSourceFactory contactDataSourceFactory = new ContactDataSourceFactory();
        liveDataSource = contactDataSourceFactory.getContactLiveDataSource();

        PagedList.Config config =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(ContactDataSource.PAGE_SIZE)
                        .build();

        contactPagedList = (new LivePagedListBuilder(contactDataSourceFactory, config)).build();

    }
}
