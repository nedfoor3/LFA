package mx.lfa.com.rawrstudio.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mx.lfa.com.rawrstudio.R;
import mx.lfa.com.rawrstudio.models.Calendario;
import mx.lfa.com.rawrstudio.viewHolders.CalendarViewHolder;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link CalendarFragmet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalendarFragmet extends Fragment {

    private String nombreEquipo;
    /*Nombre Equipo Static*/
    private final static String NOMBRE_EQUIPO = "nombreEquipo";

    @BindView(R.id.calendar_list)
    RecyclerView calendarList;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    Unbinder unbinder;
    private DatabaseReference calendarioDbReference;

    public CalendarFragmet() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalendarFragmet.
     */
    // TODO: Rename and change types and number of parameters
    public static CalendarFragmet newInstance(String param1, String param2) {
        CalendarFragmet fragment = new CalendarFragmet();
        Bundle args = new Bundle();


        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.nombreEquipo = getArguments().getString(NOMBRE_EQUIPO).toLowerCase();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calendar_fragmet, container, false);
        unbinder = ButterKnife.bind(this, view);

        calendarioDbReference = FirebaseDatabase.getInstance().getReference().child("2017/equipo/" + nombreEquipo + "/partidos");

        calendarList.setHasFixedSize(true);
        calendarList.setLayoutManager(new LinearLayoutManager(getActivity()));

        FirebaseRecyclerAdapter<Calendario, CalendarViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Calendario, CalendarViewHolder>(Calendario.class, R.layout.row_calendar, CalendarViewHolder.class, calendarioDbReference) {
            @Override
            protected void populateViewHolder(CalendarViewHolder viewHolder, Calendario calendario, int position) {

                if (calendario.getEstatus() != null) {

                    viewHolder.setLocal(calendario.getMarcadorLocal());
                    viewHolder.setVisitante(calendario.getMarcadorVisitante());

                    if ("terminado".compareTo(calendario.getEstatus().toLowerCase()) == 0) {
                        viewHolder.setEstatus(getString(R.string.final_texto));
                    } else {
                        viewHolder.setEstatus(getString(R.string.jugando_texto));
                    }
                } else {
                    viewHolder.setLocal(calendario.getLocal().substring(0, 3));
                    viewHolder.setVisitante(calendario.getVisitante().substring(0, 3));
                }
                int resourceIdLocal = getResources().getIdentifier("escudo_" + calendario.getLocal().toLowerCase(), "drawable", "mx.lfa.com.rawrstudio");
                viewHolder.setImagenLocal(resourceIdLocal);
                int primaryColorLocal = getResources().getIdentifier("primary_" + calendario.getLocal().toLowerCase(), "color", "mx.lfa.com.rawrstudio");
                primaryColorLocal = getResources().getColor(primaryColorLocal);
                viewHolder.setBackgroundLocal(primaryColorLocal);


                int resourceIdVisitante = getResources().getIdentifier("escudo_" + calendario.getVisitante().toLowerCase(), "drawable", "mx.lfa.com.rawrstudio");
                viewHolder.setImagenVisitante(resourceIdVisitante);
                int primaryColorVisitante = getResources().getIdentifier("primary_" + calendario.getVisitante().toLowerCase(), "color", "mx.lfa.com.rawrstudio");
                primaryColorVisitante = getResources().getColor(primaryColorVisitante);
                viewHolder.setBackgroundVisitante(primaryColorVisitante);
                viewHolder.setHorario(calendario.getFecha().concat(" ").concat(calendario.getHora()));
            }
        };
        calendarList.setAdapter(firebaseRecyclerAdapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        calendarList.setLayoutManager(llm);

        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
