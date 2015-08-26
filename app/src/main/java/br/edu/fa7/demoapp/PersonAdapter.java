package br.edu.fa7.demoapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by posgrad on 19/08/2015.
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private List<Person> list;
    private LayoutInflater layoutInflater;

    public void setListener(RecyclerViewOnClickListener listener) {
        this.listener = listener;
    }

    private RecyclerViewOnClickListener listener;

    public PersonAdapter(List<Person> list, Context context) {
        this.list = list;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = layoutInflater.inflate(R.layout.cardview_item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        Person p = list.get(i);
        personViewHolder.mPersonImage.setImageResource(p.getImage());
        personViewHolder.mPersonName.setText(p.getName());
        personViewHolder.mPersonEmail.setText(p.getEmail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView mPersonImage;
        private TextView mPersonName;
        private TextView mPersonEmail;

        public PersonViewHolder(View itemView){
            super(itemView);

            itemView.setOnClickListener(this);

            mPersonImage = (ImageView) itemView.findViewById(R.id.cardview_person_image);
            mPersonName = (TextView) itemView.findViewById(R.id.cardview_person_name);
            mPersonEmail = (TextView) itemView.findViewById(R.id.cardview_person_email);

        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());
        }
    }

}
