package mx.lfa.com.rawrstudio.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import mx.lfa.com.rawrstudio.R;

/**
 * Created by Tonatiuh on 26/04/2017.
 */

public class PbPViewHolder extends RecyclerView.ViewHolder {
    View pbpView;

    public PbPViewHolder(View itemView) {
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

    public void setBolaen(String lugar) {
        TextView pbpSpot = (TextView)pbpView.findViewById(R.id.spot_play_by_play);
        pbpSpot.setText(lugar);
    }

    public void setJugada(String jugada) {
        TextView pbpJugada = (TextView)pbpView.findViewById(R.id.jugada_play_by_play);
        pbpJugada.setText(jugada);
    }

}
