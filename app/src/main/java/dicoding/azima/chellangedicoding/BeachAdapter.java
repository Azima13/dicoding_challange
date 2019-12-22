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

public class BeachAdapter extends RecyclerView.Adapter<BeachAdapter.BeachViewHolder> {

    private Context context;
    private ArrayList<Beach> listBeach;

    public ArrayList<Beach> getListBeach() {
        return listBeach;
    }

    public void setListBeach(ArrayList<Beach> listBeach) {
        this.listBeach = listBeach;
    }

    public BeachAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public BeachViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_beach, parent, false);
        return new BeachViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BeachViewHolder holder, int position) {
        Beach beach =getListBeach().get(position);
        Glide.with(context).load(beach.getImgPhoto()).apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);

        holder.tvTitle.setText(beach.getTitle());
        holder.tvDesc.setText(beach.getDesc());
    }

    @Override
    public int getItemCount() {
        return getListBeach().size();
    }

    public class BeachViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgPhoto;
        TextView tvTitle, tvDesc;
        public BeachViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto =itemView.findViewById(R.id.img_photo);
            tvTitle = itemView.findViewById(R.id.txt_title);
            tvDesc = itemView.findViewById(R.id.txt_desc);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Beach beach =getListBeach().get(position);

            beach.setTitle(beach.getTitle());
            beach.setDesc(beach.getDesc());


            Intent move =new Intent(itemView.getContext(), BeachDetail.class);
            move.putExtra(BeachDetail.EXTRA_BEACH, beach);
            context.startActivity(move);
        }
    }
}
