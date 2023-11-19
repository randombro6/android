public class MainActivity extends AppCompatActivity{
    protected void onCreate(Bundle ins){
        super.onCreate(ins);
        setContentView(R.layout.activity_main);

    }

    public void handleClick(View view) {
        EditText e1 = findViewById(R.id.t1);
        EditText e2 = findViewById(R.id.t2);

        int a = Integer.parseInt(e1.getText().toString());
        int b = Integer.parseInt(e2.getText().toString());

        int c = a+b;

        Intent abc = new Intent(MainActivity.this, MainActivity2.class);
        Bundle bu = new Bundle();
        bu.putString("sum", Integer.toString(c));
        abc.putExtras(bu);
        startActivity(abc);
    }
}

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String sum = getIntent().getStringExtra("sum");
        TextView tv = findViewById(R.id.tv);

        tv.setText(sum);
    }

}
