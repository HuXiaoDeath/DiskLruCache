package cn.duan.cn.disklru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mText;
    DiskLruCacheHelper mDiskHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = (Button) findViewById(R.id.textPi);
        mText.setOnClickListener(this);

        mDiskHelp = DiskLruCacheHelper.getDiskHelpInstnce(this);
        mDiskHelp.put("text","我积分的开始觉得发卡");


        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {

                Toast.makeText(getApplicationContext()," decorView ",Toast.LENGTH_SHORT).show();
            }
        });

        mText.post(new Runnable() {
            @Override
            public void run() {

                Toast.makeText(getApplicationContext()," mText ",Toast.LENGTH_SHORT).show();
            }
        });



    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textPi:
                String text = mDiskHelp.getAsString("text");
                mText.setText(text);

                break;
        }
    }
}
