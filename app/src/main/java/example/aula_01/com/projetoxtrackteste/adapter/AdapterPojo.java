package example.aula_01.com.projetoxtrackteste.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import example.aula_01.com.projetoxtrackteste.R;
import example.aula_01.com.projetoxtrackteste.models.PojoDemo;

public class AdapterPojo extends RecyclerView.Adapter<AdapterPojo.ViewHolder>{

    private ArrayList<PojoDemo> dataList;

    public AdapterPojo(ArrayList<PojoDemo> dataList) {
        this.dataList = dataList;
    }

    @Override
    public AdapterPojo.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_principal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterPojo.ViewHolder holder, int position) {
        holder.txtUf.setText(dataList.get(position).getUf());
        holder.txtCidade.setText(dataList.get(position).getCidade());
        holder.txtData.setText(dataList.get(position).getData());
        holder.txtStatus.setText(dataList.get(position).getStatus());
        holder.txtHora.setText(dataList.get(position).getHora());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtData, txtUf, txtStatus, txtCidade, txtHora;

        public ViewHolder(View itemView) {
            super(itemView);

            txtData = (TextView) itemView.findViewById(R.id.recyclerView);
            txtUf   = (TextView) itemView.findViewById(R.id.recyclerView);
            txtStatus = (TextView) itemView.findViewById(R.id.recyclerView);
            txtHora = (TextView) itemView.findViewById(R.id.recyclerView);
            txtCidade = (TextView) itemView.findViewById(R.id.recyclerView);

        }
    }
}