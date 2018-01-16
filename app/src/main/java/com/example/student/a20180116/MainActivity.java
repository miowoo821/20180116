package com.example.student.a20180116;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.regex.Matcher;

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
    public void click3(View v)
    {
        ArrayList<String> mylist = new ArrayList();
        mylist.add("Bob");
        mylist.add("Mary");
        mylist.add("Peter");
        File f = new File(getFilesDir(), "myfile1.txt");
        try {
            FileWriter fw = new FileWriter(f);
            Gson gson = new Gson();
            String data = gson.toJson(mylist);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void click4(View v)
    {
        ArrayList<Student> mydata = new ArrayList();
        mydata.add(new Student(1, "Bob", 95));
        mydata.add(new Student(2, "Mary", 98));
        mydata.add(new Student(3, "Peter", 80));

        File f = new File(getFilesDir(), "myfile2.txt");
        try {
            FileWriter fw = new FileWriter(f);
            Gson gson = new Gson();
            String data = gson.toJson(mydata);
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void click5(View V){

        //String str = getFilesDir().getAbsolutePath();
        File f=new File(getFilesDir(),ed.getText().toString());
        try {
            FileReader f1=new FileReader(f);
            BufferedReader br=new BufferedReader(f1);

            String str1=br.readLine();//可以一次讀完，因為檔案只有一行(檔案剛剛自己寫的)
            Log.d("FILE", str1);
            Gson gson=new Gson();
           ArrayList<String> mydata=gson.fromJson(str1,new TypeToken<ArrayList<String>>(){}.getType());
            for (String s :  mydata)
            {
                Log.d("FILE", "data:" + s);
            }
            br.close();
            f1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void clickRead2(View v)
    {
        File f = new File(getFilesDir(), ed.getText().toString());
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            Log.d("FILE", str);
            Gson gson = new Gson();
            ArrayList<Student> mydata = gson.fromJson(str, new TypeToken<ArrayList<Student>>(){}.getType());
            for (Student s :  mydata)
            {
                Log.d("FILE", "data:" + s.id + "," + s.name);
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void clickk5(View v)
    {
        File f = getExternalFilesDir("data");
        Log.d("FILE", f.getAbsolutePath());
    }

    public void click6(View v)
    {
        File f = Environment.getExternalStorageDirectory();
        Log.d("FILE", f.getAbsolutePath());
    }


    class Student
    {
        public int id;
        public String name;
        public int score;
        public Student(int id, String name, int score)
        {
            this.id = id;
            this.name = name;
            this.score = score;
        }
    }
}
