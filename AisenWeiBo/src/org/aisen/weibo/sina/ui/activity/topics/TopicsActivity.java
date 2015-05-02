package org.aisen.weibo.sina.ui.activity.topics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.m.ui.activity.basic.BaseActivity;
import com.m.ui.fragment.ABaseFragment;

import org.aisen.weibo.sina.R;
import org.aisen.weibo.sina.ui.fragment.timeline.TimelineTopicsFragment;

/**
 * 话题
 * 
 * @author wangdan
 *
 */
public class TopicsActivity extends BaseActivity {

	public static void launch(Activity from, String q) {
		Intent intent = new Intent(from, TopicsActivity.class);
		intent.setAction("Previous");
		intent.putExtra("q", q);
		from.startActivity(intent);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comm_ui_fragment_container);

		if (savedInstanceState == null) {
			if (getIntent() != null && "Previous".equals(getIntent().getAction())) {
				ABaseFragment fragment = TimelineTopicsFragment.newInstance(getIntent().getStringExtra("q"));
				getFragmentManager().beginTransaction().replace(com.m.R.id.fragmentContainer, fragment, "TopicsTimelint").commit();
			}
			else {
				Uri data = getIntent().getData();
				if (data != null) {
					String d = data.toString();
					int index = d.lastIndexOf("/");
					String topicsName = d.substring(index + 1);
					topicsName = topicsName.substring(1, topicsName.length() - 1);

					ABaseFragment fragment = TimelineTopicsFragment.newInstance(topicsName);
					getFragmentManager().beginTransaction().replace(com.m.R.id.fragmentContainer, fragment, "TopicsTimelint").commit();
				} 
				else {
					finish();
					return;
				}
			}
		}

	}
	
}
