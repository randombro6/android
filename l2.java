public class MainActivity extends AppCompatActivity{
    protected void onCreate(Bundle ob){
        super.onCreate(ob);
        setContentView(R.layout.activity_main);

        WebView wv = findViewById(R.id.web);
        wv.loadUrl("https://www.facebook.com");


        ListView lv = findViewById(R.id.list);
        String cList [] = getResources().getStringArray(R.array.countryList);
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, cList);
        lv.setAdapter(ad);

    }
}
