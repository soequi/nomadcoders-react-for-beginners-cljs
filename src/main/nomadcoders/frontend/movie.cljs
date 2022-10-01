(ns nomadcoders.frontend.movie
  (:require
    [helix.core :refer [defnc]]
    [helix.dom :as d]))

(defnc Movie
  [{:keys [id
           cover
           title
           summary
           genres]}]
  (d/div {:key id}
    (d/img {:src cover :alt title})
    (d/h2 title)
    (d/p summary)
    (d/ul
      (map (fn [g]
             (d/li {:key g} g)) genres))))
