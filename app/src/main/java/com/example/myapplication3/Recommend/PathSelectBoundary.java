package com.example.myapplication3.Recommend;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication3.Login.MainActivity;
import com.example.myapplication3.MyPage.MyPageSelectMenu;
import com.example.myapplication3.R;
import com.example.myapplication3.Shopping.ShoppingActivity;

public class PathSelectBoundary extends AppCompatActivity {
    private String id;
    private String pw;

    private Button path1;
    private Button path2;

    @Override
    public boolean onCreateOptionsMenu(Menu menu)//옵션 메뉴바
    {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.mainmenu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item)//메뉴 선택
    {
        //   Toast toast = Toast.makeText(getApplicationContext(),"", Toast.LENGTH_LONG);
        int state=3;
        switch(item.getItemId())
        {
            case R.id.menu1:
                state=0;
                break;
            case R.id.menu2:
                state=1;
                break;

        }
        if(state==0){
            Intent intent = new Intent(// 다음 화면으로 전환
                    PathSelectBoundary.this,
                    MyPageSelectMenu.class);
            intent.putExtra("id",id);
            intent.putExtra("pw",pw);

            startActivity(intent);
        }
        else if(state==1){
            Toast.makeText(PathSelectBoundary.this,"로그아웃되었습니다.",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(// 다음 화면으로 전환
                    PathSelectBoundary.this,
                    MainActivity.class);

            startActivity(intent);

        }


        return super.onOptionsItemSelected(item);
    }//옵션메뉴

    protected void onCreate(Bundle saveInstanceState){

        super.onCreate(saveInstanceState);
        //setContentView(R.layout.select_path);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        pw = intent.getStringExtra("pw");

        path1 = (Button) findViewById(R.id.sin_yeoju);
        path2 = (Button) findViewById(R.id.sin_busan);

    }

    public void onClick1(View v){
        // 디비에 선택한 패스 저장
        System.out.println( ); //현재패스 찍어보기
        Next();
    }

    public void Next(){
        Intent intent = new Intent(// 다음 화면으로 전환
                PathSelectBoundary.this,
                ShoppingActivity.class); //쇼핑 액티비티로 이동
        intent.putExtra("id",id);
        intent.putExtra("pw",pw);

        startActivity(intent);

    }



}
