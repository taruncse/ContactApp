package contact.tkb.com.contactsapp;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ContactAdapter extends PagedListAdapter<ContactModel, ContactAdapter.ItemViewHolder> {

    private Context mCtx;

    protected ContactAdapter(Context mCtx) {
        super(CALLBACK);
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_row, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        ContactModel contact = getItem(position);

        if (contact != null) {
            holder.txtName.setText("Name: "+contact.getName());
            holder.txtNumber.setText("Number: "+contact.getPhone());
            holder.txtEmail.setText("Email: "+contact.getEmail());

        } else {
            Toast.makeText(mCtx, Constants.YOU_DONT_HAVE_ANY_DATA, Toast.LENGTH_LONG).show();
        }

    }


    private static DiffUtil.ItemCallback<ContactModel> CALLBACK =
            new DiffUtil.ItemCallback<ContactModel>() {

                @Override
                public boolean areItemsTheSame(@NonNull ContactModel oldItem, @NonNull ContactModel newItem) {
                    return false;
                }

                @Override
                public boolean areContentsTheSame(ContactModel oldItem, ContactModel newItem) {
                    return oldItem.equals(newItem);
                }
            };


    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView txtName,txtNumber,txtEmail;

        public ItemViewHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            txtEmail = itemView.findViewById(R.id.txtEmail);

        }
    }
}
