package com.example.sharanphonedialer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt0,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,btsave,btcall,btdel,bthash,btstar;
        EditText edittext;
        bt0=(Button)findViewById(R.id.b0);
        bt1=(Button)findViewById(R.id.b1);
        bt2=(Button)findViewById(R.id.b2);
        bt3=(Button)findViewById(R.id.b3);
        bt4=(Button)findViewById(R.id.b4);
        bt5=(Button)findViewById(R.id.b5);
        bt6=(Button)findViewById(R.id.b6);
        bt7=(Button)findViewById(R.id.b7);
        bt8=(Button)findViewById(R.id.b8);
        bt9=(Button)findViewById(R.id.b9);
        btsave=(Button)findViewById(R.id.bbss);
        btcall=(Button)findViewById(R.id.bcall);
        btdel=(Button)findViewById(R.id.bdel);
        bthash=(Button)findViewById(R.id.bhash);
        btstar=(Button)findViewById(R.id.bmul);
        edittext=(EditText) findViewById(R.id.ed1);
        bt0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                edittext.setText(edittext.getText()+"0");
            }
        });
        bt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                edittext.setText(edittext.getText()+"1");
            }
        });
        bt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                edittext.setText(edittext.getText()+"2");
            }
        });
        bt3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                edittext.setText(edittext.getText()+"3");
            }
        });
        bt4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                edittext.setText(edittext.getText()+"4");
            }
        });
        bt5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                edittext.setText(edittext.getText()+"5");
            }
        });
        bt6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                edittext.setText(edittext.getText()+"6");
            }
        });
        bt7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                edittext.setText(edittext.getText()+"7");
            }
        });
        bt8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                edittext.setText(edittext.getText()+"8");
            }
        });
        bt9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                edittext.setText(edittext.getText()+"9");
            }
        });
        bthash.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                edittext.setText(edittext.getText()+"#");
            }
        });
        btstar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                edittext.setText(edittext.getText()+"*");
            }
        });
        btsave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(ContactsContract.Intents.Insert.ACTION);
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.PHONE,edittext.getText());
                startActivity(intent);
            }
        });
        btdel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String textInBox=edittext.getText().toString();
                if(textInBox.length()>0){
                    String newText=textInBox.substring(0,textInBox.length()-1);
                    edittext.setText(newText);
                }
            }
        });
        btcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int REQUEST_PHONE = 1;
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                                Manifest.permission.CALL_PHONE}, REQUEST_PHONE);
                    } else {
                        String number = edittext.getText().toString();
                        Intent callintent = new Intent(Intent.ACTION_CALL);
                        callintent.setData(Uri.parse("tel:" + number));
                        startActivity(callintent);
                    }
                }
            }

        });
    }
}