;;;; 4clojure.com
:;;; pontual # username

;;;; jump to a problem
;;;; https://www.4clojure.com/problem/PROBLEM_NUMBER

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
;;; 'when' returns nil if x <= 0, and it becomes the empty list when used
;;; with 'conj'.
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

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #33 Replicate a sequence

((fn [coll n] (reduce concat (map #(repeat n %) coll)))
 [[1 2] [3 4]] 2)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #39 Interleave two seqs

((fn [p q] (reduce concat (map #(list % %2) p q)))
 [1 2] [:a :b :c])

;;; use mapcat: returns the result of applying concat to the result of
;;; applying map to f and colls

((fn [p q] (mapcat #(list % %2) p q))
 [1 2] [:a :b :c])


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; #30 Compress a sequence

((fn my-compress [coll]
   (cond
     (<= (count coll) 1) coll
     :else (if (= (first coll) (second coll))
             (my-compress (rest coll))
             (conj (my-compress (rest coll)) (first coll)))))
 [1 1 2 3 3 2 2 3])

;;; daowen's solution
#(map first (partition-by identity %))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #41 Drop every nth item

((fn my-drop [coll n]
   (concat
    (mapcat butlast (partition n coll))
    (drop (* n (quot (count coll) n)) coll)))
 [1 2 3 4 5 6 7 8] 3)

;;; shorter solutions use partition-all (does not throw away last elements)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #51 Advanced destructuring

;;; (= [1 2 [3 4 5] [1 2 3 4 5]] ...)

(let [[a b & c :as d]
      [1 2 3 4 5]]
  [a b c d])

;;; :as d saves entire value into d. Since the last element of the test vector
;;; is [1 2 3 4 5], it follows that d is [1 2 3 4 5], and the blank is also
;;; [1 2 3 4 5]


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #83 A Half-truth

((fn [& coll] (if (not (every? identity coll))
                (if (some identity coll)
                  true
                  false)
                false))
 true true false)

;;; use %& for collecting varargs
;;; daowen's solution
#(boolean (and (some true? %&) (some false? %&)))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; #118 Re-implement map

;;; stack overflow
((fn my-map [f coll]
   (if (empty? coll)
     ()
     (cons (f (first coll)) (my-map f (rest coll)))))
 inc [2 3 4 5 6])


;;; iterative solution
;;; times out
((fn my-map [f coll]
   (letfn [(iter [f coll result]
             (if (empty? coll)
               result
               (recur f (rest coll) (conj result (f (first coll))))))]
     (iter f coll [])))
 inc [2 3 4 5 6])

;;; insert recursive call in (lazy-seq ...), as suggested in Programming
;;; Clojure 2nd ed.

((fn my-map [f coll]
   (if (empty? coll)
     ()
     (lazy-seq
      (cons (f (first coll)) (my-map f (rest coll))))))
 inc [2 3 4 5 6])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #100 Least common multiple

;;; increase smallest number by single multiples until >= largest number
;;; 1  2  3  4
;;; 4  2  3  4
;;; 4  4  3  4
;;; 4  4  6  4
;;; 8  4  6  4
;;; 8  8  6  8
;;; 8  8  9  8
;;; 9  8  9  8
;;; 9 10  9  8
;;; 9 10  9 12
;;;12 10  9 12
;;;12 12 12 12

;;; check that all arguments are the same
((fn all-same [coll] (every? #(= (first coll) %) coll)) '(2 2 2))

;;; increase a number by step until smallest amount at or beyond limit
((fn increase-to [n step lim] (if (< n lim)
                                (increase-to (+ n step) step lim)
                                n)) 0 7 22)

((fn increase-smallest-to-largest [steps vals]
   (letfn [(increase-to [n step lim] (if (< n lim)
                                       (increase-to (+ n step) step lim)
                                       n))]
     (let [smallest-index (.indexOf vals (apply min vals))
           largest-index (.indexOf vals (apply max vals))]
       (assoc vals smallest-index (increase-to (apply min vals)
                                               (get steps smallest-index)
                                               (apply max vals))))))
 [7 3 7] [7 3 7])

;;; (assoc [0 1 2 3] 2 20) => [0 1 20 3]

((fn lcm [& nums]
   (let [steps (vec nums)]
     (letfn [(all-same [coll] (every? #(= (first coll) %) coll))
             (increase-to [n step lim]
               (if (< n lim)
                 (increase-to (+ n step) step lim)
                 n))
             (increase-smallest-to-largest [vals]
               (let [smallest-value (apply min vals)
                     largest-value (apply max vals)
                     smallest-index (.indexOf vals smallest-value)
                     largest-index (.indexOf vals largest-value)]
                 (assoc vals smallest-index (increase-to smallest-value
                                                         (get steps smallest-index)
                                                         largest-value))))
             (iterate [result]
               (if (all-same result)
                 (first result)
                 (iterate (increase-smallest-to-largest result))))]
       (iterate steps))))
 7 5/7 2 3/5)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #166 Comparisons

((fn my-compare [f a b]
   (prn (f a b) (f b a)))
 (fn [x y] (< (count x) (count y))) "pear" "plum")

((fn my-compare [f a b]
   (prn (f a b) (f b a))
   (let [test-comparison (f a b)
         test-opposite (f b a)]
     (cond (= test-comparison test-opposite) :eq
           (true? test-comparison) :lt
           :else :gt)))
 < 5 1)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #81 Set intersection

;;; Intersection = A - (A - B)

((fn [s-a s-b]
   ;;; copied difference from source
   (letfn [(the-diff [s1 s2] 
             (if (< (count s1) (count s2))
               (reduce (fn [result item] 
                         (if (contains? s2 item) 
                           (disj result item) 
                           result))
                       s1 s1)
               (reduce disj s1 s2)))]
     (let [s-a-minus-b (the-diff s-a s-b)]
       (the-diff s-a s-a-minus-b))))
 #{0 1 2 3} #{2 3 4 5})


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #62 Re-implement iterate

(take 5
      ((fn my-iterate [f x]
         (lazy-seq
          (cons x (my-iterate f (f x)))))
       #(* 2 %) 1))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #99 Product digits

#(map (comp (partial + -48) int) (seq (str (* % %2))))

;;; kohyama's solution uses read-string

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #95 To Tree, or not to Tree

;;; base case: single node with left and right branch

((fn is-tree? [node]
   (cond (nil? node) true
         (not (coll? node)) false
         (not (= (count node) 3)) false
         :else (and (is-tree? (nth node 1)) (is-tree? (nth node 2)))))
 '(:a (:b nil nil)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #135 Infix calculator

(+ (- (/ 2 2) 48) 38)  ;; backwards

(/ (- (+ 38 48) 2) 2)  ;; 42

((fn infix-calc [& args]
   (letfn [(calc-stack [args result]
             (if (empty? args)
               result
               (recur (drop 2 args) ((first args) result (second args)))))]
     (calc-stack (rest args) (first args))))
 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #122 Read a binary number
;;;; #143 Dot Product

(map (comp (partial + -48) int) (seq "1001"))

((fn dot-product [v w]
   (if (empty? v)
     0
     (+ (* (first v) (first w)) (dot-product (rest v) (rest w)))))
 [2 1] [1 1])

;;; better solution uses map
#(reduce + (map * % %2))

((fn powers-of-2 [n]
   (if (= 0 n)
     ()
     (cons (int (Math/pow 2 (- n 1))) (powers-of-2 (- n 1)))))
 2)

((fn read-binary [s]
   (letfn [(str-to-seq [s]
             (map (comp (partial + -48) int) (seq s)))
           (dot-product [v w]
             (if (empty? v)
               0
               (+ (* (first v) (first w)) (dot-product (rest v) (rest w)))))
           (powers-of-2 [n]
             (if (= 0 n)
               ()
               (cons (int (Math/pow 2 (- n 1))) (powers-of-2 (- n 1)))))]
     (let [s-len (count s)]
       (dot-product (powers-of-2 s-len) (str-to-seq s)))))
 "11")

;;; dankolov's solution
(fn read-binary [s]
  (->> s
       (map #(- (int %) (int \0)))  ;; convert to array
       (reduce #(+ (* 2 %1) %2))))  ;; during each step of the reduction,
;;; accumulated values are repeatedly multiplied by 2

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #90 Cartesian product

((fn [a b]
   (set
    (for [x a, y b]
      [x y])))
 #{"A" "K" "Q"} #{"S" "H" "D" "C"})


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #128 Recognize playing cards

((fn [s]
   (let [suits {"C" :club, "D" :diamond, "H" :heart, "S" :spade}
         ranks {"2" 0, "3" 1, "4" 2, "5" 3, "6" 4, "7" 5, "8" 6,
                "9" 7, "T" 8, "J" 9, "Q" 10, "K" 11, "A" 12}
         s-chars (seq s)
         suit-str (str (first s-chars))
         rank-str (str (second s-chars))]
     (hash-map :suit (suits suit-str) :rank (ranks rank-str))))
 "CA")

;;; better solutions destructure the input string to first and second chars

((fn smaller-than-sum-square-digits? [n]
   (let [digits-array (map #(- (int %) (int \0)) (str n))] ;; convert to array
     (< n (reduce + (map #(* % %) digits-array)))))
 19)

((fn count-smaller-than-sum-sq [coll]
   (letfn [(smaller-than-sum-square-digits? [n]
             (let [digits-array (map #(- (int %) (int \0)) (str n))]
               (< n (reduce + (map #(* % %) digits-array)))))]
     (count (filter smaller-than-sum-square-digits? coll))))
 (range 10))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #96 Beauty is symmetry

((fn [node]
   (letfn [(expand [node]
             (if (nil? node)
               nil
               (list (expand (nth node 1))
                     (first node)
                     (expand (nth node 2)))))]
     (let [flat-tree (flatten (expand node))]
       (= flat-tree (reverse flat-tree)))))
 '(:a (:b nil nil) (:c nil nil)))

((fn flip [node]
   (list (first node) (nth node 2) (nth node 1)))
 '(:a :b :c))

(flatten ((fn expand [node]
            (if (nil? node)
              nil
              (list (expand (nth node 1)) (first node) (expand (nth node 2)))))
          '(:a (:b nil nil) (:c nil nil))))

;;; cleaner solution destructures

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #97 Pascal's triangle

;;; add 0 to left of current vector and 0 to the right of another copy, then
;;; (map + [1 2 1 0] [0 1 2 1])

((fn pascal-tri [n]
   (if (= n 1)
     [1]
     (let [prev-line (pascal-tri (- n 1))]
       (map + (concat [0] prev-line) (concat prev-line [0])))))
 5)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #147 Pascal's trapezoid

(take 4
      ((fn pascal-trapezoid [line]
         (lazy-seq
          (cons line (pascal-trapezoid (map +' (concat [0] line) (concat line [0]))))))
       [1]))
;;; note: using +' to avoid overflow in the last test case


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #63 Group a sequence

;;;; list of results for each input
((fn [f inputs]
   (interleave (map f inputs) inputs))
 #(> % 5) [1 3 6 8])

;;;; (assoc {true [] false []} true (conj ({true [] false []} true) 1))

;;;; make a set with unique results, and assign [] to each
((fn group-a-seq [f inputs]
   (let [results (map f inputs)
         unique-results (set results)
         interleaved-results (interleave results inputs)
         grouped (apply hash-map (interleave unique-results (repeat [])))]
     (letfn [(accum [interl result]
               (if (empty? interl)
                 result
                 (accum (drop 2 interl)
                        ;;; result)))]
                        (assoc result (first interl)
                               (conj (result (first interl)) (second interl))))))]
       (prn grouped)
       (accum interleaved-results grouped))))
 #(> % 5) [1 3 6 8])


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #146 Trees into tables

;;; use for (?)
;;; instead of picking two levels of a hashmap, unite the first two levels
;;; into a vector, that would lead to the desired value.

((fn [m]
   ))

(def q146 '{a {p 1, q 2}, b {m 3, n 4}})

;;; correct, but paths should not be inside a vector
(for [[k1 v1] q146 [k2 v2] v1]
  [[k1 k2] v2])

(apply hash-map (apply concat
                       (for [[k1 v1] q146 [k2 v2] v1]
                         [[k1 k2] v2])))

;;; flatten one level
((fn [c]
   (apply concat c))
 '[[1 2] [3 [4]] [5]])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #153 Pairwise disjoint sets


((fn [s]
   (let [elts (apply concat s)]
     (= (count elts) (count (set elts)))))
 #{#{1} #{2}})


((fn [s]
   (let [elts (apply concat s)]
     (apply distinct? elts)))
 #{#{1} #{2}})


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #44 Rotate sequence

;;; mod with (count...)

;;; rotate 1 moves items left

((fn [n s]
   (letfn [(rotate-by-one [n s]
             (if (= n 0)
               s
               (recur (- n 1) (conj (vec (rest s)) (first s)))))]
     (rotate-by-one (mod n (count s)) s)))
 1 '(:a :b :c))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #43 Reverse interleave

;;; apply nth to iterate

(def q43 (range 9))

(map #(nth q43 % 0) (take 3 (iterate #(+ 3 %) 0)))

((fn [s sub]
   (let [ct (count s)
         sublen (quot ct sub)]
     (letfn [(build-sub [i result]
               (if (= i sub)
                 result
                 (recur (+ i 1) (conj result (map #(nth s % 0) (take sublen (iterate #(+ sub %) i)))))))]
       (build-sub 0 []))))
 [1 2 3 4 5 6] 2)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #55 Count occurrences

(fn [s] (apply hash-map
               (mapcat #(list (first %) (count %))
                       (partition-by identity (sort s)))))

;;; hisba's solution
((fn [s]
   (into {}
         (map #(vector (key %) (count (val %)))
              (group-by identity s))))
 '(1 1 2 3 1 1 1 2 3 3 3 3 3))

;;;; how does (into {} ... ) work?

;;;; daowen's solution for map defaults
(#(into {} (for [k %2] [k %])) 0 [:a :b])

(for [k [:a :b]] [k 0])

(into {} (for [k [:a :b]] [k 0]))

(into {} '([:a 0] [:b 0]))

(into {} (for [a (range 0 9 2)] [a (inc a)]))

;;; https://clojuredocs.org/clojure.core/into
;;; maps can be constructed from a sequence of 2-vectors or sequence of maps

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #54 Partition a sequence


(conj (conj () (take 3 (drop 6 (range 9)))) (take 3 (drop 3 (range 9))))

((fn [n s]
   (let [ct (count s)
         num-partitions (quot ct n)
         reduced-ct (* num-partitions n)]
     (letfn [(iter [n s i]
               (if (< i 0)
                 []
                 (conj (iter n s (dec i)) (take n (drop (* i n) s)))))]
       (iter n (take reduced-ct s) (dec num-partitions)))))
 2 (range 8))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #92 Read Roman numerals (hard)

;;; idea: keep track of running total. remove "subtractive" values first.
;;; as substring is romoved, total increases.
;;; loop, removing while substring is found in numerals string
;;; remove in order, CM = 900, CD = 400, XC = 90, XL = 40, IX = 9, IV = 4
;;; M = 1000, D = 500, C = 100, L = 50, X = 10, V = 5, I = 1

((fn remove-subs [s sub]
   (let [match-index (.indexOf s sub)]
     (if (= match-index -1)
       "Not found"
       (apply str (concat (take match-index s)
                          (drop (+ match-index (count sub)) s))))))
 "MCMXXI" "CM")

((fn parse-roman [s]
   (letfn [(sub-value [sub]
             ({"CM" 900, "CD" 400, "XC" 90, "XL" 40, "IX" 9, "IV" 4,
               "M" 1000, "D" 500, "C" 100, "L" 50, "X" 10, "V" 5, "I" 1} sub))
           (remove-subs [s sub total]
             (let [match-index (.indexOf s sub)]
               (if (= match-index -1)
                 [s total]
                 (recur (apply str
                               (concat (take match-index s)
                                       (drop (+ match-index (count sub)) s))) sub (+ total (sub-value sub))))))
           (iterate-syms [s-pair]
             (let [syms ["CM" "CD" "XC" "XL" "IX" "IV" "M" "D" "C" "L" "X" "V" "I"]
                   ct-syms (count syms)]
               (loop [i 0 pair s-pair]
                 (if (= i ct-syms)
                   pair
                   (recur (inc i) (remove-subs (first pair) (get syms i) (second pair)))))))]
     (second (iterate-syms [s 0]))))
 "MMMCMXCII")

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #67 Prime numbers

(time
 (last
  ((fn prime-seq [n]
     (letfn [(is-prime? [n]
               (loop [i 2]
                 (cond (= i n) true
                       (= (mod n i) 0) false
                       :else (recur (inc i)))))
             (next-prime [n]
               (loop [i (inc n)]
                 (if (is-prime? i)
                   i
                   (recur (inc i)))))
             (lazy-prime-seq [start]
               (lazy-seq
                (cons start (lazy-prime-seq (next-prime start)))))]
       (take n (lazy-prime-seq 2))))
   5000)))  ;; 8.24 secs in ubuntu

;;; simple case of lazy-seq
(take 5 ((fn my-lazy-range [n]
           (lazy-seq
            (cons n (my-lazy-range (inc n))))) 10))

;;; kohyama's solution

(time
 (last
  ((fn [n]
     (take n
           (filter
            (fn [m] (pos? (apply *' (map #(mod m %) (range 2 m)))))
            (iterate inc 2))))
   5000)))  ;; integer overflow

;;; daowen's solution

(time
 (last
  ((fn [n]
     (loop [ps [2], x 3]
       (if (= n (count ps)) ps
           (let [p (loop [i x] (if (some #(= 0 (mod i %)) ps) (recur (+ 2 i)) i))]
             (recur (conj ps p) (+ 2 p))))))
   5000)))  ;; 1.74 secs UAO

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #74 Filter perfect squares

(< (. Math abs (- (Math/sqrt 36) (int (Math/sqrt 36)))) 1e-9)

((fn filter-perfect-sq [s]
   (clojure.string/join
    ","
    (filter #(< (. Math abs (- (Math/sqrt %) (int (Math/sqrt %)))) 1e-9)
            (map #(. Integer parseInt %) (clojure.string/split s #",")))))
 "4,5,6,7,8,9")

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #115 The balance of N

;;; (= left right)
;;; (reduce + (map int (take (quot ct 2) (seq (str n

((fn [n]
   (let [digits (map int (seq (str n)))
         sig-half (quot (count digits) 2)
         left (take sig-half digits)
         right (take sig-half (reverse digits))]
     (apply identical? (map (partial reduce +) [left right]))))
 91091)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #116 Prime sandwich
((fn is-mean [n]
   (letfn [(is-prime? [n]
             (loop [i 2]
               (cond (= i n) true
                     (= (mod n i) 0) false
                     :else (recur (inc i)))))]
     (let [next-prime
           (memoize
            (fn [n]
              (loop [i (inc n)]
                (if (is-prime? i)
                  i
                  (recur (inc i))))))
           prev-prime
           (memoize
            (fn [n]
              (loop [i (dec n)]
                (if (is-prime? i)
                  i
                  (recur (dec i))))))]
       (if (is-prime? n)
         (= n (/ (+ (prev-prime n)
                    (next-prime n))
                 2))
         false))))
 563)


(nth
 (filter
  (fn is-mean [n]
    (letfn [(is-prime? [n]
              (loop [i 2]
                (cond (= i n) true
                      (= (mod n i) 0) false
                      :else (recur (inc i)))))]
      (let [next-prime
            (memoize
             (fn [n]
               (loop [i (inc n)]
                 (if (is-prime? i)
                   i
                   (recur (inc i))))))
            prev-prime
            (memoize
             (fn [n]
               (loop [i (dec n)]
                 (if (< i 2)
                   2
                   (if (is-prime? i)
                     i
                     (recur (dec i)))))))]
        (if (and (> n 1) (is-prime? n))
          (= n (/ (+ (prev-prime n)
                     (next-prime n))
                  2))
          false))))
  (range 200)) 3)

;;;; figure out how to memoize in letfn

(time
 (last 
  ((fn prime-seq [n]
     (letfn [(is-prime? [n]
               (loop [i 2]
                 (cond (= i n) true
                       (= (mod n i) 0) false
                       :else (recur (inc i)))))
             (next-prime [n]
               ((memoize
                 (fn [n]
                   (loop [i (inc n)]
                     (if (is-prime? i)
                       i
                       (recur (inc i)))))) n))
             (lazy-prime-seq [start]
               (lazy-seq
                (cons start (lazy-prime-seq (next-prime start)))))]
       (take n (lazy-prime-seq 2))))
   1000)))
;;;; but memoize isn't actually used because each (next-prime n) is only
;;;; used once


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #86 Happy numbers

((fn square-and-sum [n]
   (let [digits (map #(read-string (str %)) (seq (str n)))]
     (reduce + (map #(* % %) digits))))
 10)

((fn is-happy? [n]
   (letfn [(square-and-sum [n]
             (let [digits (map #(read-string (str %)) (seq (str n)))]
               (reduce + (map #(* % %) digits))))
           (iter [n seen]
             (cond
               (= n 1) true
               (some #{n} seen) false
               :else (iter (square-and-sum n) (conj seen n))))]
     (iter n [])))
 7)

;;; daowen uses loop and recur instead of iter

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #58 Function composition

(((fn [& fs]
    (letfn [(iter [fs result]
              (if (empty? fs)
                result
                (iter (drop-last fs)
                      (fn [& args]
                        (apply (last fs) args)))))]
      ))
  rest reverse) [1 2 3 4])

(rest
 (reverse [1 2 3 4]))

(zero?
 (#(mod % 8)
  (+ 3 5 7 9)))

(apply #(rest (reverse %)) '((1 2 3 4)))

((fn [& n] (rest (apply reverse n))) '[1 2 3 4])

(((fn [& fs]
    (let [fst-fn (last fs)
          other-fns (drop-last fs)]
      (fn [& n]
        (letfn [(iter [others result]
                  (if (empty? others)
                    result
                    (iter (drop-last others) ((last others) result))))]
          (iter other-fns (apply fst-fn n))))))
  #(.toUpperCase %) #(apply str %) take) 5 "hello world")

;;;; better solutions use reduce to repeatedly apply fns to
;;;; (apply (last fns) outer-args)

;;; daowen's solution
(((fn [& fs]
    (let [[f & fs] (reverse fs)]
      (fn [& xs]
        (reduce #(%2 %) (apply f xs) fs))))
  rest reverse) [1 2 3 4])

;;;; usage of (reduce f val coll)
(reduce #(list %2 %1) [1 2] '(:a :b :c))
;;;> (:c (:b (:a [1 2])))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;; #75 Euler's Totient function

((fn [n]
   (letfn [(gcd [a b]
             (cond
               (> b a) (gcd b a)
               (= b 0) a
               :else (gcd b (- a b))))]
     (count (filter #(= 1 (gcd n %)) (range 1 (inc n))))))
 40)
