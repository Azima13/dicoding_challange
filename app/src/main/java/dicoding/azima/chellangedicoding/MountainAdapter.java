package dicoding.azima.chellangedicoding;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MountainAdapter extends RecyclerView.Adapter<MountainAdapter.MountainHolder> {
    private Context context;
    private ArrayList<Mountain> listMountain;

    public ArrayList<Mountain> getListMountain() {
        return listMountain;
    }

    public void setListMountain(ArrayList<Mountain> listMountain) {
        this.listMountain = listMountain;
    }

    public MountainAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MountainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mountain, parent, false);
        return new MountainHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MountainHolder holder, int position) {
        Mountain mountain = getListMountain().get(position);
        Glide.with(context).load(mountain.getImgPhoto()).apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);

        holder.tvTitle.setText(mountain.getTitle());
        holder.tvDesc.setText(mountain.getDesc());
    }

    @Override
    public int getItemCount() {
        return getListMountain().size();
    }

    public class MountainHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPhoto;
        TextView tvTitle, tvDesc;
        public MountainHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_photo);
            tvTitle = itemView.findViewById(R.id.txt_title);
            tvDesc = itemView.findViewById(R.id.txt_desc);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Mountain mountain = getListMountain().get(position);

            mountain.setTitle(mountain.getTitle());
            mountain.setDesc(mountain.getDesc());


            Intent move =new Intent(itemView.getContext(), MountainDetail.class);
            move.putExtra(MountainDetail.EXTRA_MOUNTAIN, mountain);
            context.startActivity(move);
        }
    }
}
