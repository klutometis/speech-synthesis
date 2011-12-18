(ns speech-synthesis.say
  (:require [clj-http.client :as client]
            [fs.core :as fs]
            [clojure.java.io :as io])
  (:import (java.io File FileOutputStream)
           (javazoom.jl.player Player)))

(defn say [response]
  (let [mp3 (:body (client/get "http://translate.google.com/translate_tts"
                        {:query-params {"ie" "UTF-8"
                                        "tl" "en"
                                        "q" response}
                         :as :byte-array}))
        file (fs/temp-file "say" ".mp3")]
    (with-open [file (FileOutputStream. file)]
      (.write file mp3))
    (with-open [player (new Player (io/input-stream file))]
      (.play player))))