(ns test.app
  (:require
   ["expo" :as ex]
   ["react-native" :as rn]
   ["react" :as react]
   [reagent.core :as r]
   [shadow.expo :as expo]))

(defn root []
  [:> rn/View {:style #js {:flex 1 :justifyContent "center" :alignItems "center" :backgroundColor "lightyellow"}}
   [:> rn/Text {:style #js {:fontSize 24 :fontWeight "bold" :color "red"}} "shadow-cljs rocks"]])

(defn start []
  {:dev/after-load true}
  []
  (expo/render-root (r/as-element [root])))

(defn init []
  (start))
