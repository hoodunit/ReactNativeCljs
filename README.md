# ClojureScript on React Native for Android

Proof of concept for compiling ClojureScript for use on React Native for Android. This is simple ClojureScript JS interop duplicating the React Native example [here](https://facebook.github.io/react-native/doc/tutorial.html#content). The original JavaScript source is in [index.original.android.js](https://github.com/nicholaskariniemi/ReactNativeCljs/blob/master/index.original.android.js) and the ported ClojureScript code is in [src/hello/core.cljs](https://github.com/nicholaskariniemi/ReactNativeCljs/blob/master/src/hello/core.cljs).

## To build/run
1. Set up project for usage:
  `npm install && react-native android`
1. Plug in Android device (or load up emulator).
1. Build app and push it to the device. Enable auto-refresh in the app options.

  `react-native run-android`

1. Start server for serving up JS files to the device app.

  `react-native start`

1. Start incremental ClojureScript compilation to recompile when source files change.

  `./watch.sh`

1. Hack away in ClojureScript. Saved changes will be automatically compiled to `index.android.js` and pushed out to the app.
