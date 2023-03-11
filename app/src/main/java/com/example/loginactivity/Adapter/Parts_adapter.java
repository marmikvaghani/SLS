package com.example.loginactivity.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.loginactivity.model.machinetype.MDatum;
import com.example.loginactivity.Add_parts;
import com.example.loginactivity.R;
import java.util.List;

public class Parts_adapter extends RecyclerView.Adapter<Parts_adapter.ViewHolder >{

    List<MDatum> datumList;

    Context context;

    public Parts_adapter(Add_parts finalPage, List<MDatum> data) {
        this.datumList = data;
        this.context = finalPage;

    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_add_parts, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //  holder.id.setText(" ID : "+datumList.get(position).getId());
        holder.partyCity.setText(" MachineType : " + datumList.get(position).getMachineType());
        holder.partyName.setText(" PartsName : " + datumList.get(position).getPartsName());
        holder.machineNumber.setText(" PartsQuantity : " + datumList.get(position).getPartsQuantity());
        holder.installationDate.setText(" IsWarranty : " + datumList.get(position).getIsWarranty());
        holder.amcFromDate.setText(" getPartsPrice : " + datumList.get(position).getPartsPrice());
    }
    public int getItemCount() {
        return datumList.size();
    }
    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder  {

        TextView  partyCity,partyName,machineNumber, installationDate,amcFromDate,machinetype,amcToDate;
        LinearLayout data;

        ViewHolder(View itemView) {
            super(itemView);
            partyName= itemView.findViewById(R.id.mpartyName);
            machineNumber= itemView.findViewById(R.id.mmachineNumber);
            partyCity= itemView.findViewById(R.id.mpartyCity);
            machinetype= itemView.findViewById(R.id.mmachineType);
            installationDate= itemView.findViewById(R.id.minstallationDate);
            amcFromDate= itemView.findViewById(R.id.mamcFromDate);
            amcToDate= itemView.findViewById(R.id.mamcToDate);
            data= itemView.findViewById(R.id.mdata);

        }

    }
}