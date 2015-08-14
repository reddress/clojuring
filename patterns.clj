;;;; Common patterns

;;;; map function to sequence

;;; example: double every number in the sequence
(defn dbl [n] (* 2 n))
(def v [1 2 3 -1 -2])  ;; vector
(def lst '(10 20 30 -10 -20))  ;; list

;;; functional with built-in, map
(map dbl v)
(map dbl lst)

;;; build up with linear recursion
(defn linear-rec [f s]
  (if (empty? s)
    ()
    ;;; base case must be a list to maintain order.
    ;;; [] will result in reversed values
    ;;; (conj (conj (conj () 1) 2) 3) is (3 2 1)
    ;;; each step adds item to the front of the list
    (conj (linear-rec f (rest s)) (f (first s)))))

(linear-rec dbl v)
(linear-rec dbl lst)

;;; linear iteration
(defn linear-iter [f s]
  (letfn [(iter [f s result]
            (if (empty? s)
              result
              ;; call recur instead of using the function's name, iter
              (recur f (rest s) (conj result (f (first s))))))]
    ;;; result equals (conj (conj (conj [] 1) 2) 3)
    ;;; (conj (conj [] 1) 2) is [1 2] (each step adds to the end)
    ;;; must be a vector to maintain order, with () the result is reversed
    (iter f s [])))  

;;; linear iteration with loop
(defn loop-iter [f s]
  (loop [s s result []]
    (if (empty? s)
      result
      (recur (rest s) (conj result (f (first s)))))))

(linear-iter dbl v)
(linear-iter dbl lst)

(loop-iter dbl v)
(loop-iter dbl lst)

;;; list comprehension 
(defn for-map [f s]
  (for [x s] (f x)))

(for-map dbl v)
(for-map dbl lst)
