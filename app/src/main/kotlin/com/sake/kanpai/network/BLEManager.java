package com.sake.kanpai.network;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Handler;
import android.os.ParcelUuid;
import android.widget.Toast;

public class BLEManager {
    private Context context;

    public BLEManager(Context context) {
        this.context = context;
    }

    private BluetoothAdapter mBluetoothAdapter;
    private boolean bleFlg;
    private Handler mHandler = new Handler();

    public void search() {
        bleEnable();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // timeout
                Toast.makeText(context, "Request timed out", Toast.LENGTH_SHORT).show();
                mBluetoothAdapter.stopLeScan(mLeScanCallback);
                bleDisable();
            }
        }, 10000);

        // start scanning BLE
        mBluetoothAdapter.startLeScan(mLeScanCallback);
    }

    public void init() {
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = bluetoothManager.getAdapter();
        if (mBluetoothAdapter != null) {
            bleFlg = false;
            if (!(bleFlg = mBluetoothAdapter.isEnabled())) {
                mBluetoothAdapter.enable();
            }
        }
    }

    private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() {
        @Override
        public void onLeScan(final BluetoothDevice device, int rssi, byte[] scanRecord) {
//            getScanData(scanRecord);
            ParcelUuid[] uuids = device.getUuids();
            if (uuids != null) {
                for (ParcelUuid uuid : uuids) {
                    if (uuid.toString().equals("00fe6f-00-100-800-0805f9b34fb")) {
                        Toast.makeText(context, "信号を受信しました。", Toast.LENGTH_SHORT).show();
                        closeScanningBLE();
                        break;
                    }
                }
            }

        }
    };

    private void getScanData(byte[] scanRecord) {

        String uuid = Integer.toHexString(scanRecord[9] & 0xff)
                + Integer.toHexString(scanRecord[10] & 0xff)
                + Integer.toHexString(scanRecord[11] & 0xff)
                + Integer.toHexString(scanRecord[12] & 0xff)
                + "-"
                + Integer.toHexString(scanRecord[13] & 0xff)
                + Integer.toHexString(scanRecord[14] & 0xff)
                + "-"
                + Integer.toHexString(scanRecord[15] & 0xff)
                + Integer.toHexString(scanRecord[16] & 0xff)
                + "-"
                + Integer.toHexString(scanRecord[17] & 0xff)
                + Integer.toHexString(scanRecord[18] & 0xff)
                + "-"
                + Integer.toHexString(scanRecord[19] & 0xff)
                + Integer.toHexString(scanRecord[20] & 0xff)
                + Integer.toHexString(scanRecord[21] & 0xff)
                + Integer.toHexString(scanRecord[22] & 0xff)
                + Integer.toHexString(scanRecord[23] & 0xff)
                + Integer.toHexString(scanRecord[24] & 0xff);

        if (uuid.equals("00fe6f-00-100-800-0805f9b34fb")) {
            Toast.makeText(context, "信号を受信しました。", Toast.LENGTH_SHORT).show();
            mBluetoothAdapter.stopLeScan(mLeScanCallback);
            bleDisable();
        }
    }

    private void closeScanningBLE() {
        mBluetoothAdapter.stopLeScan(mLeScanCallback);
        bleDisable();
        // TODO: Dialog
    }

    private void bleEnable() {
        if (!mBluetoothAdapter.isEnabled()) {
            mBluetoothAdapter.enable();
        }
    }

    private void bleDisable() {
        if (bleFlg != mBluetoothAdapter.isEnabled()) {
            mBluetoothAdapter.disable();
        }
    }
}
