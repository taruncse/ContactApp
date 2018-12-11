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
        super(DIFF_CALLBACK);
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

        ContactModel item = getItem(position);

        if (item != null) {
            holder.txtName.setText(item.getName());
            holder.txtNumber.setText(item.getName());
            holder.txtEmail.setText(item.getEmail());

        } else {
            Toast.makeText(mCtx, "Item is null", Toast.LENGTH_LONG).show();
        }

    }


    private static DiffUtil.ItemCallback<ContactModel> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ContactModel>() {
                @Override
                public boolean areItemsTheSame(ContactModel oldItem, ContactModel newItem) {
                    return oldItem.getName() == newItem.getName();
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
