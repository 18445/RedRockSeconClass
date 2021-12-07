package com.example.secondclass;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secondclass.Content;
import com.example.secondclass.R;

import java.util.ArrayList;
import java.util.List;


public class Level3 extends Fragment {

    private RecyclerView mRecyclerView ;
    private List<Content> mContentList = new ArrayList<>();
    private TextView t1,t2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one, container, false);
        initData();
        mRecyclerView= view.findViewById(R.id.mRecycle);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyAdapterR myAdapterR = new MyAdapterR();
        mRecyclerView.setAdapter(myAdapterR);
        DividerItemDecoration mDivider = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(mDivider);
        return view;
    }

    private void initData() {
        for(int i = 0;i<99;i++){
                Content content = new Content();
            if(i>90){
                content.title = "！都是大卷怪！";
                content.content = "！！！！！红岩都是大卷怪！！！！！";
            } else if(i%6==0) {
                content.title = "廖老师是大卷怪";
                content.content = "郭祥瑞也是大卷怪      红岩最不卷的是王中泰";
            }else if(i%6==1){
                content.title = "王兮是大卷怪";
                content.content = "郭祥瑞也是大卷怪      红岩最不卷的是王中泰";
            }else if(i%6==2){
                content.title = "郭祥瑞是大卷怪";
                content.content = "廖老师也是大卷怪      红岩最不卷的是王中泰";
            }else if(i%6==3){
                content.title = "廖老师是大卷怪";
                content.content = "王兮也是大卷怪      红岩最不卷的是王中泰";
            }else if(i%6==4){
                content.title = "王兮是大卷怪";
                content.content = "郭祥瑞也是大卷怪      红岩最不卷的是王中泰";
            }else {
                content.title = "郭祥瑞大卷怪";
                content.content = "王兮也是大卷怪      红岩最不卷的是王中泰";
            }
            mContentList.add(content);
        }
    }
    class MyAdapterR extends RecyclerView.Adapter<MyViewHolder> {
        class Myholder extends RecyclerView.ViewHolder {
            TextView t1, t2;
            public Myholder(@NonNull View itemView) {
                super(itemView);
                t1 = itemView.findViewById(R.id.t1);
                t2 = itemView.findViewById(R.id.t2);
            }
        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(getActivity(), R.layout.item,null);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Content content = mContentList.get(position);
            holder.t1.setText(content.title);
            holder.t2.setText(content.content);
        }


        @Override
        public int getItemCount() {
            return mContentList.size();
        }
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView t1,t2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
        }
    }


}

//package com.example.secondclass;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentActivity;
//import androidx.fragment.app.FragmentManager;
//import androidx.lifecycle.Lifecycle;
//import androidx.recyclerview.widget.DividerItemDecoration;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.viewpager2.adapter.FragmentStateAdapter;
//
//import org.w3c.dom.Text;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class Level3 extends Fragment {
//    private RecyclerView recyclerView;
//    static List<Context> mContentList = new ArrayList<>();
//    TextView t1,t2;
//    private View view;
////    @Override
////    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
////        return (ViewGroup) inflater.inflate(R.layout.level3_layout, container, false);
////    }
//    @Override
//    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
//        if (view == null) {
//            view = inflater.inflate(R.layout.level3_layout, container, false);
//            t1 = view.findViewById(R.id.t1);
//            t2 = view.findViewById(R.id.t2);
//            t1.setText(mContentList.get(0).content);
//            t1.setText(mContentList.get(0).title);
//        }
//        return view;
//    }
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.level3_layout);
//        init();
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        MyAdapterR myAdapterR = new MyAdapterR();
//        recyclerView.setAdapter(myAdapterR);
//        DividerItemDecoration mDivider = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(mDivider);
//    }
//    void init(){
//        recyclerView= getActivity().findViewById(R.id.mRecycle);
//        for(int i = 0;i<50;i++){
//            Context context = new Context();
//            context.title = "廖老师是大卷怪";
//            context.content = "郭祥瑞也是大卷怪      红岩最不卷的是王中泰";
//            mContentList.add(context);
//        }
//    }
//    class MyViewHolder extends RecyclerView.ViewHolder{
//        TextView t1,t2;
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            t1 = itemView.findViewById(R.id.t1);
//            t2 = itemView.findViewById(R.id.t2);
//        }
//    }
//
//    class MyAdapterR extends RecyclerView.Adapter<MyViewHolder> {
//        class Myholder extends RecyclerView.ViewHolder {
//            TextView t1, t2;
//
//            public Myholder(@NonNull View itemView) {
//                super(itemView);
//                t1 = itemView.findViewById(R.id.t1);
//                t2 = itemView.findViewById(R.id.t2);
//            }
//        }
//        @NonNull
//        @Override
//        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view = View.inflate(getActivity(), R.layout.list_view,null);
//            return new MyViewHolder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//            Context context = mContentList.get(position);
//            holder.t1.setText(context.title);
//            holder.t2.setText(context.content);
//        }
//
//
//        @Override
//        public int getItemCount() {
//            return mContentList.size();
//        }
//    }
//
//}
////    private RecyclerView recyclerView;
////    TextView t1,t2;
////    private View view;
////    private static final String ARG_PARAM1="param1";
////    static List<Context> mContentList = new ArrayList<>();
////    String parm1;
////    public static Level3 newInstance(String parm1){
////        Level3 level3 = new Level3();
////        Bundle args = new Bundle();
////        args.putString(ARG_PARAM1,parm1);
////        level3.setArguments(args);
////        return level3;
////    }
////    public static Level3 newInstance(){
////        Level3 level3 = new Level3();
////        Bundle args = new Bundle();
////        args.putString(ARG_PARAM1, level3.parm1);
////        level3.setArguments(args);
////        return level3;
////    }
////
////    @Override
////    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
////        if(view==null){
////            view = inflater.inflate(R.layout.level3_layout,container,false);
////            t1 = view.findViewById(R.id.t1);
////            t2 = view.findViewById(R.id.t2);
////            t1.setText(mContentList.get(0).content);
////            t1.setText(mContentList.get(0).title);
////        }
////        return view;
////    }
//
////    @Override
////    public void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.level3_layout);
////        init();
////        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
////        MyAdapterR myAdapterR = new MyAdapterR();
////        recyclerView.setAdapter(myAdapterR);
////        DividerItemDecoration mDivider = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
////        recyclerView.addItemDecoration(mDivider);
////    }
////    void init(){
////        recyclerView= Objects.requireNonNull(getActivity()).findViewById(R.id.mRecycle);
////
////        for(int i = 0;i<50;i++){
////            Context context = new Context();
////            context.title = "廖老师是大卷怪";
////            context.content = "郭祥瑞也是大卷怪      红岩最不卷的是王中泰";
////            mContentList.add(context);
////        }
////    }
//
////}
//class Context {
//    public String title;
//    public String content;
//}
