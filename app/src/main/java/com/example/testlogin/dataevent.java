package com.example.testlogin;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class dataevent extends AppCompatActivity {

    private DBManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter adapter;

    final String[] from = new String[] { DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_EMAIL,
            DatabaseHelper.COLUMN_UNAME, DatabaseHelper.COLUMN_PASS};
    final int[] to = new int[] { R.id.id, R.id.name, R.id.email, R.id.uname
            ,R.id.pass};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //pilih layout
        setContentView(R.layout.dataevent);

        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();
        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

        /* Adapter untuk menunjuk data di database
         untuk di tampilkan dalam list siswa yang mana data tersebut
         menunjuk ke fragment dari ListView */
        adapter = new SimpleCursorAdapter(this, R.layout.activity_fragment, cursor, from, to, 0);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

        // OnCLickListiner untuk Data Siswa yang telah ada di database
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {

                // Mengambil nilai list yang dipilih
                TextView idTextView = (TextView) view.findViewById(R.id.id);
                TextView nameTextView = (TextView) view.findViewById(R.id.name);
                TextView emailTextView = (TextView) view.findViewById(R.id.email);
                TextView unameTextView = (TextView) view.findViewById(R.id.uname);
                TextView passTextView = (TextView) view.findViewById(R.id.pass);

                // Menyimpan nilai list yang di pilih ke variabel
                String id = idTextView.getText().toString();
                String name = nameTextView.getText().toString();
                String email = emailTextView.getText().toString();
                String uname = unameTextView.getText().toString();
                String pass = passTextView.getText().toString();


                // Proses Intent untuk mengirim data ke halaman Edit
                Intent modify_intent = new Intent(getApplicationContext(),modcontact.class);
                modify_intent.putExtra("name", name);
                modify_intent.putExtra("email", email);
                modify_intent.putExtra("uname", uname);
                modify_intent.putExtra("password", pass);

                modify_intent.putExtra("id", id);
                startActivity(modify_intent);
            }
        }); }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

}
