package mx.lfa.com.rawrstudio.views;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import mx.lfa.com.rawrstudio.R;
import mx.lfa.com.rawrstudio.models.PlaybyPlay;
import mx.lfa.com.rawrstudio.viewHolders.PbPViewHolder;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class TazonPlayByPlay extends AppCompatActivity {
    private static final String TAZONMEXICOII = "2017/tazonMexicoII";
    private DatabaseReference mDatabaseReference, marcacorLiveMayas, marcadorLiveDinos, mRowsTazon;
    private Toolbar toolbar;
    private TextView marcadorMayas, marcadorDinos;
    private RecyclerView playByPlayRecycler;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Window localWindow = this.getWindow();
        localWindow.setStatusBarColor(this.getResources().getColor(R.color.negro));
        setContentView(R.layout.activity_tazon_play_by_play);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        setToolbarValues();
        iniGUI();
        marcadorLive();
        jugadaAjugada();

    }

    //@Override
    public void setToolbarValues() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_white_24dp);

    }

    public void iniGUI(){
        mRowsTazon = mDatabaseReference.child("2017").child("tazonMexicoII").child("PBP");
        marcadorDinos = (TextView)findViewById(R.id.marcador_dinos);
        marcadorMayas = (TextView)findViewById(R.id.marcador_mayas);
        playByPlayRecycler = (RecyclerView)findViewById(R.id.recycler_play_by_play);
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        playByPlayRecycler.setHasFixedSize(true);
        playByPlayRecycler.setLayoutManager(mLayoutManager);

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
        FirebaseRecyclerAdapter<PlaybyPlay, PbPViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<PlaybyPlay, PbPViewHolder>(
                PlaybyPlay.class,
                R.layout.play_by_play_content,
                PbPViewHolder.class,
                mRowsTazon
        ) {
            @Override
            protected void populateViewHolder(PbPViewHolder viewHolder, PlaybyPlay model, int position) {
                viewHolder.setEquipo(model.getEquipo());
                viewHolder.setOportunidad(model.getOportunidad());
                viewHolder.setBolaen(model.getBolaen());
                viewHolder.setJugada(model.getJugada());

            }
        };
        playByPlayRecycler.setAdapter(firebaseRecyclerAdapter);


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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //drawerLayoutMain.openDrawer(GravityCompat.START);
                finish();
                return true;
            //...
        }
        return super.onOptionsItemSelected(item);
    }

}
