package mx.lfa.com.rawrstudio.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mx.lfa.com.rawrstudio.R;
import mx.lfa.com.rawrstudio.models.Jugador;
import mx.lfa.com.rawrstudio.viewHolders.RosterViewHolder;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */
public class RostersFragment extends Fragment {
    private String nombreEquipo;
    /*Nombre Equipo Static*/
    private final static String NOMBRE_EQUIPO = "nombreEquipo";

    private static final int PER = 0;
    private static final int UNEVEN = 1;

    String[] color = {"#FFFFFF", "#D1FFFFFF"};

    private DatabaseReference rosterDBReference;

    @BindView(R.id.number_abreviature)
    TextView numberAbreviature;
    @BindView(R.id.name_text)
    TextView nameText;
    @BindView(R.id.position_text)
    TextView positionText;
    @BindView(R.id.height_text)
    TextView heightText;
    @BindView(R.id.weight_text)
    TextView weightText;
    @BindView(R.id.tableLayout)
    TableLayout tableLayout;
    @BindView(R.id.roster_list)
    RecyclerView rosterList;
    Unbinder unbinder;

    public RostersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.nombreEquipo = getArguments().getString(NOMBRE_EQUIPO).toLowerCase();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rosters, container, false);
        unbinder = ButterKnife.bind(this, view);
        rosterDBReference = FirebaseDatabase.getInstance().getReference().child("2017/equipo/" + nombreEquipo + "/jugador");

        rosterList.setHasFixedSize(true);
        rosterList.setLayoutManager(new LinearLayoutManager(getActivity()));

        FirebaseRecyclerAdapter<Jugador, RosterViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Jugador, RosterViewHolder>(Jugador.class, R.layout.row_player, RosterViewHolder.class, rosterDBReference) {
            @Override
            protected void populateViewHolder(RosterViewHolder viewHolder, Jugador jugador, int position) {

                String fullName = jugador.getNombre().substring(0, 1).toUpperCase() + jugador.getNombre().substring(1).toLowerCase();
                fullName = fullName.concat(" ");
                fullName = fullName.concat(jugador.getApellidoPaterno().substring(0, 1) + jugador.getApellidoPaterno().substring(1).toLowerCase());

                viewHolder.setPlayerName(fullName);

                viewHolder.setPlayerNumber(jugador.getNumero());
                viewHolder.setPlayerPosition(jugador.getPosicion());
                viewHolder.setPlayerHeight(jugador.getEstatura());
                viewHolder.setPlayerWeight(jugador.getPeso());

            }

            @Override
            public RosterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                switch (viewType) {
                    case PER:
                        View viewPer = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_player, parent, false);
                        viewPer.setBackgroundColor(getResources().getColor(R.color.rojo_lfa_transparente));
                        return new RosterViewHolder(viewPer);
                    case UNEVEN:
                        View viewUneven = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_player, parent, false);
                        return new RosterViewHolder(viewUneven);
                }

                return super.onCreateViewHolder(parent, viewType);
            }

            @Override
            public int getItemViewType(int position) {

                int resultadoModulo = position % 2;
                Log.v("Resultado", "" + resultadoModulo);
                if (resultadoModulo == 0) {
                    return PER;
                } else {
                    return UNEVEN;
                }


            }
        };

        rosterList.setAdapter(firebaseRecyclerAdapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rosterList.setLayoutManager(llm);

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
