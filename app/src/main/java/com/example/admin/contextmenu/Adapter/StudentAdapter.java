package com.example.admin.contextmenu.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.contextmenu.R;
import com.example.admin.contextmenu.Student;

import java.util.ArrayList;


public class StudentAdapter extends BaseAdapter {
 ArrayList<Student> mArraylist;
 LayoutInflater mLayoutInflater;

 public StudentAdapter(Context context, ArrayList<Student> mArraylist) {
 this.mArraylist = mArraylist;
 this.mLayoutInflater = LayoutInflater.from(context);
 }

 @Override
 public int getCount() {
 return mArraylist.size();
 }

 @Override
 public Object getItem(int position) {
 return mArraylist.get(position);
 }

 @Override
 public long getItemId(int position) {
 return position;
 }

 @Override
 public View getView(int position, View convertView, ViewGroup parent) {
 convertView=mLayoutInflater.inflate(R.layout.list_item,parent,false);
 Student student=(Student)getItem(position);

 TextView name=(TextView)convertView.findViewById(R.id.name);
 TextView phone=(TextView)convertView.findViewById(R.id.phone);
 name.setText(student.getName());
 phone.setText(student.getPhone());
 return convertView;
 }
 }
