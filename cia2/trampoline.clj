;;; p. 68

;;; instead of directly calling next function, return an anonymous function
;;; that calls the next function

(declare hat)
(declare sat)

(defn cat [n]
  (when-not (zero? n)
    (when (zero? (rem n 100))
      (println "cat:" n))
    (fn [] (hat (dec n)))))

(defn hat [n]
  (when-not (zero? n)
    (when (zero? (rem n 33))
      (println "hat:" n))
    (fn [] (sat (dec n)))))

(defn sat [n]
  (when-not (zero? n)
    (when (zero? (rem n 5))
      (println "sat:" n))
    (fn [] (cat (dec n)))))
