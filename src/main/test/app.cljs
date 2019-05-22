(ns test.app
  (:require
   ["expo" :as ex]
   ["react-native" :as rn]
   ["react" :as react]
   [reagent.core :as r]
   [shadow.expo :as expo]))

(defn root []
  [:> rn/Text {:style #js {:fontSize 24}} "holy shit world"])

(defn start []
  {:dev/after-load true}
  []
  (expo/render-root (r/as-element [root])))

(defn init []
  (start))
