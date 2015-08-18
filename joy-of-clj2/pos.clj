;;;; p. 112
(defn index [coll])

(defn pos [e coll]
  (for [[i v] (index coll) :when (= e v)] i))

