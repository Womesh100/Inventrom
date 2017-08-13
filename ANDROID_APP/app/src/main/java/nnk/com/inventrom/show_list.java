package nnk.com.inventrom;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

/**
    *  To show the user details in the ListView using array Adapter
 */

public class show_list extends Fragment
{
    public View onCreateView(LayoutInflater li,ViewGroup vg,Bundle b)
    {
        super.onCreateView(li, vg, b);
        /**
         * inflate the Show list Layout(First parameter is id,second View Group,third is Boolean value
          [that have not attached to root in layout]using false keyword)
         */
        View v = li.inflate(R.layout.fragment_show_list,vg,false);
        //finding the listview reference
        ListView lv=(ListView)v.findViewById(R.id.lv);
        //creating arrayList object
        ArrayList al=new ArrayList();
        /**
         * Getting file[image File] from our Phone's Storage Which is Located inside "InventomApp".
          */
        File f = Environment.getExternalStoragePublicDirectory( Environment.DIRECTORY_PICTURES+ File.separator+"InventromApp");
        //putting the list of files in file array
        File[] files=f.listFiles();
        String filename = "";
        /**
         * If file is empty in our storage then simply it shows a Toast message["File is Empty"].
         */
        if(files.length==0) {
            Toast.makeText(getContext(),"File is Empty", Toast.LENGTH_SHORT).show();
        }
        else{
            /**
             * while Image is in Stored then adding to the ListView using [al.add()].
             */
            for (int i = 0; i < files.length; i++) {
                al.add(files[i].getName() + "\n");
            }
            /**
             * created ArrayAdapter object to showing the list files in a ListView
             */
            ArrayAdapter aa = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item, al);
            lv.setAdapter(aa);
        }
        return v;
    }
}
