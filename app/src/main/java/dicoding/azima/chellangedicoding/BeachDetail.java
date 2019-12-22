package dicoding.azima.chellangedicoding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class BeachDetail extends AppCompatActivity {
    public final static String EXTRA_BEACH = "extra_beach";
    TextView tTitle, tDesc;

    ImageView imgPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beach_detail);

        tTitle = findViewById(R.id.txt_title);
        tDesc = findViewById(R.id.txt_desc);
        imgPoster = findViewById(R.id.img_photo);

        Beach beach = getIntent().getParcelableExtra(EXTRA_BEACH);

        tTitle.setText(beach.getTitle());
        tDesc.setText(beach.getDesc());

        Glide.with(this).load(beach.getImgPhoto()).apply(new RequestOptions().override(350, 550))
                .into(imgPoster);



    }
}
