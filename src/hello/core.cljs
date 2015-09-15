(ns hello.core)

(enable-console-print!)

(def React (js/require "react-native"))
(def AppRegistry (aget React "AppRegistry"))
(def StyleSheet (aget React "StyleSheet"))
(def Text (partial (aget React "createElement") (aget React "Text")))
(def View (partial (aget React "createElement") (aget React "View")))

(def styles (.create StyleSheet (clj->js {
  :container {:flex 1
              :justifyContent "center"
              :alignItems "center"
              :backgroundColor "#F5FCFF"}
  :welcome {:fontSize 20
            :textAlign "center"
            :margin 10}
  :instructions {:textAlign "center"
                 :color "#333333"
                 :marginBottom 5}})))

(def main-view (View #js {:style (aget styles "container")}
  (Text #js {:style (aget styles "welcome")} "Welcome to ClojureScript on React Native!")
  (Text #js {:style (aget styles "instructions")} "To get started, edit src/core/hello.cljs")
  (Text #js {:style (aget styles "instructions")} "Shake or press menu button for dev menu")))

(def create-class (aget React "createClass"))
(def ClojureReactAndroid (create-class #js {:render (fn [] main-view)}))
(def register-component (aget AppRegistry "registerComponent"))

(register-component "ClojureReactAndroid" (fn [] ClojureReactAndroid))
