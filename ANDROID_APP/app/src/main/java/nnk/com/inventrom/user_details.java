package nnk.com.inventrom;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class user_details extends AppCompatActivity
{
    Button bb;
    EditText et1,et2,et3;
    RadioGroup rg;
    RadioButton rb;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        bb=(Button)findViewById(R.id.button);
        rg = (RadioGroup)findViewById(R.id.rg);
        et1=(EditText)findViewById(R.id.name);
        et2=(EditText)findViewById(R.id.Age);
        et3=(EditText)findViewById(R.id.Addr);
    }
    public void submit(View v)
    {
        /**
         * Getting data From all EditText.
         */
        String file_name=et1.getText().toString().trim();
        String Age = et2.getText().toString().trim();
        String Address = et3.getText().toString().trim();
        /**
         * Getting the folder path from Phone's Storage and saves the txt file into that
         */
        String file_path= Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+file_name+".txt";
        try {
            // File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            //  if (!root.exists()) {
            //    root.mkdirs();

            Log.e("file path := ", file_path);
            /**
             * creating object of file to be insert
             */
            FileOutputStream fout = new FileOutputStream(file_path);
            if (file_name.isEmpty()) {
                et1.setError("Please enter name");
                et1.requestFocus();
            } else if (Age.isEmpty()) {
                et2.setError("Please enter age");
                et2.requestFocus();
            } else if (Address.isEmpty()) {
                et3.setError("Please enter Address");
                et3.requestFocus();
            } else {
                /**
                 * Writting to a file with name[from EditText].txt
                 */
                fout.write(file_name.getBytes());
                fout.write(Age.getBytes());
                fout.write(Address.getBytes());

                int id = rg.getCheckedRadioButtonId();
                rb = (RadioButton) findViewById(id);
                String st = rb.getText().toString();

                fout.write(st.getBytes());
                fout.close();
                Toast.makeText(this, "File Created", Toast.LENGTH_SHORT).show();
            }
        }
        //Exception for byte Array input
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Going another Class Called GraphActivity.class
        Intent i=new Intent(this,GraphhActivity.class);
        startActivity(i);
    }
}
