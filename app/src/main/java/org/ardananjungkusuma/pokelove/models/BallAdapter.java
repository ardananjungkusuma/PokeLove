package org.ardananjungkusuma.pokelove.models;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.ardananjungkusuma.pokelove.R;

import java.util.ArrayList;
import java.util.List;

public class BallAdapter extends RecyclerView.Adapter<BallAdapter.BallViewHolder> {
    private List<Ball> listBall = new ArrayList<>();

    public BallAdapter(List<Ball> listBall) {
        this.listBall = listBall;
    }

    private OnBallClickListener listener;

    public interface OnBallClickListener {
        public void onClick(View view, int position);
    }

    public void setListener(OnBallClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public BallViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vh = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_ball,viewGroup,false);
        BallViewHolder viewHolder = new BallViewHolder(vh);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BallViewHolder ballViewHolder, int i) {
        Ball item = listBall.get(i);
        ballViewHolder.txtBallName.setText(item.getName());
        ballViewHolder.txtCatchRateModifier.setText(item.getCatchRateModifier());
        ballViewHolder.txtDebutGen.setText(item.getDebutGen());
        ballViewHolder.txtAdditionalEffect.setText(item.getAdditionalEffect());
        ballViewHolder.txtDescription.setText(item.getDescription());
        Picasso.get().load(item.getImgUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .into(ballViewHolder.imgBall);
    }

    @Override
    public int getItemCount() {
        return listBall.size();
    }


    public void filterList(ArrayList<Ball> filterBall) {
        listBall = filterBall;
        notifyDataSetChanged();
    }

    public class BallViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgBall;
        public TextView txtBallName, txtCatchRateModifier,txtDescription, txtDebutGen, txtAdditionalEffect;

        public BallViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBall = itemView.findViewById(R.id.imgBall);
            txtBallName = itemView.findViewById(R.id.txtBallName);
            txtCatchRateModifier = itemView.findViewById(R.id.txtCatchRateModifier);
            txtDebutGen = itemView.findViewById(R.id.txtDebutGen);
            txtAdditionalEffect = itemView.findViewById(R.id.txtAdditionalEffect);
            txtDescription = itemView.findViewById(R.id.txtDesc);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(v, getAdapterPosition());
                }
            });
        }
    }
}
