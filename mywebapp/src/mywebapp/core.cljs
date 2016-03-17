(ns mywebapp.core)

(enable-console-print!)

(println "Hello world 2")

(defn ^:export triple [x]
  (+ x x x))
