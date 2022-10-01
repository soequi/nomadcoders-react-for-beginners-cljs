(ns nomadcoders.frontend.routes.home
  (:require [helix.core :refer [defnc $]]
            [helix.dom :as d]
            [helix.hooks :as hooks]
            [promesa.core :as p]
            [nomadcoders.frontend.components.movie :refer [Movie]]
            [nomadcoders.frontend.utils :refer [json-get]]))

(defnc Home
  []
  (let [[loading set-loading] (hooks/use-state true)
        [movies set-movies] (hooks/use-state [])]

    (hooks/use-effect []
                      (p/let [{:keys [data]} (json-get "https://yts.mx/api/v2/list_movies.json?minimum_rating=8.8&sort_by=year")]
                             (set-movies (:movies data))
                             (set-loading false)))
    ;(js/console.log movies)
    (d/div
      (if loading
        (d/h1 "Loading...")
        (d/div
          (map (fn [movie]
                 ($ Movie {:key (:id movie)
                           :id (:id movie)
                           :cover (:medium_cover_image movie)
                           :title (:title movie)
                           :summary (:summary movie)
                           :genres (:genres movie)})) movies))))))

