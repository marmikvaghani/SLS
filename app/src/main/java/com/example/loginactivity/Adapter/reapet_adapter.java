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

import com.example.loginactivity.R;
import com.example.loginactivity.model.reapet_example.Datum;
import com.example.loginactivity.reapet_complaint;

import java.util.List;

public class reapet_adapter extends RecyclerView.Adapter<reapet_adapter.ViewHolder >{


    List<Datum> datumdata;

    Context context;


    public reapet_adapter(reapet_complaint finalPage, List<com.example.loginactivity.model.reapet_example.Datum> data) {
        this.datumdata = data;
        this.context = finalPage;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_panding, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //  holder.id.setText(" ID : "+datumList.get(position).getId());

        holder.cmp_id.setText(" cmdID : "+datumdata.get(position).getCmpId());
        holder.partyName.setText(" partyName: "+datumdata.get(position).getPartyName());
        holder.partyCity.setText(" પાર્ટીનું શહેર: "+datumdata.get(position).getPartyCity());
        holder.engineerCity.setText(" engineerCity : "+datumdata.get(position).getEngineerCity());
        holder.machineNo.setText(" મશીન નંબર  : "+datumdata.get(position).getMachineNo());
        holder.details.setText(" details : "+datumdata.get(position).getDetails());
        holder.callBy.setText(" callBy : "+datumdata.get(position).getCallBy());
        holder.logBy.setText(" logby: "+datumdata.get(position).getLogBy());
        holder.engineerName.setText(" એન્જિનિયરનું નામ: "+datumdata.get(position).getEngineerName());
        holder.createDateAt.setText(" createDateAt : "+datumdata.get(position).getCreateDateAt());
        holder.createTimeAt.setText(" createTimeAt : "+datumdata.get(position).getCreateTimeAt());
        holder.upadateDateAt.setText(" upadateDateAt : "+datumdata.get(position).getUpadateAt());
        holder.upadateTimeAt.setText(" upadateTimeAt : "+datumdata.get(position).getUpadateTimeAt());
        holder.repeatComplaintNumber.setText(" repeatComplaintNumber : "+datumdata.get(position).getRepeatComplaintNumber());
        holder.machineType.setText(" machineType : "+datumdata.get(position).getMachineType());
        holder.upadateAt.setText(" upadateAt : "+datumdata.get(position).getUpadateAt());


    }

    @Override
    public int getItemCount() {
        return datumdata.size();

    }
    public class ViewHolder extends RecyclerView.ViewHolder  {

        TextView cmp_id,partyName,machineNo, details,engineerName,logBy,partyCity,engineerCity;
        TextView  callBy,createDateAt,createTimeAt,upadateDateAt,upadateTimeAt,repeatComplaintNumber,machineType,upadateAt;
        LinearLayout data;

        ViewHolder(View itemView) {
            super(itemView);
            data= itemView.findViewById(R.id.pdata);


            cmp_id= itemView.findViewById(R.id.pcmp_id);
            partyName= itemView.findViewById(R.id.ppartyName);
            partyCity= itemView.findViewById(R.id.ppartyCity);
            engineerCity= itemView.findViewById(R.id.pengineerCity);
            machineNo= itemView.findViewById(R.id.pmachineNo);
            details= itemView.findViewById(R.id.pdetails);
            callBy= itemView.findViewById(R.id.pcallBy);
            logBy= itemView.findViewById(R.id.plogby);
            engineerName= itemView.findViewById(R.id.pengineerName);
            createDateAt= itemView.findViewById(R.id.pcreateDateAt);
            createTimeAt= itemView.findViewById(R.id.pcreateTimeAt);
            upadateDateAt= itemView.findViewById(R.id.pupadateDateAt);
            upadateTimeAt= itemView.findViewById(R.id.pupadateTimeAt);
            repeatComplaintNumber= itemView.findViewById(R.id.prepeatComplaintNumber);
            machineType= itemView.findViewById(R.id.pmachineType);
            upadateAt= itemView.findViewById(R.id.pupadateAt);
        }

    }
}