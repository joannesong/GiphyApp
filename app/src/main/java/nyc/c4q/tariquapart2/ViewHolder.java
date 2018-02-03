package nyc.c4q.tariquapart2;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by joannesong on 2/3/18.
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    private ImageView image;
    public ViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.itemview_image);
    }
}
