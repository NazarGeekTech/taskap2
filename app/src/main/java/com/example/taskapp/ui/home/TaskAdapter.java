package com.example.taskapp.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taskapp.R;
import com.example.taskapp.ui.Title;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private ArrayList<String> list = new ArrayList<>();
    private Title title ;


    public TaskAdapter(Title title) {
        this.title = title;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addList(ArrayList<String> list) {
        this.list.addAll(0,list);
        notifyDataSetChanged();
    }

    public void addItem(  String text) {
        list.add( 0,text);
       notifyItemInserted(list.size() -1);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    title.tost(getAdapterPosition());

                }
            });
        }

        public void bind(String s) {
            textView.setText(s);
            if (getAdapterPosition() % 2 == 0)
                itemView.setBackgroundColor(itemView.getResources().getColor(R.color.purple_300));
            else
                itemView.setBackgroundColor(itemView.getResources().getColor(R.color.purple_250));


        }
    }
}
