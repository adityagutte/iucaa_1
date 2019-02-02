package com.cabalabs.iucaa;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;


import java.util.List;

/**
 * Created by Aws on 11/03/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Summary> mData ;
    RequestOptions option;


    public RecyclerViewAdapter(Context mContext, List<Summary> mData) {
        this.mContext = mContext;
        this.mData = mData;

        // Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.summary_row_item,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, SummaryActivity.class);
                i.putExtra("id",mData.get(viewHolder.getAdapterPosition()).getId());
                i.putExtra("folder_name",mData.get(viewHolder.getAdapterPosition()).getFolder());
//                i.putExtra("OBSID",mData.get(viewHolder.getAdapterPosition()).getOBSID());
//                i.putExtra("Observer",mData.get(viewHolder.getAdapterPosition()).getObserver());
//                i.putExtra("RA",mData.get(viewHolder.getAdapterPosition()).getRA());
//                i.putExtra("Decr",mData.get(viewHolder.getAdapterPosition()).getDecr());
//                i.putExtra("Exposure_time",mData.get(viewHolder.getAdapterPosition()).getExposure_time());

                mContext.startActivity(i);

            }
        });




        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.id.setText(mData.get(position).getId());
        holder.folder_name.setText(mData.get(position).getFolder());
//        holder.tv_studio.setText(mData.get(position).getStudio());
//        holder.tv_category.setText(mData.get(position).getCategorie());

        // Load Image from the internet and set it into Imageview using Glide

      //  Glide.with(mContext).load(mData.get(position).getImage_url()).apply(option).into(holder.img_thumbnail);



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id ;
        TextView folder_name ;
//        TextView tv_studio ;
//        TextView tv_category;
//        ImageView img_thumbnail;
        LinearLayout view_container;





        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            id = itemView.findViewById(R.id.tv_id);
            folder_name = itemView.findViewById(R.id.tv_foldername);
//            tv_rating = itemView.findViewById(R.id.rating);
//            tv_studio = itemView.findViewById(R.id.studio);
//            img_thumbnail = itemView.findViewById(R.id.thumbnail);

        }
    }

}
