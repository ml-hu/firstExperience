package swu.hmliang.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView text;
    String[]names = {"张三","李四","王五","李六"};
    //定时器每隔一段时间切换一次名字
    Timer timer = new Timer();
    //创建定时器
    TimerTask task;
    int index = 0;
    //创建索引值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        btn = findViewById(R.id.mStartBtn);
        text = findViewById(R.id.mNameTextView);
        text.setText(names[index]);
        //给按纽添加点击事件
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn.getText().toString() == "Start"){
                    btn.setText("Stop");
                    //初始化计时器任务
                    task = new TimerTask() {
                        @Override
                        public void run() {
                            if(index>names.length-1){
                                index = 0;
                            }else{
                                index++;

                            }
                            text.setText(names[index]);
                        }
                    };
                    //分配一个定时任务
                    timer.schedule(task,0,100);
                }else{
                    btn.setText("Start");
                    timer.cancel();
                }
            }
        });


    }
}
