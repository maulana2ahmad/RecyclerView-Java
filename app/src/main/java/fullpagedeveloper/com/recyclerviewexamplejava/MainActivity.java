package fullpagedeveloper.com.recyclerviewexamplejava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import fullpagedeveloper.com.recyclerviewexamplejava.adapter.ContactRecyclerViewAdapter;
import fullpagedeveloper.com.recyclerviewexamplejava.model.Contact;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsRecyclerView = findViewById(R.id.contactsRecycler);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("ahmad", "@d", "https://www.godfatherstyle.com/wp-content/uploads/2016/01/wedding-photografhy.jpg"));
        contacts.add(new Contact("baja", "@d", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQjFzQ6XzdQ86bHFZUzKUePdVKTlBLTDB2YlkF37JcsJEB_fHFv&usqp=CAU"));
        contacts.add(new Contact("car", "@d", "https://earthsky.org/upl/2018/12/comet-wirtanen-Jack-Fusco-dec-2018-Anza-Borrego-desert-CA-e1544613895713.jpg"));
        contacts.add(new Contact("dido", "@d", "https://interactive-examples.mdn.mozilla.net/media/examples/grapefruit-slice-332-332.jpg"));
        contacts.add(new Contact("endy", "@d", "https://image.shutterstock.com/image-photo/colorful-flower-on-dark-tropical-260nw-721703848.jpg"));
        contacts.add(new Contact("faiz", "@d", "https://s.ftcdn.net/v2013/pics/all/curated/RKyaEDwp8J7JKeZWQPuOVWvkUjGQfpCx_cover_580.jpg?r=1a0fc22192d0c808b8bb2b9bcfbf4a45b1793687"));
        contacts.add(new Contact("gazali", "@d", "https://pixlr.com/photo/image-editing-20200512-pw.jpg"));

        ContactRecyclerViewAdapter adapter = new ContactRecyclerViewAdapter(this);
        adapter.setContacts(contacts);
        Log.d("data", contacts.toString());
        Log.d("data2", adapter.toString());


        contactsRecyclerView.setAdapter(adapter);
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
