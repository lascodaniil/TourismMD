package com.example.turismmd_final.Model;

import java.util.ArrayList;
import java.util.List;

public interface PointsServiceListener {
    void onPonintsReceiver(List<Point> points);

    void onFailure();
}
