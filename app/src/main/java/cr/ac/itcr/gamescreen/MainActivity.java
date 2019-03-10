package cr.ac.itcr.gamescreen;

import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        Log.e("Width", "sxsx");
        GridLayout board = findViewById(R.id.boardLayout);


        //Get screen size
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        Log.e("Width", "" + width);
        Log.e("height", "" + height);


        int cellSize =  40;//board.getWidth();
        for(int i = 0; i<288; i++) {
            View img = new View(this);

            img.setLayoutParams(new ViewGroup.LayoutParams(cellSize, cellSize));
            if(i%2==0)
                img.setBackgroundColor(Color.CYAN);
            else
                img.setBackgroundColor(Color.RED);
            board.addView(img, i);
        }
        /*
        int count = board.getChildCount();
        System.out.println(count);
        for(int i = 0; i<count; i++){
            //ImageView v = (ImageView) board.getChildAt(i);
            //if (i == 0){
                //v.setImageResource(R.drawable.aqua);
                board.getChildAt(i).setBackgroundColor(Color.BLUE);
                System.out.println(i);
            //}
        }*/
    }

    public void fillBackground(){

    }
    
}
