;;;; 4clojure.com
:;;; ernesto ) username

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

