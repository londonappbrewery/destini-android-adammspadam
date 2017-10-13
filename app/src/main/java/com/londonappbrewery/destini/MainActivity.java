package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mAns1Button;
    Button mAns2Button;
    int mStoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mAns1Button = (Button) findViewById(R.id.buttonTop);
        mAns2Button = (Button) findViewById(R.id.buttonBottom);
        mStoryIndex = 1;


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mAns1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1 || mStoryIndex == 2) {
                    setStory(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2);
                    mStoryIndex = 3;
                } else {
                    setStoryEnd(R.string.T6_End);
                }
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mAns2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1) {
                    setStory(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2);
                    mStoryIndex = 2;
                } else if (mStoryIndex == 3) {
                    setStoryEnd(R.string.T5_End);
                } else {
                    setStoryEnd(R.string.T4_End);
                }
            }
        });

    }

    private void setStory(int storyTextResID, int storyAns1ResID, int storyAns2ResID) {
        mStoryTextView.setText(storyTextResID);
        mAns1Button.setText(storyAns1ResID);
        mAns2Button.setText(storyAns2ResID);
    }

    private void setStoryEnd(int storyEndResID) {
        mStoryTextView.setText(storyEndResID);
        mAns1Button.setVisibility(View.GONE);
        mAns2Button.setVisibility(View.GONE);
    }
}
