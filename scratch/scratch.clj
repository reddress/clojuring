(+ 1 2)

(- 2 3)

(- 1 2)
(+ (* 1 1) (* 2 2) (* 3 3))


(+
 (* 10
    10)
 (* 20 20)
 (* 30 30))

(comment
  
  (+ 1 1)
  (if true
    1
    2)
  
  )


(time
 (nth
  ((fn my-lazy-range [n]
     (lazy-seq 
      (cons n (my-lazy-range (inc n)))))
   0) 999999))


(defn mapdef [def ks]
  "4clojure map defaults"
  (loop [remks ks result {}]
    (if (empty? remks)
      result
      (recur (rest remks) (conj result {(first remks) def})))))

(defn build-result [n]
  (loop [count n result []]
    (if (> count 0)
      (recur (dec count) (conj result count))
      result)))

(defn my-count [s]
  (if (next s)
    (+ 1 (my-count (next s)))
    0))
