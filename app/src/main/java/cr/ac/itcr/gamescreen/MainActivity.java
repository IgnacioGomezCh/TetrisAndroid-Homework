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
        GridLayout board = findViewById(R.id.boardLayout);


        //Get screen size
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;

        int cellSize =  (width - 16)/12 - 1;//board.getWidth();
        for(int i = 0; i<288; i++) {
            View img = new View(this);

            img.setLayoutParams(new ViewGroup.LayoutParams(cellSize, cellSize));
            if (i % 24 == 23 || i % 12 == 0 || i < 11)
                img.setBackgroundColor(Color.GRAY);
            else
                img.setBackgroundColor(Color.BLACK);
            board.addView(img, i);

        }

        View pieceCreator = new View(this);
        pieceCreator.setLayoutParams(new ViewGroup.LayoutParams(cellSize, cellSize));
        pieceCreator.setBackgroundColor(Color.RED);
        board.addView(pieceCreator, 148);


        System.out.println("------------------------" + (11%12));


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
