'use strict';
/**
 * This exposes the native ToastAndroid module as a JS module. Tthis has a
 * function 'show' which takes the following parameters:
 *
 * 1. String message: A string with the text to toast
 * 2. int duration: The duration of the toast. May be ToastAndroid.SHORT or
 *    ToastAndroid.LONG
 */

import React from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';

import { NativeModules } from 'react-native';
module.exports = NativeModules.ToastAndroid;

// import ToastAndroid from './ToastAndroid';
// ToastAndroid.show('Awesome', ToastAndroid.SHORT);

/**
// Call back
UIManager.measureLayout(
  100,
  100,
  (msg) => {
    console.log(msg);
  },
  (x, y, width, height) => {
    console.log(x + ':' + y + ':' + width + ':' + height);
  }
);
*/

/**
// Promises
async function measureLayout() {
  try {
    var {
      relativeX,
      relativeY,
      width,
      height,
    } = await UIManager.measureLayout(100, 100);

    console.log(relativeX + ':' + relativeY + ':' + width + ':' + height);
  } catch (e) {
    console.error(e);
  }
}

measureLayout();
*/
/**
// Sending Events to JavaScript
import { DeviceEventEmitter } from 'react-native';
var ScrollResponderMixin = {
  mixins: [Subscribable.Mixin],


  componentWillMount: function() {
    ...
    this.addListenerOn(DeviceEventEmitter,
                       'keyboardWillShow',
                       this.scrollResponderKeyboardWillShow);
    ...
  },
  scrollResponderKeyboardWillShow:function(e: Event) {
    this.keyboardWillOpenTo = e;
    this.props.onKeyboardWillShow && this.props.onKeyboardWillShow(e);
  },
};
// or directly
...
componentWillMount: function() {
  DeviceEventEmitter.addListener('keyboardWillShow', function(e: Event) {
    // handle event.
  });
}
...
*/

class HelloWorld extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.hello}>Hello, World</Text>
      </View>
    )
  }
}

var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
});

AppRegistry.registerComponent('HelloWorld', () => HelloWorld);
