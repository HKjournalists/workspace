package com.mz.youchat.activity.user;

import com.youchat.R;
import com.youchat.R.layout;
import com.youchat.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class UserSettingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_setting);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_setting, menu);
		return true;
	}

}
