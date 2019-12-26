package com.example.testlogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class modcontact extends Activity implements View.OnClickListener {
    private Button updateBtn, deleteBtn;
    private EditText name_edittext,email_edittext,uname_edittext,password_edittext;
    private Integer _id;
    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Update Data");
        setContentView(R.layout.activity_modcontact);
        dbManager = new DBManager(this);
        dbManager.open();

        name_edittext = (EditText) findViewById(R.id.txtName);
        email_edittext = (EditText) findViewById(R.id.txtemail);
        uname_edittext = (EditText) findViewById(R.id.txtuname);
        password_edittext = (EditText) findViewById(R.id.txtpass);
        updateBtn = (Button) findViewById(R.id.btnUPDATE);
        deleteBtn = (Button) findViewById(R.id.btnDELETE);

        /* Membuat objek Intent dengan nilai yang dikirim objek Intent
 yang telah memanggil kelas ini sebelumnya */
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String uname = intent.getStringExtra("uname");
        String pass = intent.getStringExtra("password");

        _id = Integer.parseInt(id);
        name_edittext.setText(name);
        email_edittext.setText(email);
        uname_edittext.setText(uname);
        password_edittext.setText(pass);
        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
    }
    // Pemilihan untuk tombol yang disentuh user (update/ delete)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // Pilihan Update
            case R.id.btnUPDATE:
                // Menyimpan nilai kelas dan nama baru ke variabel
                String name = name_edittext.getText().toString();
                String email = email_edittext.getText().toString();
                String uname = uname_edittext.getText().toString();
                String pass = password_edittext.getText().toString();
 /* Memanggil fungsi update melalui objek dbManager
 fungsi ini membawa tiga parameter yakni _id, kelas, nama */
                dbManager.update(_id,name, email, uname, pass);
 /* Setelah selesai, akan memanggil fungsi returnHome()
 untuk kembali kehalaman utama */
                this.returnHome();
                break;
            // Pilihan Update
            case R.id.btnDELETE:
                // Memanggil fungsi delete dengan parameter _id
                dbManager.delete(_id);

                this.returnHome();
                break;
        } }
    // Fungsi untuk kembali ke halaman awal
    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(),
                dataevent.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    } }

