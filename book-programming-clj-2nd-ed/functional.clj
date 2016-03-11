;;;; p. 91 functional programming

;;; bad idea
(defn stack-consuming-fib [n]
  (cond
    (= n 0) 0
    (= n 1) 1
    :else (+ (stack-consuming-fib (- n 1))
             (stack-consuming-fib (- n 2)))))

;;; (stack-consuming-fib 1000)

;;; iterative method 
(defn tail-fib [n]
  (letfn [(fib [current next n]
            (if (zero? n)
              current
              (fib next (+ current next) (dec n))))]
    (fib 0N 1N n)))

(tail-fib 1000)

;;; explicit self-recursion
(defn recur-fib [n]
  (letfn [(fib [current next n]
            (if (zero? n)
              current
              (recur next (+ current next) (dec n))))]
    (fib 0N 1N n)))

(recur-fib 1000)

;;; lazy seq
(defn lazy-seq-fib
  ([]
   (concat [0 1] (lazy-seq-fib 0N 1N)))
  ([a b]
   (let [n (+ a b)]
     (lazy-seq
      (cons n (lazy-seq-fib b n))))))

(take 10 (lazy-seq-fib))

;;; (rem (nth (lazy-seq-fib) 100000) 1000)


