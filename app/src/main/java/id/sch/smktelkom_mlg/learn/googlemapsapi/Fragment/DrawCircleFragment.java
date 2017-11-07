package id.sch.smktelkom_mlg.learn.googlemapsapi.Fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

import id.sch.smktelkom_mlg.learn.googlemapsapi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrawCircleFragment extends Fragment implements OnMapReadyCallback {

    static final CameraPosition SGH = CameraPosition.builder()
            .target(new LatLng(-6.887088, 111.670994))
            .zoom(10)
            .bearing(0)
            .tilt(45)
            .build();
    GoogleMap m_map;
    boolean mapReady = false;
    LatLng sugihan = new LatLng(-6.884764, 111.675016);


    public DrawCircleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_draw_circle, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.moveCamera(CameraUpdateFactory.newCameraPosition(SGH));
        map.addCircle(new CircleOptions()
                .center(sugihan)
                .radius(1000)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(64, 0, 255, 0)));

    }
}
