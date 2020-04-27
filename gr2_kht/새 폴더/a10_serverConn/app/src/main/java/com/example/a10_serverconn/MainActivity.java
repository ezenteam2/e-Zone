package com.example.a10_serverconn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("## @@@ 로그 출력 한번 해봄 ##", "시작킈!!!!!");
        //String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20200422";
        String url = "";
        request(url);
        TextView tv = findViewById(R.id.textViewxx);
        tv.setText("헬로우???????");
    }

    public void request(String urlS) {
        try {
            URL url = new URL(urlS);

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            if(conn != null) {
                conn.setConnectTimeout(10000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);

                int resCode = conn.getResponseCode();
                System.out.println("반응 코드값 : " + resCode);
                if(resCode == 200) {
                    System.out.println("## 서버에서 전송된 Stream 객체 ##");
                    System.out.println(conn.getInputStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    String line = "";
                    StringBuffer sb = new StringBuffer();
                    while((line = reader.readLine())!=null) {
                        Log.d("###JSON데이터###"+line);
                        sb.append(line);
                    }
                    tv = findViewById(R.id.textViewxx);
                    tv.setText(sb.toString());
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
