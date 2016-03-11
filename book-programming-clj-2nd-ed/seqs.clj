;;;; seqs, cons, first, and rest

;;; p.58
;;; 6.aug.2015

(def person {:fname "Adam" :lname "Parker"})

(rest person)
(cons [:mname "J"] person)

(class (cons [:mname "J"] person))

(first (cons [:mname "J"] person))

(seq? (cons 'a ()))
