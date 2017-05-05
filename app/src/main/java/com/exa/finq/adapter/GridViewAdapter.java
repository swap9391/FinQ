package com.exa.finq.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.exa.finq.R;
import com.exa.finq.common.SquareImageView;
import com.exa.finq.model.ImageItem;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/**
 * Created by root on 5/5/17.
 */

public class GridViewAdapter extends ArrayAdapter {
    private Context context;
    private int layoutResourceId;
    private ArrayList data = new ArrayList();

    public GridViewAdapter(Context context, int layoutResourceId, ArrayList data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.imageTitle = (TextView) row.findViewById(R.id.text);
            holder.image = (SquareImageView) row.findViewById(R.id.picture);
            holder.image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        ImageItem item = (ImageItem) data.get(position);
        holder.imageTitle.                                                                                                                                                                           setText(item.getTitle());
        Drawable drawable = context.getResources().getDrawable(item.getImage());

        // holder.image.setImageBitmap(drawable);
        /*Glide.with(context)
                .load(drawable)
                .asBitmap()
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(holder.image);*/

        Picasso.with(context)
                .load(item.getImage())
                .resize(300  ,300)
                .onlyScaleDown()
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.image);


        return row;
    }

    static class ViewHolder {
        TextView imageTitle;
        SquareImageView image;
    }


}