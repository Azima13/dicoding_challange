package dicoding.azima.chellangedicoding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MountainDetail extends AppCompatActivity {
    public final static String EXTRA_MOUNTAIN = "extra_mountain";
    private TextView tTitle, tDesc;

    private ImageView imgPoster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mountain_detail);

        tTitle = findViewById(R.id.txt_title);
        tDesc = findViewById(R.id.txt_desc);

        imgPoster = findViewById(R.id.img_photo);

        Mountain mountain = getIntent().getParcelableExtra(EXTRA_MOUNTAIN);

        tTitle.setText(mountain.getTitle());
        tDesc.setText(mountain.getDesc());

        Glide.with(this)
                .load(mountain.getImgPhoto()).apply(new RequestOptions().override(350, 550))
                .into(imgPoster);
    }
}
