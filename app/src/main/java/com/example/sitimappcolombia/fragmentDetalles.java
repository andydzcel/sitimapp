package com.example.sitimappcolombia;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sitimappcolombia.dao.LugaresDAO;
import com.example.sitimappcolombia.modelos.Lugares;
import com.example.sitimappcolombia.viewmodels.LugarViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentDetalles#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentDetalles extends DialogFragment {

    TextView txtNombreSitio, txtDescripcion, txtCategoria, txtLatitud, txtLongitud;
    TextView txt7, txt10, txt13, txt16;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "id_lug";

    // TODO: Rename and change types of parameters
    private int id_lug;

    public fragmentDetalles() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment fragmentDetalles.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentDetalles newInstance(int param1) {
        fragmentDetalles fragment = new fragmentDetalles();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            id_lug = getArguments().getInt(ARG_PARAM1);

        }

        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.ThemeOverlay_Material_Dialog_Alert);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista =inflater.inflate(R.layout.fragment_detalles, container, false);

        LugaresDAO lugardb = new LugaresDAO(vista.getContext());
        Lugares sitio = lugardb.obtenerLugares(id_lug);

        txtNombreSitio = (TextView) vista.findViewById(R.id.txt_fragment_NombreSitio);
        txtDescripcion = (TextView) vista.findViewById(R.id.txt_fragment_Descripcion);
        txtCategoria = (TextView) vista.findViewById(R.id.txt_fragment_Categoria);
        txtLatitud = (TextView) vista.findViewById(R.id.txt_fragment_Latitud);
        txtLongitud = (TextView) vista.findViewById(R.id.txt_fragment_Longitud);
        Button btnmapa= (Button) vista.findViewById(R.id.btn_fragment_detalles_verenmapa);

        txtNombreSitio.setText(sitio.getNombre());
        txtDescripcion.setText(sitio.getDescripcion());
        txtCategoria.setText(sitio.getCategoria());
        txtLatitud.setText(String.valueOf(sitio.getLatitud()));
        txtLongitud.setText(String.valueOf(sitio.getLongitud()));

        txt7 = (TextView) vista.findViewById(R.id.textView7);
        txt10 = (TextView) vista.findViewById(R.id.textView10);
        txt13 = (TextView) vista.findViewById(R.id.textView13);
        txt16 = (TextView) vista.findViewById(R.id.textView16);

        txt7.setText("Descripción:");
        txt10.setText("Categoría:");
        txt13.setText("Latitud:");
        txt16.setText("Longitud:");

        btnmapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LugaresDAO lugardb = new LugaresDAO(vista.getContext());
                Lugares sitio = lugardb.obtenerLugares(id_lug);
 //               sitio.getLatitud();
 //               sitio.getLongitud();

                Intent i = new Intent(v.getContext(),activity_map.class);
                i.putExtra("nombre", sitio.getNombre());
                i.putExtra("latitud", sitio.getLatitud());
                i.putExtra("longitud", sitio.getLongitud());
                startActivity(i);
//                fragmentMap.newInstance(sitio.getNombre(), sitio.getLatitud(), sitio.getLongitud()).show(getChildFragmentManager(), null);
           }
        });

        return vista;
    }
}