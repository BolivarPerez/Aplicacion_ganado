package com.example.boli.aplicacion_ganado.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.boli.aplicacion_ganado.R;
import com.example.boli.aplicacion_ganado.modelos.modelo_vacas;

import java.util.List;

/**
 * Created by BOLI on 23/04/2015.
 */
public class adaptadorvacas extends RecyclerView.Adapter<adaptadorvacas.vacasViewHolder> {

    public List<modelo_vacas> items;

    public static class vacasViewHolder extends RecyclerView.ViewHolder{

        public TextView n_arete;
        public TextView f_nacimiento;
        public TextView nombre;
        public TextView sexo;
        public TextView f_gestacion;
        public TextView f_parto;

        public vacasViewHolder(View v) {
            super(v);
            n_arete = (TextView) v.findViewById(R.id.no_arete);
            f_nacimiento = (TextView) v.findViewById(R.id.fecha1);
            nombre = (TextView) v.findViewById(R.id.nombre);
            sexo = (TextView) v.findViewById(R.id.sexo);
            f_gestacion = (TextView) v.findViewById(R.id.fecha2);
            f_parto = (TextView) v.findViewById(R.id.fecha3);
        }

        }
    public adaptadorvacas(List<modelo_vacas> items) {this.items = items;}

    public int getItemCount() {return  items.size();}


    @Override
    public vacasViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.resgistro_card, viewGroup, false);
        return new vacasViewHolder(v);
    }

    public void onBindViewHolder(vacasViewHolder viewHolder, int i){
        viewHolder.n_arete.setText("Arete: " + String.valueOf(items.get(i).getN_arete()));
        viewHolder.f_nacimiento.setText("F.Nac: " + items.get(i).getF_nacimiento());
        viewHolder.nombre.setText("Nombre: " + items.get(i).getNombre());
        viewHolder.sexo.setText("Sexo: " + items.get(i).getSexo());
        viewHolder.f_gestacion.setText("F.Gest: " + items.get(i).getF_gestacion());
        viewHolder.f_parto.setText("F.Parto: " + items.get(i).getF_parto());
    }
}
