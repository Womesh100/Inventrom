package nnk.com.inventrom;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment_tab extends Fragment {
//I have Used button for TAB so initializing button reference
    Button bt1,bt2;

    //created View Group LayoutInflater for fragment Class(only for TAB)

    public View onCreateView(LayoutInflater li,ViewGroup vg,Bundle b)
    {
        super.onCreateView(li,vg,b);
        View v = li.inflate(R.layout.fragment_fragment_tab,vg,false);

        //finding the button reference with view v.

        bt1 = (Button)v.findViewById(R.id.b1);
        bt2 = (Button)v.findViewById(R.id.b2);


        /**used for clicking tabs
         * created an fragment object and added to frame layout in main activity with on click
         * Listener for (both tabs) and given toast message
         */


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment_Actions fa = new Fragment_Actions();
                ft.add(R.id.frr,fa);
                ft.commit();
                Toast.makeText(getContext(), "Actions", Toast.LENGTH_SHORT).show();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                show_list l = new show_list();
                ft.add(R.id.frr,l);
                ft.commit();
                Toast.makeText(getContext(), "Show List", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}
