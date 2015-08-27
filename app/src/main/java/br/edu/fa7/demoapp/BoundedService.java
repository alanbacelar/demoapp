package br.edu.fa7.demoapp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by alan on 8/26/15.
 */
public class BoundedService extends Service {

    private IBinder binder;
    private boolean stop;
    private final String TAG = "DEMOAPP_BOUNDED_SERVICE";

    public BoundedService() {
        this.binder = new LocalIBinder();
        this.stop = false;
    }

    public void start() {
        this.stop = false;

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;


                while(!stop) {
                    try {
                        Log.i(TAG, "Valor: " + i++);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.getStackTrace();
                    }
                }
            }
        }).start();
    }

    public void stop() {
        stop = true;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public class LocalIBinder extends Binder {
        public BoundedService getService() {
            return BoundedService.this;
        }
    }
}
