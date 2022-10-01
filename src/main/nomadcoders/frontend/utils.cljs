(ns nomadcoders.frontend.utils
  (:require [promesa.core :as p]))

(defn json-get [url]
  (p/let [resp (js/fetch url)
          json (.json resp)]
         (js->clj json :keywordize-keys true)))
