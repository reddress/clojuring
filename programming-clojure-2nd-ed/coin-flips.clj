;;;; p. 99

;;; simpler version of partition, but does not discard last values
(defn group [lst n]
  (if (empty? lst)
    ()
    (conj (group (drop n lst) n) (take n lst))))

(defn group-iter [lst n]
  (letfn [(iter [lst n result]
            (if (empty? lst)
              (reverse result)
              (recur (drop n lst) n (conj result (take n lst)))))]
    (iter lst n ())))

;;; (group-iter (range 9) 2)

;;; (group (range 11) 3)

(def coin-flips [:h :t :t :h :h :h])

(group (interleave coin-flips (rest coin-flips)) 2)

