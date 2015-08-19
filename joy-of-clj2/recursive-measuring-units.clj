;;; p. 157

(defn convert [context descriptor]
  (reduce (fn [result [mag unit]]
            (+ result
               (let [val (get context unit)]
                 (if (vector? val)
                   (* mag (convert context val))
                   (* mag val)))))
          0
          (partition 2 descriptor)))

(def simple-metric {:meter 1,
                    :km 1000,
                    :cm 1/100,
                    :mm [1/10 :cm]})

(convert simple-metric [30 :cm 1 :km])

;;; p. 163
(defn fac-cps [n k]
  (println "fac-cps" n)
  (letfn [(cont [v] (k (* v n)))]
    ;;; cont is a function of one argument
    (if (zero? n)
      (k 1)
      (recur (dec n) cont))))

(defn fac [n]
  (fac-cps n identity))

(fac 5)

;;; n = 0, k = (identity 1)
;;; cont [v] = (identity (* v 0))
;;; but fac-cps returns (identity 1) = 1

;;; ========
;;; (fac 1)
;;; n = 1, k = identity
;;; cont [v] = (identity (* v 1))
;;; if is false
;;; (recur 0 (identity (* v 1)))

;;; n = 0, k = (identity (* v 1))
;;; cont [v] = ((identity (* v 1)) (* v 0))
;;; if is true
;;; (identity (* v 1)) with v = 1
;;; result is 1

;;; (fac 2)
;;; n = 2, k = identity
;;; cont [v] = (identity (* v 2))
;;; (recur 1 (identity (* v 2)))

;;; n = 1, k = (identity (* v 2))
;;; cont [v] = ((identity (* v 2)) (* v 1)) = (identity (* (* v 1) 2))
;;; (recur 0 (identity (* (* v 1) 2)))

;;; n = 0, k = (identity (* (* v 1) 2))
;;; if is true
;;; (k 1) = (identity (* (* 1 1) 2)) = 2  UAO

