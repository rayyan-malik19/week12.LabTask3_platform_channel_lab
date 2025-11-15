package com.example.labtask3_week12_mad // <-- replace with your package

import android.os.Build
import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {

    private val DEVICE_INFO_CHANNEL = "platformchannel.companyname.com/deviceinfo"

    // Attach MethodChannel here
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, DEVICE_INFO_CHANNEL)
            .setMethodCallHandler { call, result ->
                if (call.method == "getDeviceInfo") {
                    val deviceInfo = getDeviceInfo()
                    result.success(deviceInfo)
                } else {
                    result.notImplemented()
                }
            }
    }

    // Function to get device info
    private fun getDeviceInfo(): String {
        return "\nDevice: ${Build.DEVICE}" +
                "\nManufacturer: ${Build.MANUFACTURER}" +
                "\nModel: ${Build.MODEL}" +
                "\nProduct: ${Build.PRODUCT}" +
                "\nVersion Release: ${Build.VERSION.RELEASE}" +
                "\nVersion SDK: ${Build.VERSION.SDK_INT}" +
                "\nFingerprint: ${Build.FINGERPRINT}"
    }
}
