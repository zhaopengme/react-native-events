# react-native-events

Get phone call or Headset event using react-native

## Installation

### Manual installation

**Android:**

1.In your android/settings.gradle file, make the following additions:
```
include ':react-native-events'
project(':react-native-events').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-events/android')
```

2.In your android/app/build.gradle file, add the `:react-native-events` project as a compile-time dependency:

```
...
dependencies {
    ...
    compile project(':react-native-events')
}
```

3.Update the MainApplication.java file to use `react-native-events` via the following changes:

```java
import me.zhaopeng.RNEvents.RNEventsPackage;
public class MainApplication extends Application implements ReactApplication {

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        protected boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(
                    new MainReactPackage(),
                    new RNEventsPackage(),  //here
            );
        }
    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }
}
```