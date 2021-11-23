package com.example.sitimappcolombia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.example.sitimappcolombia.modelos.Lugares;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentDetalles#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentDetalles extends Fragment {

    TextView txtNombreSitio, txtDescripcion, txtCategoria, txtLatitud, txtLongitud;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragmentDetalles() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentDetalles.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentDetalles newInstance(String param1, String param2) {
        fragmentDetalles fragment = new fragmentDetalles();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista =inflater.inflate(R.layout.fragment_detalles, container, false);

        /*txtNombreSitio = (TextView) vista.findViewById(R.id.txt_fragment_NombreSitio);
        txtDescripcion = (TextView) vista.findViewById(R.id.txt_fragment_Descripcion);
        txtCategoria = (TextView) vista.findViewById(R.id.txt_fragment_Categoria);
        txtLatitud = (TextView) vista.findViewById(R.id.txt_fragment_Latitud);
        txtLongitud = (TextView) vista.findViewById(R.id.txt_fragment_Longitud);*/

        return vista;
    }

    /*public void cargarDetalles (Lugares sitio) {

        txtNombreSitio.setText(sitio.getNombre());
        txtDescripcion.setText(sitio.getDescripcion());
        txtCategoria.setText(sitio.getCategoria());
        txtLatitud.setText(sitio.getLatitud().toString());
        txtLongitud.setText(sitio.getLongitud().toString());

    }*/
}