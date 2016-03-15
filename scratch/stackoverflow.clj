(defn count-down [n]
  (when-not (zero? n)
    (when (zero? (rem n 100))
      (println "count-down: " n))
    (count-down (dec n))))
