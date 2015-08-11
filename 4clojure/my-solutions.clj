;;;; 4clojure.com
:;;; pontual # username

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #156 Map defaults

((fn [default-value coll]
   (apply hash-map (interleave coll (repeat default-value)))) 0 [:a :b :c])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #134 A nil key

((fn [k m] (nil? (get m k :not-found))) :a {:a nil :b 2})

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #23 Reverse a Sequence

;;; original solution
(fn rev [lst]
  (letfn [(iter [lst result]
            (if (empty? lst)
              result
              (iter (rest lst) (cons (first lst) result))))]
    (iter lst ())))

;;; Note: Use recur instead of repeating the function name, as seen in
;;; answer by nikelandjelo
(fn rev [lst]
  ((fn [lst result]
     (if (empty? lst)
       result
       (recur (rest lst) (cons (first lst) result))))
   lst ()))

;;; daowen: solutions do not have to be functions
reduce conj ()

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #38 Maximum value
(fn [& xs] (reduce #(if (> %1 %2) %1 %2) xs))

;;; same as daowen. I like.


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #57 Simple recursion

;;; problem
((fn foo [x]
   (when (> x 0)
     (conj (foo (dec x)) x))) 5)
;;; when returns nil if x <= 0, and it becomes the empty list.
;;; expression becomes (conj (conj ... (conj nil 1) 2) 3) 4) 5)
;;; because we are dealing with a list, the result is '(5 4 3 2 1)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #26 Fibonacci Sequence

(defn single-let-fib [n]
  (letfn [(fib-iter [n result]
            (if (= n 2)
              result
              (let [ct (count result)]
                (recur (- n 1) (conj result (+ (nth result (- ct 1))
                                               (nth result (- ct 2))))))))]
    (fib-iter n [1 1])))

;;; daowen's solution
(defn daowen-fib [n]
  (take n ((fn fib [x y]
             (lazy-seq
              (cons x (fib y (+ x y)))))
           1 1)))

;;;; #26 Fibonacci sequence, redone as lazy, from my memory
#(take % ((fn lazy-fib [a b]
            (lazy-seq
             (cons a (lazy-fib b (+ a b))))) 1 1))

;;;; Programming Clojure solution
(def fibs (lazy-cat [1 1] (map + fibs (rest fibs))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; Factorial

;;; notice that factorial is equivalent to sum of a range

(#(apply * (drop 1 (range (+ % 1)))) 5)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #46 Flipping out - Flip first and second arguments

(fn flip [f]
  (fn [a b]  
    (f b a)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #28 Flatten a sequence

((fn [s]
   (letfn [(iter [s result]
             (let [fst (first s)]
               (cond
                 (empty? s) result
                 (not (coll? fst)) (iter (rest s) (conj result fst))
                 ;;; concat, not conj or cons
                 :else (iter (concat (iter fst []) (rest s)) result))))]
     (iter (vec s) []))) '((1 2) (((3))) [4 [5 6]]))

;;; jfacorro's solution
(fn flat [lst]
  (if (not (coll? lst)) [lst]
      (reduce concat (map flat lst))))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #66 Greatest common divisor

;;; Poor man's Euclid's algorithm
;;; Uses remainder on SICP
((fn gcd [a b]
   (cond
     (> b a) (gcd b a)
     (= b 0) a
     :else (gcd b (- a b)))) 7 5)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #22 Count a sequence

;;; hisba's solution

#(reduce (fn [n x] (inc n)) 0 %1)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #27 Palindrome detector

;;; use (seq %) to convert lists, strings, vectors... to an expanded seq

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #49 Split a sequence

#(concat (list (take % %2)) (list (drop % %2)))

;;; daowen's solution

(juxt take drop)
