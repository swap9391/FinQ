package com.exa.finq.fragment;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.exa.finq.MainActivity;
import com.exa.finq.R;
import com.exa.finq.adapter.GridViewAdapter;
import com.exa.finq.model.ImageItem;

import java.util.ArrayList;

/**
 * Created by root on 5/5/17.
 */

public class ProfileFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_profile, container, false);

        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        inflater.inflate(R.menu.profile_edit, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_edit:
                Toast.makeText(getMyActivity(),"Edit Clicked",Toast.LENGTH_SHORT).show();
                // Not implemented here
                return false;


            default:
                break;
        }

        return false;
    }


    public MainActivity getMyActivity(){
        return (MainActivity)getActivity();
    }

}
