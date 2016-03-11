;;;; loops
;;; 6.aug.2015

;;; countdown p.46
(loop [result []
       x 5]
  (if (zero? x)
    result
    (recur (conj result x) (dec x))))

;;; p.49
(defn indexed [coll] (map-indexed vector coll))

(defn index-filter [pred coll]
  (when pred
    (for [[idx elt] (indexed coll) :when (pred elt)] idx)))

;;; p. 68
(for [file "ABCDEFGH" rank (range 1 9)] (format "%c%d" file rank))

(count
 (for [suit "CDHS" rank "A23456789TJQK"] (format "%c%c" rank suit)))

