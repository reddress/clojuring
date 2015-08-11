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

