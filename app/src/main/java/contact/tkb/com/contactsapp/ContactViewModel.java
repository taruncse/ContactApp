package contact.tkb.com.contactsapp;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

public class ContactViewModel extends ViewModel {

    LiveData<PagedList<ContactModel>> itemPagedList;
    LiveData<PageKeyedDataSource<Integer, ContactModel>> liveDataSource;

    public ContactViewModel() {

        ContactDataSourceFactory itemDataSourceFactory = new ContactDataSourceFactory();
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource();

        PagedList.Config config =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(ContactDataSource.PAGE_SIZE)
                        .build();

        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, config)).build();

    }
}
