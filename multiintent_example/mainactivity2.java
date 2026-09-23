import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView a1,a2;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        a1 = findViewById(R.id.textView);
        a2 = findViewById(R.id.textView2);
        b = findViewById(R.id.button2);

        Bundle extra = getIntent().getExtras();
        String text = extra.getString("name");
        String text1 = extra.getString("age");
        a1.setText(text);
        a2.setText(text1);
    }
public void Click(View view){
Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
startActivity(intent);
    }
    }
