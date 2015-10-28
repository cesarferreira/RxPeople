package github.cesarferreira.rxpeople.sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import github.cesarferreira.rxpeople.models.FakeUser;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private static List<FakeUser> items;

    public UsersAdapter(List<FakeUser> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_users_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FakeUser item = items.get(position);

        holder.titleTextView.setText(String.format("%s %s", item.name.first, item.name.last));
        holder.subtitleTextView.setText(item.location.street);

        setupImage(holder.imageView, item.picture.medium);

        holder.itemView.setTag(item);
    }

    private void setupImage(ImageView image, String imageUrl) {
        image.setImageBitmap(null);
        Picasso.with(image.getContext()).cancelRequest(image);
        Picasso.with(image.getContext()).load(imageUrl).into(image);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final Context mContext;

        @Bind(R.id.image)
        public ImageView imageView;

        @Bind(R.id.title)
        public TextView titleTextView;

        @Bind(R.id.subtitle)
        public TextView subtitleTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            System.out.println("You clicked: " + getAdapterPosition());
        }
    }
}
