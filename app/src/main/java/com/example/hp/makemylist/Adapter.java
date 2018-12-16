package com.example.hp.makemylist;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context mContext;
    private Cursor mCursor;

    public Adapter(Context context, Cursor cursor)
    {
        mContext=context;
        mCursor=cursor;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nameText;
        public TextView countText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameText= itemView.findViewById(R.id.textview_name_item);
            countText= itemView.findViewById(R.id.textview_amount_item);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        LayoutInflater inflater= LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int i) {
        if(!mCursor.moveToPosition(i)){
            return;
        }
        String name = mCursor.getString(mCursor.getColumnIndex(Contract.Entry.COLUMN_NAME));
        int amount = mCursor.getInt(mCursor.getColumnIndex(Contract.Entry.COLUMN_AMOUNT));
        long id=mCursor.getLong(mCursor.getColumnIndex(Contract.Entry._ID));

        holder.nameText.setText(name);
        holder.countText.setText(String.valueOf(amount));
        holder.itemView.setTag(id);
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor){
        if(mCursor!=null){
            mCursor.close();
        }
        mCursor = newCursor;

        if(newCursor!=null)
            notifyDataSetChanged();;
    }
}
