package nnk.com.inventrom;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GraphhActivity extends AppCompatActivity
{
  Button button;
    SeekBar seek;
    GraphView graph;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphh);
        button=(Button)findViewById(R.id.button);
        seek = (SeekBar) findViewById(R.id.sb);
        graph = (GraphView) findViewById(R.id.graph);
/**
 * created a line graph object
 * added a series of points in line graph
 * set background color blue
 */
        final LineGraphSeries<DataPoint> series = new LineGraphSeries<>(getDataPoint());
        graph.addSeries(series);
        series.setThickness(10);
        series.setDrawBackground(true);
        series.setBackgroundColor(Color.BLUE);
        seek.setProgress(Color.GRAY);
        /**
         * Created a seebar Listner
         * created anonymous class inside that
         * when we touch seekbar it will move with color using method onProgressChanged
         */
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                /**
                 * series.setBackgroundColor(Color.BLUE);
                 * seek.setProgress(0);
                 */
                   // series.setDrawBackground(true);
                    series.setBackgroundColor(Color.rgb(0,0,progress+50));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    private DataPoint[] getDataPoint() {
        /**
         * Created a data point object for plotting numbers in graph
         */
        DataPoint[] dp = new DataPoint[]
                {
                        new DataPoint(0, 0),
                        new DataPoint(1, 1),
                        new DataPoint(2, 2),
                        new DataPoint(3, 3),
                        new DataPoint(4, 4),
                        new DataPoint(5, 5),
                        new DataPoint(6, 6),
                        new DataPoint(7, 7),
                        new DataPoint(8, 8)
                };
        return (dp);
    }
    //here we simpally goes to main activity class using Intent

    public void reset(View v)
    {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        }
    }
