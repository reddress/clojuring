;;; solutions for user athena/a...#

;;; in general, replace (defn FN-NAME [arglist] ... with (fn [arglist] ...

(ns four-clojure
  (:require [clojure.core :refer :all]
            [clojure.repl :refer :all]
            [clojure.test :refer :all]))

;;; 22 mar 2016
;;; #26

;;; 
;;; (__ 3) '(1 1 2)

(defn fib [n]
  (letfn [(iter [i result]
            (cond (= i n) result
                  :else (recur (inc i) (conj result (+ (nth result (- i 1))
                                                       (nth result (- i 2)))))))]
    (iter 2 [1 1])))

(fib 8)

;;; does nothing because conj cannot alter immutable "result"
(defn conj-dotimes [n]
  (let [result [0]]
    (dotimes [i n]
      (conj result i))
    result))

(defn build-iter [num]
  (letfn [(iter [n result]
            (if (= n 0)
              result
              (recur (- n 1) (conj result n))))]
    (iter num [])))

(build-iter 3)

(deftest test-fib
  (is (= (fib 3) '(1 1 2))))

(run-tests 'four-clojure)


;;; #23

(defn my-reverse [s]
  ((fn [items result]
    (if (seq items)
      (recur (rest items) (cons (first items) result))
      result)) s '()))

(my-reverse '(1 2 3))

(deftest test-reverse
  (is (= (my-reverse [1 2 3 4 5]) [5 4 3 2 1]))
  (is (= (my-reverse [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])))

(run-tests 'four-clojure)

;;; #27

(defn is-palindrome [x]
  (if (string? x)
    (= x (clojure.string/reverse x))
    (= x (reverse x))))

(#(= % ((if (string? %) clojure.string/reverse reverse) %)) "racecar")


;;; #32

(defn dupe [s]
  (loop [items s
         result []]
    (let [first-item (first items)]
      (if (seq items)
        (recur (rest items) (conj result first-item first-item))
        result))))

(dupe '(:a :a :b))
