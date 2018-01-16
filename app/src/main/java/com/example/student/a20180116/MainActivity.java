package com.example.student.a20180116;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed=(EditText)findViewById(R.id.editText);

    }

    public void click1(View v){
        String str = getFilesDir().getAbsolutePath();
        Log.d("FILE", str);
        String str1 = getCacheDir().getAbsolutePath();
        Log.d("FILE", str1);
    }

    public void creatfile(View v){
        String str = getFilesDir().getAbsolutePath();

        Log.d("FILE", str);
        File f1=new File(str+"/"+ed.getText().toString());//用EDITTEXT幫新增檔案命名

        try {
            f1.createNewFile();
            FileWriter fw=new FileWriter(f1);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
