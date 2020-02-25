package org.flepper.convexhull;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

class IconsAdapter extends RecyclerView.Adapter<IconsAdapter.MyViewHolder> {
    List<IconData> iconDataList;
    public IconsAdapter(List<IconData> iconDataList) {
        this.iconDataList = iconDataList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_empty_card, viewGroup, false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        IconData data=iconDataList.get(i);
        Random rnd = new Random();
        int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        viewHolder.name.setText(data.name);
    }
    @Override
    public int getItemCount() {
        return iconDataList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,age;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}