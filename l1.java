

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToast("Activity Created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast("Activity Started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("Activity Stopped");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showToast("Activity Paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showToast("Activity Resumed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("Activity Destroyed");
    }


     void showToast(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
