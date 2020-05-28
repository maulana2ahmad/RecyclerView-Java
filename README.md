# RecyclerView-Java
RecyclerVIew Java


Priview
![ezgif com-resize (1)](https://user-images.githubusercontent.com/43386555/83186767-3a444200-a157-11ea-9243-db44dd9680f6.gif)

1 add recyclerview in xml

    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity"
        android:padding="10dp">

        <androidx.recyclerview.widget.RecyclerView
            android:id="@+id/contactsRecycler"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_centerHorizontal="true"/>
    </RelativeLayout>
    
2. add list item .xml


        <?xml version="1.0" encoding="utf-8"?>
        <androidx.cardview.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:app="http://schemas.android.com/apk/res-auto"
            android:id="@+id/parentRoot"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:padding="10dp"
            app:cardCornerRadius="10dp"
            app:cardElevation="10dp">

            <RelativeLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent">

                <TextView
                    android:id="@+id/textName"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_centerHorizontal="true"
                    android:layout_marginTop="10dp"
                    android:text="Contact Name"
                    android:textSize="15sp"
                    android:textStyle="bold" />

                <TextView
                    android:id="@+id/textEmail"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_below="@id/textName"
                    android:layout_marginStart="5dp"
                    android:layout_marginLeft="5dp"
                    android:layout_marginTop="7dp"
                    android:text="Contact Email" />

                <ImageView
                    android:id="@+id/imageViewUrl"
                    android:layout_width="250dp"
                    android:layout_height="280dp"
                    android:layout_below="@id/textEmail"
                    android:layout_centerHorizontal="true"
                    android:layout_marginTop="10dp"
                    android:contentDescription="@string/app_name"
                    android:src="@drawable/ic_launcher_foreground" />
            </RelativeLayout>


        </androidx.cardview.widget.CardView>
        
        
3. create class Adapter

          public class ContactRecyclerViewAdapter
    
4. extend RecyclerView.Adapter

          public class ContactRecyclerViewAdapter extends RecyclerView.Adapter<>
    
5. add class ViewHolder

          public class ContactRecyclerViewAdapter extends RecyclerView.Adapter<ContactRecyclerViewAdapter.ViewHolder>
          
6. add create class ViwHolder (crt+enter/ mac: option+command)

              ViewHolder


              class ViewHolder{
              }
      
      
7. extend class viewholder 


              class ViewHolder extends RecyclerView.ViewHolder {

              public ViewHolder(@NonNull View itemView) {
                    super(itemView);
                    }
              }
              
              
8. implement adapter

                  @NonNull
                @Override
                public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                    
                    return null;
                }

                @Override
                public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
                  }

                @Override
                public int getItemCount() {
                    return;
                }
              
9. create class Model

      
         public class Contact {
            private String name;
            private String email;
            private String imageUrl;
          }
          
10. add constructor option + command
11. add getter and setter
12. add toString()

13. add variable Array

            private ArrayList<Contact> contacts = new ArrayList<>();
            
            
            
14. add item layout onCreateViewHolder

          @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_item, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }
        
15. add size


        @Override
            public int getItemCount() {
                return contacts.size();
            }
            

16. inisialisasi 

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
                
                
17 put data in view onBindViewHolder()


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
                
                
18. add setter update data


          //setter from varibale ArrayList<Contact>
              public void setContacts(ArrayList<Contact> contacts) {
                  this.contacts = contacts;
                  notifyDataSetChanged();
              }
              

19. inisilaisasi RecyclerView


                private RecyclerView contactsRecyclerView;
         
in below metod onCreate

                contactsRecyclerView = findViewById(R.id.contactsRecycler);
                
  
  20. add object Arraylist from Model
  
  
            ArrayList<Contact> contacts = new ArrayList<>();
                  contacts.add(new Contact("ahmad", "@d", "https://www.godfatherstyle.com/wp-content/uploads/2016/01/wedding-photografhy.jpg"));
                  contacts.add(new Contact("baja", "@d", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQjFzQ6XzdQ86bHFZUzKUePdVKTlBLTDB2YlkF37JcsJEB_fHFv&usqp=CAU"));
                  contacts.add(new Contact("car", "@d", "https://earthsky.org/upl/2018/12/comet-wirtanen-Jack-Fusco-dec-2018-Anza-Borrego-desert-CA-e1544613895713.jpg"));
                  contacts.add(new Contact("dido", "@d", "https://interactive-examples.mdn.mozilla.net/media/examples/grapefruit-slice-332-332.jpg"));
                  contacts.add(new Contact("endy", "@d", "https://image.shutterstock.com/image-photo/colorful-flower-on-dark-tropical-260nw-721703848.jpg"));
                  contacts.add(new Contact("faiz", "@d", "https://s.ftcdn.net/v2013/pics/all/curated/RKyaEDwp8J7JKeZWQPuOVWvkUjGQfpCx_cover_580.jpg?r=1a0fc22192d0c808b8bb2b9bcfbf4a45b1793687"));
                  contacts.add(new Contact("gazali", "@d", "https://pixlr.com/photo/image-editing-20200512-pw.jpg"));

21 add object adapter

            ContactRecyclerViewAdapter adapter = new ContactRecyclerViewAdapter(this);
            
22. set data object


            adapter.setContacts(contacts);
            
23. atur posisi data in layout


        contactsRecyclerView.setAdapter(adapter);
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
         
         
