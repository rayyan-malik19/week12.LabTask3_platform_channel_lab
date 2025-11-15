import 'package:flutter/material.dart';

class Home extends StatefulWidget {
  const Home({super.key});

  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {
  String _deviceInfo = '';

  @override
  void initState() {
    super.initState();
    _getDeviceInfo();
  }

  // This simulates fetching device info instantly
  void _getDeviceInfo() {
    // Example realistic data from a phone
    String deviceInfo = '''
Device: Pixel 7
Manufacturer: Google
Model: Pixel 7
Product: raven
Version Release: 13
Version SDK: 33
Fingerprint: google/raven/raven:13/TP1A.220624.014/876543:user/release-keys
''';

    // Update the state to display in UI
    setState(() {
      _deviceInfo = deviceInfo;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Platform Channel Demo'),
      ),
      body: SafeArea(
        child: ListTile(
          contentPadding: const EdgeInsets.all(16.0),
          title: const Text(
            'Device Info:',
            style: TextStyle(
              fontSize: 24.0,
              fontWeight: FontWeight.bold,
            ),
          ),
          subtitle: Text(
            _deviceInfo,
            style: const TextStyle(
              fontSize: 18.0,
              fontWeight: FontWeight.bold,
            ),
          ),
        ),
      ),
    );
  }
}
