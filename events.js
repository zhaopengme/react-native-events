/**
 * @providesModule react-native-events
 */

var RNDeviceInfo = require('react-native').NativeModules.RNDeviceInfo;

module.exports = {
  getUniqueID: function () {
    return RNDeviceInfo.uniqueId;
  }
};
