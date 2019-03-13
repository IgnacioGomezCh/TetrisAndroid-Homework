package cr.ac.itcr.gamescreen;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int[][] gameBoard = new int[22][10];

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        GridLayout board = findViewById(R.id.boardLayout);

        //Starts the gameboard with 0 on all cells
        //startBoard();

        //Get screen size
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        board.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            public void onSwipeTop() {
                Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeLeft() {
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeBottom() {
                Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }
        });


        int cellSize =  (width - 16)/12 - 1;//board.getWidth();



        for(int i = 0; i<288; i++) {
            View img = new View(this);
            img.setLayoutParams(new ViewGroup.LayoutParams(cellSize, cellSize));
            board.addView(img, i);
        }



        final View pieceCreator1 = new View(this);
        pieceCreator1.setLayoutParams(new ViewGroup.LayoutParams(cellSize, cellSize));
        pieceCreator1.setBackgroundColor(Color.RED);
        final View pieceCreator2 = new View(this);
        pieceCreator2.setLayoutParams(new ViewGroup.LayoutParams(cellSize, cellSize));
        pieceCreator2.setBackgroundColor(Color.RED);
        final View pieceCreator3 = new View(this);
        pieceCreator3.setLayoutParams(new ViewGroup.LayoutParams(cellSize, cellSize));
        pieceCreator3.setBackgroundColor(Color.RED);
        final View pieceCreator4 = new View(this);
        pieceCreator4.setLayoutParams(new ViewGroup.LayoutParams(cellSize, cellSize));
        pieceCreator4.setBackgroundColor(Color.RED);
        board.removeViewAt(14);
        board.addView(pieceCreator1, 14);
        board.removeViewAt(15);
        board.addView(pieceCreator2, 15);
        board.removeViewAt(25);
        board.addView(pieceCreator3, 25);
        board.removeViewAt(26);
        board.addView(pieceCreator4, 26);
        Thread piece1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator animation = ObjectAnimator.ofFloat(pieceCreator1, "translationY", 10000f);
                animation.setDuration(10000);
                animation.start();
            }
        });
        Thread piece2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator animation = ObjectAnimator.ofFloat(pieceCreator2, "translationY", 10000f);
                animation.setDuration(10000);
                animation.start();
            }
        });
        Thread piece3 = new Thread(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator animation = ObjectAnimator.ofFloat(pieceCreator3, "translationY", 10000f);
                animation.setDuration(10000);
                animation.start();
            }
        });
        Thread piece4 =new Thread(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator animation = ObjectAnimator.ofFloat(pieceCreator4, "translationY", 10000f);
                animation.setDuration(10000);
                animation.start();
            }
        });

        piece1.run(); piece2.run(); piece3.run(); piece4.run();


    }

    private boolean startBoard(){
        try {
            for (int i = 0; i < 22; i++)
                for (int j = 0; j < 10; j++)
                    gameBoard[i][j] = 0;
            return true;
        }catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    private void printMatrix(){
        String row = "";
        for(int i = 0; i<22; i++) {
            row = "";
            for (int j = 0; j < 10; j++) {
                row += gameBoard[i][j] + " ";
            }
            System.out.println(row);
        }

    }
}
