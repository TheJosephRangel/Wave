package com.example.wave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class chatScreen extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView chatRecycler;
    private List<Chats> mChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_screen);

        ImageView homeButton = findViewById(R.id.homeButton);
        ImageView pointsButton = findViewById(R.id.pointsButton);
        ImageView chatButton = findViewById(R.id.chatButton);
        ImageView calendarButton = findViewById(R.id.calendarButton);
        ImageView checkinButton = findViewById(R.id.checkinButton);
        ImageView profileButton = findViewById(R.id.profileButton);

        chatButton.setColorFilter(Color.argb(255, 225, 188, 145));


        homeButton.setOnClickListener(this);
        pointsButton.setOnClickListener(this);
        chatButton.setOnClickListener(this);
        calendarButton.setOnClickListener(this);
        checkinButton.setOnClickListener(this);
        profileButton.setOnClickListener(this);

        chatRecycler = (RecyclerView) findViewById(R.id.chatRecyclerView);
        chatRecycler.setLayoutManager(new LinearLayoutManager(this));

        mChat = new ArrayList<>();

        Chats chat = new chatScreen.Chats();
        chat.setChatMessage("Hello!");
        chat.setChatSender("Logan Hoelscher");
        mChat.add(chat);

        Chats chat1 = new chatScreen.Chats();
        chat1.setChatMessage("Hey! :D");
        chat1.setChatSender("Ashton Adams");
        mChat.add(chat1);

        Chats chat2 = new chatScreen.Chats();
        chat2.setChatMessage("Hey everybody Wave is cool!");
        chat2.setChatSender("Joseph Rangel");
        mChat.add(chat2);

        Chats chat3 = new chatScreen.Chats();
        chat3.setChatMessage("What new event is happening tonight?");
        chat3.setChatSender("Logan Hoelscher");
        mChat.add(chat3);

        Chats chat4 = new chatScreen.Chats();
        chat4.setChatMessage("Check the rewards page!");
        chat4.setChatSender("Joseph Rangel");
        mChat.add(chat4);

        Chats chat5 = new chatScreen.Chats();
        chat5.setChatMessage("I will see y'all at the UC!");
        chat5.setChatSender("Ashton Adams");
        mChat.add(chat5);

        Chats chat6 = new chatScreen.Chats();
        chat6.setChatMessage("See ya there.");
        chat6.setChatSender("Joseph Rangel");
        mChat.add(chat6);

        Chats chat7 = new chatScreen.Chats();
        chat7.setChatMessage("Did anybody due Capstone hw?");
        chat7.setChatSender("Logan Hoelscher");
        mChat.add(chat7);

        Chats chat8 = new chatScreen.Chats();
        chat8.setChatMessage("Nope...");
        chat8.setChatSender("Ashton Adams");
        mChat.add(chat8);

        chatRecycler.setAdapter(new ChatAdapter(mChat));

    }

    class ChatAdapter extends RecyclerView.Adapter<chatScreen.ChatViewHolder>{
        List<Chats> mChat;
        public ChatAdapter(List<Chats> chat) {
            super();
            this.mChat = chat;
        }

        @NonNull
        @Override
        public chatScreen.ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new chatScreen.ChatViewHolder(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull chatScreen.ChatViewHolder holder, int position) {
            holder.bind(this.mChat.get(position));
        }

        @Override
        public int getItemCount() {
            return this.mChat.size();
        }
    }

    class ChatViewHolder extends RecyclerView.ViewHolder{
        private TextView ChatMessage;
        private TextView ChatSender;
        public ChatViewHolder(ViewGroup container){
            super(LayoutInflater.from(chatScreen.this).inflate(R.layout.chat_tile, container, false));
            ChatMessage = (TextView) itemView.findViewById(R.id.ChatMessage);
            ChatSender = (TextView) itemView.findViewById(R.id.ChatSender);
        }
        public void bind(Chats chat){
            ChatMessage.setText(chat.getChatMessage());
            ChatSender.setText(chat.getChatSender());
        }
    }

    class Chats{
        private String chatMessage;
        private String chatSender;

        public String getChatMessage() {
            return chatMessage;
        }

        public void setChatMessage(String chatMessage) {
            this.chatMessage = chatMessage;
        }

        public String getChatSender() {
            return chatSender;
        }

        public void setChatSender(String chatSender) {
            this.chatSender = chatSender;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homeButton:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.pointsButton:
                Intent intent1 = new Intent(this, pointsScreen.class);
                startActivity(intent1);
                break;
            case R.id.chatButton:
                Intent intent2 = new Intent(this, chatScreen.class);
                startActivity(intent2);
                break;
            case R.id.calendarButton:
                Intent intent3 = new Intent(this, upcomingEvents.class);
                startActivity(intent3);
                break;
            case R.id.checkinButton:
                Intent intent4 = new Intent(this, eventCheckIn.class);
                startActivity(intent4);
                break;
            case R.id.profileButton:
                Intent intent5 = new Intent(this, profile.class);
                startActivity(intent5);
                break;
        }
    }
}