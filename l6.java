public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    int forwardTime = 5000;
    int backwardTime = 5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.song);
    }

    public void onPlay(View view) {
        Toast.makeText(getApplicationContext(), "Playing Song", Toast.LENGTH_LONG).show();
        mediaPlayer.start();
    }

    public void onPause(View view) {
        Toast.makeText(getApplicationContext(), "Pausing Song", Toast.LENGTH_LONG).show();
        mediaPlayer.pause();
    }

    public void onRestart(View view) {
        Toast.makeText(getApplicationContext(), "Restarting Song", Toast.LENGTH_LONG).show();
        mediaPlayer.seekTo(0);
        mediaPlayer.start();
    }

    public void onStop(View view) {
        Toast.makeText(getApplicationContext(), "Stopping Song", Toast.LENGTH_LONG).show();
        mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(this, R.raw.song);
    }

    public void onRewind(View view) {
        int currentPos = mediaPlayer.getCurrentPosition();
        if ((currentPos - backwardTime) >= 0) {
            mediaPlayer.seekTo(currentPos - backwardTime);
        }
    }

    public void onForward(View view) {
        int currentPos = mediaPlayer.getCurrentPosition();
        if ((currentPos + forwardTime) <= mediaPlayer.getDuration()) {
            mediaPlayer.seekTo(currentPos + forwardTime);
        }
    }
}
