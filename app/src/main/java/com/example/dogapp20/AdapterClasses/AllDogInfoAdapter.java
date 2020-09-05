package com.example.dogapp20.AdapterClasses;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dogapp20.R;

public class AllDogInfoAdapter extends RecyclerView.Adapter<AllDogInfoAdapter.ProgrammingViewHolder> {
    private String[] data;
    public AllDogInfoAdapter(String[] data)
    {
        this.data=data;
    }
    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.alldoginfo,parent,false);
        return new ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolder holder, int position) {
        String title=data[position];
        holder.tv1.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder {
        ImageView imgicon;
        TextView tv1;
        TextView tv2;
        Button b1;
        public ProgrammingViewHolder(View itemView) {
            super(itemView);
            imgicon=itemView.findViewById(R.id.imageView5);
            tv1=itemView.findViewById(R.id.textView2);
            tv2=itemView.findViewById(R.id.textView);
            b1=itemView.findViewById(R.id.b1);
        }
    }
}

