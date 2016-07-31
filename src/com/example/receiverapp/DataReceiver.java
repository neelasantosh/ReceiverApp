package com.example.receiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class DataReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String data = intent.getStringExtra("data");
		Toast.makeText(context, "Message:" + data, 5).show();
		
		
	}

}
