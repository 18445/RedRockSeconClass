package com.example.secondclass;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

//public class Level4_Adapter extends RecyclerView.Adapter<Level4_Adapter.Holder> {
public class Level4_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Type> mType;
    private Title title;
    private OnItemClickListener listener;
    public Level4_Adapter(List<Type> mType) {
        this.mType = mType;
    }
    public enum ItemType {
        ITEM1, ITEM2
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listenser) {
        this.listener = listenser;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = null;
        if(viewType == ItemType.ITEM1.ordinal()){
            return new Holder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_level4_title, parent, false));
        }else if (viewType == ItemType.ITEM2.ordinal()){
            return new Holder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_level4_type, parent, false));
//        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_level4_type,parent,false);
        }
//        assert v != null;
//        return new RecyclerView.ViewHolder(v) ;
        return null;
    }
    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof Holder2){
            Holder2 holder2 = (Holder2) holder;
            holder2.textAbove.setText(mType.get(position).above);
            holder2.textBelow.setText(mType.get(position).below);
            holder2.imageView.setImageResource(mType.get(position).getPicture());
        }else if(holder instanceof Holder1){
            //无操作
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        Toast.makeText(v.getContext(), "前方正在修建中呢", Toast.LENGTH_SHORT).show();
//                        listener.onItemClick(position1);
                    }
                }
            });
        }
    }
    @Override
    public int getItemCount() {
        return mType.size();
    }
    public int getItemViewType(int position) {
        if (position == 0) {
            return ItemType.ITEM1.ordinal();
        } else {
            return ItemType.ITEM2.ordinal();
        }
    }

    public static class Holder1 extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;

        public Holder1(View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.leftTitle);
            textView2 = itemView.findViewById(R.id.rightTitle);
        }
    }

    static class Holder2 extends RecyclerView.ViewHolder{
        TextView textAbove ;
        TextView textBelow ;
        ImageView imageView;
        public Holder2(@NonNull View itemView) {
            super(itemView);
            textAbove =itemView.findViewById(R.id.above_title);
            textBelow =itemView.findViewById(R.id.below_title);
            imageView =itemView.findViewById(R.id.picture);
        }
    }


}

