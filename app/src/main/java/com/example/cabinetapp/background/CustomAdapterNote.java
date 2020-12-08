package com.example.cabinetapp.background;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cabinetapp.Entite.Note;
import com.example.cabinetapp.R;

import java.util.ArrayList;

public class CustomAdapterNote extends ArrayAdapter<Note> implements View.OnClickListener{

    private ArrayList<Note> dataSet;
    Context mContext;


    // View lookup cache
    private static class ViewHolder {
        TextView title;
        TextView description;
    }
    //ArrayList<Patient> patients,
    public CustomAdapterNote(ArrayList<Note> data, Context context) {
        super(context, R.layout.note_item, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Note note=(Note) object;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Note note = getItem(position);
        //Patient patient =getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        CustomAdapterNote.ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new CustomAdapterNote.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.note_item, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.titreNote);
            viewHolder.description = (TextView) convertView.findViewById(R.id.desNote);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (CustomAdapterNote.ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.title.setText(note.getTitre());
        viewHolder.description.setText(note.getDescription());
        // Return the completed view to render on screen
        return convertView;
    }
}
