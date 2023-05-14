package com.example.recyclingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ChatFragment extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView txtWelcome;
    EditText edtMessage;
    ImageButton btnSend;
    List<HelperClass> messageList;
    MessageAdapter messageAdapter;
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_fragment);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.chat_rv);
        txtWelcome = findViewById(R.id.txtWelcome);
        edtMessage = findViewById(R.id.message_edit_text);
        btnSend = findViewById(R.id.send_btn);

        messageList = new ArrayList<>();
        //Send message to recyclerView
        messageAdapter = new MessageAdapter(messageList);
        recyclerView.setAdapter(messageAdapter);
        LinearLayoutManager LlayoutManager = new LinearLayoutManager(this);
        LlayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(LlayoutManager);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = edtMessage.getText().toString().trim();
                addToChat(question,HelperClass.SENT_BY_ME);
                apiCaller(question);
                edtMessage.setText("");
                txtWelcome.setVisibility(View.GONE);
            }
        });

        ImageView dashbaordBttn = findViewById(R.id.dashboard_button);
        dashbaordBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatFragment.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }

    void addToChat(String message, String sentby){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messageList.add(new HelperClass(message, sentby));
                messageAdapter.notifyDataSetChanged();
                recyclerView.smoothScrollToPosition(messageAdapter.getItemCount());
            }
        });
    }

    void addResponse(String response){
        messageList.remove(messageList.size()-1);
        addToChat(response, HelperClass.SENT_BY_BOT);
    }

    void apiCaller(String question){
        messageList.add(new HelperClass("Typing...", HelperClass.SENT_BY_BOT));
        JSONObject objectJSON = new JSONObject();
        try {
            objectJSON.put("model", "gpt-3.5-turbo");
            JSONArray msgArr = new JSONArray();
            JSONObject obj = new JSONObject();
            obj.put("role", "user");
            obj.put("content", question);
            msgArr.put(obj);

            objectJSON.put("messages", msgArr);
        }catch (JSONException e){
            throw new RuntimeException(e);
        }

        RequestBody body = RequestBody.create(objectJSON.toString(), JSON);
        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/chat/completions")
                .header("Authorization", "Bearer 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")
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

                addResponse("Failure To Load Response" + e.getMessage());


            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                if (response.isSuccessful()){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        JSONArray jsonArray = null;
                        jsonArray = jsonObject.getJSONArray("choices");
                        String result = jsonArray.getJSONObject(0)
                                .getJSONObject("message")
                                .getString("content");
                        addResponse(result.trim());
                    }catch(JSONException e){
                        throw new RuntimeException(e);
                    }
                }else {
                    addResponse("Failed Response Due to" + response.body().string());
                }

            }
        });

    }
}