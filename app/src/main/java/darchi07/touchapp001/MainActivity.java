package darchi07.touchapp001;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    // X軸最低スワイプ距離
    private static final int SWIPE_MIN_DISTANCE = 50;

    // X軸最低スワイプスピード
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;

    // Y軸の移動距離　これ以上なら横移動を判定しない
    private static final int SWIPE_MAX_OFF_PATH = 250;

    // タッチイベントを処理するためのインタフェース
    private GestureDetector mGestureDetector;
    private Button button;
    private TextView textView1;
    private TextView textView2;
    public TextView textView3;
    public TextView textView4;
    ImageView imageView;
    String ges = "", output = "";
    private static final HashMap<String, String> map = new HashMap<String, String>(); //五十音表を格納
    static HashMap<Integer, String> mondai = new HashMap<>();//問題文格納
    int b1 = 10;
    int b2,b3,b4 = 10;
    int rend = 0;
    String keyboardsize = "small";

    static {
        map.put("00", "");
        map.put("01", "");
        map.put("02", "");
        map.put("03", "");

        map.put("04", "");
        map.put("05", "");
        map.put("06", "");
        map.put("07", "");

        map.put("40", "");
        map.put("41", "");
        map.put("42", "");
        map.put("43", "");

        map.put("44", "");
        map.put("45", "");
        map.put("46", "");
        map.put("47", "");

        map.put("54", "1");
        map.put("55", "2");
        map.put("56", "3");
        map.put("57", "4");

        map.put("64", "5");
        map.put("65", "6");
        map.put("66", "7");
        map.put("67", "8");

        map.put("74", "9");
        map.put("75", "0");
        map.put("76", "");
        map.put("77", "");

        map.put("50", "q");
        map.put("51", "w");
        map.put("52", "e");
        map.put("53", "r");

        map.put("60", "t");
        map.put("61", "y");
        map.put("62", "u");
        map.put("63", "i");

        map.put("70", "o");
        map.put("71", "p");
        map.put("72", "");
        map.put("73", "");

        map.put("14", "a");
        map.put("15", "s");
        map.put("16", "d");
        map.put("17", "f");

        map.put("24", "g");
        map.put("25", "h");
        map.put("26", "j");
        map.put("27", "k");

        map.put("30", "");
        map.put("31", "");
        map.put("32", "");
        map.put("33", "");

        map.put("34", "l");
        map.put("35", "");
        map.put("36", "");
        map.put("37", "");

        map.put("10", "");
        map.put("11", "z");
        map.put("12", "x");
        map.put("13", "c");

        map.put("20", "v");
        map.put("21", "b");
        map.put("22", "n");
        map.put("23", "m");


    }

    static {

        mondai.put(1, "add");
        mondai.put(2, "length");
        mondai.put(3, "play");
        mondai.put(4, "design");
        mondai.put(5, "end");
        mondai.put(6, "value");
        mondai.put(7, "earth");
        mondai.put(8, "test");
        mondai.put(9, "dentsu");
        mondai.put(10, "vote");
        mondai.put(11, "hat");
        mondai.put(12, "italab");
        mondai.put(13, "computer");
        mondai.put(14, "access");
        mondai.put(15, "sit");
        mondai.put(16, "alarm");
        mondai.put(17, "sea");
        mondai.put(18, "teach");
        mondai.put(19, "long");
        mondai.put(20, "put");
        mondai.put(21, "string");
        mondai.put(22, "glance");
        mondai.put(23, "click");
        mondai.put(24, "list");
        mondai.put(25, "happy");
        mondai.put(26, "wear");
        mondai.put(27, "peach");
        mondai.put(28, "rock");
        mondai.put(29, "lock");
        mondai.put(30, "up");
        mondai.put(31, "apple");
        mondai.put(32, "cost");
        mondai.put(33, "apply");
        mondai.put(34, "prove");
        mondai.put(35, "skill");
        mondai.put(36, "sense");
        mondai.put(37, "power");
        mondai.put(38, "sort");
        mondai.put(39, "view");
        mondai.put(40, "war");
        mondai.put(41, "amuse");
        mondai.put(42, "loss");
        mondai.put(43, "gaze");
        mondai.put(44, "blink");
        mondai.put(45, "life");
        mondai.put(46, "class");
        mondai.put(47, "jam");
        mondai.put(48, "exact");
        mondai.put(49, "short");
        mondai.put(50, "odd");
        mondai.put(51, "zman");
        mondai.put(52, "diet");
        mondai.put(53, "joy");
        mondai.put(54, "luck");
        mondai.put(55, "pain");
        mondai.put(56, "egg");
        mondai.put(57, "dog");
        mondai.put(58, "door");
        mondai.put(59, "milk");
        mondai.put(60, "box");
        mondai.put(61, "watch");
        mondai.put(62, "map");
        mondai.put(63, "lemon");
        mondai.put(64, "hard");
        mondai.put(65, "camera");
        mondai.put(66, "tree");
        mondai.put(67, "fish");
        mondai.put(68, "town");
        mondai.put(69, "time");
        mondai.put(70, "house");
        mondai.put(71, "room");
        mondai.put(72, "meal");
        mondai.put(73, "sky");
        mondai.put(74, "farm");
        mondai.put(75, "people");
        mondai.put(76, "cloud");
        mondai.put(77, "game");
        mondai.put(78, "music");
        mondai.put(79, "lie");
        mondai.put(80, "cat");
        mondai.put(81, "jr");
        mondai.put(82, "video");
        mondai.put(83, "ice");
        mondai.put(84, "part");
        mondai.put(85, "key");
        mondai.put(86, "bell");
        mondai.put(87, "fool");
        mondai.put(88, "side");
        mondai.put(89, "snow");
        mondai.put(90, "food");
        mondai.put(91, "answer");
        mondai.put(92, "love");
        mondai.put(93, "care");
        mondai.put(94, "king");
        mondai.put(95, "space");
        mondai.put(96, "cut");
        mondai.put(97, "become");
        mondai.put(98, "lend");
        mondai.put(99, "low");
        mondai.put(100, "few");
        mondai.put(101, "2015");
        mondai.put(102, "exist");
        mondai.put(103, "miss");
        mondai.put(104, "marry");
        mondai.put(105, "mean");
        mondai.put(106, "no");
        mondai.put(107, "2016");
        mondai.put(108, "enter");
        mondai.put(109, "hold");
        mondai.put(110, "noon");
        mondai.put(111, "not");
        mondai.put(112, "me");
        mondai.put(113, "mine");
        mondai.put(114, "sing");
        mondai.put(115, "catch");
        mondai.put(116, "none");
        mondai.put(117, "what");
        mondai.put(118, "chance");
        mondai.put(119, "east");
        mondai.put(120, "north");
        mondai.put(121, "1234");
        mondai.put(122, "able");
        mondai.put(123, "touch");
        mondai.put(124, "west");
        mondai.put(125, "south");
        mondai.put(126, "5678");
        mondai.put(127, "where");
        mondai.put(128, "young");
        mondai.put(129, "ill");
        mondai.put(130, "today");
        mondai.put(131, "men");
        mondai.put(132, "man");
        mondai.put(133, "new");
        mondai.put(134, "now");
        mondai.put(135, "yes");
        mondai.put(136, "9012");
        mondai.put(137, "bill");
        mondai.put(138, "dance");
        mondai.put(139, "know");
        mondai.put(140, "corn");
        mondai.put(141, "fox");
        mondai.put(142, "hall");
        mondai.put(143, "bomb");
        mondai.put(144, "japan");
        mondai.put(145, "god");
        mondai.put(146, "date");
        mondai.put(147, "fill");
        mondai.put(148, "quiz");
        mondai.put(149, "list");
        mondai.put(150, "gas");
        mondai.put(151, "knock");
        mondai.put(152, "3456");
        mondai.put(153, "holy");
        mondai.put(154, "beach");
        mondai.put(155, "lazy");
        mondai.put(156, "hello");
        mondai.put(157, "crazy");
        mondai.put(158, "7890");
        mondai.put(159, "and");
        mondai.put(160, "when");
        mondai.put(161, "while");
        mondai.put(162, "ever");
        mondai.put(163, "alone");
        mondai.put(164, "once");
        mondai.put(165, "then");
        mondai.put(166, "on");
        mondai.put(167, "off");
        mondai.put(168, "never");
        mondai.put(169, "just");
        mondai.put(170, "still");
        mondai.put(171, "pen");
        mondai.put(172, "campus");
        mondai.put(173, "indeed");
        mondai.put(174, "all");
        mondai.put(175, "long");
        mondai.put(176, "raw");
        mondai.put(177, "cute");
        mondai.put(178, "wet");
        mondai.put(179, "close");
        mondai.put(180, "monkey");
        mondai.put(181, "quick");
        mondai.put(182, "wild");
        mondai.put(183, "blow");
        mondai.put(184, "share");
        mondai.put(185, "select");
        mondai.put(186, "plate");
        mondai.put(187, "yen");
        mondai.put(188, "smell");
        mondai.put(189, "can");
        mondai.put(190, "order");
        mondai.put(191, "gray");
        mondai.put(192, "red");
        mondai.put(193, "cent");
        mondai.put(194, "menu");
        mondai.put(195, "center");
        mondai.put(196, "net");
        mondai.put(197, "bowl");
        mondai.put(198, "lip");
        mondai.put(199, "poem");
        mondai.put(200, "gram");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGestureDetector = new GestureDetector(this, mOnGestureListener);
        setContentView(R.layout.activity_main);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        if (keyboardsize == "small") {
            rend = 300;
            b1 = 500;
            b2 = 700;
            b3 = 900;
            b4 = 1100;
        }

    }

    // タッチイベント
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return mGestureDetector.onTouchEvent(event);
    }

    private final GestureDetector.SimpleOnGestureListener mOnGestureListener = new GestureDetector.SimpleOnGestureListener() {

        // フリックイベント
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {

            try {

                // 移動距離・スピードを出力
                float distance_y = Math.abs((event1.getY() - event2.getY()));
                float velocity_y = Math.abs(velocityY);
                textView1.setText("縦の移動距離:" + distance_y + " 縦の移動スピード:" + velocity_y);
                if (event1.getY() >= 1400) {
                    // Y軸の移動距離が大きすぎる場合
                    if (Math.abs(event1.getX() - event2.getX()) > SWIPE_MAX_OFF_PATH) {
                        textView2.setText("横の移動距離が大きすぎ");
                    }
                    // 開始位置から終了位置の移動距離が指定値より大きい
                    // Y軸の移動速度が指定値より大きい
                    else if (event1.getY() - event2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                        textView2.setText("下から上" + event1.getX());
                        if (event1.getX() <= b1 && event1.getX() >= rend) {

                            ges = ges + "4";
                            textView3.setText("ボタン1" + ges);
                        } else if (event1.getX() >= b1 && event1.getX() <= b2) {

                            ges = ges + "5";
                            textView3.setText("ボタン2" + ges);

                        } else if (event1.getX() >= b2 && event1.getX() <= b3) {

                            ges = ges + "6";
                            textView3.setText("ボタン3" + ges);
                        } else if (event1.getX() >= b3 && event1.getX() <= b4) {

                            ges = ges + "7";
                            textView3.setText("ボタン4" + ges);
                        }
                        sub(ges);

                    }
                    // 終了位置から開始位置の移動距離が指定値より大きい
                    // Y軸の移動速度が指定値より大きい
                    else if (event2.getY() - event1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                        textView2.setText("上から下" + event1.getX());
                        if (event1.getX() <= b1 && event1.getX() >= rend) {

                            ges = ges + "0";
                            textView3.setText("ボタン1" + ges);
                        } else if (event1.getX() >= b1 && event1.getX() <= b2) {

                            ges = ges + "1";
                            textView3.setText("ボタン2" + ges);
                        } else if (event1.getX() >= b2 && event1.getX() <= b3) {
                            ges = ges + "2";
                            textView3.setText("ボタン3" + ges);


                        } else if (event1.getX() >= b3 && event1.getX() <= b4) {
                            ges = ges + "3";

                            textView3.setText("ボタン4" + ges);

                        }
                        sub(ges);
                    }
                }
            } catch (Exception e) {
                // TODO
            }

            return false;
        }
    };

    public void sub(String sub) {

        if (ges.length() == 2) {
            output = output + map.get(sub);
            textView4.setText(output);
            imageView.setBackgroundResource(R.drawable.design01);
            ges = "";
        } else if (ges.length() == 1) {

            switch (sub) {
                case "0":
                    Log.v("", "");
                    imageView.setBackgroundResource(R.drawable.design010);
                    break;
                case "1":
                    imageView.setBackgroundResource(R.drawable.design011);
                    break;
                case "2":
                    imageView.setBackgroundResource(R.drawable.design012);
                    break;
                case "3":
                    imageView.setBackgroundResource(R.drawable.design013);
                    break;
                case "4":
                    imageView.setBackgroundResource(R.drawable.design014);
                    break;
                case "5":
                    imageView.setBackgroundResource(R.drawable.design015);
                    break;
                case "6":
                    imageView.setBackgroundResource(R.drawable.design016);
                    break;
                case "7":
                    imageView.setBackgroundResource(R.drawable.design017);
                    break;

            }

        }

    }


    @Override
    public void onClick(View v) {

        if(v==button){
            Intent intent = new Intent(this, design01.class);
            startActivityForResult(intent, 0);
        }
    }


}
