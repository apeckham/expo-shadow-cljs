(ns test.app
  (:require
   ["expo" :as ex]
   ["react-native" :as rn]
   ["react" :as react]
   [reagent.core :as r]
   [re-frame.core :refer [subscribe dispatch dispatch-sync reg-event-db reg-sub]]
   [shadow.expo :as expo]))

(reg-event-db :initdb [] (fn [] {:count 0}))
(reg-event-db :clicked [] (fn [db] (update db :count inc)))
(reg-sub :count (fn [db _] (:count db)))

(defn root []
  [:> rn/View {:style #js {:flex 1 :justifyContent "center" :alignItems "center" :backgroundColor "lightyellow"}
               }
   [:> rn/Text {:on-press #(dispatch [:clicked])
                :style #js {:fontSize 48}}
               @(subscribe [:count])]
   [:> rn/Text {:on-press #(dispatch [:clicked])
                :style #js {:fontSize 24 :fontWeight "bold" :color "red"}} "shadow-cljs rocks"]])

(defn start []
  {:dev/after-load true}
  []
  (dispatch-sync [:initdb])
  (expo/render-root (r/as-element [root])))

(defn init []
  (start))