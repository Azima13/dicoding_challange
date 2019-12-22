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
public class BeachFragment extends Fragment {

    private RecyclerView rvCategory;
    private ArrayList<Beach> list = new ArrayList<>();

    public BeachFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_beach, container, false);
        rvCategory = v.findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(BeachData.getLisrData());
        showRecyclerBeach();
        return v;
    }

    private void showRecyclerBeach() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this.getContext()));
        BeachAdapter ma = new BeachAdapter(this.getContext());
        ma.setListBeach(list);
        rvCategory.setAdapter(ma);
    }

}
