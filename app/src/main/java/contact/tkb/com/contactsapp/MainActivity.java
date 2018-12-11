package contact.tkb.com.contactsapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView contactRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.loadJSONFromAsset(this);


        contactRecyclerView = findViewById(R.id.contactRecyclerView);
        contactRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        contactRecyclerView.setHasFixedSize(true);
        ContactViewModel itemViewModel = ViewModelProviders.of(this).get(ContactViewModel.class);
        final ContactAdapter adapter = new ContactAdapter(this);
        itemViewModel.itemPagedList.observe(this, new Observer<PagedList<ContactModel>>() {
            @Override
            public void onChanged(@Nullable PagedList<ContactModel> items) {
                adapter.submitList(items);
            }
        });


        contactRecyclerView.setAdapter(adapter);
    }
}
