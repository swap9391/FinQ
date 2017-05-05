package com.exa.finq.fragment;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.exa.finq.R;
import com.exa.finq.adapter.GridViewAdapter;
import com.exa.finq.model.ImageItem;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * Created by root on 5/5/17.
 */

public class DashboardFragment extends Fragment {

    private GridView gridView;
    private GridViewAdapter gridAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_dashboard, container, false);

        gridView = (GridView)view. findViewById(R.id.gridView);
        gridAdapter = new GridViewAdapter(getActivity(), R.layout.layout_grid_item, getData());
        gridView.setAdapter(gridAdapter);

        return view;
    }
    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.random_imgs);
        TypedArray str = getResources().obtainTypedArray(R.array.random_text);
        for (int i = 0; i < imgs.length(); i++) {
            Integer bitmap =  imgs.getResourceId(i, -1);
            String text = str.getString(i);
            imageItems.add(new ImageItem(bitmap, text));
        }
        return imageItems;
    }

}
