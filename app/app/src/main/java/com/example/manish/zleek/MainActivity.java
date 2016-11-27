package com.example.manish.zleek;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.camera);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        final Button sign_in=(Button) findViewById(R.id.signin);
        final Button a = (Button) findViewById(R.id.formal);
        final Button b = (Button) findViewById(R.id.fashionForward);
        final Button c = (Button) findViewById(R.id.streetwear);
        final Button d = (Button) findViewById(R.id.adventure);

        final ImageView a_clicked = (ImageView) findViewById(R.id.formal_clicked);

        final ImageView b_clicked = (ImageView) findViewById(R.id.fashionForward_clicked);
        final ImageView c_clicked = (ImageView) findViewById(R.id.streetwear_clicked);

        final ImageView d_clicked = (ImageView) findViewById(R.id.adventure_clicked);


        sign_in.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.zalando.co.uk/login/")));
                 }


        });

        a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                a_clicked.setAlpha((float) 1.0);


                b_clicked.setAlpha((float) 0);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                a_clicked.setAlpha((float) 0.0);
                b_clicked.setAlpha((float) 1.0);

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                a_clicked.setAlpha((float) 0.0);
                b_clicked.setAlpha((float) 1.0);

            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               // a_clicked.setAlpha((float) 0.0);
               // b_clicked.setAlpha((float) 0.0);
                //d_clicked.setAlpha((float) 1.0);

            }
        });

    }


    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();

            Bitmap imageBitmap = (Bitmap) extras.get("data");

            Intent intent = new Intent(this, ImageKindaView.class);
            intent.putExtra("bitmap", imageBitmap);
            startActivity(intent);
        }
    }

}
