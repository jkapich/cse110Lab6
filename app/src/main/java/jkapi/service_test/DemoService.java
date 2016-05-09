package jkapi.service_test;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class DemoService extends Service {

    public DemoService() {
    }

    @Override
    public int onStartCommand (Intent intent, int flags, int startID) {
        Toast.makeText(DemoService.this, "Service Started", Toast.LENGTH_SHORT).show();

        synchronized (this) {
            try {
                wait(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            stopSelf();
        }
        return super.onStartCommand(intent, flags, startID);
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy () {
        Toast.makeText(DemoService.this, "Service Stopped", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
