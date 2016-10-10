package com.crazymo.training;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private List<ChatBean> chatBeanList;
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void getViews() {
        recyclerView = (RecyclerView) findViewById(R.id.listv_chatting);
    }

    private void initAdapter(){
        chatBeanList=new ArrayList<>();
        chatBeanList.add(new ChatBean("Hello~~~",null,0));
        chatBeanList.add(new ChatBean("Nice to meet U",null,1));
        chatBeanList.add(new ChatBean("Me tooo",null,0));
        chatBeanList.add(new ChatBean("LOL~~~",null,1));
        chatBeanList.add(new ChatBean("LOL~~~",null,1));
        chatBeanList.add(new ChatBean("LOL~~~",null,0));
    }
    private void initRecyclerView(){
        //设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置adapter
        recyclerView.setAdapter(new ChatAdapter(this, chatBeanList));
        //设置默认动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void init() {
        getViews();
        initAdapter();
        initRecyclerView();
    }

    class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

        private List<ChatBean> chatBeanList;
        private LayoutInflater inflater;

        public ChatAdapter(Context context,List<ChatBean> chatBeans){
            this.chatBeanList=chatBeans;
            this.inflater=LayoutInflater.from(context);
        }

        @Override
        public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ChatViewHolder holder;
            if(viewType==0) {
                holder = new ChatViewHolder(LayoutInflater.from(
                        MainActivity.this).inflate(R.layout.item_response, parent,
                        false));
            }
            else{
                holder = new ChatViewHolder(LayoutInflater.from(
                        MainActivity.this).inflate(R.layout.item_send, parent,
                        false));
            }
            return holder;
        }

        @Override
        public int getItemViewType(int position) {
            return chatBeanList.get(position).getType();
        }

        @Override
        public void onBindViewHolder(ChatViewHolder holder, int position) {

            if(chatBeanList.get(position).getType()==0) {
                holder.tvResponse.setText(chatBeanList.get(position).getContent());
            }else {
                holder.tvSend.setText(chatBeanList.get(position).getContent());
            }
        }

        @Override
        public int getItemCount() {
            return chatBeanList.size();
        }

        class ChatViewHolder extends RecyclerView.ViewHolder {

            TextView tvResponse;
            TextView tvSend;

            public ChatViewHolder(View view) {
                super(view);
                tvResponse = (TextView) view.findViewById(R.id.tv_resopense);
                tvSend=(TextView)view.findViewById(R.id.tv_send);
            }
        }
    }
}
