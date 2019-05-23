package com.example.turismmd_final.Fragmemts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.turismmd_final.Adapter.PostAdapter;
import com.example.turismmd_final.MainActivity;
import com.example.turismmd_final.Model.Point;
import com.example.turismmd_final.Model.PointsServiceListener;
import com.example.turismmd_final.R;
import com.example.turismmd_final.Repository.PointRepository;

import java.util.ArrayList;
import java.util.List;

public class AllPosts extends Fragment implements PointsServiceListener  {

    View rootView;
    private RecyclerView recyclerView;
    private PostAdapter postAdapter;
    PointRepository pointRepository;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView= inflater.inflate(R.layout.points_fragment,container,false);
        recyclerView = rootView.findViewById(R.id.RecyclerViewPosts);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        postAdapter = new PostAdapter(getActivity());
        recyclerView.setAdapter(postAdapter);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pointRepository = new PointRepository(this);
        pointRepository.GetPoints();
    }

    @Override
    public void onPonintsReceiver(List<Point> points) {
        postAdapter.updatePoint(points);
    }

    @Override
    public void onFailure() {

    }
}
