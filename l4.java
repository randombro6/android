public class MainActivity extends AppCompatActivity{
    protected void onCreate(Bundle ins){
        super.onCreate(ins);
        setContentView(R.layout.activity_main);

    }

    public void handleClick(View view) {
        EditText e1 = findViewById(R.id.t1);
        Uri uri = Uri.parse("tel:"+ e1.getText().toString());
        Intent abc = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(abc);
    }
}
