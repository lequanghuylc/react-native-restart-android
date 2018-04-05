# react-native-restart-android 

Restart the whole react native android application 

Note: this project is Android only

## Installation Process

* download this from npm

```
npm install react-native-restart-android --save
```

* Run `react-native link` to automatically link the library.

#### manual link process

* Edit `android/settings.gradle`:

  ```diff
  + include ':react-native-restart-android'
  + project(':react-native-restart-android').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-restart-android/android')
  ```

* Edit `android/app/build.gradle`:

  ```diff
  dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile "com.android.support:appcompat-v7:23.0.1"
    compile "com.facebook.react:react-native:+"
  + compile project(':react-native-restart-android')
  }
  ```

* Edit `android/app/src/main/java/.../MainApplication.java`:

  ```diff
  + import com.rnrestartandroid.RNRestartAndroidPackage;
  ```

  ```diff
    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
        new MainReactPackage()
  +     , new RNRestartAndroidPackage()
      );
    }
  ```

## Usage

```js
import RestartAndroid from 'react-native-restart-android'
// or
import { RestartAndroid } from 'react-native-restart-android'
// or
const RestartAndroid = require('react-native-restart-android')

// methods (Android only, will throw Error on iOS)
RestartAndroid.restart()
```
