package org.ardananjungkusuma.pokelove.models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.ardananjungkusuma.pokelove.ElementActivity;
import org.ardananjungkusuma.pokelove.R;

import java.util.ArrayList;
import java.util.List;

public class ElementAdapter extends RecyclerView.Adapter<ElementAdapter.ElementViewHolder>{
    private List<Element> listElement = new ArrayList<>();

    public ElementAdapter(List<Element> listElement) { this.listElement = listElement; }

    private ElementAdapter.OnElementClickListener listener;

    public interface OnBallClickListener {
        public void onClick(View view, int position);
    }

    public void setListener(ElementAdapter.OnElementClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vh = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_element,parent,false);
        ElementAdapter.ElementViewHolder viewHolder = new ElementAdapter.ElementViewHolder(vh);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ElementViewHolder holder, int position) {
        Element item = listElement.get(position);
        holder.txtElementName.setText(item.getName());
        holder.txtDescription.setText(item.getDescription());
        holder.txtDefense.setText(item.getDefense());
        holder.txtOffense.setText(item.getOffense());
        holder.txtContestProperties.setText(item.getContestProperties());
        Picasso.get().load(item.getImg())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imgElement);
    }

    @Override
    public int getItemCount() {
        return listElement.size();
    }

    public interface OnElementClickListener {
        public void onClick(View view, int position);
    }

    public class ElementViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgElement;
        public TextView txtElementName, txtDescription, txtDefense, txtOffense, txtContestProperties;

        public ElementViewHolder(@NonNull View itemView) {
            super(itemView);
            imgElement = itemView.findViewById(R.id.imgElement);
            txtElementName = itemView.findViewById(R.id.txtElementName);
            txtDescription = itemView.findViewById(R.id.txtDescElement);
            txtDefense = itemView.findViewById(R.id.txtDefense);
            txtOffense = itemView.findViewById(R.id.txtOffense);
            txtContestProperties = itemView.findViewById(R.id.txtContestProperties);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(v, getAdapterPosition());
                }
            });
        }
    }
}
