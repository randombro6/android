public class MainActivity extends AppCompatActivity{
    protected void onCreate(Bundle ob){
        super.onCreate(ob);
        setContentView(R.layout.activity_main);
        
        WebView wv = findViewById(R.id.web);
        wv.loadUrl("url");

        ListView lv = findViewById(R.id.list);
        String countryList [] = getResources().getStringArray(R.array.country);

        ArrayAdapter<String> adap = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, countryList);
        lv.setAdapter(adap);

    }
}
