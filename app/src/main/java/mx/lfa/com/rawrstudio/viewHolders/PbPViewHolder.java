package mx.lfa.com.rawrstudio.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.load.engine.Resource;

import mx.lfa.com.rawrstudio.R;

/**
 * Created by Tonatiuh on 26/04/2017.
 */

public class PbPViewHolder extends RecyclerView.ViewHolder {
    View pbpView;
    TextView pbpOportunidad;


    public PbPViewHolder(View itemView) {
        super(itemView);
        pbpView = itemView;
    }

    public void setEquipo(String equipo){
        TextView pbpEquipo = (TextView)pbpView.findViewById(R.id.equipo_play_by_play);
        if(equipo.equals("DINOS")){
            pbpEquipo.setText(equipo);
            pbpEquipo.setTextColor(pbpEquipo.getResources().getColor(R.color.primary_dinos));
        }
         else if(equipo.equals("DRIVE DINOS")  || equipo.equals("TOUCH DOWN DINOS") || equipo.equals("FG DINOS")){
            pbpEquipo.setTextColor(pbpEquipo.getResources().getColor(R.color.blanco));
            pbpEquipo.setBackgroundColor(pbpEquipo.getResources().getColor(R.color.primary_dinos));
            pbpEquipo.setWidth(5000);
            pbpEquipo.setText(equipo);
            pbpOportunidad = (TextView) pbpView.findViewById(R.id.oportunidad_play_by_play);
            pbpOportunidad.setVisibility(View.GONE);
        }
        else if(equipo.equals("MAYAS")){
            pbpEquipo.setTextColor(pbpEquipo.getResources().getColor(R.color.primary_mayas));
        pbpEquipo.setText(equipo);
        }
        else if(equipo.equals("DRIVE MAYAS") || equipo.equals("TOUCH DOWN MAYAS") || equipo.equals("FG MAYAS")){
            pbpEquipo.setTextColor(pbpEquipo.getResources().getColor(R.color.blanco));
            pbpEquipo.setBackgroundColor(pbpEquipo.getResources().getColor(R.color.primary_mayas));
            pbpEquipo.setWidth(5000);
            pbpEquipo.setText(equipo);
            pbpOportunidad = (TextView) pbpView.findViewById(R.id.oportunidad_play_by_play);
            pbpOportunidad.setVisibility(View.GONE);
        }
        else {
            pbpEquipo.setText(equipo);
        }

    }

    public void setOportunidad(String oportunidad) {
        pbpOportunidad = (TextView) pbpView.findViewById(R.id.oportunidad_play_by_play);
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
