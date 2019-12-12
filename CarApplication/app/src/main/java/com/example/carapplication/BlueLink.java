package com.example.carapplication;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Set;

public class BlueLink extends Activity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private BluetoothAdapter bluetoothAdapter;
    private ArrayList<String> devicesList = new ArrayList<>();
    private ArrayAdapter<String> listAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.link);
        listView = findViewById(R.id.listview1);
        listAdapter = new ArrayAdapter<String>(BlueLink.this,android.R.layout.simple_list_item_1,devicesList);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(!bluetoothAdapter.isEnabled()){
            bluetoothAdapter.enable();
        }
        Set<BluetoothDevice> set = bluetoothAdapter.getBondedDevices();
        for(BluetoothDevice tmp:set){
            StringBuilder sb = new StringBuilder();
            sb.append(tmp.getName()).append(" ").append(tmp.getAddress());
            devicesList.add(sb.toString());
        }
        listAdapter.notifyDataSetChanged();
    }

    private class BlueReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            String gg = device.getName()+" "+device.getAddress();
                if (!devicesList.contains(gg)) {
                devicesList.add(gg);
                listAdapter.notifyDataSetChanged();
                }
                }
            if(BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)){
                Toast.makeText(BlueLink.this, "停止搜索", Toast.LENGTH_SHORT).show();
            }
            }
            }


    private BlueReceiver receiver;
    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction(BluetoothDevice.ACTION_FOUND);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        receiver = new BlueReceiver();
        this.registerReceiver(receiver,filter);
        bluetoothAdapter.startDiscovery();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String tmp = devicesList.get(i);
        String[] a= tmp.split(" ");
        String address = a[1];
        Bundle bundle  = new Bundle();
        bundle.putString("address",address);
        Intent intent = new Intent(BlueLink.this,MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
