(ns hello.core)

(enable-console-print!)

(def React (js/require "react-native"))
(def AppRegistry (aget React "AppRegistry"))
(def StyleSheet (aget React "StyleSheet"))
(def Image (partial (aget React "createElement") (aget React "Image")))
(def Text (partial (aget React "createElement") (aget React "Text")))
(def View (partial (aget React "createElement") (aget React "View")))

(def MOCKED_MOVIES_DATA [
   {:title "Title"
    :year "2015"
    :posters {:thumbnail "http://i.imgur.com/UePbdph.jpg"}}])

(def styles (.create StyleSheet (clj->js {
  :container {:flex 1
              :flexDirection "row"
              :justifyContent "center"
              :alignItems "center"
              :backgroundColor "#F5FCFF"}
  :thumbnail {:width 53 :height 81}
  :rightContainer {:flex 1}
  :title {:fontSize 20
          :marginBottom 8
          :textAlign "center"}
  :year {:textAlign "center"}})))

(def create-class (aget React "createClass"))
(defn render []
  (let [movie (first MOCKED_MOVIES_DATA)]
    (View #js {:style (aget styles "container")}
      (Image (clj->js {:style (aget styles "thumbnail")
                       :source {:uri (get-in movie [:posters :thumbnail])}}))
      (View (clj->js {:style (aget styles "rightContainer")})
        (Text (clj->js {:style (aget styles "title")}) (:title movie))
        (Text (clj->js {:style (aget styles "year")}) (:year movie))))))
(def ClojureReactAndroid (create-class #js {:render render}))
(def register-component (aget AppRegistry "registerComponent"))

(register-component "ClojureReactAndroid" (fn [] ClojureReactAndroid))
