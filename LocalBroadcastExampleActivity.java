import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LocalBroadcastExampleActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_list);
		
		Button buttonStartService = (Button)findViewById(R.id.button_ok);
		buttonStartService.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Register MessageService in Manifest to work
				startService(new Intent(LocalBroadcastExampleActivity.this, MessageService.class));
			}
		});

	}

	@Override
	protected void onPause() {
		// Unregister since the activity is paused.
		LocalBroadcastManager.getInstance(this).unregisterReceiver(
				mMessageReceiver);
		super.onPause();
	}

	@Override
	protected void onResume() {
		// Register to receive messages.
		// We are registering an observer (mMessageReceiver) to receive Intents
		// with actions named "custom-event-name".
		LocalBroadcastManager.getInstance(this).registerReceiver(
				mMessageReceiver, new IntentFilter("custom-event-name"));
		super.onResume();
	}

	// Our handler for received Intents. This will be called whenever an Intent
	// with an action named "custom-event-name" is broadcasted.
	private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			// Get extra data included in the Intent
			String message = intent.getStringExtra("message");
			Log.d("receiver", "Got message: " + message);
		}
	};

	public class MessageService extends Service {

		@Override
		public IBinder onBind(Intent intent) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int onStartCommand(Intent intent, int flags, int startId) {
			// TODO Auto-generated method stub
			sendMessage();
			return super.onStartCommand(intent, flags, startId);
		}
		
		// Send an Intent with an action named "custom-event-name". The Intent
		// sent should
		// be received by the ReceiverActivity.
		private void sendMessage() {
			Log.d("sender", "Broadcasting message");
			Intent intent = new Intent("custom-event-name");
			// You can also include some extra data.
			intent.putExtra("message", "This is my message!");
			LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
		}

	}

}
