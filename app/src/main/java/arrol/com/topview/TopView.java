package arrol.com.topview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by User on 2016/3/14.
 */
public class TopView extends LinearLayout{

    ButtonListener listener;

    public TopView(Context context) {
        super(context);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public TopView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.topview, this);

        Button leftButton=(Button)findViewById(R.id.buttonLeft);
        Button rightButton=(Button)findViewById(R.id.buttonRight);
        TextView title=(TextView)findViewById(R.id.title);

        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.TopView);

        String leftButtonText=typedArray.getString(R.styleable.TopView_leftButtonText);
        int leftButtonTextColor=typedArray.getColor(R.styleable.TopView_leftButtonTextColor, 0);
        float leftButtonTextSize=typedArray.getDimension(R.styleable.TopView_leftButtonTextSize, 19);
        int leftButtonHeight=typedArray.getInteger(R.styleable.TopView_leftButtonHeight, 100);
        int leftButtonWidth=typedArray.getInteger(R.styleable.TopView_leftButtonWidth, 100);
        Drawable leftButtonBackground=typedArray.getDrawable(R.styleable.TopView_leftButtonBackground);


        String titleText=typedArray.getString(R.styleable.TopView_titleText);
        float titleTextSize=typedArray.getDimension(R.styleable.TopView_titleTextSize, 19);
        int titleTextColor=typedArray.getColor(R.styleable.TopView_titleTextColor, 0);

        String rightButtonText=typedArray.getString(R.styleable.TopView_rightButtonText);
        int rightButtonTextColor=typedArray.getColor(R.styleable.TopView_rightButtonTextColor, 0);
        float rightButtonTextSize=typedArray.getDimension(R.styleable.TopView_rightButtonTextSize, 19);
        int rightButtonHeight=typedArray.getInteger(R.styleable.TopView_rightButtonHeight, 100);
        int rightButtonWidth=typedArray.getInteger(R.styleable.TopView_rightButtonWidth, 100);
        Drawable rightButtonBackground=typedArray.getDrawable(R.styleable.TopView_rightButtonBackground);


        typedArray.recycle();

        LayoutParams leftParams;
        leftParams=(LayoutParams)leftButton.getLayoutParams();
        leftParams.width=leftButtonWidth;
        leftParams.height=leftButtonHeight;
        leftButton.setLayoutParams(leftParams);
        leftButton.setBackground(leftButtonBackground);
        leftButton.setTextSize(leftButtonTextSize);
        leftButton.setTextColor(leftButtonTextColor);
        leftButton.setText(leftButtonText);

        title.setText(titleText);
        title.setTextColor(titleTextColor);
        title.setTextSize(titleTextSize);

        LayoutParams rightParams;
        rightParams=(LayoutParams)rightButton.getLayoutParams();
        rightParams.width=rightButtonWidth;
        rightParams.height=rightButtonHeight;
        rightButton.setLayoutParams(rightParams);
        rightButton.setBackground(rightButtonBackground);
        rightButton.setTextSize(rightButtonTextSize);
        rightButton.setTextColor(rightButtonTextColor);
        rightButton.setText(rightButtonText);

        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onLeftClick();
            }
        });
        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onRightClick();
            }
        });
    }

    public TopView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public interface ButtonListener{
        void onLeftClick();
        void onRightClick();
    }

    //暴露一个方法
    public void setListener(ButtonListener listener){
        this.listener=listener;
    }
}
