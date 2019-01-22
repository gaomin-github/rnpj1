/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  NativeModules,  
  TouchableOpacity,
  DeviceEventEmitter,
} from 'react-native';

export default class rnpj1 extends Component {
  componentDidMount(){
      DeviceEventEmitter.addListener('consoleYS',this.eventHandler);
  };
  componentWillUnmount(){
      DeviceEventEmitter.removeListener('consoleYS',this.eventHandler);
  }

  eventHandler=(message)=>{
      console.log('consoleYs：')
      console.log(message)
  }
  onPressYS(){
      NativeModules.TestModule1.startActivityFromJS("com.rnpj1.testPlugin1.TestActivity1",null);
  }
  onPressYSParam1(){
      NativeModules.TestModule2.startActivityFromJS("com.rnpj1.testPlugin2.TestActivity2",'前台传给原生');
  }
  onPressYSParam2(){
      NativeModules.TestModule3.startActivityFromJS("com.rnpj1.testPlugin3.TestActivity3",null);
  }
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>
        <Text style={styles.instructions}>
          To get started, edit index.android.js
        </Text>
        <Text style={styles.instructions}>
          Double tap R on your keyboard to reload,{'\n'}
          Shake or press menu button for dev menu
        </Text>
        <TouchableOpacity onPress={this.onPressYS} >
          <Text style={{color:'#50B1F8',fontSize:16}}>原生调用</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={this.onPressYSParam1} >
          <Text style={{color:'#50B1F8',fontSize:16}}>原生调用传参</Text>
        </TouchableOpacity>
        <TouchableOpacity onPress={this.onPressYSParam2} >
          <Text style={{color:'#50B1F8',fontSize:16}}>原生回调传参</Text>
        </TouchableOpacity>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

AppRegistry.registerComponent('rnpj1', () => rnpj1);
