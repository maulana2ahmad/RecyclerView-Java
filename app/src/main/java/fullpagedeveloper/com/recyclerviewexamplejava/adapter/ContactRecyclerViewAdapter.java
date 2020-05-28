package fullpagedeveloper.com.recyclerviewexamplejava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import fullpagedeveloper.com.recyclerviewexamplejava.R;
import fullpagedeveloper.com.recyclerviewexamplejava.model.Contact;

public class ContactRecyclerViewAdapter extends RecyclerView.Adapter<ContactRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Contact> contacts = new ArrayList<>();

    private Context context;

    public ContactRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txtName.setText(contacts.get(position).getName());
        holder.textEmail.setText(contacts.get(position).getEmail());
        holder.parentRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Select " + contacts.get(position).getName(), Toast.LENGTH_LONG ).show();
            }
        });

        Glide.with(context)
                .asBitmap()
                .load(contacts.get(position).getImageUrl())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    //setter from varibale ArrayList<Contact>
    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName, textEmail;
        private CardView parentRoot;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.textName);
            textEmail = itemView.findViewById(R.id.textEmail);
            parentRoot = itemView.findViewById(R.id.parentRoot);
            image = itemView.findViewById(R.id.imageViewUrl);
        }
    }
}
