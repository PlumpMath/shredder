(ns shredder.core
    (:require [shredder.dev :refer [is-dev?]]
              [om.core :as om :include-macros true]
              [om-tools.dom :as dom :include-macros true]
              [om-tools.core :refer-macros [defcomponent]]
              [om-bootstrap.button :as b]))

(defonce app-state (atom {:text "Hello Chestnut!"}))


(om/root
  (fn [app owner]
    (reify om/IRender
      (render [_]
        (dom/div
          (dom/h1 (:text app))
          (dom/p "Foo")
          (b/toolbar {}
                     (b/button {} "Default")
                     (b/button {:bs-style "primary"} "Primary")
                     (b/button {:bs-style "success"} "Success")
                     (b/button {:bs-style "info"} "Info")
                     (b/button {:bs-style "warning"} "Warning")
                     (b/button {:bs-style "danger"} "Danger")
                     (b/button {:bs-style "link"} "Link"))))))
  app-state
  {:target (. js/document (getElementById "app"))})


;; Original om/root
;(om/root
;  (fn [app owner]
;    (reify om/IRender
;      (render [_]
;        (dom/h1 (:text app)))))
;  app-state
;  {:target (. js/document (getElementById "app"))})
