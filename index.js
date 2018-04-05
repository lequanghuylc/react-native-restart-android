import { NativeModules, Platform } from "react-native";
const { RNRestartAndroid } = NativeModules;

function unSupportedError() {
  throw new Error("[react-native-restart-android] does not support iOS");
}

const RestartAndroid = Platform.OS === "android"
  ? {
      restart() {
        return RNRestartAndroid.restart();
      }
    }
  : {
      restart: unSupportedError
    };

export { RestartAndroid };
export default RestartAndroid;
