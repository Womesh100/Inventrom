package nnk.com.inventrom;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//This Activity is for Action Tab only that goes to camera Class (using Intent) when we press the button "click picture"

public class Fragment_Actions extends Fragment
{
    Button bb;
    public View onCreateView(LayoutInflater li,ViewGroup vg,Bundle b)
    {
        super.onCreateView(li, vg, b);
        View v = li.inflate(R.layout.fragment_fragment__actions,vg,false);
        bb=(Button)v.findViewById(R.id.bt_Action);
        /**
         * used OnClickListener for pressing button
         * Intent is used to call Camera class
         */
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(getActivity(),MyCamera.class);
                startActivity(i);
            }
        });
        return v;
    }
}
