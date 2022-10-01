(ns nomadcoders.frontend.routes.detail
  (:require [helix.core :refer [defnc]]
            [helix.dom :as d]
            [helix.hooks :as hooks]
            [goog.object :as gobj]
            [promesa.core :as p]
            ["react-router-dom" :refer [useParams]]
            [nomadcoders.frontend.utils :refer [json-get]]))

(defnc Detail
  []
  (let [id (-> (useParams)
               (gobj/get "id"))]
    (js/console.log id)
    (hooks/use-effect
      []
      (p/let [json (json-get (str "https://yts.mx/api/v2/movie_details.json?movie_id=" id))]
             (js/console.log (get-in json [:data :movie]))))
    (d/h1 "Detail")))
