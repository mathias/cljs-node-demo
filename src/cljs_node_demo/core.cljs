(ns cljs-node-demo.core
  (:require [cljs.nodejs :as node]))

(def http (node/require "http"))

(defn handler [req res]
  (.writeHead res 200 (str {"Content-Type" "text/plain"}))
  (.end res "Hello world!\n"))

(defn start [& _]
  (let [server (.createServer http handler)]
    (.listen server 1337 "127.0.0.1")
    (println "Server running at http://127.0.0.1:1337")))

(set! *main-cli-fn* start)
