package com.example.loginactivity.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginactivity.R;
import com.example.loginactivity.allCompaint;
import com.example.loginactivity.model.total_com_ex.Datum1;

import java.util.List;

public  class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    /*  private String[] mData;
      private LayoutInflater mInflater;*/

    List<Datum1> datum;
    Context context;

    public RecyclerAdapter(Context finalPage, List<Datum1> data) {
        this.datum = data;
        this.context = finalPage;

    }
    // data is passed into the constructor
    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_image_view, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
       // holder.id.setText(" ID : "+datum.get(position).getCmpId());
        holder.cmd_id.setText(" cmdID : "+datum.get(position).getCmpId());
        holder.partyName.setText(" પાર્ટીનું નામ : "+datum.get(position).getPartyName());
        holder.partyCity.setText( " પાર્ટીનું શહેર : "+datum.get(position).getPartyCity());
        holder.engineerCity.setText(" eng city : "+datum.get(position).getEngineerCity());
        holder.machineNo.setText(" મશીન નંબર : "+datum.get(position).getMachineNo());
        holder.details.setText(" details: "+datum.get(position).getDetails());
        holder.callBy.setText(" Callby : "+datum.get(position).getCallBy());
        holder.logby.setText(" logby : "+datum.get(position).getLogBy());
        holder.engineerName.setText(" eng name : "+datum.get(position).getEngineerName());
        holder.createDateAt.setText(" createDateAt : "+datum.get(position).getCreateDateAt());
        holder.createTimeAt.setText(" createTimeAt : "+datum.get(position).getCreateTimeAt());
        holder.upadateDateAt.setText(" upadateDateAt : "+datum.get(position).getUpadateAt());
        holder.upadateTimeAt.setText(" upadateTimeAt : "+datum.get(position).getUpadateTimeAt());
        holder.repeatComplaintNumber.setText(" repeatComplaintNumber : "+datum.get(position).getRepeatComplaintNumber());
        holder.machineType.setText(" machineType : "+datum.get(position).getMachineType());
        holder.endTime.setText(" endTime : "+datum.get(position).getEndTime());
        holder.startTime.setText(" startTime : "+datum.get(position).getStartTime());
        holder.solution.setText(" solution : "+datum.get(position).getSolution());
        holder.upadateAt.setText(" upadateAt : "+datum.get(position).getUpadateAt());
        holder.data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, allCompaint.class);
                i.putExtra("CmpId", String.valueOf("ફરિયાદ આઈડી : "+datum.get(position).getCmpId()));
                i.putExtra("createDateAt", String.valueOf("ફરિયાદની તારીખ : "+datum.get(position).getCreateDateAt()));
                i.putExtra("upadateTimeAt", String.valueOf("અપડેટ કરેલ સમય : "+datum.get(position).getUpadateDateAt()));
                i.putExtra("machineNo", String.valueOf("મશીન નં : "+datum.get(position).getMachineNo()));
                i.putExtra("machineType", String.valueOf("મશીન નામ : "+datum.get(position).getMachineType()));

                i.putExtra("partyName", String.valueOf("પાર્ટીનું નામ : "+datum.get(position).getPartyName()));
                i.putExtra("details", String.valueOf("ફરિયાદ વિગતો : "+datum.get(position).getDetails()));
                i.putExtra("id",datum.get(position).getId());
                //solution
                i.putExtra("solution", String.valueOf("ઉકેલ: "+datum.get(position).getSolution()));
               // i.putExtra("time",String.valueOf("time"+datum.get(position).gettime()));

                context.startActivity(i);
            }
        });


//        holder.email.setText(datumList.get(position).getEmail());


//                .error(R.drawable.imagenotfound);
    }

    // total number of cells
    @Override
    public int getItemCount() {
        return datum.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView id,cmd_id,partyCity,engineerCity,machineNo, details,callBy,logby,engineerName,createDateAt,createTimeAt,upadateDateAt;
        TextView upadateTimeAt,repeatComplaintNumber,machineType,endTime,startTime,solution,upadateAt,partyName;
        LinearLayout data;

        ViewHolder(View itemView) {
            super(itemView);
            data= itemView.findViewById(R.id.Alldata);

            cmd_id= itemView.findViewById(R.id.cmd_id);
            partyName= itemView.findViewById(R.id.cpartyName);
            partyCity= itemView.findViewById(R.id.cpartyCity);
            engineerCity= itemView.findViewById(R.id.cengineerCity);
            machineNo= itemView.findViewById(R.id.cmachineNo);
            details= itemView.findViewById(R.id.cdetails);
            callBy= itemView.findViewById(R.id.ccallBy);
            logby= itemView.findViewById(R.id.clogby);
            engineerName= itemView.findViewById(R.id.cengineerName);
            createDateAt= itemView.findViewById(R.id.ccreateDateAt);
            createTimeAt= itemView.findViewById(R.id.ccreateTimeAt);
            upadateDateAt= itemView.findViewById(R.id.cupadateDateAt);
            upadateTimeAt= itemView.findViewById(R.id.cupadateTimeAt);
            repeatComplaintNumber= itemView.findViewById(R.id.crepeatComplaintNumber);
            machineType= itemView.findViewById(R.id.cmachineType);
            endTime= itemView.findViewById(R.id.cendTime);
            startTime= itemView.findViewById(R.id.cstartTime);
            solution= itemView.findViewById(R.id.csolution);
            upadateAt= itemView.findViewById(R.id.cupadateAt);



        }
    }
}