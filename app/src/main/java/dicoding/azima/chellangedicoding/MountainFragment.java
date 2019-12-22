package dicoding.azima.chellangedicoding;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MountainFragment extends Fragment {

    private RecyclerView rvMountain;
    private ArrayList<Mountain> list = new ArrayList<>();

    public MountainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mountain, container, false);
        rvMountain = v.findViewById(R.id.rv_mountain);
        rvMountain.setHasFixedSize(true);

        list.addAll(MountainData.getListData());

        showRecyclerMountain();

        return v;
    }

    private void showRecyclerMountain() {
        rvMountain.setLayoutManager(new LinearLayoutManager(this.getContext()));
        MountainAdapter ma = new MountainAdapter(this.getContext());
        ma.setListMountain(list);
        rvMountain.setAdapter(ma);
    }

}
