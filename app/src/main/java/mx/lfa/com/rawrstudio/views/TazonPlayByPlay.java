package mx.lfa.com.rawrstudio.views;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.lfa.com.rawrstudio.R;
import mx.lfa.com.rawrstudio.models.PlaybyPlay;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class TazonPlayByPlay extends AppCompatActivity {
    public static final String TAZONMEXICOII = "2017/tazonMexicoII";
    private RecyclerView mpbpRecyclerList;
    private LinearLayoutManager mLinearLayoutManager;
    private DatabaseReference mDatabaseReference, marcacorLiveMayas, marcadorLiveDinos, mRowsTazon;
    //private TextView pbpEquipo, pbpOportunidad, pbpJugada;
    private ListView listViewJugadas;
    private List<PlaybyPlay>laBuena;
    private FirebaseRecyclerAdapter<PlaybyPlay, pBpViewHolder> mFirebaseRecyclerAdapter;
    private PlaybyPlay paraTazon;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.marcador_mayas)
    TextView marcadorMayas;
    @BindView(R.id.marcador_dinos)
    TextView marcadorDinos;
 //   @BindView(R.id.recycler_play_by_play)
   // RecyclerView recyclerPlayByPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Window localWindow = this.getWindow();
        localWindow.setStatusBarColor(this.getResources().getColor(R.color.negro));
        setContentView(R.layout.activity_tazon_play_by_play);
        ButterKnife.bind(this);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        setToolbarValues();
        iniGUI();
        marcadorLive();
        jugadaAjugada();

    }

    //@Override
    public void setToolbarValues() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void iniGUI(){
        mRowsTazon = mDatabaseReference.child("2017").child("tazonMexicoII");

        mpbpRecyclerList = (RecyclerView)findViewById(R.id.recycler_play_by_play);
        mpbpRecyclerList.setHasFixedSize(true);
        mpbpRecyclerList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setStackFromEnd(true);
        mpbpRecyclerList.setLayoutManager(mLinearLayoutManager);

    }

    public void marcadorLive(){
        marcacorLiveMayas = mDatabaseReference.child("2017").child("tazonMexicoII").child("marcadorMayas");
        marcadorLiveDinos = mDatabaseReference.child("2017").child("tazonMexicoII").child("marcadorDinos");
        marcacorLiveMayas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                marcadorMayas.setText(dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        marcadorLiveDinos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                marcadorDinos.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void jugadaAjugada(){
        FirebaseRecyclerAdapter<PlaybyPlay, pBpViewHolder> fireBaseRecyclerAdapter = new FirebaseRecyclerAdapter<PlaybyPlay, pBpViewHolder>(
                PlaybyPlay.class,
                R.layout.play_by_play_content,
                pBpViewHolder.class,
                mRowsTazon) {
            @Override
            protected void populateViewHolder(pBpViewHolder viewHolder, PlaybyPlay model, int position) {
                viewHolder.setEquipo(model.getEquipo());
                viewHolder.setOportunidad(model.getOportunidad());
                viewHolder.setJugada(model.getJugada());
            }

            @Override
            public pBpViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return super.onCreateViewHolder(parent, viewType);
            }

            @Override
            public int getItemViewType(int position) {
                return super.getItemViewType(position);
            }
        };

        mpbpRecyclerList.setAdapter(fireBaseRecyclerAdapter);
        LinearLayoutManager llmm = new LinearLayoutManager(this);
        mpbpRecyclerList.setLayoutManager(llmm);
    }


    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public static class pBpViewHolder extends RecyclerView.ViewHolder {
        View pbpView;

        public pBpViewHolder(View itemView) {
            super(itemView);
            pbpView = itemView;
        }

        public void setEquipo(String equipo){
            TextView pbpEquipo = (TextView)pbpView.findViewById(R.id.equipo_play_by_play);
            pbpEquipo.setText(equipo);

        }

        public void setOportunidad(String oportunidad) {
            TextView pbpOportunidad = (TextView) pbpView.findViewById(R.id.oportunidad_play_by_play);
            pbpOportunidad.setText(oportunidad);
        }

        public void setJugada(String jugada) {
            TextView pbpJugada = (TextView)pbpView.findViewById(R.id.jugada_play_by_play);
            pbpJugada.setText(jugada);
        }
    }

}
