(defn print-me [item]
  (println item))

(defn process [items]
  (map print-me items))

(process [1 2])

(def a (process [1 2 3]))
