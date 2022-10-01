(ns nomadcoders.frontend.components.movie
  (:require
    [helix.core :refer [defnc $]]
    [helix.dom :as d]
    ["react-router-dom" :refer [Link]]))

(defnc Movie
  [{:keys [id
           cover
           title
           summary
           genres]}]
  (d/div
    (d/img {:src cover :alt title})
    (d/h2 ($ Link {:to (str "/movie/" id)} title))
    (d/p summary)
    (d/ul
      (map (fn [g]
             (d/li {:key g} g)) genres))))