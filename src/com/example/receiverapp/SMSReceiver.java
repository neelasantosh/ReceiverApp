package com.example.receiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "new sms...", 5).show();
		
		Bundle bn = intent.getExtras();
		Object [] smsObject = (Object[]) bn.get("pdus");//constant value key to get data from number
		//get first sms par data
		byte[] smsBytes = (byte[]) smsObject[0];
		
		//convert sms bytes to an object
		SmsMessage sms = SmsMessage.createFromPdu(smsBytes);
		
		String number = sms.getDisplayOriginatingAddress();
		String content = sms.getMessageBody();
		
		Toast.makeText(context, number +","+content, 5).show();
		
		//start activity when sms received
		Intent in = new Intent(context,MainActivity.class);
		in.putExtra("sms", number+","+content);
		in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(in);
	}

}
