package com.example.shivanikoul.threads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button imageBtn, ToastBtn;
    ImageView image;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToastBtn = findViewById(R.id.ToastBtn);
        imageBtn = findViewById(R.id.imageBtn);
        progressBar=findViewById(R.id.progress);

        image = findViewById(R.id.imageview);

        ToastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "I am in Toast", Toast.LENGTH_SHORT).show();
                ;
            }
        });

        imageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                LoadImage();
                new LoadIconTask().execute(R.drawable.pari);
            }


        });
    }
         class  LoadIconTask extends  AsyncTask<Integer,Integer,Bitmap> {



             @Override
             protected void onPreExecute() {
                 super.onPreExecute();
                 progressBar.setVisibility(ProgressBar.VISIBLE);
             }
             @Override
             protected Bitmap doInBackground(Integer... integers) {
                 try {
                     Thread.sleep(000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();

                 }
                 Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.pari);

                 return bitmap;
             }

             @Override
             protected void onPostExecute(Bitmap bitmap) {
                 super.onPostExecute(bitmap);
                 image.setImageBitmap(bitmap);
                 progressBar.setVisibility(ProgressBar.INVISIBLE);
             }

             @Override
             protected void onProgressUpdate(Integer... values) {
                 super.onProgressUpdate(values);
                 progressBar.setProgress(values[0]);

             }

         }
//    private void LoadImage() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pari);
//                MainActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        image.setImageBitmap(bitmap);
//                    }
//                });
//            }
//        }).start();
//
//
//    }
}