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
