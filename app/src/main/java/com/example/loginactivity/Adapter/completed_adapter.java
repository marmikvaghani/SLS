package com.example.loginactivity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginactivity.R;
import com.example.loginactivity.completed_complaint;
import com.example.loginactivity.model.completedComplaint.Datum;

import java.util.List;

public class completed_adapter extends RecyclerView.Adapter <completed_adapter.ViewHolder >{

    List<Datum> datum;

    Context contex;

    public completed_adapter(completed_complaint completed_complaint, List<Datum> data) {
        this.datum = data;
        this.contex = completed_complaint;
    }

    @NonNull
    @Override
    public completed_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_complaint, parent, false);
        return new completed_adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull completed_adapter.ViewHolder holder, int position) {
        holder.cmp_id.setText(" cmdID : "+datum.get(position).getCmpId());
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

        holder.rating.setText(" rating : "+datum.get(position).getRating());
        holder.endComplaintLocation.setText(" endComplaintLocation : "+datum.get(position).getEndComplaintLocation());
        holder.startAndEndTimeDuration.setText(" startAndEndTimeDuration : "+datum.get(position).getStartAndEndTimeDuration());
        holder.startComplaintLocation.setText(" startComplaintLocation : "+datum.get(position).getStartComplaintLocation());

    }


    @Override
    public int getItemCount() {
        return datum.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder  {

        TextView cmp_id,partyCity,engineerCity,machineNo, details,callBy,logby,engineerName,createDateAt,createTimeAt,upadateDateAt,rating,endComplaintLocation;
        TextView upadateTimeAt,repeatComplaintNumber,machineType,endTime,startTime,solution,upadateAt,partyName,startAndEndTimeDuration,startComplaintLocation;
        LinearLayout data;

        ViewHolder(View itemView) {
            super(itemView);
            data= itemView.findViewById(R.id.cdata);


            cmp_id= itemView.findViewById(R.id.ccmpid);
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
            rating= itemView.findViewById(R.id.rating);
            startAndEndTimeDuration= itemView.findViewById(R.id.startAndEndTimeDuration);
            startComplaintLocation= itemView.findViewById(R.id.startComplaintLocation);
            endComplaintLocation= itemView.findViewById(R.id.endComplaintLocation);

        }

    }
}

