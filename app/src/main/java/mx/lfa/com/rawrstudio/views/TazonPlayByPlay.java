package mx.lfa.com.rawrstudio.views;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.lfa.com.rawrstudio.R;
import mx.lfa.com.rawrstudio.models.PlaybyPlay;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.FirebaseDatabase;

public class TazonPlayByPlay extends AppCompatActivity {

    public static class pBpViewHolder extends RecyclerView.ViewHolder {
        public TextView pbpEquipo, pbpOportunidad, pbpJugada;

        public pBpViewHolder(View v) {
            super(v);
            pbpEquipo = (TextView) itemView.findViewById(R.id.equipo_play_by_play);
            pbpOportunidad = (TextView) itemView.findViewById(R.id.oportunidad_play_by_play);
            pbpJugada = (TextView) itemView.findViewById(R.id.jugada_play_by_play);
        }
    }

    public static final String TAZONMEXICOII = "2017/tazonMexicoII";
    private RecyclerView mpbpRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private DatabaseReference mFirebaseDatabaseReference;
    private DatabaseReference mRowsTazon;
    private FirebaseRecyclerAdapter<PlaybyPlay, pBpViewHolder> mFirebaseAdapter;


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.marcador_mayas)
    TextView marcadorMayas;
    @BindView(R.id.marcador_dinos)
    TextView marcadorDinos;
    @BindView(R.id.recycler_play_by_play)
    RecyclerView recyclerPlayByPlay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Window localWindow = this.getWindow();
        localWindow.setStatusBarColor(this.getResources().getColor(R.color.negro));
        setContentView(R.layout.activity_tazon_play_by_play);
        ButterKnife.bind(this);
        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        System.out.print(mFirebaseDatabaseReference);

        setToolbarValues();
        iniGUI();

    }

    //@Override
    public void setToolbarValues() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void iniGUI(){
        mpbpRecyclerView = (RecyclerView)findViewById(R.id.recycler_play_by_play);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setStackFromEnd(true);
        mpbpRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRowsTazon = mFirebaseDatabaseReference.child("2017/tazonMexicoII");

        mFirebaseAdapter = new FirebaseRecyclerAdapter<PlaybyPlay, pBpViewHolder>(
                PlaybyPlay.class,
                R.layout.play_by_play_content,
                pBpViewHolder.class,
                mRowsTazon) {
            @Override
            protected void populateViewHolder(pBpViewHolder viewHolder, PlaybyPlay model, int position) {
                viewHolder.pbpEquipo.setText(model.getEquipo());
                viewHolder.pbpOportunidad.setText(model.getOportunidad());
                viewHolder.pbpJugada.setText(model.getJugada());
            }
        };

        mFirebaseAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(){
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount){
                super.onItemRangeInserted(positionStart, itemCount);
                int roomCount = mFirebaseAdapter.getItemCount();
                int lastVisiblePosition = mLinearLayoutManager.findLastCompletelyVisibleItemPosition();
                if (lastVisiblePosition == -1 || (positionStart >= (roomCount -1) && lastVisiblePosition == (positionStart -1))){
                    mpbpRecyclerView.scrollToPosition(positionStart);
                }
            }
        });
        mpbpRecyclerView.setLayoutManager(mLinearLayoutManager);
        mpbpRecyclerView.setAdapter(mFirebaseAdapter);
    

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in.
        // TODO: Add code to check if user is signed in.
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



}
