package com.example.juice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class Adapter extends BaseAdapter {

    private Context context;
    Controllerdb controllerdb;
    private ArrayList<String> CustomerName = new ArrayList<>();
    private ArrayList<String> CustomerEmail = new ArrayList<>();



    public Adapter(Context context, ArrayList<String> CustomerName, ArrayList<String> CustomerEmail) {
        this.context = context;
        this.CustomerName = CustomerName;
        this.CustomerEmail = CustomerEmail;
    }

    @Override
    public int getCount() {
        return CustomerEmail.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final ViewHolder holder;
        controllerdb = new Controllerdb(context);
        LayoutInflater layoutInflater;

        if (convertView == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.layout, null);

            holder = new ViewHolder();

            holder.name = (TextView) convertView.findViewById(R.id.tvname);
            holder.email = (TextView) convertView.findViewById(R.id.tvemail);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.email.setText(CustomerEmail.get(position));
        holder.name.setText(CustomerName.get(position));

        return convertView;
    }
}
