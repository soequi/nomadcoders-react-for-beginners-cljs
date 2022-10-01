(ns nomadcoders.frontend.app
  (:require
    [cljss.core :refer-macros [defstyles]]
    [helix.core :refer [defnc $]]
    ["react-router-dom" :refer [BrowserRouter Routes Route Link]]
    ["react-dom/client" :as rdom]
    [nomadcoders.frontend.routes.home :refer [Home]]
    [nomadcoders.frontend.routes.detail :refer [Detail]]))


(defnc App
  []
  ($ BrowserRouter
     ($ Routes
        ($ Route {:path "/" :element ($ Home)})
        ($ Route {:path "/movie" :element ($ Detail)})
        ($ Route {:path "/movie/:id" :element ($ Detail)}))))

(defn ^:export init []
  (let [root (rdom/createRoot (js/document.getElementById "root"))]
    (.render root ($ App))))
