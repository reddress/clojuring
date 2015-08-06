:;;; 06.aug.15 my filter function that accumulates matching elements

(defn filter-accum [lst pred accum]
  (if (empty? lst)
    accum
    (filter-accum (rest lst) pred
                  (if (pred (first lst))
                    (conj accum (first lst))
                    accum))))

(defn my-filter [lst pred]
  (filter-accum lst pred []))

(my-filter [1 2 3 4 5] #(= (mod % 2) 1))
