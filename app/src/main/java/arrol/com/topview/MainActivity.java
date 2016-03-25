package arrol.com.topview;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    protected TopView topView;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topView=(TopView)findViewById(R.id.topView);
        //通过暴露的方法给View设上监听
        topView.setListener(new TopView.ButtonListener() {
            @Override
            public void onLeftClick() {
                Toast.makeText(MainActivity.this, "Back", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightClick() {

                Toast.makeText(MainActivity.this,"More",Toast.LENGTH_LONG).show();
            }
        });
    }
}
